package com.yanxin.service.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanxin.common.LocationUtil;
import com.yanxin.dao.CommentMapper;
import com.yanxin.dao.ShopMapper;
import com.yanxin.domain.PsfwTransfer;
import com.yanxin.domain.Shop;
import com.yanxin.domain.ShopExample;
import com.yanxin.domain.ShopResponse;
import com.yanxin.service.ShopService;

@Primary
@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public Integer addShop(Shop shop) {
		
		return shopMapper.insert(shop);
	}

	@Override
	public Integer updateShop(Shop shop) {

		return null;
	}

	@Override
	public Integer deleteShop(Integer shopId) {

		return null;
	}

	@Override
	public List<ShopResponse> findShopByPoint(String longitude,String dimension) {
		
		ShopExample example = new ShopExample();
		
		example.setOrderByClause("id desc");
		
		List<ShopResponse> list = new ArrayList<>();
		
		List<Shop> shopList = shopMapper.selectByExample(example);
		
		for(Shop shop :shopList){
			
			if(shop.getElectronicFence()!=null){
				boolean location = LocationUtil.isInPolygon(longitude, dimension, shop.getElectronicFence());
				
				if(location==true){
					ShopResponse shopResponse = new ShopResponse();
					
					shopResponse.setDescription(shop.getDescription());
					shopResponse.setId(shop.getId());
					shopResponse.setImageUrl(shop.getImageUrl());
					shopResponse.setShopAddress(shop.getShopAddress());
					shopResponse.setShopName(shop.getShopName());
					
					list.add(shopResponse);
				}
			}
			
		}
		return list;
	}
	
	@Override
	public PageInfo<Shop> findShopByPage(Integer pageNum,Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		ShopExample example = new ShopExample();
		
		example.setOrderByClause("id desc");
		
		List<Shop> shopList = shopMapper.selectByExample(example);
		
		PageInfo<Shop> page = new PageInfo<>(shopList);
		return page;
	}
	
	@Override
	public PageInfo<Shop> findShopListByPage(Integer pageNum,Integer pageSize, String longitude, String dimension, String orderType,String industryType) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		Map<String,Object> map = new HashMap<>();
		map.put("longitude", longitude);
		map.put("dimension", dimension);
		map.put("orderType", orderType);
		map.put("industryType", industryType);
		List<Shop> shopList = shopMapper.findListByPage(map);
		for(Shop shop :shopList){
			//根据门店ID查询评分
			String dd=commentMapper.findAvgScore(shop.getId());
			if(dd!=null&&"".equals(dd)==false){
				
				Double score = Double.parseDouble(dd);
				NumberFormat  nf=new  DecimalFormat( "0.0 ");
				score = Double.parseDouble(nf.format(score));
				shop.setScore(score);
			}
			shop.setNeedTime((int)(shop.getDistance()/15000*60));
		}
		PageInfo<Shop> page = new PageInfo<>(shopList);
		return page;
	}

	@Override
	public Shop findShopById(Integer shopId) {
		
		Shop shop  =shopMapper.selectByPrimaryKey(shopId);
		
		//根据门店ID查询评分
		String dd=commentMapper.findAvgScore(shop.getId());
		if(dd!=null&&"".equals(dd)==false){
			
			Double score = Double.parseDouble(dd);
			NumberFormat  nf=new  DecimalFormat( "0.0 ");
			score = Double.parseDouble(nf.format(score));
			shop.setScore(score);
		}
		shop.setNeedTime((int)(shop.getDistance()/15000*60));
		
		return shop;
	}
	@Override
	public List<Shop> findListAll(){
		return shopMapper.findListAll();
	}
	@Override
	public List<PsfwTransfer> findPsfw(Integer shopId){
		
		List<Shop> list= new ArrayList<Shop>();
		if(shopId!=null){
			
			ShopExample example = new ShopExample();
			
			example.createCriteria().andIdEqualTo(shopId);
			list = shopMapper.selectByExample(example);
		}else{
			list = shopMapper.findListAll();
		}
		List<PsfwTransfer> psfwList= new ArrayList<>();
		for(Shop shop:list){
			
			PsfwTransfer psfw = new PsfwTransfer();
			
			psfw.setPsfw(shop.getElectronicFence());
			
			psfwList.add(psfw);
			
		}
		return  psfwList;

	}
}
