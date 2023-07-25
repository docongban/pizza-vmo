package com.docongban.controller.admin;

import com.docongban.entity.Category;
import com.docongban.entity.Ingredient;
import com.docongban.export.IngredientExcel;
import com.docongban.payload.ProductSelling;
import com.docongban.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/ingredient")
public class AdminIngredientController {

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("")
    public ModelAndView getIngredient() {
        ModelAndView modelAndView = new ModelAndView("admin/ingredient");
//        LocalDate today = LocalDate.now();
//        String month = String.valueOf(today.getMonthValue());
//        List<Ingredient> ingredients = this.ingredientRepository.getByMonth(month);
//        Long total = 0L;
//        for(Ingredient i: ingredients){
//            total+=i.getPrice();
//        }
//        modelAndView.addObject("ingredients", ingredients);
//        modelAndView.addObject("totalIngredients", total);
//        modelAndView.addObject("month", month);
        return modelAndView;
    }

    @PostMapping("/{month}")
    public List<Ingredient> getAllIngredient(@PathVariable("month") String month, HttpServletRequest request) {
        List<Ingredient> ingredients = this.ingredientRepository.getByMonth(month);
        Long total = 0L;
        for(Ingredient i: ingredients){
            total+=i.getPrice();
        }

        HttpSession session = request.getSession();
        session.setAttribute("ingredients", ingredients);
        session.setAttribute("totalIngredients", total);
        session.setAttribute("month", month);

        return ingredients;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("admin/formIngredient");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCategory(@ModelAttribute("ingredient") Ingredient ingredient,HttpServletRequest request) {
        ingredient.setImportTime(Instant.now());
        this.ingredientRepository.save(ingredient);
        LocalDate today = LocalDate.now();
        String month = String.valueOf(today.getMonthValue());
        this.getAllIngredient(month,request);
        return new ModelAndView("redirect:"+"/admin/ingredient");
    }

    @GetMapping("/export/excel/{month}")
    public void exportToExcel(HttpServletResponse response, @PathVariable("month") String month) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headervalue = "attachment; filename=Thong ke chi tieu thang " + month +".xlsx";

        response.setHeader(headerKey, headervalue);
        List<Ingredient> ingredientList = this.ingredientRepository.getByMonth(month);
        Long total = 0L;
        for(Ingredient i: ingredientList){
            total+=i.getPrice();
        }
        IngredientExcel ingredientExcel = new IngredientExcel(ingredientList,month);
        ingredientExcel.export(response,month,total);
    }

    @GetMapping("/barChart")
    public ModelAndView barChart(){
        ModelAndView modelAndView = new ModelAndView("admin/ingredientChart");
        List<Object[]> listObj=this.ingredientRepository.getAllByMonth();
        Map<String, Long> data = new LinkedHashMap<>();
        for(int i=1;i<=12;i++){
            for(Object[] obj: listObj){
                if(Integer.parseInt(obj[0].toString())==i){
                    data.put("Tháng "+i , Long.parseLong(obj[1].toString()));
                    break;
                }else{
                    data.put("Tháng "+i , 0L);
                }
            }
        }
        modelAndView.addObject("keySet", data.keySet());
        modelAndView.addObject("values", data.values());
        return modelAndView;

    }
}
