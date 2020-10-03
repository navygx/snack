package com.yc.snack.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yc.snack.product.enums.ResultEnum;

public class ResultVo {
	private Integer code;
	private String msg;
	
	@JsonProperty("data")
	private Object obj;

	@Override
	public String toString() {
		return "ResultVo [code=" + code + ", msg=" + msg + ", obj=" + obj + "]";
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

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public ResultVo(Integer code, String msg, Object obj) {
		super();
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}

	public ResultVo(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResultVo(Integer code, Object obj) {
		super();
		this.code = code;
		this.obj = obj;
	}

	public ResultVo(String msg, Object obj) {
		super();
		this.msg = msg;
		this.obj = obj;
	}
	
	public ResultVo(ResultEnum enums,Object obj) {
		super();
		this.code = enums.getCode();
		this.msg = enums.getMsg();
		this.obj = obj;
	}

	public ResultVo(ResultEnum enums) {
		super();
		this.code = enums.getCode();
		this.msg = enums.getMsg();
	}
	
	

	public ResultVo(Integer code) {
		super();
		this.code = code;
	}

	public ResultVo() {
		super();
	}
	
	
}
