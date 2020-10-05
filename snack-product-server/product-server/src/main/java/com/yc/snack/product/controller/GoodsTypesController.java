package com.yc.snack.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.snack.product.bean.GoodsType;
import com.yc.snack.product.enums.ResultEnum;
import com.yc.snack.product.service.IGoodsTypeService;
import com.yc.snack.product.vo.ResultVO;


@RestController
@RequestMapping("/types")
public class GoodsTypesController {
	@Autowired
	private IGoodsTypeService goodsTypeService;
	
	@GetMapping("/finds")
	public ResultVO finds() {
		List<GoodsType> list=goodsTypeService.finds();
		if(list==null || list.isEmpty()) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.SUCCESS,list);
	}
	
	@GetMapping("/findAll")
	public List<GoodsType> findAll(){
		return goodsTypeService.findAll();
	}
	
	@GetMapping("/find")
	public List<GoodsType> find(){
		return goodsTypeService.finds();
	}
}
