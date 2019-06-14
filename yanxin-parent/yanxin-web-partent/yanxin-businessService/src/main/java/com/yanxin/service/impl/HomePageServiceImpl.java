package com.yanxin.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yanxin.dao.AdvertisementMapper;
import com.yanxin.dao.MotionMapper;
import com.yanxin.dao.ProductCategoryMapper;
import com.yanxin.dao.ProductImageMapper;
import com.yanxin.dao.ProductMapper;
import com.yanxin.dao.PromotionMapper;
import com.yanxin.dao.ShopCartMapper;
import com.yanxin.domain.Advertisement;
import com.yanxin.domain.AdvertisementExample;
import com.yanxin.domain.Motion;
import com.yanxin.domain.MotionExample;
import com.yanxin.domain.ProductCategory;
import com.yanxin.domain.ProductImage;
import com.yanxin.domain.ProductTransfer;
import com.yanxin.domain.Promotion;
import com.yanxin.domain.ShopCart;
import com.yanxin.domain.ShopCartExample;
import com.yanxin.domain.ShopCategory;
import com.yanxin.service.HomePageService;

@Primary
@Service
public class HomePageServiceImpl implements HomePageService {

	@Autowired
	private ProductMapper productDao;
	
	@Autowired
	private ProductImageMapper productImageMapper;
	
	@Autowired
	private AdvertisementMapper advertisementMapper;
	
	@Autowired
	private PromotionMapper promotionMapper;
	
	@Autowired
	private MotionMapper motionMapper;
	
	@Autowired
	private ShopCartMapper shopCartMapper;
	@Autowired
	private ProductCategoryMapper  productCategoryMapper;
	
	@Override
	public List<ProductTransfer> findListAllWithCategory(Map<String,Object> map,Integer userId){
		
		List<ProductTransfer> list = productDao.findListAllWithCategory(map);
		
		for(ProductTransfer productTransfer : list){
			if(productTransfer.getStartTime()!=null&&productTransfer.getEndTime()!=null){
				Calendar date = Calendar.getInstance();
				
				date.setTime(new Date());

		        Calendar begin = Calendar.getInstance();
		        begin.setTime(productTransfer.getStartTime());

		        Calendar end = Calendar.getInstance();
		        end.setTime(productTransfer.getEndTime());
				
				if(date.after(begin) && date.before(end)){
					productTransfer.setPrice(productTransfer.getPrice());
					productTransfer.setOriginalPrice(productTransfer.getOriginalPrice());
				}else{
					productTransfer.setPrice(productTransfer.getOriginalPrice());
					productTransfer.setOriginalPrice(null);
				}
			}else{
				productTransfer.setOriginalPrice(null);
			}
			
			if(productTransfer.getImage()!=null&&"".equals(productTransfer.getImage())==false){
				String[] imageIds = productTransfer.getImage().split(",");
				
				ProductImage image = productImageMapper.findById(Long.valueOf(imageIds[0]));
				
				productTransfer.setImage(image!=null?image.getUrl():"");
			}
			//根据商品ID和门店ID查询促销信息
			List<Promotion> promotionList = promotionMapper.findByProductId(map);
			
			productTransfer.setPromotionList(promotionList);
			
			//根据商品ID和门店ID查询购物车信息
			if(userId!=null){
				
				ShopCartExample example = new ShopCartExample();
				example.createCriteria().andShopIdEqualTo(productTransfer.getShopId()).andProductIdEqualTo(productTransfer.getId().intValue()).andUserIdEqualTo(userId);
				
				List<ShopCart> cartList = shopCartMapper.selectByExample(example);
				if(cartList!=null&&cartList.size()!=0){
					productTransfer.setShopCartNum(cartList.get(0).getGoodNum());
					productTransfer.setShopCartId(cartList.get(0).getId());
				}
				
			}
			
			
		}
		return list;
	}
	
	@Override
	public List<ProductTransfer> findHotProduct(Map<String,Object> map,Integer userId){
		
		List<ProductTransfer> list = productDao.findHotProduct(map);
		
		for(ProductTransfer productTransfer : list){
			if(productTransfer.getStartTime()!=null&&productTransfer.getEndTime()!=null){
				Calendar date = Calendar.getInstance();
				
				date.setTime(new Date());

		        Calendar begin = Calendar.getInstance();
		        begin.setTime(productTransfer.getStartTime());

		        Calendar end = Calendar.getInstance();
		        end.setTime(productTransfer.getEndTime());
				
				if(date.after(begin) && date.before(end)){
					productTransfer.setPrice(productTransfer.getPrice());
					productTransfer.setOriginalPrice(productTransfer.getOriginalPrice());
				}else{
					productTransfer.setPrice(productTransfer.getOriginalPrice());
					productTransfer.setOriginalPrice(null);
				}
			}else{
				productTransfer.setOriginalPrice(null);
			}
			
			if(productTransfer.getImage()!=null&&"".equals(productTransfer.getImage())==false){
				String[] imageIds = productTransfer.getImage().split(",");
				
				ProductImage image = productImageMapper.findById(Long.valueOf(imageIds[0]));
				
				productTransfer.setImage(image!=null?image.getUrl():"");
			}
			//根据商品ID和门店ID查询促销信息
			List<Promotion> promotionList = promotionMapper.findByProductId(map);
			
			productTransfer.setPromotionList(promotionList);
			
			//根据商品ID和门店ID查询购物车信息
			if(userId!=null){
				
				ShopCartExample example = new ShopCartExample();
				example.createCriteria().andShopIdEqualTo(productTransfer.getShopId()).andProductIdEqualTo(productTransfer.getId().intValue()).andUserIdEqualTo(userId);
				
				List<ShopCart> cartList = shopCartMapper.selectByExample(example);
				if(cartList!=null&&cartList.size()!=0){
					productTransfer.setShopCartNum(cartList.get(0).getGoodNum());
					productTransfer.setShopCartId(cartList.get(0).getId());
				}
				
			}
			
			
		}
		return list;
	}
	
	@Override
	public List<ProductTransfer> findNewProduct(Map<String,Object> map,Integer userId){
		
		List<ProductTransfer> list = productDao.findNewProduct(map);
		
		for(ProductTransfer productTransfer : list){
			
			if(productTransfer.getStartTime()!=null&&productTransfer.getEndTime()!=null){
				Calendar date = Calendar.getInstance();
				
				date.setTime(new Date());

		        Calendar begin = Calendar.getInstance();
		        begin.setTime(productTransfer.getStartTime());

		        Calendar end = Calendar.getInstance();
		        end.setTime(productTransfer.getEndTime());
				
				if(date.after(begin) && date.before(end)){
					productTransfer.setPrice(productTransfer.getPrice());
					productTransfer.setOriginalPrice(productTransfer.getOriginalPrice());
				}else{
					productTransfer.setPrice(productTransfer.getOriginalPrice());
					productTransfer.setOriginalPrice(null);
				}
			}else{
				productTransfer.setOriginalPrice(null);
			}
			
			if(productTransfer.getImage()!=null&&"".equals(productTransfer.getImage())==false){
				String[] imageIds = productTransfer.getImage().split(",");
				
				ProductImage image = productImageMapper.findById(Long.valueOf(imageIds[0]));
				
				productTransfer.setImage(image!=null?image.getUrl():"");
			}
			//根据商品ID和门店ID查询促销信息
			List<Promotion> promotionList = promotionMapper.findByProductId(map);
			
			productTransfer.setPromotionList(promotionList);
			
			//根据商品ID和门店ID查询购物车信息
			if(userId!=null){
				
				ShopCartExample example = new ShopCartExample();
				example.createCriteria().andShopIdEqualTo(productTransfer.getShopId()).andProductIdEqualTo(productTransfer.getId().intValue()).andUserIdEqualTo(userId);
				
				List<ShopCart> cartList = shopCartMapper.selectByExample(example);
				if(cartList!=null&&cartList.size()!=0){
					productTransfer.setShopCartNum(cartList.get(0).getGoodNum());
					productTransfer.setShopCartId(cartList.get(0).getId());
				}
				
			}
			
			
		}
		return list;
	}
	
	@Override
	public List<ProductTransfer> findHotCategory(Map<String,Object> map){
		return productDao.findHotCategory(map);
	}

	@Override
	public List<ShopCategory> findShopOneCategory(Integer shopId) {
		
		List<ShopCategory> catList = productDao.findShopCategory(shopId);
		for(ShopCategory shopCategory : catList){
			ProductCategory productCategory = productCategoryMapper.findById(shopCategory.getId());
			
			ProductImage productImage = productImageMapper.findById(Long.valueOf(productCategory.getTreePath()));
			
			shopCategory.setImageUrl(productImage.getUrl());
		}
		
		return catList;
	}
	
	@Override
	public List<ShopCategory> findShopTwoCategory(Integer shopId,Integer productCategoryId) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("shopId", shopId);
		map.put("productCategoryId", productCategoryId);
		return productDao.findShopCategoryTwo(map);
	}
	
	@Override
	public List<ShopCategory> findShopThreeCategory(Integer shopId,Integer productCategoryTwoId) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("shopId", shopId);
		map.put("productCategoryTwoId", productCategoryTwoId);
		return productDao.findShopCategoryThird(map);
	}
	
	@Override
	public List<Advertisement> findAdvertisement(Integer shopId) {
		
		AdvertisementExample example = new AdvertisementExample();
		
		example.createCriteria().andShopIdEqualTo(shopId).andOnShelfEqualTo(1);
		
		return advertisementMapper.selectByExample(example);
	}
	
	@Override
	public List<Advertisement> shopAdvertisement() {
		
		AdvertisementExample example = new AdvertisementExample();
		
		example.createCriteria().andIsShopEqualTo(0);
		
		return advertisementMapper.selectByExample(example);
	}
	
	@Override
	public List<Motion> findMotions(Integer shopId) {
		
		MotionExample example = new MotionExample();
		
		example.createCriteria().andShopIdEqualTo(shopId).andOnShelfEqualTo(1).andTypeEqualTo("0");
		
		List<Motion> motionList = motionMapper.selectByExample(example);
		if(motionList.size()!=0){
			
			for(Motion motion : motionList){
				List<ProductTransfer> productList = new ArrayList<>();
				
				if("".equals(motion.getProductIds())==false&&motion.getProductIds()!=null){
					String[] ids = motion.getProductIds().split(",");
					
					for(int i=0;i<ids.length;i++){
						//根据商品ID查询商品信息
						ProductTransfer product = productDao.findById(Long.parseLong(ids[i]));
						if(product!=null){
							if(product.getImage()!=null&&"".equals(product.getImage())==false){
								String[] imageIds = product.getImage().split(",");
								
								ProductImage image = productImageMapper.findById(Long.valueOf(imageIds[0]));
								
								product.setImage(image!=null?image.getUrl():"");
							}
							
							productList.add(product);
						}
						
					}
				}
				motion.setProductList(productList);
			}
		}
		return  motionList;
	}

	@Override
	public ProductTransfer findProductDetail(Integer productId,Integer shopId,Integer userId) {
		ProductTransfer product = productDao.findById((long)productId);
		if(product!=null){
			if(product.getStartTime()!=null&&product.getEndTime()!=null){
				Calendar date = Calendar.getInstance();
				
				date.setTime(new Date());

		        Calendar begin = Calendar.getInstance();
		        begin.setTime(product.getStartTime());

		        Calendar end = Calendar.getInstance();
		        end.setTime(product.getEndTime());
				
				if(date.after(begin) && date.before(end)){
					product.setPrice(product.getPrice());
					product.setOriginalPrice(product.getOriginalPrice());
				}else{
					product.setPrice(product.getOriginalPrice());
					product.setOriginalPrice(null);
				}
			}else{
				product.setOriginalPrice(null);
			}
			
			if(product.getImage()!=null&&"".equals(product.getImage())==false){
				String[] imageIds = product.getImage().split(",");
				
				List<ProductImage> imageList = new ArrayList<>();
				
				for(int i=0;i<imageIds.length;i++){
					
					ProductImage productImage = productImageMapper.findById(Long.valueOf(imageIds[i]));
					
					imageList.add(productImage);
				}
				product.setProductImageList(imageList);
				product.setImage(imageList.get(0).getUrl());
			}
			
			//根据商品ID和门店ID查询购物车信息
			if(userId!=null){
				
				ShopCartExample example = new ShopCartExample();
				example.createCriteria().andShopIdEqualTo(shopId).andProductIdEqualTo(productId).andUserIdEqualTo(userId);
				
				List<ShopCart> cartList = shopCartMapper.selectByExample(example);
				if(cartList!=null&&cartList.size()!=0){
					product.setShopCartNum(cartList.get(0).getGoodNum());
					product.setShopCartId(cartList.get(0).getId());
				}
				
			}
		}
		return product;
	}
	
	
	@Override
	public ProductTransfer findProductByCode(String barCode,Integer shopId,Integer userId) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("barCode", barCode);
		map.put("shopId", shopId);
		ProductTransfer product = productDao.findByBarCode(map);
		if(product!=null){
			if(product.getStartTime()!=null&&product.getEndTime()!=null){
				Calendar date = Calendar.getInstance();
				
				date.setTime(new Date());

		        Calendar begin = Calendar.getInstance();
		        begin.setTime(product.getStartTime());

		        Calendar end = Calendar.getInstance();
		        end.setTime(product.getEndTime());
				
				if(date.after(begin) && date.before(end)){
					product.setPrice(product.getPrice());
					product.setOriginalPrice(product.getOriginalPrice());
				}else{
					product.setPrice(product.getOriginalPrice());
					product.setOriginalPrice(null);
				}
			}else{
				product.setOriginalPrice(null);
			}
			
			if(product.getImage()!=null&&"".equals(product.getImage())==false){
				String[] imageIds = product.getImage().split(",");
				
				List<ProductImage> imageList = new ArrayList<>();
				
				for(int i=0;i<imageIds.length;i++){
					
					ProductImage productImage = productImageMapper.findById(Long.valueOf(imageIds[i]));
					
					imageList.add(productImage);
				}
				product.setProductImageList(imageList);
				product.setImage(imageList.get(0).getUrl());
			}
			
			//根据商品ID和门店ID查询购物车信息
			if(userId!=null){
				
				ShopCartExample example = new ShopCartExample();
				example.createCriteria().andShopIdEqualTo(shopId).andProductIdEqualTo(product.getId().intValue()).andUserIdEqualTo(userId);
				
				List<ShopCart> cartList = shopCartMapper.selectByExample(example);
				if(cartList!=null&&cartList.size()!=0){
					product.setShopCartNum(cartList.get(0).getGoodNum());
					product.setShopCartId(cartList.get(0).getId());
				}
				
			}
		}
		return product;
	}

	@Override
	public List<ProductTransfer> pushProducts(Integer productCategoryTwoId,Integer productCategoryThirdId, Integer shopId, Integer userId) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("shopId", shopId);
		if(productCategoryTwoId!=null&&"".equals(productCategoryTwoId)==false){
			map.put("productCategoryTwoId", productCategoryTwoId);
		}
		if(productCategoryThirdId!=null&&"".equals(productCategoryThirdId)==false){
			map.put("productCategoryThirdId", productCategoryThirdId);
		}
		
		List<ProductTransfer> list = productDao.findPushProduct(map);
		
		for(ProductTransfer productTransfer : list){
			if(productTransfer.getStartTime()!=null&&productTransfer.getEndTime()!=null){
				Calendar date = Calendar.getInstance();
				
				date.setTime(new Date());

		        Calendar begin = Calendar.getInstance();
		        begin.setTime(productTransfer.getStartTime());

		        Calendar end = Calendar.getInstance();
		        end.setTime(productTransfer.getEndTime());
				
				if(date.after(begin) && date.before(end)){
					productTransfer.setPrice(productTransfer.getPrice());
					productTransfer.setOriginalPrice(productTransfer.getOriginalPrice());
				}else{
					productTransfer.setPrice(productTransfer.getOriginalPrice());
					productTransfer.setOriginalPrice(null);
				}
			}else{
				productTransfer.setOriginalPrice(null);
			}
			
			if(productTransfer.getImage()!=null&&"".equals(productTransfer.getImage())==false){
				String[] imageIds = productTransfer.getImage().split(",");
				
				ProductImage image = productImageMapper.findById(Long.valueOf(imageIds[0]));
				
				productTransfer.setImage(image!=null?image.getUrl():"");
			}
			//根据商品ID和门店ID查询促销信息
			List<Promotion> promotionList = promotionMapper.findByProductId(map);
			
			productTransfer.setPromotionList(promotionList);
			
			//根据商品ID和门店ID查询购物车信息
			if(userId!=null){
				
				ShopCartExample example = new ShopCartExample();
				example.createCriteria().andShopIdEqualTo(shopId).andProductIdEqualTo(productTransfer.getId().intValue()).andUserIdEqualTo(userId);
				
				List<ShopCart> cartList = shopCartMapper.selectByExample(example);
				if(cartList!=null&&cartList.size()!=0){
					productTransfer.setShopCartNum(cartList.get(0).getGoodNum());
				}
			}
		}
		
		return list;
	}

	@Override
	public List<Motion> findReport(Integer shopId) {
		
        MotionExample example = new MotionExample();
		
		example.createCriteria().andShopIdEqualTo(shopId).andOnShelfEqualTo(1).andTypeEqualTo("1");
		
		List<Motion> motionList = motionMapper.selectByExample(example);
		
		return motionList;
	}
}
