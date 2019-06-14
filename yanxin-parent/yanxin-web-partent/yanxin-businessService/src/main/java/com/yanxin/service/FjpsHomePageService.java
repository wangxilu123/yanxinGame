package com.yanxin.service;

import com.yanxin.domain.FjpsHomePage;

public interface FjpsHomePageService {
	
	FjpsHomePage  findHomePageNum (Integer adminId,Integer shopId);
}
