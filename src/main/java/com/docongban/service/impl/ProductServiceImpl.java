package com.docongban.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.docongban.payload.ProductSelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.docongban.entity.Product;
import com.docongban.repository.ProductRepository;
import com.docongban.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProductByCategoryId(int id){
		return productRepository.findAllByCategoryId(id);
	}
	
	public List<Product> getAllProductBySearchName(String keyword){
		return productRepository.searchByName(keyword);
	}

	@Override
	public List<ProductSelling> getTop5(String month,Integer top) {
		List<Object[]> listObj = this.productRepository.getTop5Selling(month,top);
		List<ProductSelling> productSellings = new ArrayList<>();
		for(Object[] obj: listObj){
			ProductSelling productSelling = new ProductSelling();

			productSelling.setTitle(obj[0].toString());
			productSelling.setContent(obj[1].toString());
			productSelling.setThumbnail(obj[2].toString());
			productSelling.setPrice(obj[3].toString());
			productSelling.setCountProduct(Long.parseLong(obj[4].toString()));

			productSellings.add(productSelling);
		}
		return productSellings;
	}
}
