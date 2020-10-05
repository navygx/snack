package com.yc.snack.product.mapper;

import java.util.List;
import java.util.Map;

import com.yc.snack.product.bean.GoodsInfo;
import com.yc.snack.product.dto.CartInfoDTO;
import com.yc.snack.product.dto.ProductInfoDTO;

public interface IGoodsInfoMapper {
	public int add(GoodsInfo gf);
	
	public int update(GoodsInfo gf);
	
	/**
	 * 查看商品详细
	 * @param gid
	 * @return
	 */
	public GoodsInfo findByGid(String gno);
	
	public List<GoodsInfo> findByPage(Map<String, Object> map);
	
	public int total(Map<String, Object> map);
	
	public List<GoodsInfo> finds(Map<String, Object> map);

	public int totals(Map<String, Object> map);
	
	public List<ProductInfoDTO> listForGno(List<String> gnos);
	
	public List<ProductInfoDTO> listForCno(List<String> Cnos);

	public List<CartInfoDTO> findByCart(List<String> gnos);
	
	public int buckleStock(List<CartInfoDTO> list);
}


