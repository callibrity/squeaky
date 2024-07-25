package com.callibrity.squeaky.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.regex.Pattern;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
    );

    @EqualsAndHashCode.Include
    private final String address;

    public Email(String address) {
        if(!isValidAddress(address)) {
            throw new IllegalArgumentException("Invalid email address: " + address);
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return address;
    }

    private static boolean isValidAddress(String address) {
        return EMAIL_PATTERN.matcher(address).matches();
    }
}
