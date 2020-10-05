package com.yc.snack.product.exception;

import com.yc.snack.product.enums.ResultEnum;

public class ProductException extends RuntimeException{
	private static final long serialVersionUID = 8515005266825654727L;

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public ProductException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code=resultEnum.getCode();
	}
}
