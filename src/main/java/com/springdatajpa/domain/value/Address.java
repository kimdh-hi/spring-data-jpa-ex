package com.springdatajpa.domain.value;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String address;
    private String detailAddress;
}
