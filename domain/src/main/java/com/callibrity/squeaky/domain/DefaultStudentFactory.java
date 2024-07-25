package com.callibrity.squeaky.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultStudentFactory implements StudentFactory {

    @Override
    public Student createStudent(String firstName, String lastName, Email email) {
        log.info("Creating student {} {} ({})...", firstName, lastName, email);
        final StudentId studentId = new StudentId();
        return new Student(studentId, firstName, lastName, email);
    }
}
