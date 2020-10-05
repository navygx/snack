package com.yc.snack.product.mapper;

import java.util.List;
import java.util.Map;

import com.yc.snack.product.bean.CartInfo;
import com.yc.snack.product.vo.CartInfoVO;

public interface ICartInfoMapper {
	/**
	 * 根据会员编号获取购物车信息
	 * @param mno
	 * @return
	 */
	public List<CartInfo> finds(String mno);
	
	/**
	 * 根据会员编号获取购物车信息
	 * @param mno
	 * @return
	 */
	public List<CartInfoVO> findByGno(String mno);
	
	/**
	 * 根据购物车编号获取购物信息
	 * @param mno
	 * @return
	 */
	public List<CartInfoVO> findByCnos(String[] cnos);
	
	/**
	 * 修改购买数量
	 * @param map
	 * @return
	 */
	public int updateNum(Map<String, Object> map);
	
	/**
	 * 删除购物车数据
	 * @param cnos
	 * @return
	 */
	public int delete(List<String> cnos);
	
	/**
	 * 加入购物车
	 * @param cf
	 * @return
	 */
	public int add(CartInfo cf);
}
