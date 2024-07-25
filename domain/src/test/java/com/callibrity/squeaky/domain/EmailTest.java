package com.callibrity.squeaky.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {

    @Test
    void validEmail() {
        var email = new Email("john@doe.com");
        assertThat(email.getAddress()).isEqualTo("john@doe.com");
    }

    @Test
    void invalidEmail() {
        assertThatThrownBy(() -> new Email("john@doe")).isInstanceOf(IllegalArgumentException.class);
    }

}