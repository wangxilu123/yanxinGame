package com.yanxin.service;

import org.springframework.stereotype.Service;

import com.yanxin.domain.RedisKeyDto;


@Service
public interface RedisService {
	void addData(RedisKeyDto redisKeyDto);
    void delete(RedisKeyDto redisKeyDto);
    RedisKeyDto redisGet(RedisKeyDto redisKeyDto);
    void addRedisData(RedisKeyDto redisKeyDto,int outTime);
}
