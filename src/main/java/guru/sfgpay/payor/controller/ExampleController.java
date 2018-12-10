package guru.sfgpay.payor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Example not mapped in OA3, should fail validations
 * Created by jt on 2018-12-10.
 */
@RestController
public class ExampleController {

    @GetMapping("/notinoa3")
    Map<String, Object> notMappedInOA3(){

        Map<String, Object> returnMap = new HashMap<>();

        returnMap.put("Not In OA3", "Not Implemented");

        return returnMap;
    }

}
