package com.yc.snack.product.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.snack.product.bean.GoodsInfo;
import com.yc.snack.product.dto.CartInfoDTO;
import com.yc.snack.product.dto.ProductInfoDTO;
import com.yc.snack.product.enums.ResultEnum;
import com.yc.snack.product.exception.ProductException;
import com.yc.snack.product.mapper.IGoodsInfoMapper;
import com.yc.snack.product.service.IGoodsInfoService;
import com.yc.snack.product.util.RequestParamUtil;
import com.yc.snack.product.util.StringUtil;

@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService{
	@Autowired
	private IGoodsInfoMapper goodsInfoMapper;

	@Override
	public int add(GoodsInfo gf) {
		if (StringUtil.checkNull(gf.getGname(), gf.getPrice(), gf.getPics())) {
			return -1;
		}
		return goodsInfoMapper.add(gf);
	}

	@Override
	public int update(GoodsInfo gf) {
		if (StringUtil.checkNull(gf.getGname(), gf.getPrice(), gf.getPics())) {
			return -1;
		}
		return goodsInfoMapper.update(gf);
	}

	@Override
	public GoodsInfo findByGid(String gno) {
		if (StringUtil.checkNull(gno)) {
			return null;
		}
		return goodsInfoMapper.findByGid(gno);
	}

	@Override
	public Map<String, Object> findByPage(Map<String, Object> map) {
		map = RequestParamUtil.updateFindByPage(map);
		map.put("total", goodsInfoMapper.total(map));
		map.put("rows", goodsInfoMapper.findByPage(map));
		return map;
	}

	@Override
	public Map<String, Object> findByFirst(Map<String, Object> map) {
		map = RequestParamUtil.updateFindByPage(map);
		map.put("total", goodsInfoMapper.totals(map));
		map.put("rows", goodsInfoMapper.findByPage(map));
		return map;
	}

	@Override
	public List<GoodsInfo> finds(Map<String, Object> map) {
		map = RequestParamUtil.updateFindByPage(map);
		return goodsInfoMapper.finds(map);
	}

	@Override
	public List<ProductInfoDTO> listForGno(List<String> gnos) {
		if (gnos == null || gnos.isEmpty()) {
			return Collections.emptyList();
		}
		return goodsInfoMapper.listForGno(gnos);
	}

	@Override
	public List<ProductInfoDTO> listForCno(List<String> cnos) {
		if (cnos == null || cnos.isEmpty()) {
			return Collections.emptyList();
		}
		return goodsInfoMapper.listForCno(cnos);
	}

	/**
	 * 扣库存的方法
	 */
	@Override
	public int buckleStock(List<CartInfoDTO> list) {
		int result = 0;
		
		// 获取需要扣库存的商品编号
		List<String> gnos = list.stream().map(CartInfoDTO::getGno).collect(Collectors.toList());
		
		// 查看这些商品的库存量够不够
		List<CartInfoDTO> goodsList = this.findByCart(gnos); // 获取需要扣存款的商品的商品编号和仓库量
		
		if (goodsList.size() < list.size()) { // 说明有些商品没有查到
			throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
		}
		
		for (CartInfoDTO item : list) {
			for (CartInfoDTO product : goodsList) {
				if (item.getGno().equals(product.getGno())) {
					if (item.getNums() > product.getNums()) {
						throw new ProductException(ResultEnum.PRODUCT_INSUFFICIENT_STOCK);
					}
				
					item.setNums(product.getNums() - item.getNums()); // 最终的仓库量是原有仓库量-你所购买的商品数量
					continue;
				}
			}
		}
		
		result = goodsInfoMapper.buckleStock(goodsList);
		
		if (result > 0) { // 说明扣库存成功，这个时候发送一个消息出去，告诉其他服务库存变了
			// DOTO 发到消息到rabbitmq里面
			
		}
		return result;
	}

	@Override
	public List<CartInfoDTO> findByCart(List<String> gnos) {
		return goodsInfoMapper.findByCart(gnos);
	}
}
