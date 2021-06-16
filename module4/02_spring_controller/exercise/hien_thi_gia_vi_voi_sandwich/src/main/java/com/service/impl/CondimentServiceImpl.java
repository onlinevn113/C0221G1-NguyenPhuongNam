package com.service.impl;

import com.service.ICondimentService;
import org.springframework.stereotype.Service;

@Service
public class CondimentServiceImpl implements ICondimentService {
    @Override
    public String a(String [] condiment) {
        String a="";
        for (int i =0;i<condiment.length;i++){
            a +=condiment[i]+", ";
        }
        return a;
    }
}
