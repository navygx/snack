package com.yc.snack.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.snack.product.bean.GoodsType;
import com.yc.snack.product.mapper.IGoodsTypeMapper;
import com.yc.snack.product.service.IGoodsTypeService;
import com.yc.snack.product.util.StringUtil;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService{
	@Autowired
	private IGoodsTypeMapper goodsTypeMapper;
	
	@Override
	public int add(GoodsType type) {
		if (StringUtil.checkNull(type.getTname())) {
			return -1;
		}
		return goodsTypeMapper.add(type);
	}

	@Override
	public int update(GoodsType type) {
		if (StringUtil.checkNull(type.getTname())) {
			return -1;
		}
		return goodsTypeMapper.update(type);
	}

	@Override
	public List<GoodsType> findAll() {
		return goodsTypeMapper.findAll();
	}

	@Override
	public List<GoodsType> finds() {
		return goodsTypeMapper.finds();
	}
}
