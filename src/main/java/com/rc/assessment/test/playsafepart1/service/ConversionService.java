package com.rc.assessment.test.playsafepart1.service;

import com.rc.assessment.test.playsafepart1.model.Unit;

public interface ConversionService {

    double ktoc(Unit kelvin);
    double ctok(Unit celsius);
    double mtok(Unit miles) throws Exception;
    double ktom(Unit kilometers) throws Exception;
}
