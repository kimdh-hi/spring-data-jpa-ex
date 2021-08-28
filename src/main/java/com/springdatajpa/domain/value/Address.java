package com.springdatajpa.domain.value;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String address;
    private String detailAddress;
}
