package br.com.freitas.service;

import br.com.freitas.calculator.TariffCalculatorDDD;
import br.com.freitas.calculator.TariffCalculatorDDI;
import br.com.freitas.calculator.TariffCalculatorInternal;
import br.com.freitas.calculator.TariffCalculatorLocal;
import br.com.freitas.handler.CallRateCalculator;

public class TariffConfigService {

    public CallTariffService getInstance() {

        CallRateCalculator tariffs = new TariffCalculatorInternal()
                            .setNextCalculator(new TariffCalculatorLocal())
                            .setNextCalculator(new TariffCalculatorDDD())
                            .setNextCalculator(new TariffCalculatorDDI());

        return new CallTariffService(tariffs);
    }
}
