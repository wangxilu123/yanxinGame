package com.yanxin.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.yanxin.domain.PsfwTransfer;
import com.yanxin.domain.Shop;
import com.yanxin.domain.ShopResponse;


public interface ShopService {

	/**
     * 添加门店
     * @param Shop
     * @return
     */
	Integer addShop(Shop shop);
	
    /**
     * 修改门店信息
     * @param Shop
     * @return
     */
    Integer updateShop(Shop shop);
    
    /**
     * 删除门店
     * @param Shop
     * @return
     */
    Integer deleteShop(Integer shopId);
    
    /**
     * 根据门店ID查询门店信息
     * @param ShopId
     * @return
     */
    Shop findShopById(Integer shopId);

    List<ShopResponse> findShopByPoint(String longitude, String dimension);
    
	PageInfo<Shop> findShopByPage(Integer pageNum, Integer pageSize);
	
	List<Shop> findListAll();

	List<PsfwTransfer> findPsfw(Integer shopId);

	PageInfo<Shop> findShopListByPage(Integer pageNum, Integer pageSize,String longitude, String dimension, String orderType,String industryType);
}
