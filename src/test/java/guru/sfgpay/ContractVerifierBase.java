package guru.sfgpay;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import guru.sfgpay.payor.SfgPayorServiceApplication;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jt on 2018-12-10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SfgPayorServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("oa3-validate")
public class ContractVerifierBase {

    //by classpath
    private static final String OA3_URL = "/oa3/openapi.yml";
    private final OpenApiValidationFilter validationFilter = new OpenApiValidationFilter(OA3_URL);

    @LocalServerPort
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;
    }
}
