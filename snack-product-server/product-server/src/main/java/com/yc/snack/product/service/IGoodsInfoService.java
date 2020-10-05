package com.yc.snack.product.service;

import java.util.List;
import java.util.Map;

import com.yc.snack.product.bean.GoodsInfo;
import com.yc.snack.product.dto.CartInfoDTO;
import com.yc.snack.product.dto.ProductInfoDTO;

public interface IGoodsInfoService {
	public int add(GoodsInfo gf);

	public int update(GoodsInfo gf);

	public GoodsInfo findByGid(String gno);

	public Map<String, Object> findByPage(Map<String, Object> map);

	public Map<String, Object> findByFirst(Map<String, Object> map);

	public List<GoodsInfo> finds(Map<String, Object> map);

	public List<ProductInfoDTO> listForGno(List<String> gnos);

	public List<ProductInfoDTO> listForCno(List<String> Cnos);

	public int buckleStock(List<CartInfoDTO> list);
	
	public List<CartInfoDTO> findByCart(List<String> gnos);
}
