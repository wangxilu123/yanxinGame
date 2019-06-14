package com.yanxin.dao;

import com.yanxin.domain.ProductImage;

public interface ProductImageMapper {
   
	int insert(ProductImage productImage);
	
	int delete(Long id);
	
	ProductImage findById(Long id);
	
}