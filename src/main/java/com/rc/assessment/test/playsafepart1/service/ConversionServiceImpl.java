package com.rc.assessment.test.playsafepart1.service;

import com.rc.assessment.test.playsafepart1.model.Unit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class ConversionServiceImpl implements ConversionService {

    @Value("${unit.celsius}")
    private double celsiusValue;
    @Value("${unit.kelvin}")
    private double kelvinValue;
    @Value("${unit.mile}")
    private double mileValue;
    @Value("${unit.kilometer}")
    private double kilometerValue;

    @Override
    public double ktoc(Unit kelvin) {
        return kelvin.getValue() - celsiusValue;
    }

    @Override
    public double ctok(Unit celsius) {
        return celsius.getValue() + kelvinValue;
    }

    @Override
    public double mtok(Unit miles) throws Exception {
        if (miles.getValue() < 0){
            throw new Exception("value can't be less than zero");
        }
        return miles.getValue() * kilometerValue;
    }

    @Override
    public double ktom(Unit kilometers) throws Exception {
        if (kilometers.getValue() < 0){
            throw new Exception("value can't be less than zero");
        }
        return kilometers.getValue() * mileValue;
    }
}
