package com.yc.snack.product.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.snack.product.bean.CartInfo;
import com.yc.snack.product.enums.ResultEnum;
import com.yc.snack.product.service.ICartInfoService;
import com.yc.snack.product.util.SessionConstantKeys;
import com.yc.snack.product.vo.CartInfoVO;
import com.yc.snack.product.vo.ResultVO;
import com.yc.snack.user.dto.MemberLoginInfoDTO;

@RestController
@RequestMapping("/cart")
public class CartInfoController {
	@Autowired
	private ICartInfoService cartInfoService;
	
	@PostMapping("/findByCnos")
	public ResultVO findByCnos(@RequestParam("cnos[]") String[] cnos) {
		List<CartInfoVO> list = cartInfoService.findByCnos(cnos);
		
		if (list == null || list.isEmpty()) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.SUCCESS, list);
	}
	
	/**
	 * 查询个人购物详细信息
	 * @param session
	 * @return
	 */
	@GetMapping("/finds")
	public ResultVO finds(HttpSession session) {
		Object obj = session.getAttribute(SessionConstantKeys.CURRENTMEMBERACCOUNT);
		if (obj == null) {
			return new ResultVO(ResultEnum.LOGIN_ERROR);
		}
		
		MemberLoginInfoDTO member = (MemberLoginInfoDTO) obj;
		
		List<CartInfoVO> list = cartInfoService.findByGno(String.valueOf(member.getMno()));
		
		if (list == null || list.isEmpty()) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.SUCCESS, list);
	}
	
	@PostMapping("/add")
	public ResultVO add(CartInfo cf, HttpSession session) {
		String cno = UUID.randomUUID().toString().replace("-", "");
		Object obj = session.getAttribute(SessionConstantKeys.CURRENTMEMBERACCOUNT);
		if (obj == null) {
			return new ResultVO(ResultEnum.LOGIN_ERROR);
		}
		
		MemberLoginInfoDTO member = (MemberLoginInfoDTO) obj;
		cf.setMno(member.getMno());
		cf.setCno(cno);
		
		int result = cartInfoService.add(cf);
		if (result > 0) {
			return new ResultVO(ResultEnum.SUCCESS);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	/**
	 * 修改购买数量
	 * @param map
	 * @return
	 */
	@PostMapping("/update")
	public ResultVO update(@RequestParam Map<String, Object> map) {
		int result = cartInfoService.updateNum(map);
		if (result > 0) {
			return new ResultVO(ResultEnum.SUCCESS);
		}
		return new ResultVO(ResultEnum.ERROR);
	}
	
	/**
	 * 获取购物车信息
	 * @param session
	 * @return
	 */
	@GetMapping("info")
	public ResultVO findByMno(HttpSession session) {
		Object obj = session.getAttribute(SessionConstantKeys.CURRENTMEMBERACCOUNT);
		if (obj == null) {
			return new ResultVO(ResultEnum.LOGIN_ERROR);
		}
		
		MemberLoginInfoDTO member = (MemberLoginInfoDTO) obj;
		List<CartInfo> list = cartInfoService.finds(String.valueOf(member.getMno()));
		if (list == null || list.isEmpty()) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.SUCCESS, list);
	}
	
	@PostMapping("/del")
	public int  delCart(@RequestParam List<String> cnos) {
		return cartInfoService.delete(cnos);
	}
}
