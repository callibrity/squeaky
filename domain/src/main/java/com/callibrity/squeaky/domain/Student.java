package com.callibrity.squeaky.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @EqualsAndHashCode.Include
    private final StudentId id;
    private String firstName;
    private String lastName;
    private Email email;

    public Student(StudentId id, String firstName, String lastName, Email email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
