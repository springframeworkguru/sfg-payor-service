package guru.sfgpay.payor.service;

import guru.sfgpay.payor.model.Address;
import guru.sfgpay.payor.model.Language;
import guru.sfgpay.payor.model.Payor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by jt on 2018-12-07.
 */
@Service
public class PayorServiceImpl implements PayorService {

    public static final String GOOD_UUID = "0a818933-087d-47f2-ad83-2f986ed087eb";

    @Override
    public Optional<Payor> getPayor(UUID payorId) {

        Payor returnPayor;

        if (payorId.toString().equals(GOOD_UUID)){
            returnPayor = Payor.builder()
                    .payorId(payorId.toString())
                    .language(Language.EN)
                    .payorName("Freddy")
                    .primaryContactEmail("foo@example.com")
                    .primaryContactPhone("1231231234")
                    .primaryContactName("joe")
                    .address(Address.builder()
                            .line1("test 1")
                            .city("Key West")
                            .country("US")
                            .zipOrPostcode("12312")
                            .build())
                    .build();
        } else if (payorId.toString().equals("00000000-0000-0000-0000-000000000000")) {
            return Optional.empty();
        }
        else {
            returnPayor = Payor.builder().address(Address.builder().build()).build();
        }

        return Optional.of(returnPayor);
    }
}
