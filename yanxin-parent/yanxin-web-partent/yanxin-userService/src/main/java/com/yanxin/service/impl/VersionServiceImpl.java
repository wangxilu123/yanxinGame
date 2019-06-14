package com.yanxin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yanxin.dao.VersionMapper;
import com.yanxin.domain.Version;
import com.yanxin.domain.VersionExample;
import com.yanxin.service.VersionService;

@Primary
@Service
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionMapper versionMapper;

	@Override
	public Version getVersion() {
		
		VersionExample example = new VersionExample();
		
		example.setOrderByClause("id desc");
		
		List<Version> list  = versionMapper.selectByExample(example);
		
		return list.get(0);
	}

}
