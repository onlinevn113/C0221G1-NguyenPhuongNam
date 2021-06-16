package service.impl;

import org.springframework.stereotype.Service;
import service.IDictionaryService;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Override
    public String check(String input) {
//        Map<String, String> map = new HashMap<>();
//        map.put("hello", "xin chào");
//        map.put("good bye", "tạm biệt");
//        map.put("good morning", "chào buổi sáng");
//        map.put("car", "xe ô tô");
//       return map.get(input.toLowerCase());

        String[] vn = {"xin chào", "tạm biệt", "cảm ơn"};
        String[] engl = {"hello", "good bye", "thank you"};
        String result = null;
        for (int i = 0; i < vn.length; i++) {
            if (input.equals(vn[i])) {
                result = engl[i];
                break;
            } else if (input.equals(engl[i])) {
                result = vn[i];
                break;
            } else {
                result = "not found !! ";
            }
        }
        return result;
    }
}
