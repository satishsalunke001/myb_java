package com.rts.myb.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.myb.model.MyProductDto;
import com.rts.myb.service.ProductDaoService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	ProductDaoService productDaoService;
	
	@GetMapping("product/productList")
	public ResponseEntity<Map<String,Object>> getAllProducts(){
		List<MyProductDto> products = productDaoService.getProductList();
		Map<String, Object> model = new HashMap<>();
		model.put("StatusDetails", products.size() + " products found");
		model.put("Success", "true");
		model.put("products", products);
		
		return ok(model);
		
	}
}
