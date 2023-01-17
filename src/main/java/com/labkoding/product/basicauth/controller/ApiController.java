package com.labkoding.product.basicauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping(value = {"/api"})
public class ApiController {
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/generatePDF", method = RequestMethod.POST)
    public Map hello(@RequestBody Map bodyRequest) {
        // date to string format
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        Date date = new Date();
        String strDate = formatter.format(date);

        String laterWaktu = (String) bodyRequest.get("latarWaktu");
        Map response = new HashMap();
        response.put("status", "success");
        response.put("text", "Jakarta "+strDate+", Selamat "+laterWaktu+" pelanggan!");
        return response;
    }
}
