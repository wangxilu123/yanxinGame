package com.yanxin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.yanxin.common.ResultDto;
import com.yanxin.domain.AppUser;
import com.yanxin.domain.Comment;
import com.yanxin.service.CommentService;
import com.yanxin.service.impl.CheckToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 类说明:
 * @author 作者 E-mail: wangxilu
 */
@Api(description = "评论相关接口")
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CheckToken checkToken;
	

	@ApiOperation(value = "根据门店查询评论", nickname = "根据门店查询评论")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum", value = "第几页，默认1", required = false, paramType = "query", dataType = "int"),
		@ApiImplicitParam(name = "pageSize", value = "每页多少条，默认10", required = false, paramType = "query", dataType = "int"),
        @ApiImplicitParam(name = "shopId", required = false, paramType = "query", dataType = "int")
    })
	@GetMapping("/findComment")
	public ResultDto<PageInfo<Comment>> findFirstCategory(HttpServletRequest request,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "shopId", required = false) Integer shopId){

			PageInfo<Comment> result = commentService.findCommentByShopId(shopId, pageNum, pageSize);

			return new ResultDto<>(200, "查询成功！", result);
	}
	
	@ApiOperation(value = "评论接口",nickname = "评论接口")
    @ApiImplicitParam(name = "Comment", required = true, dataType = "Comment")
    @PostMapping("/addComment")
    public ResultDto<Integer> addStaffDistribution(HttpServletRequest request, @RequestBody  Comment comment){
    	
		AppUser appUser = checkToken.check(request.getHeader("token"));

		if (appUser != null) {
    		comment.setUserId(appUser.getId());
    		comment.setUserName(appUser.getUserName());
    	Integer id = commentService.addComment(comment);
    		return new ResultDto<>(200,"评论成功！",id);
    	}else{
    		return new ResultDto<>(403,"token失效请重新登录！");
    	}
    }
	
}