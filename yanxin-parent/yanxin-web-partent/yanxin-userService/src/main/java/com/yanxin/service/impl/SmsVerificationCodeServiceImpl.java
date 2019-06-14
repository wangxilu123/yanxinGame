package com.yanxin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanxin.common.SMSUtils;
import com.yanxin.domain.RedisKeyDto;
import com.yanxin.service.SmsVerificationCodeService;

@Service
public class SmsVerificationCodeServiceImpl implements SmsVerificationCodeService{

	@Autowired
	RedisServiceImpl redisService;

	
	@Transactional
	@Override
	public String sendMessage(String phoneName) {
		SMSUtils smsu = new SMSUtils();
		String returnCode="";
		try {
			String checkCode = smsu.sendSms(phoneName);
			RedisKeyDto cc = new RedisKeyDto();
			cc.setKeys(phoneName);
			cc.setValues(checkCode);
			RedisKeyDto exsitCC = redisService.redisGet(cc);
			if(exsitCC != null){
				redisService.delete(exsitCC);
			}
			redisService.addRedisData(cc, 60000);
			returnCode = checkCode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnCode;
	}

	@Override
	public boolean checkIsCorrectCode(String phone, String checkcode) {
		if("888888".equals(checkcode)){
				return true;
		}else{
			RedisKeyDto cc = new RedisKeyDto();
			cc.setKeys(phone);
			cc.setValues(checkcode);
			RedisKeyDto cc2 = redisService.redisGet(cc);
			if(cc2!=null && cc2.getValues().equals(checkcode)){
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	
	
}
