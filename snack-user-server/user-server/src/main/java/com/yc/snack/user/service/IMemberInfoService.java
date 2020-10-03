package com.yc.snack.user.service;

import com.yc.snack.user.bean.MemberInfo;

public interface IMemberInfoService {
	public MemberInfo login(MemberInfo mf);
	
	public int reg(MemberInfo mf);
}
