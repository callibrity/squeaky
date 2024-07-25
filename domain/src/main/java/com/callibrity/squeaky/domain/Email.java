package com.callibrity.squeaky.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Email {

    @EqualsAndHashCode.Include
    private final String address;

    public Email(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address;
    }
}
