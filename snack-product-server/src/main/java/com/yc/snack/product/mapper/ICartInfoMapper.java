package com.yc.snack.product.mapper;

import java.util.List;
import java.util.Map;

import com.yc.snack.product.bean.CartInfo;

public interface ICartInfoMapper {
	public List<CartInfo> finds(String mno);
	
	public List<Map<String, String>> info(String mno);
	
	public List<CartInfo> findByCno(String[] cnos);
	
	public int updateNum(Map<String, Object> map);
	
	public int delete(String[] cnos);
	
	public int add(CartInfo cf);
}
