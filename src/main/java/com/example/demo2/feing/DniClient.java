package com.example.demo2.feing;

import com.example.demo2.response.ResponseDni;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
@FeignClient(name = "api-reniec", url = "https://api.apis.net.pe/v2/reniec/")
public interface DniClient {
    @GetMapping("/dni")
    ResponseDni getInfoDni(@RequestParam("numero") String numero,
                           @RequestHeader("Authorization")String token);
}
