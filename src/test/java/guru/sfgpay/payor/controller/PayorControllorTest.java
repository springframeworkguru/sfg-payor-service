package guru.sfgpay.payor.controller;

import com.atlassian.oai.validator.mockmvc.OpenApiMatchers;
import guru.sfgpay.payor.service.PayorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PayorControllorTest {

    //by classpath
    private static final String OA3_URL = "/oa3/openapi.yml";

    PayorControllor payorControllor;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        payorControllor = new PayorControllor(new PayorServiceImpl());
        mockMvc = MockMvcBuilders.standaloneSetup(payorControllor).build();
    }

    @Test
    public void getPayor() throws Exception {
        mockMvc.perform(get("/v1/payors/0a818933-087d-47f2-ad83-2f986ed087eb"))
                .andExpect(status().isOk())
                .andExpect(openApi().isValid(OA3_URL));
    }

    @Test(expected = OpenApiMatchers.OpenApiValidationException.class)
    public void getPayorFailSchema() throws Exception {
        mockMvc.perform(get("/v1/payors/16ea5c75-1476-4651-b117-bcb33d77f2b5"))
                .andExpect(status().isOk())
                .andExpect(openApi().isValid(OA3_URL));
    }
}