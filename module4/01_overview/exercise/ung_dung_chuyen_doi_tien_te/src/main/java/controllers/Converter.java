package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Converter {
    @GetMapping
    public String comeHome(){
        return "home";
    }


    @PostMapping("abc")
    public String convert(@RequestParam String money, String typeMoney,String typeMoney1, Model model){
        double result = Double.parseDouble(money) * Double.parseDouble(typeMoney1) / Double.parseDouble(typeMoney) ;
        model.addAttribute("result",result);
        return "home";
    }
}
