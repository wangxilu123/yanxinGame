package com.yanxin.dao;

import java.util.List;
import java.util.Map;

import com.yanxin.domain.Product;
import com.yanxin.domain.ProductTransfer;
import com.yanxin.domain.ShopCategory;


public interface ProductMapper {

	public List<ProductTransfer> findListAllWithCategory(Map<String,Object> map);
	
	public List<ProductTransfer> findHotProduct(Map<String,Object> map);
	
	public List<ProductTransfer> findNewProduct(Map<String,Object> map);
	
	public List<ProductTransfer> findHotCategory(Map<String,Object> map);
	
	int insert(Product product);
	
	int update(Product product);
	
	int delete(Long id);
	
	ProductTransfer findById(Long id);
	
	ProductTransfer findByBarCode (Map<String,Object> map);
	
	Product findProductById(Long id);
	
	Product findProductByGoodCode(String goodCode);
	
	List<ShopCategory> findShopCategory(Integer shopId);
	
	List<ShopCategory> findShopCategoryTwo(Map<String,Object> map);
	
	List<ShopCategory> findShopCategoryThird(Map<String,Object> map);
	
	List<Product> findProducts(Map<String,Object> map);
	
	List<ProductTransfer> findPushProduct(Map<String,Object> map);
	
	long countByExample(boolean isMarketable);
}