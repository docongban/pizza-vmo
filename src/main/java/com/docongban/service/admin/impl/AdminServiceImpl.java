package com.docongban.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import com.docongban.entity.Evulate;
import com.docongban.repository.EvulateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.docongban.entity.Discount;
import com.docongban.entity.OrderAccount;
import com.docongban.entity.OrderDetail;
import com.docongban.repository.OrderAccountRepository;
import com.docongban.repository.OrderDetailRepository;
import com.docongban.service.admin.AdminService;
import com.docongban.service.admin.DiscountService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private DiscountService discountService;

	@Autowired
	private OrderAccountRepository orderAccountRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	EvulateRepository evulateRepository;
	
	@Override
	public void getAllBills(ModelAndView modelAndView) {
		List<Discount> discounts = discountService.getAlls();

        List<OrderAccount> orderAccounts = orderAccountRepository.findAllSortAsc();
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
		List<Evulate> evulates=new ArrayList<>();
        List<Double> totalPrice = new ArrayList<>();
        List<Double> totalPriceOrigin = new ArrayList<>();
        List<Double> disountValue = new ArrayList<>();

        for (OrderAccount oc : orderAccounts) {
			Evulate evulate=this.evulateRepository.findByOrderAccountId(oc.getId());
			evulates.add(evulate);

            Double total = 0D;
			Double t = 0D;
            for (OrderDetail od : orderDetails) {
                if (oc.getId() == od.getOrderAccountId()) {
                    total += (od.getProductPrice() * od.getOrderQuantity());
					t = total;
                }
            }
			totalPriceOrigin.add(total);
            for(int i = 0 ; i < discounts.size() ; i++) {
				Double nextValue = discounts.get(i).getValue();
				if( total < nextValue ) {
					if( i > 0 ) {
						total -= (total * discounts.get(i-1).getDiscount()/100);
						break;						
					}
					else {
						break;
					}
				}
			}
            totalPrice.add(total);
			disountValue.add(t-total);
        }

		// tỉ lệ đánh giá
		List<Double> listPercent=this.evulateRepository.getPercent();

        modelAndView.addObject("orderAccounts", orderAccounts);
        modelAndView.addObject("orderDetails", orderDetails);
		modelAndView.addObject("evulates", evulates);
        modelAndView.addObject("totalPrice", totalPrice);
        modelAndView.addObject("totalPriceOrigin", totalPriceOrigin);
        modelAndView.addObject("disountValue", disountValue);
        modelAndView.addObject("listPercent", listPercent);
	}

}
