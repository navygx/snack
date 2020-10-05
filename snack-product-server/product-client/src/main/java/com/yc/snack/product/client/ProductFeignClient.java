package com.yc.snack.product.client;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.snack.product.dto.CartInfoDTO;
import com.yc.snack.product.dto.ProductInfoDTO;
import com.yc.snack.product.dto.ProductTypeInfoDTO;

@FeignClient(name="product-server",fallback=ProductFeignClient.ProductFeignClientFallback.class)
public interface ProductFeignClient {
	@PostMapping("/product/listForGno")
	public List<ProductInfoDTO> findByGno(@RequestParam List<String> gnos);
	
	@PostMapping("/product/listForCno")
	public List<ProductInfoDTO> findByCno(@RequestParam List<String> cnos);
	
	@PostMapping("/product/buckleStock")
	public int buckleStock(@RequestBody List<CartInfoDTO> list);
	
	@PostMapping("/product/types")
	public List<ProductTypeInfoDTO> findTypes();
	
	@PostMapping("/cart/del")
	public int delCart(@RequestParam List<String> cnos);
	
	@Component
	public static class ProductFeignClientFallback implements ProductFeignClient{

		@Override
		public List<ProductInfoDTO> findByGno(List<String> gnos) {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}

		@Override
		public List<ProductInfoDTO> findByCno(List<String> cnos) {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}

		@Override
		public int buckleStock(List<CartInfoDTO> list) {
			// TODO Auto-generated method stub
			return -1;
		}

		@Override
		public List<ProductTypeInfoDTO> findTypes() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}

		@Override
		public int delCart(List<String> cnos) {
			// TODO Auto-generated method stub
			return -1;
		}
		
	}
	
}
