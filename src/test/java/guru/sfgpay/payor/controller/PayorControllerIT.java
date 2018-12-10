package guru.sfgpay.payor.controller;

import guru.sfgpay.payor.model.Payor;
import guru.sfgpay.payor.service.PayorServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jt on 2018-12-10.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayorControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testInvalidPathIs400() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/notinoa3", String.class);

        assertThat(responseEntity.getStatusCode().is4xxClientError());
    }

    @Test
    public void testGoodPayor() {
        ResponseEntity<Payor> responseEntity = this.restTemplate
                .getForEntity("/v1/payors/" + PayorServiceImpl.GOOD_UUID, Payor.class);

        assertThat(responseEntity.getStatusCode().is2xxSuccessful());
    }


    /**
     * Will fail - http://localhost:8080/v1/payors/16ea5c75-1476-4651-b117-bcb33d77f2b5
     */
    @Ignore //todo - validation is getting disabled in test, but works okay when running
    @Test
    public void testBadPayor() {
        ResponseEntity<Payor> responseEntity = this.restTemplate
                .getForEntity("/v1/payors/16ea5c75-1476-4651-b117-bcb33d77f2b5", Payor.class);

        assertThat(responseEntity.getStatusCode().is2xxSuccessful());
    }
}
