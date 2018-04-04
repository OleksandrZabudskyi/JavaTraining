package ua.training.service;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.bean.LiabilityInsurance;

import java.util.Optional;

import static org.junit.Assert.*;

public class DerivativeServiceImplTest {
    private DerivativeService derivativeService;

    @Before
    public void setUp() {
        derivativeService = new DerivativeServiceImpl();
    }

    @Test
    public void testFindLiabilityInsuranceIfParamsNull() {
        Optional<LiabilityInsurance>  liabilityInsurance = derivativeService.findLiabilityInsurance(null, null);
        assertEquals(false, liabilityInsurance.isPresent());
    }
}