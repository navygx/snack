package com.yc.snack.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.snack.product.dto.ProductTypeInfoDTO;
import com.yc.snack.product.service.IGoodsTypeService;

@RestController
@RequestMapping("/product")
public class GoodsTypesForOrderController {
	@Autowired
	private IGoodsTypeService goodsTypeSerice;
	
	@GetMapping("/types")
	public List<ProductTypeInfoDTO> findTypes() {
		return goodsTypeSerice.findTypes();
	}
}
