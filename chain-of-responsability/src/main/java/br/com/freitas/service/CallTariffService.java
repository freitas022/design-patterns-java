package br.com.freitas.service;

import java.math.BigDecimal;

import br.com.freitas.domain.Call;
import br.com.freitas.handler.CallRateCalculator;

public class CallTariffService {
    
    private CallRateCalculator calculator;

    public CallTariffService(CallRateCalculator calculator) {
        this.calculator = calculator;
    }

    public BigDecimal taxRate(Call call) {
        return calculator.taxRate(call);
    }
}
