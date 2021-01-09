package com.rts.myb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.myb.domain.MyProduct;
import com.rts.myb.model.MyProductDto;
import com.rts.myb.repo.MyProductRepo;

@Service
public class ProductDaoService {

	@Autowired
	MyProductRepo myProductRepo;
	
	
	public List<MyProductDto> getProductList() {
		List<MyProduct> productList = myProductRepo.findAll();
		List<MyProductDto> productDtos = new ArrayList<MyProductDto>();
		MyProductDto productDto;
		for(MyProduct product: productList) {
			productDto = new MyProductDto();
			productDto.setId(product.getId());
			productDto.setName(product.getName());
			productDto.setTitle(product.getTitle());
			productDto.setProductId(product.getProductId());
			productDto.setCategory(product.getCategory());
			productDto.setPrice(product.getPrice());
			productDto.setPriceValue(product.getPriceValue());
			productDto.setStatus(product.isStatus());
			productDtos.add(productDto);
		}
		
		return productDtos;
	}
}
