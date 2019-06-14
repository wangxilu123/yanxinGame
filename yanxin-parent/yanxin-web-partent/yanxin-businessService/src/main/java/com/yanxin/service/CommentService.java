package com.yanxin.service;

import com.github.pagehelper.PageInfo;
import com.yanxin.domain.Comment;

public interface CommentService {

	PageInfo<Comment> findCommentByShopId(Integer shopId, Integer pageNum, Integer pageSize);

	Integer addComment(Comment comment);
	
}
