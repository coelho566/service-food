package com.fiapfood.client.application.ports.out;

import com.fiapfood.client.application.core.domain.Address;

public interface GetAddressPort {

    Address getAddress(String postalCode);
}
