package com.yanxin.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yanxin.common.RSResult;
import com.yanxin.common.SystemConfig;
import com.yanxin.domain.Admin;
import com.yanxin.domain.HaixinGood;
import com.yanxin.domain.Product;
import com.yanxin.domain.ProductCategory;
import com.yanxin.domain.ProductImage;
import com.yanxin.domain.ProductTransfer;
import com.yanxin.service.HaixinService;
import com.yanxin.service.ProductCategoryService;
import com.yanxin.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

@RestController
public class GamesController {

	@Autowired
	ProductService productService;
	@Autowired
	ProductCategoryService productCategoryService;
	@Autowired
	HaixinService haixinService;
	
	
	@RequestMapping(value = "/admin/game", method = RequestMethod.GET)
	public ModelAndView getProduct(HttpServletRequest request,
			@RequestParam(value = "num", defaultValue = "1") Integer num,
			@RequestParam(value = "property",required=false) String property) throws SQLException {
		PageHelper.startPage(num, 10);
		SecurityContext ctx = SecurityContextHolder.getContext();  
	    Authentication auth = ctx.getAuthentication(); 
	    Admin admin = (Admin) auth.getPrincipal();
	    Map<String,Object> map = new HashMap<>();
	    map.put("shopId", admin.getCompanyId());
		List<ProductTransfer> products = productService.findListAllWithCategory(map);
		PageInfo<ProductTransfer> pager = new PageInfo<>(products);
		request.setAttribute("pager", pager);
		request.setAttribute("admin", admin);
		request.setAttribute("property",property);
		return new ModelAndView("admin/product_list");
	}
	
	@RequestMapping(value = "/game/list", method = RequestMethod.GET)
	public ModelAndView productList(HttpServletRequest request,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer num,
			@RequestParam(value = "keyword",required=false) String name,
			@RequestParam(value = "property",required=false) String property) throws SQLException {
		if (null != name && !"".equals(name) ) {
			PageHelper.startPage(num, 10);
			SecurityContext ctx = SecurityContextHolder.getContext();  
		    Authentication auth = ctx.getAuthentication(); 
		    Admin admin = (Admin) auth.getPrincipal();
		    Map<String,Object> map = new HashMap<>();
		    map.put("shopId", admin.getCompanyId());
		    map.put("name", name);
		    request.setAttribute("admin", admin);
			List<ProductTransfer> products = productService.findListAllWithCategory(map);
			PageInfo<ProductTransfer> pager = new PageInfo<>(products);
			request.setAttribute("pager", pager);
			request.setAttribute("property",property);
			request.setAttribute("keyword",name);
			return new ModelAndView("admin/product_list");
		}
		return this.getProduct(request, num,property);
	}
	
	@RequestMapping(value = "/game/add", method = RequestMethod.GET)
	public ModelAndView productAdd(HttpServletRequest request) {
		SecurityContext ctx = SecurityContextHolder.getContext();  
	    Authentication auth = ctx.getAuthentication(); 
	    Admin admin = (Admin) auth.getPrincipal();
		List<ProductCategory> productCategoryTreeList = productCategoryService.getProductCategory(0);
		request.setAttribute("productCategoryTreeList", productCategoryTreeList);
		/*List<HaixinGood> haixinGoodsList = haixinService.findAllHaixinGoods();*/
		SystemConfig systemConfig = new SystemConfig();
		systemConfig.setUploadLimit(10);
		systemConfig.setAllowedUploadImageExtension("png,jpg");
		request.setAttribute("systemConfig",systemConfig);
		request.setAttribute("shopId",admin.getCompanyId());
		/*request.setAttribute("haixinGoodsList", haixinGoodsList);*/
		return new ModelAndView("admin/product_input");
	}
	@RequestMapping(value = "/game/save", method = RequestMethod.POST)
	public ModelAndView productSave(HttpServletRequest request,
			@RequestParam(value = "goodName") String name,
			@RequestParam(value = "goodCode") String goodCode,
			@RequestParam(value = "product.originPlace") String originPlace,
			@RequestParam(value = "fullName") String fullName,
			@RequestParam(value = "weight") String weight,
			@RequestParam(value = "parentId",required=false) String pid,
			@RequestParam(value = "parentSecondId",required=false) String parentSecondId,
			@RequestParam(value = "parentThirdId",required=false) String parentThirdId,
			@RequestParam(value = "originalPrice") BigDecimal originalPrice,
			@RequestParam(value = "product.price") BigDecimal price,
			@RequestParam(value = "warrantDays") String warrantDays,//保质期单位
			@RequestParam(value = "product.isMarketable") boolean isMarketable,
			@RequestParam(value = "product.isTop") boolean isTop,
			@RequestParam(value = "product.introduction",required=false) String introduction,
			@RequestParam(value = "product.warrantyPeriod") Integer warrantyPeriod,//保质期
			@RequestParam(value = "brandName",required=false) String brandName,
			@RequestParam(value = "storageCondition",required=false) String storageCondition,
			@RequestParam(value = "product.shop") Integer shop,
			@RequestParam(value = "startTime") String startTime,
			@RequestParam(value = "endTime") String endTime
			) throws SQLException {
		
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("productImages");
		String parentId;
		if(!parentThirdId.equals("0")) {
			parentId = parentThirdId;
		}else {
			if(!parentSecondId.equals("0")) {
				parentId = parentSecondId;
			}else {
				parentId = pid;
			}
		}
		try {
			productService.insert(name, goodCode, originPlace,
					parentId, price, 
					isMarketable, isTop, introduction, shop, files,originalPrice,warrantyPeriod,warrantDays,brandName,storageCondition,fullName,weight,startTime,endTime,pid);
			ModelAndView mv = new ModelAndView("redirect:/product/list");
			return mv;
		}catch(Exception e) {
			request.setAttribute("errorMessages", e.getMessage());
			request.setAttribute("redirectionUrl", "/admin/product/product");
			return new ModelAndView("admin/error");
		}
	}
	@RequestMapping(value = "/game/delete", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String productDelete(HttpServletRequest request) throws SQLException {
		RSResult rr = new RSResult();
		String[] productIds = request.getParameterValues("ids");
		int resultDelete = productService.delete(productIds);
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
	
	@RequestMapping(value = "/game/edit", method = RequestMethod.GET)
	public ModelAndView productEdit(HttpServletRequest request) {
		String productId = request.getParameter("id");
		ProductTransfer product = productService.findById(Long.valueOf(productId));
		if(product.getWeight()!=null&&!"".equals(product.getWeight())){
			if(product.getWeight().indexOf("Kg")!=-1){
				product.setWeight(product.getWeight().replace("Kg",""));
			}
			
		}
		SimpleDateFormat str = new SimpleDateFormat("yyyy-MM-dd"); 
		product.setNewendTime(product.getEndTime()!=null?str.format(product.getEndTime()):"");
		product.setNewstartTime(product.getStartTime()!=null?str.format(product.getStartTime()):"");
		
		List<ProductCategory> productCategoryTreeList = productCategoryService.getProductCategory(0);
		request.setAttribute("productCategoryTreeList", productCategoryTreeList);
		SystemConfig systemConfig = new SystemConfig();
		systemConfig.setUploadLimit(10);
		systemConfig.setAllowedUploadImageExtension("png,jpg");
		
		List<ProductImage> productImages = productService.getAllAttachmentImage(product);
		/*List<HaixinGood> haixinGoodsList = haixinService.findAllHaixinGoods();*/
		product.setProductImageList(productImages);
		request.setAttribute("systemConfig",systemConfig);
		request.setAttribute("product",product);
		request.setAttribute("shopId", product.getShopId());
		/*request.setAttribute("haixinGoodsList", haixinGoodsList);*/
		return new ModelAndView("admin/product_input");
	}
	
	@RequestMapping(value = "/game/update", method = RequestMethod.POST)
	public ModelAndView productUpdate(HttpServletRequest request,
			@RequestParam(value = "product.id") Integer id,
			@RequestParam(value = "goodName") String name,
			@RequestParam(value = "goodCode") String goodCode,
			@RequestParam(value = "product.originPlace") String originPlace,
			@RequestParam(value = "parentId") String pid,
			@RequestParam(value = "fullName") String fullName,
			@RequestParam(value = "weight") String weight,
			@RequestParam(value = "parentSecondId") String parentSecondId,
			@RequestParam(value = "parentThirdId") String parentThirdId,
			@RequestParam(value = "originalPrice") BigDecimal originalPrice,
			@RequestParam(value = "product.price") BigDecimal price,
			@RequestParam(value = "warrantDays") String warrantDays,//保质期单位
			@RequestParam(value = "product.isMarketable") boolean isMarketable,
			@RequestParam(value = "product.isTop") boolean isTop,
			@RequestParam(value = "product.introduction",required=false) String introduction,
			@RequestParam(value = "product.warrantyPeriod") Integer warrantyPeriod,//保质期
			@RequestParam(value = "brandName",required=false) String brandName,
			@RequestParam(value = "storageCondition",required=false) String storageCondition,
			@RequestParam(value = "product.shop") Integer shop,
			@RequestParam(value = "startTime") String startTime,
			@RequestParam(value = "endTime") String endTime
			) throws SQLException {
		
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("productImages");
		String[] productImageIds = request.getParameterValues("productImageIds");
		String parentId;
		if(!parentThirdId.equals("0")) {
			parentId = parentThirdId;
		}else {
			if(!parentSecondId.equals("0")) {
				parentId = parentSecondId;
			}else {
				parentId = pid;
			}
		}
		try {
			productService.update(id,name, goodCode, originPlace,
					parentId, price,isMarketable, isTop, introduction, shop, files,productImageIds,originalPrice,warrantyPeriod,warrantDays,brandName,storageCondition,fullName,weight,startTime,endTime,pid);
			ModelAndView mv = new ModelAndView("redirect:/product/list");
			return mv;
		}catch(Exception e) {
			request.setAttribute("errorMessages", e.getMessage());
			request.setAttribute("redirectionUrl", "/admin/product/product");
			return new ModelAndView("admin/error");
		}
	}
	
	
}
