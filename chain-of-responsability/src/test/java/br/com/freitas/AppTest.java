package br.com.freitas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.freitas.domain.Call;
import br.com.freitas.domain.CallType;
import br.com.freitas.service.TariffConfigService;

/**
 * Unit test for simple App.
 */
class AppTest {

    private TariffConfigService tariffCalculator;

    private List<Call> calls = new ArrayList<>();

    @BeforeEach
    public void init() {
        System.out.println("startup");
        tariffCalculator = new TariffConfigService();
        calls.addAll(List.of(
            new Call("2299911-1111","2298888-8888", 10, Instant.now(), CallType.INTERNAL),
            new Call("2299911-1111","2298888-8888", 10, Instant.now(), CallType.LOCAL),
            new Call("2299911-1111","2298888-8888", 10, Instant.now(), CallType.DDD),
            new Call("2299911-1111","2298888-8888", 10, Instant.now(), CallType.DDI)
        ));
    }
    
    @AfterEach
    public void tear() {
        System.out.println("teardown");
        calls.clear();
    }

    @Test
    @DisplayName("Deve calcular a taxa de faturamento para uma chamada interna.")
    void calculate_BillingRate_InternalCall() {
        System.out.println("running test 1");
        
        BigDecimal expected = new BigDecimal("1.20");
        var actual = tariffCalculator.getInstance().taxRate(calls.get(0));
        
        assertNotNull(calls);
        assertThat(expected, equalTo(actual));
    }

    @Test
    @DisplayName("Deve calcular a taxa de faturamento para uma chamada local.")
    void calculate_BillingRate_LocalCall() {
        System.out.println("running test 2");
        
        BigDecimal expected = new BigDecimal("2.40");
        var actual = tariffCalculator.getInstance().taxRate(calls.get(1));
        
        assertNotNull(calls);
        assertThat(expected, equalTo(actual));
    }

    @Test
    @DisplayName("Deve calcular a taxa de faturamento para uma chamada regional.")
    void calculate_BillingRate_RegionalCall() {
        System.out.println("running test 3");
        
        BigDecimal expected = new BigDecimal("3.80");
        var actual = tariffCalculator.getInstance().taxRate(calls.get(2));
        
        assertNotNull(calls);
        assertThat(expected, equalTo(actual));
    }

    @Test
    @DisplayName("Deve calcular a taxa de faturamento para uma chamada internacional.")
    void calculate_BillingRate_InternationalCall() {
        System.out.println("running test 4");
        
        var actual = tariffCalculator.getInstance().taxRate(calls.get(3));
        BigDecimal expected = new BigDecimal("38.00");
        
        assertNotNull(calls);
        assertThat(expected, equalTo(actual));
    }
}
