package com.yanxin.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.yanxin.common.GetWxOrderno;
import com.yanxin.common.RequestHandler;
import com.yanxin.common.ResultDto;
import com.yanxin.common.Sha1Util;
import com.yanxin.common.TenpayUtil;
import com.yanxin.common.XmltoJsonUtil;
import com.yanxin.domain.AlipayConfig;
import com.yanxin.domain.AlipayNotifyParam;
import com.yanxin.domain.AppUser;
import com.yanxin.domain.Order;
import com.yanxin.service.OrderService;
import com.yanxin.service.impl.CheckToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 支付管理
 * 
 * @author wangxilu
 * @version 1.0
 */
@Component
@Api(description = "支付相关接口")
@RequestMapping("/payments")
public class PaymentController {
	
	 private static Logger logger = LoggerFactory.getLogger(PaymentController.class);


	 private ExecutorService executorService = Executors.newFixedThreadPool(20);
	
	@Autowired
    private OrderService orderService;
	
	@Autowired
	private CheckToken checkToken;

	// 微信统一下单接口路径
	public static final String createOrderURL="https://api.mch.weixin.qq.com/pay/unifiedorder"; 

	public static final String appid = "wxd2f7d73babd9de68";//在微信开发平台登记的app应用 
	
	public static final String partner = "1505765861";//商户号
	// 微信回调地址
	private static final String NOTIFYURL = "http://47.105.86.63:41203/payments/notify";
	
	public static final String partnerkey ="9a72407e88e9786148906a3400f9a44a";//不是商户登录密码，是商户在微信平台设置的32位长度的api秘钥，  
	
	public static final String appsecret = "c15e1da71829aa86776f9b4fc40514d0"; 
	
	
	//支付宝配置
	public static final String alipay_appId = "2018121762579198";//支付宝APP应用ID
	
	public static final String alipay_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCs0PMXPN0BC6KZ61pcYHFYGOSLuMcrLykTkfipuN74v09TZUej2Q2m+gMt2s9UFmkKwQSpN/bDgJFMPzmqEGYq0zyb1PJ9rCvmL6L37rpP0+eymDcot33uALp3nUPiLxYyE9PpBhQinw6hOqIPiNS3/t0WVkftd1uZnJcn25TA58BI4S+t2Wl1AdNje5DW63YN3pReIuVHqOXN/FqFWz4HX70QCW7j1JH8QMLKjFHPFUftYKDIl7ttoNf68qTl2q5HUikRG2enWg4apxD+mGCM8wzg3+1kp4ZGaTE/cYJYp9Fc75vn5RdtjNPGHQ7Dxti59sxaNEMmnv5h65KdZxpPAgMBAAECggEAXjI+bmokZI98/7zDMhr3bPeUi3waQ7WfBCXKjmhQUPGmQWSxGeQThvI7jWD5JXJZqxzud3YjsQiBKjhELChoJ+uf26jEzC9udjd88vtS3nQ4lKZXWoA5yeLnwI8eE0lrJbydAyTnEL/173fQIfuJRwlKZQR+jDdE3IP3+Ce9+y7w8IMcZNc3R3f/zZJkHYgPsqCK/8EspSzZ9mDf+t7UAzUWuniqq+VQUHPsyrVWZmnTODsplKf0FzKsetUNzpQOnD57trD5Bdxe2i3lQPgYxPfVGRTX7pWuazjSWclDflyiwNZi/CbL35umSI6Z7+vW+1+1/Fwt1NPEQ/2a6QVzgQKBgQDl9sD9MiMKn0G80ZcP253AobZjQib15dY1SVb8EQyYUPkKeJwNk2ULRzDUOZVn2tDSeqMcya13FqMWvGxAekAlVD+t4pWyQ5FIrLDBOcv96JX8B1V1J+L5eoXtNbri/zZClSGHaDU0Y1KY/N9R04GT46rYprve64ypBp0tfq/LoQKBgQDAYdWS1/2L+oxPAGmHnkvLKRsfdp/JNgoiqBXShiVZD1Q1aTyVLlLNMrs+grsjQkehBROWByGWLCULLUkr/oupyLXrag5nTFNdgxVgBByJa1QfIhSEVqQ1L+/WuxmjqpEgCK6QM8RpUnCnBtZv8D5W8ffzjqXaqATWnM77vW+f7wKBgQDNYHynJDnLaMPrADwre3X97e7X4uKsxaFzYZZ/9DINbnOceG7WaQba9a+UOgFHCVNqRwCZ2zxCmUL6MTl0tDnJnN5qS2xqEpIUF7acOyQGFcytk1ctFHxPVq95VH0d8dPhzxJsvhKWQQYpf91qVLzq+W9BolczFac/5ZpGYVhbQQKBgQC4YUvLKB1F+kRdNxztMMadmPD4z71Gn/dIzeXUVmMXHzzqz8iThckwB040FCF9Inn6Fh52bLFA92AtfSKi+pwqhkXssUHKuPkxJ3/l/SrIfcgq6oPVbiCFJUNtfvaMyN28YPXFGQhGlQ+I1WHR+OQWemPU10OX8+5nLfSmiyGfmwKBgQDCoSCLvucfizCJsDcdbBMsOjCwoQvRdluboQx5FdcqR6Yn/ipLZtB/osAHW/6ndFEs5+Xz0GX91cYXd8+WpB/QUodaXWIl53O/tCaz7Dr/5oCnRWiDE1jTT5uuMfYYwiz+DvnGkGvw2e0h2P02FcwNXKKzgQx7LiKh0HZvbnCtZg==";//支付宝私钥
	
	public static final String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArNDzFzzdAQuimetaXGBxWBjki7jHKy8pE5H4qbje+L9PU2VHo9kNpvoDLdrPVBZpCsEEqTf2w4CRTD85qhBmKtM8m9Tyfawr5i+i9+66T9Pnspg3KLd97gC6d51D4i8WMhPT6QYUIp8OoTqiD4jUt/7dFlZH7XdbmZyXJ9uUwOfASOEvrdlpdQHTY3uQ1ut2Dd6UXiLlR6jlzfxahVs+B1+9EAlu49SR/EDCyoxRzxVH7WCgyJe7baDX+vKk5dquR1IpERtnp1oOGqcQ/phgjPMM4N/tZKeGRmkxP3GCWKfRXO+b5+UXbYzTxh0Ow8bYufbMWjRDJp7+YeuSnWcaTwIDAQAB";//支付宝公钥

	/**
	 * 微信统一下单
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ApiOperation(value = "微信支付接口",nickname = "微信支付接口")
	@RequestMapping(value = "/weixinPay", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "Integer")
	@ResponseBody
    public void topay(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		AppUser appUser = checkToken.check(request.getHeader("token"));
		
		JSONObject retMsgJson=new JSONObject();
		if(appUser!=null){
			  request.setCharacterEncoding("UTF-8");  
			    response.setCharacterEncoding("UTF-8");  
			    response.setContentType("text/html;charset=UTF-8");  
			    String orderId= request.getParameter("orderId");  
			    PrintWriter out = response.getWriter();  
			    String json=null;  
			       
			    Order order=orderService.findById(Integer.parseInt(orderId));//获取订单数据  
			    String money = order.getOrderAmount().toString();//获取订单金额  
			    //金额转化为分为单位  
			    float sessionmoney = Float.parseFloat(money);  
			    String finalmoney = String.format("%.2f", sessionmoney);  
			    finalmoney = finalmoney.replace(".", "");  
			            String currTime = TenpayUtil.getCurrTime();  
			            //8位日期  
			            String strTime = currTime.substring(8, currTime.length());  
			            //四位随机数  
			            String strRandom = TenpayUtil.buildRandom(4) + "";  
			            //10位序列号,可以自行调整。  
			            String strReq = strTime + strRandom;          
			            //商户号  
			            String mch_id = partner;  
			            //子商户号  非必输  
			            //String sub_mch_id="";  
			            //设备号   非必输  
			            String device_info="";  
			            //随机数   
			            String nonce_str = strReq;  
			            String body = order.getOrderNum();  
			            //商户订单号  
			            String out_trade_no = order.getOrderNum();//订单编号加时间戳  
			            int intMoney = Integer.parseInt(finalmoney);              
			            //总金额以分为单位，不带小数点  
			            String total_fee = String.valueOf(intMoney);  
			            //订单生成的机器 IP  
			            String spbill_create_ip =request.getRemoteAddr();  
			            String notify_url =NOTIFYURL;//微信异步通知地址           
			            String trade_type = "APP";//app支付必须填写为APP  
			                        //对以下字段进行签名  
			            SortedMap<String, String> packageParams = new TreeMap<String, String>();  
			            packageParams.put("appid", appid);    
			            packageParams.put("body", body);    
			            packageParams.put("mch_id", mch_id);      
			            packageParams.put("nonce_str", nonce_str);    
			            packageParams.put("notify_url", notify_url);    
			            packageParams.put("out_trade_no", out_trade_no);      
			            packageParams.put("spbill_create_ip", spbill_create_ip);   
			            packageParams.put("total_fee", "0.01");  
			            packageParams.put("trade_type", trade_type);    
			            RequestHandler reqHandler = new RequestHandler(request, response);  
			            reqHandler.init(appid, appsecret, partnerkey);        
			            String sign = reqHandler.createSign(packageParams);//获取签名  
			            String xml="<xml>"+  
			                    "<appid>"+appid+"</appid>"+  
			                    "<body><![CDATA["+body+"]]></body>"+  
			                    "<mch_id>"+mch_id+"</mch_id>"+  
			                    "<nonce_str>"+nonce_str+"</nonce_str>"+  
			                    "<notify_url>"+notify_url+"</notify_url>"+  
			                    "<out_trade_no>"+out_trade_no+"</out_trade_no>"+  
			                    "<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+  
			                    "<total_fee>"+0.01+"</total_fee>"+  
			                    "<trade_type>"+trade_type+"</trade_type>"+  
			                    "<sign>"+sign+"</sign>"+  
			                    "</xml>";  
			            String allParameters = "";  
			            try {  
			                allParameters =  reqHandler.genPackage(packageParams);  
			             } catch (Exception e) {  
			                // TODO Auto-generated catch block  
			                e.printStackTrace();  
			            }  
			            String prepay_id="";  
			            try {  
			                prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);  
			                if(prepay_id.equals("")){  
			                retMsgJson.put("msg", "error");  
			                json=retMsgJson.toString();                   
			                out.write(json);  
			                out.close();  
			                return;  
			                 }  
			            } catch (Exception e1) {  
			                // TODO Auto-generated catch block  
			                e1.printStackTrace();  
			             }  
			                        //获取到prepayid后对以下字段进行签名最终发送给app  
			                       SortedMap<String, String> finalpackage = new TreeMap<String, String>();  
			            String timestamp = Sha1Util.getTimeStamp();  
			            finalpackage.put("appid", appid);    
			            finalpackage.put("timestamp", timestamp);    
			            finalpackage.put("noncestr", nonce_str);    
			            finalpackage.put("partnerid", partner);   
			            finalpackage.put("package", "Sign=WXPay");                
			            finalpackage.put("prepayid", prepay_id);    
			            String finalsign = reqHandler.createSign(finalpackage);  
			                    retMsgJson.put("msg", "ok");  
			                    retMsgJson.put("appid", appid);  
			                    retMsgJson.put("timestamp", timestamp);  
			                    retMsgJson.put("noncestr", nonce_str);  
			                    retMsgJson.put("partnerid", partner);  
			                    retMsgJson.put("prepayid", prepay_id);  
			                    retMsgJson.put("package", "Sign=WXPay");  
			                    retMsgJson.put("sign", finalsign);  
			                    json=retMsgJson.toString();                   
			                    out.write(json);  
			                    out.close();  
		}else{
			 retMsgJson.put("msg", 403);  
		     retMsgJson.put("body", "token失效请重新登录！"); 
		}
	}
	
	/**  
     * 微信订单回调接口  
     *   
     * @return  
     */  
	@ApiOperation(value = "微信回调接口",nickname = "微信回调接口") 
    @RequestMapping(value = "/notify", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")  
    @ResponseBody  
    public void notify(HttpServletRequest request,HttpServletResponse response){  
    	ResultDto result = new ResultDto();// 返回数据结果集合  
        try{  
            request.setCharacterEncoding("UTF-8");    
            response.setCharacterEncoding("UTF-8");    
            response.setContentType("text/html;charset=UTF-8");    
            response.setHeader("Access-Control-Allow-Origin", "*");     
            InputStream in=request.getInputStream();    
            ByteArrayOutputStream out=new ByteArrayOutputStream();    
            byte[] buffer =new byte[1024];    
            int len=0;    
            while((len=in.read(buffer))!=-1){    
                out.write(buffer, 0, len);    
            }    
            out.close();    
            in.close();    
            String content=new String(out.toByteArray(),"utf-8");//xml数据    
              
            JSONObject jsonObject = JSONObject.parseObject(XmltoJsonUtil.xml2JSON(content)) ;    
            JSONObject result_xml = jsonObject.getJSONObject("xml");  
            JSONArray result_code =  result_xml.getJSONArray("result_code");  
            String code = (String)result_code.get(0);  
              
            if(code.equalsIgnoreCase("FAIL")){  
                result.setMsg("微信统一订单下单失败");  
                result.setCode(-1);               
              
                response.getWriter().write(setXml("SUCCESS", "OK"));  
                  
                  
            }else if(code.equalsIgnoreCase("SUCCESS")){  
                result.setMsg("微信统一订单下单成功");  
                result.setCode(1);    
                  
                JSONArray out_trade_no = result_xml.getJSONArray("out_trade_no");//订单编号  
                
                //修改订单状态。。。。。。
                //根据订单号查询订单信息
                
                Order order = orderService.findById((Integer)out_trade_no.get(0));
                
                order.setStatus("1");
                orderService.updateOrder(order);
                  
                response.getWriter().write(setXml("SUCCESS", "OK"));  
            }             
        }catch(Exception e){  
            result.setMsg(e.getMessage());  
            result.setCode(-1);  
            return;  
        }  
          
    }
	
	
	/**
	 * 修改订单状态
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ApiOperation(value = "修改订单状态接口",nickname = "修改订单状态接口")
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "Integer"),
	@ApiImplicitParam(name = "payType", value = "支付方式,微信wx，支付宝zfb", required = true, dataType = "String")
	})
	@ResponseBody
    public void updateStatus(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		AppUser appUser = checkToken.check(request.getHeader("token"));
		
		JSONObject retMsgJson=new JSONObject();
		if(appUser!=null){
			  request.setCharacterEncoding("UTF-8");  
			    response.setCharacterEncoding("UTF-8");  
			    response.setContentType("text/html;charset=UTF-8");  
			    String orderId= request.getParameter("orderId");  
			    String payType= request.getParameter("payType");
			    
                //根据订单号查询订单信息
                
                Order order = orderService.findById(Integer.parseInt(orderId));
                
                order.setStatus("1");
                order.setPayType(payType);
                orderService.updateOrder(order);
                
                PrintWriter out = response.getWriter();
                
                retMsgJson.put("msg", "ok");  
                out.write(retMsgJson.toString());
			   
		}else{
			 retMsgJson.put("msg", 403);  
		     retMsgJson.put("body", "token失效请重新登录！"); 
		}
	}
	
	

	// 返回用IP地址
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader(" x-forwarded-for ");
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getHeader(" WL-Proxy-Client-IP ");
		}
		if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// 随机字符串生成
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	// 拼接xml 请求路径
	public static String getRequestXML(SortedMap<Object, Object> parame) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		Set set = parame.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			// 过滤相关字段sign
			if ("sign".equalsIgnoreCase(key)) {
				buffer.append("<" + key + ">" + "<![CDATA[" + value + "]]>" + "</" + key + ">");
			} else {
				buffer.append("<" + key + ">" + value + "</" + key + ">");
			}
		}
		buffer.append("</xml>");
		return buffer.toString();
	}

	//返回微信服务  
    public static String setXml(String return_code,String return_msg){    
           return "<xml><return_code><![CDATA["+return_code+"]]></return_code><return_msg><![CDATA["+return_msg+"]]></return_msg></xml>";    
   } 
    
    
    /**
	 * 支付宝统一下单
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ApiOperation(value = "支付宝支付接口",nickname = "支付宝支付接口")
	@RequestMapping(value = "/aliPay", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ApiImplicitParam(name = "orderId", value = "订单ID", required = true, dataType = "Integer")
	@ResponseBody
    public String aliPay(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		AppUser appUser = checkToken.check(request.getHeader("token"));
		
		JSONObject retMsgJson=new JSONObject();
		if(appUser!=null){
			    request.setCharacterEncoding("UTF-8");  
			    response.setCharacterEncoding("UTF-8");  
			    response.setContentType("text/html;charset=UTF-8");  
			    String orderId= request.getParameter("orderId");  
			       
			    Order order=orderService.findById(!"".equals(orderId)?Integer.parseInt(orderId):null);//获取订单数据  
			    String money = order.getOrderAmount().toString();//获取订单金额  
			   /* //金额转化为分为单位  
			    float sessionmoney = Float.parseFloat(money);  
			    String finalmoney = String.format("%.2f", sessionmoney);  
			    finalmoney = finalmoney.replace(".", "");*/
			    
			    //实例化客户端
		        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipay_appId, alipay_private_key , "json", "UTF-8", alipay_public_key, "RSA2");
			    
		        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		        AlipayTradeAppPayRequest aliRequest = new AlipayTradeAppPayRequest();
		        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		        model.setPassbackParams("优先生活订单");;  //描述信息  添加附加数据
		        model.setSubject("优先生活商品"); //商品标题
		        model.setOutTradeNo(order!=null?order.getOrderNum():""); //商家订单编号
		        model.setTimeoutExpress("30m"); //超时关闭该订单时间
		        model.setTotalAmount("0.01");  //订单总金额
		        model.setProductCode("QUICK_MSECURITY_PAY"); //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
		        aliRequest.setBizModel(model);
		        aliRequest.setNotifyUrl("http://yxlifeshop.com:41203/payments/alipay_callback");  //回调地址
		        String orderStr = "";
		        try {
		                //这里和普通的接口调用不同，使用的是sdkExecute
		                AlipayTradeAppPayResponse aliResponse = alipayClient.sdkExecute(aliRequest);
		                orderStr = aliResponse.getBody();
		                System.out.println(orderStr);//就是orderString 可以直接给客户端请求，无需再做处理。
		            } catch (AlipayApiException e) {
		                e.printStackTrace();
		        }
		        return orderStr;
			            
		}else{
			 retMsgJson.put("msg", 403);  
		     retMsgJson.put("body", "token失效请重新登录！"); 
		     return null;
		}
	}
	
	@RequestMapping("alipay_callback")
    @ResponseBody
    public String callback(HttpServletRequest request) {
        Map<String, String> params = convertRequestParamsToMap(request); // 将异步通知中收到的待验证所有参数都存放到map中
        String paramsJson = JSON.toJSONString(params);
        try {
            // 调用SDK验证签名
            boolean signVerified = AlipaySignature.rsaCheckV1(params, alipay_public_key,
            		"UTF-8");
            if (signVerified) {
                logger.info("支付宝回调签名认证成功");
                // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
                this.check(params);
                // 另起线程处理业务
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        AlipayNotifyParam param = buildAlipayNotifyParam(params);
                        String trade_status = param.getTradeStatus();
                        // 支付成功
                        if (trade_status.equals("TRADE_SUCCESS")
                                || trade_status.equals("TRADE_FINISHED")) {
                            // 处理支付成功逻辑
                            try {
                            	Order order = orderService.findByOrderNum(param.getOutTradeNo());
                                
                                order.setStatus("1");
                                order.setPayType("zfb");
                                orderService.updateOrder(order);                   

                            } catch (Exception e) {
                                logger.error("支付宝回调业务处理报错,params:" + paramsJson, e);
                            }
                        } else {
                            logger.error("没有处理支付宝回调业务，支付宝交易状态：{},params:{}",trade_status,paramsJson);
                        }
                    }
                });
                // 如果签名验证正确，立即返回success，后续业务另起线程单独处理
                // 业务处理失败，可查看日志进行补偿，跟支付宝已经没多大关系。
                return "success";
            } else {
                logger.info("支付宝回调签名认证失败，signVerified=false, paramsJson:{}", paramsJson);
                return "failure";
            }
        } catch (AlipayApiException e) {
            logger.error("支付宝回调签名认证失败,paramsJson:{},errorMsg:{}", paramsJson, e.getMessage());
            return "failure";
        }
    }
	
	// 将request中的参数转换成Map
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<String, String>();

        Set<Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }

        return retMap;
    }

    private AlipayNotifyParam buildAlipayNotifyParam(Map<String, String> params) {
        String json = JSON.toJSONString(params);
        return JSON.parseObject(json, AlipayNotifyParam.class);
    }

    /**
     * 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
     * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
     * 3、校验通知中的seller_id（或者seller_email)是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
     * 4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。
     * 在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。
     * 在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
     * 
     * @param params
     * @throws AlipayApiException
     */
    private void check(Map<String, String> params) throws AlipayApiException {      
        String outTradeNo = params.get("out_trade_no");

        // 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        Order order = orderService.findByOrderNum(outTradeNo); // 这个方法自己实现
        if (order == null) {
            throw new AlipayApiException("out_trade_no错误");
        }       

        // 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        long total_amount = new BigDecimal(params.get("total_amount")).multiply(new BigDecimal(100)).longValue(); 
        
        
        if (total_amount != order.getOrderAmount().longValue()) {
            throw new AlipayApiException("error total_amount");
        }

        // 3、校验通知中的seller_id（或者seller_email)是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
        // 第三步可根据实际情况省略

        // 4、验证app_id是否为该商户本身。
        if (!params.get("app_id").equals(alipay_appId)) {
            throw new AlipayApiException("app_id不一致");
        }
    }

}
