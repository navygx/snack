package com.yc.snack.user.mapper;

import com.yc.snack.user.bean.MemberInfo;

public interface IMemberInfoMapper {
	public MemberInfo login(MemberInfo mf);
	
	public int reg(MemberInfo mf);
}
