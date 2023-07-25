package com.docongban.controller.admin;

import com.docongban.entity.Product;
import com.docongban.payload.ProductSelling;
import com.docongban.payload.StatisticalResponse2;
import com.docongban.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/admin/product-selling")
public class AdminProductSellingController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    ModelAndView getAllProducts(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("admin/productSelling");
        return modelAndView;
    }

    @PostMapping("/{month}/{top}")
    public List<ProductSelling> getAllProduct(@PathVariable("month") String month,@PathVariable("top") Integer top, HttpServletRequest request) {
        List<ProductSelling> products = productService.getTop5(month,top);

        HttpSession session = request.getSession();
        session.setAttribute("products", products);
        session.setAttribute("month", month);
        session.setAttribute("top", top);

        return products;
    }
}
