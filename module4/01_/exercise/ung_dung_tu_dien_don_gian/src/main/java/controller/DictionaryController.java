package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping()
    public String home(){
        return "home";
    }
    @PostMapping()
    public String translate(@RequestParam String input, Model model){
//        Map<String, String > map=new HashMap<>();
//        map.put("hello","xin chào");
//        map.put("good bye","tạm biệt");
//        map.put("good morning","chào buổi sáng");
//        map.put("car","xe ô tô");
//        model.addAttribute("result",map.get(input.toLowerCase()));
//        return home();


        String[] vn = {"xin chào", "tạm biệt", "cảm ơn"};
        String[] engl = {"hello", "good bye", "thank you"};
        String result=null;
        for (int i =0 ; i< vn.length; i++ ){
            if (input.equals(vn[i])){
                result=engl[i];
                break;
            }
            else if (input.equals(engl[i])){
                result=vn[i];
                break;
            }else {
                result="not found !! ";
            }
        }
        model.addAttribute("result", result);
        return "/home";
    }

}
