package com.docongban.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import com.docongban.entity.OrderAccount;
import com.docongban.entity.OrderDetail;
import com.docongban.export.BillPDF;
import com.docongban.repository.EvulateRepository;
import com.docongban.service.admin.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.docongban.entity.Account;
import com.docongban.repository.AccountRepository;
import com.docongban.repository.OrderAccountRepository;
import com.docongban.repository.OrderDetailRepository;
import com.docongban.service.admin.AdminAccountService;
import com.docongban.service.admin.AdminService;
import com.docongban.service.admin.SellerService;

@RestController
@RequestMapping("/admin")
//@CrossOrigin("http://localhost:8088/admin/**")
public class AdminController {

    @Autowired
    OrderAccountRepository orderAccountRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AdminAccountService adminAccountService;

    @Autowired
    EvulateRepository evulateRepository;

    @Autowired
    SellerService sellerService;
    
    @Autowired
    private AdminService adminService;

    @Autowired
    DiscountService discountService;

    @GetMapping("/bill")
    public ModelAndView getBill() {
        ModelAndView modelAndView = new ModelAndView("admin/bill");
        adminService.getAllBills(modelAndView);
        return modelAndView;
    }

    @GetMapping("/bill-pdf/{id}")
    public ModelAndView exportPdfBill(@PathVariable int id, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=hoadon_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        ModelAndView modelAndView = new ModelAndView("admin/bill");
        BillPDF billPDF=new BillPDF();
        List<OrderDetail> orderDetails=this.orderDetailRepository.findByOrderAccountId(id);
        OrderAccount orderAccount = this.orderAccountRepository.findById(id).get();
        billPDF.export(response,orderDetails,orderAccount, this.discountService.getAlls());
        return modelAndView;
    }
    @GetMapping("/bill-chart")
    public ModelAndView barChart(){
        ModelAndView modelAndView = new ModelAndView("admin/billChart");

        List<Double> listPercent=this.evulateRepository.getPercent();
        modelAndView.addObject("listPercent", listPercent);

        return modelAndView;

    }

    @Transactional
    @GetMapping("/bill/complete/{id}")
    public RedirectView checkComplete(@PathVariable int id) {
        orderAccountRepository.updateStatus(id);
        return new RedirectView("/admin/bill");
    }


    /*
     * Hiển thị ra danh sách tất cả người dùng (danh sách tất cả account)
     * Version: 1.0
     */
    @GetMapping("/account")
    public ModelAndView getAccounts() {
        ModelAndView modelAndView = new ModelAndView("admin/account");
        List<Account> accounts = adminAccountService.getAllAccounts();
        modelAndView.addObject("accounts", accounts);
        return modelAndView;
    }


}
