package com.example.demospring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ControllerParams {

    private static Map<String, Object> params = new HashMap<String, Object>();

    static {
        params.put("IGV", 0.18);
    }

    @GetMapping("/params")
    public List<Map<String,Object>> consultarParams() {
        List<Map<String,Object>> lst = new ArrayList<>();
        params.keySet().forEach(k->{
            Map<String,Object> map = new HashMap<>();
            map.put("id", k);
            map.put("valor", params.get(k));
            lst.add(map);
        });
        return lst;
    }

    @PostMapping ("/param/nuevo")
    public Map<String,Object> guardarParam(@RequestBody Map<String,Object> nuevo) {
        params.put(nuevo.get("id").toString(), nuevo.get("valor"));   
        return nuevo;
    }
}
