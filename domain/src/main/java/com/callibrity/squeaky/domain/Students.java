package com.callibrity.squeaky.domain;

import java.util.Optional;

public interface Students {
    Optional<Student> findById(StudentId id);

    void add(Student student);

    boolean existsByEmail(Email email);
}
