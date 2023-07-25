package com.docongban.controller.admin;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.docongban.entity.Ingredient;
import com.docongban.export.IngredientExcel;
import com.docongban.payload.StatisticalDTO;
import com.docongban.payload.StatisticalResponse2;
import com.docongban.repository.OrderAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.docongban.payload.StatisticalResponse;
import com.docongban.service.admin.StatisticalService;

/*
 * Thống kê doanh thu
 * Version: 1.0
 */

@RestController
@RequestMapping("/admin/statistical")
public class AdminStatisticalController {
	
	@Autowired
	private StatisticalService statisticalService;

	@Autowired
	private OrderAccountRepository orderAccountRepository;
	
	@GetMapping
	public ModelAndView statisticalPage() {
		ModelAndView modelAndView = new ModelAndView("admin/statistical");
		return modelAndView;
	}
	
	@PostMapping("/{month}")
	public List<StatisticalDTO> getMonthStatistical(@PathVariable("month") String month, HttpServletRequest request) {
		return statisticalService.getStatistical(month, request);
	}

	@GetMapping("/export/excel/{month}")
	public void exportToExcel(HttpServletResponse response, @PathVariable("month") String month) throws IOException {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Thong ke doanh thu thang " + month +".xlsx";

		response.setHeader(headerKey, headervalue);
		this.statisticalService.exportStatistical(response,month);
	}

	@GetMapping("/barChart")
	public ModelAndView barChart(){
		ModelAndView modelAndView = new ModelAndView("admin/statisticalChart");
		List<Object[]> listObj=this.orderAccountRepository.getAllTotalByMonth();
		Map<String, Long> data = new LinkedHashMap<>();
		Map<String, Long> data2 = new LinkedHashMap<>();
		for(int i=1;i<=12;i++){
			for(Object[] obj: listObj){
				if(Integer.parseInt(obj[0].toString())==i){
					data.put("Tháng "+i , Long.parseLong(obj[1].toString()));
					data2.put("Tháng "+i , Long.parseLong(obj[2].toString()));
					break;
				}else{
					data.put("Tháng "+i , 0L);
					data2.put("Tháng "+i , 0L);
				}
			}
		}
		modelAndView.addObject("keySet", data.keySet());
		modelAndView.addObject("values", data.values());
		modelAndView.addObject("values2", data2.values());
		return modelAndView;

	}
}
