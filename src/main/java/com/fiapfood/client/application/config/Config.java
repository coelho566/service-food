package com.fiapfood.client.application.config;

import com.fiapfood.client.adapters.inbound.mapper.ClientMapper;
import com.fiapfood.client.application.core.usecase.ClientUseCase;
import com.fiapfood.client.application.ports.out.GetAddressPort;
import com.fiapfood.client.application.ports.out.ClientRepositoryPort;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;

@Dependent
public class Config {

    @Default
    public ClientUseCase clientUseCase(GetAddressPort getAddressPort, ClientRepositoryPort clientRepositoryPort, ClientMapper clientMapper){
        return new ClientUseCase(getAddressPort, clientRepositoryPort, clientMapper);
    }
}
