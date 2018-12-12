package guru.sfgpay;

import guru.sfgpay.payor.controller.PayorControllor;
import guru.sfgpay.payor.service.PayorServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

/**
 * Created by jt on 2018-12-10.
 */
public class ContractVerifierBase {

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(new PayorControllor(new PayorServiceImpl()));
    }
}
