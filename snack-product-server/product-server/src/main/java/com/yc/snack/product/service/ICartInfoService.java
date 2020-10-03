package com.yc.snack.product.service;

import java.util.List;
import java.util.Map;

import com.yc.snack.product.bean.CartInfo;

public interface ICartInfoService {
	public List<CartInfo> finds(String mno);
	
	public List<Map<String, String>> info(String mno);
	
	public List<CartInfo> findByCno(String cnos);
	
	public int updateNum(Map<String, Object> map);
	
	public int delete(String[] cnos);
	
	public int add(CartInfo cf);
}
