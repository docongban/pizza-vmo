package com.docongban.service;

import java.util.List;

import com.docongban.payload.ProductSelling;
import org.springframework.stereotype.Service;

import com.docongban.entity.Product;

@Service
public interface ProductService {

	List<Product> getAllProductByCategoryId(int id);
	
	List<Product> getAllProductBySearchName(String keyword);

	List<ProductSelling> getTop5(String month,Integer top);
}
