package br.com.freitas.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.freitas.domain.Call;
import br.com.freitas.handler.CallRateCalculator;

public class TariffCalculatorDDI extends CallRateCalculator {

    @Override
    public BigDecimal taxRate(Call call) {
        if (call.isDDI()) {
            return callRateCalculatorDDI(call);
        } else {
            return super.taxRate(call);
        }
    }

    private BigDecimal callRateCalculatorDDI(Call call) {
        var tax = 3.80;
        int duration = call.durationInMinutes();
        BigDecimal costPerMinute = BigDecimal.valueOf(tax).setScale(2, RoundingMode.HALF_EVEN);
        return costPerMinute.multiply(new BigDecimal(duration));
    }
}