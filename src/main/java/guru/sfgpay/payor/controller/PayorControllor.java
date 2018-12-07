package guru.sfgpay.payor.controller;

import guru.sfgpay.payor.model.Payor;
import guru.sfgpay.payor.service.PayorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by jt on 2018-12-07.
 */
@RestController
@RequestMapping("/v1/payors")
public class PayorControllor {

    private final PayorService payorService;

    public PayorControllor(PayorService payorService) {
        this.payorService = payorService;
    }

    @GetMapping(value = "/{payorId}")
    public ResponseEntity<Payor> getPayor(@PathVariable("payorId") UUID payorId){

        return ResponseEntity.of(payorService.getPayor(payorId));
    }

}
