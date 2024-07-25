package com.callibrity.squeaky.domain;

public interface StudentFactory {
    Student createStudent(String firstName, String lastName, Email email);
}
