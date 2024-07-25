package com.callibrity.squeaky.domain;

public interface Students {
    void add(Student student);
    boolean existsByEmail(Email email);
}
