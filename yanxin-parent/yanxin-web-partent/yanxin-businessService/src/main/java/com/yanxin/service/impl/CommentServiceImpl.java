package com.yanxin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanxin.dao.CommentMapper;
import com.yanxin.dao.UserMapper;
import com.yanxin.domain.Comment;
import com.yanxin.domain.CommentExample;
import com.yanxin.service.CommentService;

import lombok.Synchronized;

@Primary
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public PageInfo<Comment> findCommentByShopId(Integer shopId,Integer pageNum,Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		CommentExample example = new CommentExample();
		
		example.createCriteria().andShopIdEqualTo(shopId);
		
		example.setOrderByClause("create_time desc");
		
		List<Comment> list = commentMapper.selectByExample(example);
		
		PageInfo<Comment> page = new PageInfo<Comment>(list);
		
		return page;
	}

	@Override
	@Synchronized
	@Transactional
	public Integer addComment(Comment comment) {

		comment.setCreateTime(new Date());
		return commentMapper.insert(comment);
	}
}
