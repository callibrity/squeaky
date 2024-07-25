package com.callibrity.squeaky.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultStudentFactoryTest {

    @Test
    void createStudent() {
        var factory = new DefaultStudentFactory();

        var student = factory.createStudent("John", "Doe", new Email("john@doe.com"));

        assertThat(student).isNotNull();
    }
}