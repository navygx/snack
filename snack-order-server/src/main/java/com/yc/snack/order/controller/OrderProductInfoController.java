package com.yc.snack.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.snack.order.enums.ResultEnum;
import com.yc.snack.order.vo.ResultVo;
import com.yc.snack.product.dto.ProductInfoDTO;

import net.sf.ehcache.util.ProductInfo;

@RestController
@RequestMapping("product")
public class OrderProductInfoController {
	@PostMapping("listForGno")
	public ResultVo listForGno(@RequestParam List<String> gnos) {
		ProductInfoDTO dto=null;
		return new ResultVo(ResultEnum.DATA_NULL);
	}
}
