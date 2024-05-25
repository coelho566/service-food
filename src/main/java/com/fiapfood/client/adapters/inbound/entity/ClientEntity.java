package com.fiapfood.client.adapters.inbound.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MongoEntity(collection="Client")
public class ClientEntity {

    private ObjectId id;
    private String name;
    private String phone;
    private String email;
    private String document;
    private String documentType;
    private Boolean allowNotification;
    private AddressEntity address;

}