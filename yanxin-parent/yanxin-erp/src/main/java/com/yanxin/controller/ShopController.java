package com.yanxin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.aliyun.oss.ServiceException;
import com.github.pagehelper.PageInfo;
import com.yanxin.common.OSSClientUtil;
import com.yanxin.common.RSResult;
import com.yanxin.common.SystemConfig;
import com.yanxin.domain.Shop;
import com.yanxin.service.ShopService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OSSClientUtil ossClient;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView shopList(HttpServletRequest request,
			@RequestParam(value = "pageNumber", defaultValue = "1" , required = false) Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10" , required = false) Integer pageSize){
		
		PageInfo<Shop> pager = shopService.findShopByPage(pageNum, pageSize);
		
		request.setAttribute("pager", pager);
		return new ModelAndView("shop/shop_list");
	}
	
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public ModelAndView shopToAdd(HttpServletRequest request) throws SQLException, UnsupportedEncodingException, SOAPException, ServiceException, IOException {
		SystemConfig systemConfig = new SystemConfig();
		systemConfig.setUploadLimit(10);
		systemConfig.setAllowedUploadImageExtension("png,jpg");
		
		request.setAttribute("systemConfig",systemConfig);
		return new ModelAndView("shop/shop_add");
	}
	
	@RequestMapping(value = "/toEdit", method = RequestMethod.GET)	public ModelAndView shopToEdit(HttpServletRequest request,
			@RequestParam(value = "shopId", required = false) Integer shopId) throws SQLException, UnsupportedEncodingException, SOAPException, ServiceException, IOException {
		
		Shop shop = shopService.findShopById(shopId);
		request.setAttribute("shop", shop);
		request.setAttribute("shopId", shop.getId());
		
		SystemConfig systemConfig = new SystemConfig();
		systemConfig.setUploadLimit(10);
		systemConfig.setAllowedUploadImageExtension("png,jpg");
		request.setAttribute("systemConfig",systemConfig);
		return new ModelAndView("shop/shop_add");
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST )
	public ModelAndView save(HttpServletRequest request,
			@RequestParam(value = "shopName",required=false) String shopName,
			@RequestParam(value = "owner",required=false) String owner,
			@RequestParam(value = "shopAddress",required=false) String shopAddress,
			@RequestParam(value = "startDistributionCosts",required=false) Double startDistributionCosts,
			@RequestParam(value = "distributionCosts",required=false) Double distributionCosts,
			@RequestParam(value = "description",required=false) String description,
			@RequestParam(value = "lonlat",required=false) String lonlat,
			@RequestParam(value = "electronicFence",required=false) String electronicFence,
			@RequestParam(value = "weixinMchid",required=false) String weixinMchid,
			@RequestParam(value = "aliPartnerid",required=false) String aliPartnerid)
			throws Exception {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("shopImages");
		
		Shop shop= new Shop();
		if(!"".equals(lonlat)){
			String[] newlonlat=lonlat.split(",");	
			shop.setDimension(newlonlat[1]);
			shop.setLongitude(newlonlat[0]);
		}
		shop.setShopName(shopName);
		shop.setDescription(description);
		shop.setDistributionCosts(distributionCosts);
		shop.setStartDistributionCosts(startDistributionCosts);
		shop.setAliPartnerid(aliPartnerid);
		shop.setWeixinMchid(weixinMchid);
		
		shop.setOwner(owner);
		shop.setShopAddress(shopAddress);
		shop.setElectronicFence(electronicFence);
		
		
        StringBuilder sb = new StringBuilder();
		
			if(files!=null){
	            for(int i=0;i<files.size();i++){  
	                MultipartFile file = files.get(i);
	                if (file.getSize() > 0) {
	                	String name = ossClient.uploadImg2Oss(file);
	            	    String imgUrl = ossClient.getImgUrl(name);
	                        sb.append(imgUrl);
	                        sb.append(",");
	                }
	            } 
	        }
			if(sb.length()>0){
				sb.deleteCharAt(sb.length()-1);
				shop.setImageUrl(sb.toString());
			}
			
		shopService.addShop(shop);
		ModelAndView mv = new ModelAndView("redirect:/shop/list");
		return mv;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,
			@RequestParam(value = "shopId",required=false) Integer shopId,
			@RequestParam(value = "shopName",required=false) String shopName,
			@RequestParam(value = "owner",required=false) String owner,
			@RequestParam(value = "shopAddress",required=false) String shopAddress,
			@RequestParam(value = "startDistributionCosts",required=false) Double startDistributionCosts,
			@RequestParam(value = "distributionCosts",required=false) Double distributionCosts,
			@RequestParam(value = "description",required=false) String description,
			@RequestParam(value = "lonlat",required=false) String lonlat,
			@RequestParam(value = "electronicFence",required=false) String electronicFence,
			@RequestParam(value = "weixinMchid",required=false) String weixinMchid,
			@RequestParam(value = "aliPartnerid",required=false) String aliPartnerid)
			throws Exception {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("shopImages");
		
        Shop shop = shopService.findShopById(shopId);
		if(!"".equals(lonlat)){
			String[] newlonlat=lonlat.split(",");	
			shop.setDimension(newlonlat[1]);
			shop.setLongitude(newlonlat[0]);
		}
		shop.setShopName(shopName);
		shop.setDescription(description);
		shop.setDistributionCosts(distributionCosts);
		shop.setStartDistributionCosts(startDistributionCosts);
		shop.setAliPartnerid(aliPartnerid);
		shop.setWeixinMchid(weixinMchid);
		
		shop.setOwner(owner);
		shop.setShopAddress(shopAddress);
		shop.setElectronicFence(electronicFence);
		
		
        StringBuilder sb = new StringBuilder();
		
			if(files!=null){
	            for(int i=0;i<files.size();i++){  
	                MultipartFile file = files.get(i);
	                if (file.getSize() > 0) {
	                	String name = ossClient.uploadImg2Oss(file);
	            	    String imgUrl = ossClient.getImgUrl(name);
	                        sb.append(imgUrl);
	                        sb.append(",");
	                }
	            } 
	        }
			if(sb.length()>0){
				sb.deleteCharAt(sb.length()-1);
				shop.setImageUrl(sb.toString());
			}
		shopService.updateShop(shop);
		ModelAndView mv = new ModelAndView("redirect:/shop/list");
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String productDelete(HttpServletRequest request) throws SQLException {
		RSResult rr = new RSResult();
		String[] productIds = request.getParameterValues("ids");
		int resultDelete = shopService.delete(productIds);
		if (resultDelete == 1) {
			rr.setMessage("删除成功！");
			rr.setCode("200");
			rr.setStatus("success");
		} else {
			rr.setMessage("删除失败！");
			rr.setCode("0");
			rr.setStatus("failure");
		}
		return JSONObject.fromObject(rr).toString();
	}

}
