package com.callibrity.squeaky.domain;

import java.util.Optional;

public interface Students {
    Optional<Student> findByStudentId(StudentId studentId);
    void add(Student student);
    void update(Student student);

    boolean existsByEmail(Email email);
}
