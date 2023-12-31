package com.docongban.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docongban.entity.Discount;
import com.docongban.repository.DiscountRepository;
import com.docongban.service.admin.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	DiscountRepository discountRepository;


	/*
	 * Lấy toàn bộ discount
	 * Version: 1.0
	 */
	@Override
	public List<Discount> getAlls() {
		return discountRepository.getAllSort();
	}

	
	/*
	 * Lấy discount theo id
	 * Version: 1.0
	 */
	@Override
	public Discount getById(Long id) {
		return discountRepository.getById(id);
	}

	
	/*
	 * Thêm mới discount
	 * Version: 1.0
	 */
	@Override
	public Discount createDiscount(Double discount, Double value) {
		Discount newDiscount = new Discount();
		newDiscount.setDiscount(discount);
		newDiscount.setValue(value);
		return discountRepository.save(newDiscount);
	}

	
	/*
	 * Sửa discount
	 * Version: 1.0
	 */
	@Override
	public Discount update(Long id, Discount discount) {
		return discountRepository.save(discount);
	}

	
	/*
	 * Xóa discount
	 * Version: 1.0
	 */
	@Override
	public void delete(Long id) {
		discountRepository.deleteById(id);
	}
	
}
