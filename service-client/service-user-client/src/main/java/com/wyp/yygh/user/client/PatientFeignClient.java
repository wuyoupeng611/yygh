package com.wyp.yygh.user.client;

import com.wyp.yygh.model.user.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-user")
@Component
public interface PatientFeignClient {

    //根据就诊人id获取就诊人信息
    @GetMapping("/api/patient/inner/get/{id}")
    public Patient getPatientOrder(@PathVariable("id") Long id);
}
