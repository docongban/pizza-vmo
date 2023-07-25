package com.docongban.service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.docongban.payload.StatisticalDTO;
import com.docongban.payload.StatisticalResponse;
import com.docongban.payload.StatisticalResponse2;

public interface StatisticalService {
	List<StatisticalResponse> getMonthStatistical(String month, HttpServletRequest request);
	List<StatisticalResponse2> getStatisticalByMonth(String month, HttpServletRequest request);
	List<StatisticalDTO> getStatistical(String month, HttpServletRequest request);

	void exportStatistical(HttpServletResponse response, String month) throws IOException;
}
