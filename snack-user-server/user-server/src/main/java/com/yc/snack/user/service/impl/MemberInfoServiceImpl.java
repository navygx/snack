package com.yc.snack.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.snack.user.bean.MemberInfo;
import com.yc.snack.user.mapper.IMemberInfoMapper;
import com.yc.snack.user.service.IMemberInfoService;
import com.yc.snack.user.util.StringUtil;

@Service
public class MemberInfoServiceImpl implements IMemberInfoService{
	@Autowired
	private IMemberInfoMapper memberInfoMapper;
	
	@Override
	public MemberInfo login(MemberInfo mf) {
		if (StringUtil.checkNull(mf.getNickName(), mf.getPwd())) {
			return null;
		}
		return memberInfoMapper.login(mf);
	}
	
	@Override
	public int reg(MemberInfo mf) {
		if (StringUtil.checkNull(mf.getNickName(), mf.getEmail())) {
			return -1;
		}
		return memberInfoMapper.reg(mf);
	}
}
