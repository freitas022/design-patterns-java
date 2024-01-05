package br.com.freitas.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.freitas.domain.Call;
import br.com.freitas.handler.CallRateCalculator;

public class TariffCalculatorDDD extends CallRateCalculator {

    @Override
    public BigDecimal taxRate(Call call) {
        if (call.isDDD()) {
            return callRateCalculatorDDD(call);
        } else {
            return super.taxRate(call);
        }
    }

    private BigDecimal callRateCalculatorDDD(Call call) {
        var tax = 0.38;
        int duration = call.durationInMinutes();
        BigDecimal costPerMinute = BigDecimal.valueOf(tax).setScale(2, RoundingMode.HALF_EVEN);
        return costPerMinute.multiply(new BigDecimal(duration));
    }
}
