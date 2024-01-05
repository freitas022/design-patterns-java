package br.com.freitas;

import java.math.BigDecimal;
import java.time.Instant;

import br.com.freitas.domain.Call;
import br.com.freitas.domain.CallType;
import br.com.freitas.service.TariffConfigService;

/**
 * Hello world!
 *
 */
public class App {

	private static final String TEL2 = "92222-2222";
	private static final String TEL1 = "91111-1111";
	private static final String TIPO_LIGACAO = "Essa ligação é do tipo ";
	private static final String DURACAO_MINUTOS = "Duração (minutos): ";

	public static void main(String[] args) {

		var ligacaoDDI = new Call(TEL1, TEL2, 3, Instant.now(), CallType.DDI);
		var ligacaoDDD = new Call(TEL1, TEL2, 15, Instant.now(), CallType.DDD);
		var ligacaoLocal = new Call(TEL1, TEL2, 25, Instant.now(), CallType.LOCAL);

		final var tariffCalculator = new TariffConfigService();

		BigDecimal costDDI = tariffCalculator.getInstance().taxRate(ligacaoDDI);
		System.out.println(DURACAO_MINUTOS + ligacaoDDI.durationInMinutes());
		System.out.println(TIPO_LIGACAO + ligacaoDDI.callType());
		System.out.println("Custo total (DDI): R$ " + costDDI);

		BigDecimal costDDD = tariffCalculator.getInstance().taxRate(ligacaoDDD);
		System.out.println(DURACAO_MINUTOS + ligacaoDDD.durationInMinutes());
		System.out.println(TIPO_LIGACAO + ligacaoDDD.callType());
		System.out.println("Custo total (DDD): R$ " + costDDD);

		BigDecimal costLocal = tariffCalculator.getInstance().taxRate(ligacaoLocal);
		System.out.println(DURACAO_MINUTOS + ligacaoLocal.durationInMinutes());
		System.out.println(TIPO_LIGACAO + ligacaoLocal.callType());
		System.out.println("Custo total (LOCAL): R$ " + costLocal);

	}
}
