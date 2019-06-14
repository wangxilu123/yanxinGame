package com.yanxin.service;

import java.util.List;
import java.util.Map;

import com.yanxin.domain.Advertisement;
import com.yanxin.domain.Motion;
import com.yanxin.domain.ProductTransfer;
import com.yanxin.domain.ShopCategory;


public interface HomePageService {

	List<ProductTransfer> findListAllWithCategory(Map<String, Object> map,Integer userId);
	
	List<ShopCategory> findShopOneCategory(Integer shopId);

	List<ShopCategory> findShopTwoCategory(Integer shopId,Integer productCategoryId);

	List<ShopCategory> findShopThreeCategory(Integer shopId, Integer productCategoryTwoId);

	List<ProductTransfer> findHotCategory(Map<String, Object> map);

	List<Advertisement> findAdvertisement(Integer shopId);

	List<Motion> findMotions(Integer shopId);
	
	List<Motion> findReport(Integer shopId);
	
	ProductTransfer findProductDetail(Integer productId,Integer shopId,Integer userId);
	
	List<ProductTransfer> pushProducts(Integer productCategoryTwoId,Integer productCategoryThirdId,Integer shopId,Integer userId);

	List<ProductTransfer> findHotProduct(Map<String, Object> map, Integer userId);

	List<ProductTransfer> findNewProduct(Map<String, Object> map, Integer userId);

	ProductTransfer findProductByCode(String barCode, Integer shopId, Integer userId);

	List<Advertisement> shopAdvertisement();
  
}
