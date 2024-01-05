package br.com.freitas.handler;

import java.math.BigDecimal;

import br.com.freitas.domain.Call;

public abstract class CallRateCalculator {

	private CallRateCalculator nextCalculator;

	public CallRateCalculator setNextCalculator(CallRateCalculator nextCalculator) {
		if (this.nextCalculator == null) {
            this.nextCalculator = nextCalculator;
        } else {
            this.nextCalculator.setNextCalculator(nextCalculator);
        }
        return this;
	}

	public BigDecimal taxRate(Call ligacao) {
		//handle request
		return (nextCalculator != null)
				? nextCalculator.taxRate(ligacao)
				: BigDecimal.ZERO;
	}

}
