package com.fiapfood.client.adapters.outbound;

import com.fiapfood.client.adapters.outbound.rest.GetAddressRest;
import com.fiapfood.client.application.core.domain.Address;
import com.fiapfood.client.application.ports.out.GetAddressPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class GetAddressAdapter implements GetAddressPort {

    @Inject
    @RestClient
    GetAddressRest getAddressRest;

    @Override
    public Address getAddress(String postalCode) {
        return getAddressRest.buscar(postalCode);
    }
}
