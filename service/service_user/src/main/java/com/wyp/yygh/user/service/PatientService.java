package com.wyp.yygh.user.service;

import com.wyp.yygh.model.user.Patient;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PatientService extends IService<Patient> {
    //获取就诊人列表
    List<Patient> findAllByUserId(Long userId);

    //根据id获取就诊人信息
    Patient getPatientId(Long id);

}
