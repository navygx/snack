package com.yc.snack.product.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.snack.product.bean.CartInfo;
import com.yc.snack.product.mapper.ICartInfoMapper;
import com.yc.snack.product.service.ICartInfoService;
import com.yc.snack.product.util.StringUtil;
import com.yc.snack.product.vo.CartInfoVO;

/**
 * company 源辰信息
 * @author navy
 * @date 2020年8月23日
 * Email haijunzhou@hnit.edu.cn
 */
@Service
public class CartInfoServiceImpl implements ICartInfoService{
	@Autowired
	private ICartInfoMapper cartInfoMapper;

	@Override
	public List<CartInfo> finds(String mno) {
		if (StringUtil.checkNull(mno)) {
			return Collections.emptyList();
		}
		return cartInfoMapper.finds(mno);
	}

	@Override
	public int updateNum(Map<String, Object> map) {
		if (StringUtil.checkNull(String.valueOf(map.get("cno")))) {
			return -1;
		}
		return cartInfoMapper.updateNum(map);
	}

	@Override
	public int add(CartInfo cf) {
		if (StringUtil.checkNull(cf.getCno())) {
			return -1;
		}
		return cartInfoMapper.add(cf);
	}

	@Override
	public List<CartInfoVO> findByCnos(String[] cnos) {
		if (cnos == null || cnos.length <= 0) {
			return Collections.emptyList();
		}
		return cartInfoMapper.findByCnos(cnos);
	}

	@Override
	public int delete(List<String> cnos) {
		if (cnos == null || cnos.isEmpty()) {
			return -1;
		}
		return cartInfoMapper.delete(cnos);
	}

	@Override
	public List<CartInfoVO> findByGno(String mno) {
		if (StringUtil.checkNull(mno)) {
			return Collections.emptyList();
		}
		return cartInfoMapper.findByGno(mno);
	}
}
