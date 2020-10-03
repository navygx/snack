package com.yc.snack.product.enums;

public enum ResultEnum {
	ERROR(500,"失败"),
	SUCCESS(200,"成功"),
	DATA_NULL(501,"数据为空");
	
	private Integer code;
	private String msg;
	
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
