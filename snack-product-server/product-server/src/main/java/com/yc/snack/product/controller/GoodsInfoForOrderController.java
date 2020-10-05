package com.yc.snack.product.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.snack.product.dto.ProductInfoDTO;
import com.yc.snack.product.service.IGoodsInfoService;

@RestController
@RequestMapping("/product")
public class GoodsInfoForOrderController {
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	@PostMapping("/listForGno")
	public List<ProductInfoDTO> listForGno(@RequestBody List<String> gnos){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsInfoService.listForGno(gnos);
	}
	
	@PostMapping("/listForGnos")
	public List<ProductInfoDTO> listForGnos(@RequestBody List<String> gnos){
		return goodsInfoService.listForGno(gnos);
	}
	
	@PostMapping("/listForCno")
	public List<ProductInfoDTO> listForCno(@RequestBody List<String> cnos){
		return goodsInfoService.listForCno(cnos);
	}
}
