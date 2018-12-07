package guru.sfgpay.payor.service;

import guru.sfgpay.payor.model.Payor;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by jt on 2018-12-07.
 */
public interface PayorService {

    Optional<Payor> getPayor(UUID payorId);
}
