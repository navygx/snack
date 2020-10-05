package com.yc.snack.product.dto;

/**
 * 购物车信息传输对象
 * company 源辰信息
 * @author navy
 * @date 2020年10月2日
 * Email haijunzhou@hnit.edu.cn
 */
public class CartInfoDTO {
	private String gno;
	private Integer nums;
	private Double price;
	
	@Override
	public String toString() {
		return "CrartInfoDTO [gno=" + gno + ", nums=" + nums + ", price=" + price + "]";
	}

	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gno == null) ? 0 : gno.hashCode());
		result = prime * result + ((nums == null) ? 0 : nums.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartInfoDTO other = (CartInfoDTO) obj;
		if (gno == null) {
			if (other.gno != null)
				return false;
		} else if (!gno.equals(other.gno))
			return false;
		if (nums == null) {
			if (other.nums != null)
				return false;
		} else if (!nums.equals(other.nums))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
}	
