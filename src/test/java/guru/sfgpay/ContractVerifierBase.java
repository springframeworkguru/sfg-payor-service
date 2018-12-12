package guru.sfgpay;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import guru.sfgpay.payor.controller.PayorControllor;
import guru.sfgpay.payor.service.PayorServiceImpl;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 2018-12-10.
 */
public class ContractVerifierBase {

    //by classpath
    private static final String OA3_URL = "/oa3/openapi.yml";
    private final OpenApiValidationFilter validationFilter = new OpenApiValidationFilter(OA3_URL);

    @Before
    public void setUp() throws Exception {
        List filters = new ArrayList();
        filters.add(validationFilter);

        RestAssured.replaceFiltersWith(filters);

        RestAssuredMockMvc.standaloneSetup(new PayorControllor(new PayorServiceImpl()));
    }
}
