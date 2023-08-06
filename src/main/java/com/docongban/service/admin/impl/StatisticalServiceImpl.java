package com.docongban.service.admin.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.docongban.entity.Ingredient;
import com.docongban.export.StatisticalExcel;
import com.docongban.payload.*;
import com.docongban.repository.IngredientRepository;
import com.docongban.service.admin.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docongban.entity.Discount;
import com.docongban.entity.OrderAccount;
import com.docongban.entity.OrderDetail;
import com.docongban.repository.OrderAccountRepository;
import com.docongban.repository.OrderDetailRepository;
import com.docongban.service.admin.DiscountService;
import com.docongban.service.admin.StatisticalService;

@Service
public class StatisticalServiceImpl implements StatisticalService {
	
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderAccountRepository orderAccountRepository;

	@Autowired
	private IngredientRepository ingredientRepository;

	@Autowired
	private PayrollService payrollService;

	@Override
	public List<StatisticalResponse> getMonthStatistical(String month, HttpServletRequest request) {
		List<Discount> discounts = discountService.getAlls();

		// Mỗi order_account là một hóa đơn.

		// Lấy ra danh sách order account:
		List<OrderAccount> orderAccounts = orderAccountRepository.findAll();

		// Lấy ra danh sách order_detail:
		List<OrderDetail> listOrderDetails = orderDetailRepository.findAll();

		// List tổng tiền của các order_account: (list tổng tiền của các hóa đơn)
		List<TotalEachOrderAccount> listTotals = new ArrayList<TotalEachOrderAccount>();

		// Tính tổng tiền theo từng order_account_id: (Mỗi lần order sẽ sinh ra một
		// order_account_id khác nhau):
		for (OrderDetail orderDetail : listOrderDetails) {
			Integer orderAccountId = orderDetail.getOrderAccountId();
			Long totalPrice = orderDetail.getOrderQuantity() * orderDetail.getProductPrice();
			Boolean check = false;

			// Tính tổng tiền của mỗi hóa đơn (mỗi order_account là một hóa đơn)
			for (TotalEachOrderAccount totalObj : listTotals) {
				// Nếu đã tồn tại order account id -> update total
				if (totalObj.getId() == orderAccountId) {
					totalObj.setTotal(totalObj.getTotal() + totalPrice);
					check = true;
				}
			}

			// Nếu chưa tồn tại order account id -> thì thêm vào danh sách
			if (!check) {
				TotalEachOrderAccount totalObj = new TotalEachOrderAccount(orderAccountId, totalPrice, null);
				listTotals.add(totalObj);
			}
		}

		// Map ngày cho từng tổng tiền của mỗi hóa đơn:
		for (OrderAccount orderAccount : orderAccounts) {
			for (TotalEachOrderAccount totalObj : listTotals) {
				// Nếu status = 1 và id = order_account_id -> map ngày
				if (orderAccount.getId() == totalObj.getId() && orderAccount.getOrderStatus() == 1) {
					totalObj.setDate(orderAccount.getOrderDate());
					break;
				}
			}
		}

		// Tính toán tổng giá trị sau khi trừ discount:
		for (TotalEachOrderAccount totalObj : listTotals) {
			Long totalPrice = totalObj.getTotal();
			for (int i = 0; i < discounts.size(); i++) {
				Double nextValue = discounts.get(i).getValue();
				if (totalPrice < nextValue) {
					if (i > 0) {
						totalPrice -= Math.round((totalPrice * discounts.get(i - 1).getDiscount() / 100));
						totalObj.setTotal(totalPrice);
						break;
					} else {
						break;
					}
				}
			}
		}

		// Đến đây sẽ thu được: (order_account_id, totalPrice, date) - listTotals
		// -> tính tổng doanh thu theo ngày
		List<StatisticalResponse> listStatisticalResponses = this.totalStaticPerDay(listTotals);

		// Đến đây mình sẽ được một list chứa tổng doanh thu của các ngày: (ngày, tổng
		// doanh thu)
		List<StatisticalResponse> listClone = new ArrayList<>(listStatisticalResponses);
		Long totalTurnover = 0L;
		for (int i = 0; i < listClone.size(); i++) {
			StatisticalResponse statistical = listClone.get(i);
			if (statistical.getDate() != null) {
				String pattern = "dd/MM/yyyy HH:mm:ss";

				DateFormat df = new SimpleDateFormat(pattern);
				String date = df.format(statistical.getDate());
				String statisticalMonth = date.substring(3, 5);
				if (!statisticalMonth.equals(month)) {
					listStatisticalResponses.remove(statistical);
				} else { // Tính tổng doanh thu:
					totalTurnover += statistical.getTurnover();
				}
			}

		}

		HttpSession session = request.getSession();
		session.setAttribute("statisticals", listStatisticalResponses);
		session.setAttribute("totalTurnover", totalTurnover);
		session.setAttribute("month", month);

		return listStatisticalResponses;
	}

	private List<StatisticalResponse> totalStaticPerDay(List<TotalEachOrderAccount> listTotals){
		List<StatisticalResponse> listStatisticalResponses = new ArrayList<StatisticalResponse>();
		for (TotalEachOrderAccount totalObj : listTotals) {
			Boolean check = false;
			if (totalObj.getDate() == null) {
				// Bỏ qua những đơn hàng chưa hoàn thành (status = 0 -> sẽ không có date)
				continue;
			}
			for (StatisticalResponse statisticalResponse : listStatisticalResponses) {

				// Lấy ra ngày, tháng, năm của totalObj:
				Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
				cal1.setTime(totalObj.getDate());
				int totalObjYear = cal1.get(Calendar.YEAR);
				int totalObjMonth = cal1.get(Calendar.MONTH);
				int totalObjDay = cal1.get(Calendar.DAY_OF_MONTH);

				// Lấy ra ngày, tháng, năm của statisticalResponse:
				Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
				cal2.setTime(statisticalResponse.getDate());
				int statisticalResponseYear = cal2.get(Calendar.YEAR);
				int statisticalResponseMonth = cal2.get(Calendar.MONTH);
				int statisticalResponseDay = cal2.get(Calendar.DAY_OF_MONTH);

				// Nếu đã có ngày đó -> update:
				if (totalObjYear == statisticalResponseYear && totalObjMonth == statisticalResponseMonth
						&& totalObjDay == statisticalResponseDay) {
					check = true;
					// Update:
					statisticalResponse.setTurnover(statisticalResponse.getTurnover() + totalObj.getTotal());
					break;
				}
			}

			// Nếu không có ngày đó -> thêm mới:
			if (!check) {
				StatisticalResponse statisticalResponse = new StatisticalResponse(totalObj.getDate(),
						totalObj.getTotal());
				listStatisticalResponses.add(statisticalResponse);
			}
		}

		return listStatisticalResponses;
	}

	@Override
	public List<StatisticalResponse2> getStatisticalByMonth(String month, HttpServletRequest request) {
		List<Object[]> lstObj = this.orderAccountRepository.getByMonth(month);

		List<StatisticalResponse2> listStatisticalResponses= new ArrayList<>();
		Locale localeEN = new Locale("en", "EN");
		NumberFormat en = NumberFormat.getInstance(localeEN);
		for (Object[] obj : lstObj) {
			StatisticalResponse2 statisticalResponse2 = new StatisticalResponse2();

			statisticalResponse2.setDate(obj[0].toString());
			statisticalResponse2.setTurnover((Long.parseLong(obj[1].toString())));

			listStatisticalResponses.add(statisticalResponse2);
		}
		Long totalTurnover = 0L;
		for(StatisticalResponse2 s: listStatisticalResponses){
			totalTurnover+=s.getTurnover();
		}

		HttpSession session = request.getSession();
		session.setAttribute("statisticals", listStatisticalResponses);
		session.setAttribute("totalTurnover", en.format(totalTurnover));
		session.setAttribute("month", month);

		return listStatisticalResponses;
	}

	public long getLaiThang(String month){
		List<Object[]> lstObj = this.orderAccountRepository.getAllByMonth(month);
		List<StatisticalDTO> statisticalDTOList = new ArrayList<>();
		Long total = 0L;
		Long totalAfterDiscount=0L;
		for (Object[] obj : lstObj) {
			StatisticalDTO statisticalDTO=new StatisticalDTO();

			statisticalDTO.setDate(obj[0].toString());
			total+=Long.parseLong(obj[1].toString());
			statisticalDTO.setTotal(Long.parseLong(obj[1].toString()));
			totalAfterDiscount+=Long.parseLong(obj[2].toString());
			statisticalDTO.setTotalAfterDiscount(Long.parseLong(obj[2].toString()));

			statisticalDTOList.add(statisticalDTO);
		}

		// chi
		List<Ingredient> ingredients = this.ingredientRepository.getByMonth(month);
		Long totalIngredients = 0L;
		for(Ingredient i: ingredients){
			totalIngredients+=i.getPrice();
		}
		long totalSalary = 0L;
		List<PayrollResponse> payrollResponseList = this.payrollService.getAllsByMonth(month);
		for(PayrollResponse p: payrollResponseList){
			totalSalary+=p.getTotalDate()*40000*8;
		}

		// lãi
		long lai = totalAfterDiscount-totalIngredients-totalSalary;

		return lai;
	}

	@Override
	public List<StatisticalDTO> getStatistical(String month, HttpServletRequest request) {
		List<Object[]> lstObj = this.orderAccountRepository.getAllByMonth(month);
		List<StatisticalDTO> statisticalDTOList = new ArrayList<>();
		Long total = 0L;
		Long totalAfterDiscount=0L;
		for (Object[] obj : lstObj) {
			StatisticalDTO statisticalDTO=new StatisticalDTO();

			statisticalDTO.setDate(obj[0].toString());
			total+=Long.parseLong(obj[1].toString());
			statisticalDTO.setTotal(Long.parseLong(obj[1].toString()));
			totalAfterDiscount+=Long.parseLong(obj[2].toString());
			statisticalDTO.setTotalAfterDiscount(Long.parseLong(obj[2].toString()));

			statisticalDTOList.add(statisticalDTO);
		}

		// chi
		List<Ingredient> ingredients = this.ingredientRepository.getByMonth(month);
		Long totalIngredients = 0L;
		for(Ingredient i: ingredients){
			totalIngredients+=i.getPrice();
		}
		long totalSalary = 0L;
		List<PayrollResponse> payrollResponseList = this.payrollService.getAllsByMonth(month);
		for(PayrollResponse p: payrollResponseList){
			totalSalary+=p.getTotalDate()*40000*8;
		}

		// lãi
		long lai = totalAfterDiscount-totalIngredients-totalSalary;

		// tốc độ tăng trưởng
		double tangTruong=0D;
		String preMonth = String.valueOf(Integer.parseInt(month)-1);
		long prelai = this.getLaiThang(preMonth);
		if(prelai!=0){
			DecimalFormat newFormat = new DecimalFormat("#.##");
			if(lai <= prelai){
				tangTruong = Double.valueOf(newFormat.format((double) lai/prelai))-1;
			}else{
				tangTruong = Double.valueOf(newFormat.format((double) lai/prelai));
			}
		}

		HttpSession session = request.getSession();
		session.setAttribute("statisticals", statisticalDTOList);
		session.setAttribute("total", total);
		session.setAttribute("totalAfterDiscount", totalAfterDiscount);
		session.setAttribute("totalIngredients", totalIngredients);
		session.setAttribute("totalSalary", totalSalary);
		session.setAttribute("lai", lai);
		session.setAttribute("tangTruong", tangTruong);
		session.setAttribute("preMonth", preMonth);
		session.setAttribute("month", month);

		return statisticalDTOList;
	}

	@Override
	public void exportStatistical(HttpServletResponse response, String month) throws IOException {
		List<Object[]> lstObj = this.orderAccountRepository.getAllByMonth(month);
		List<StatisticalDTO> statisticalDTOList = new ArrayList<>();
		Long total = 0L;
		Long totalAfterDiscount=0L;
		for (Object[] obj : lstObj) {
			StatisticalDTO statisticalDTO=new StatisticalDTO();

			statisticalDTO.setDate(obj[0].toString());
			total+=Long.parseLong(obj[1].toString());
			statisticalDTO.setTotal(Long.parseLong(obj[1].toString()));
			totalAfterDiscount+=Long.parseLong(obj[2].toString());
			statisticalDTO.setTotalAfterDiscount(Long.parseLong(obj[2].toString()));

			statisticalDTOList.add(statisticalDTO);
		}

		// chi
		List<Ingredient> ingredients = this.ingredientRepository.getByMonth(month);
		Long totalIngredients = 0L;
		for(Ingredient i: ingredients){
			totalIngredients+=i.getPrice();
		}
		long totalSalary = 0L;
		List<PayrollResponse> payrollResponseList = this.payrollService.getAllsByMonth(month);
		for(PayrollResponse p: payrollResponseList){
			totalSalary+=p.getTotalDate()*40000*8;
		}

		// lãi
		long lai = totalAfterDiscount-totalIngredients-totalSalary;

		// tốc độ tăng trưởng
		double tangTruong=0D;
		String preMonth = String.valueOf(Integer.parseInt(month)-1);
		long prelai = this.getLaiThang(preMonth);
		if(prelai!=0){
			DecimalFormat newFormat = new DecimalFormat("#.##");
			if(lai <= prelai){
				tangTruong = Double.valueOf(newFormat.format((double) lai/prelai))-1;
			}else{
				tangTruong = Double.valueOf(newFormat.format((double) lai/prelai));
			}
		}

		StatisticalExcel statisticalExcel=new StatisticalExcel();
		statisticalExcel.export(response,statisticalDTOList,total,totalAfterDiscount,totalIngredients,
				totalSalary,lai,tangTruong,preMonth,month);
	}

}
