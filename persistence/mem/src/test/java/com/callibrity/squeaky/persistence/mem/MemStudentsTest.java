package com.callibrity.squeaky.persistence.mem;

import com.callibrity.squeaky.domain.DefaultStudentFactory;
import com.callibrity.squeaky.domain.Email;
import com.callibrity.squeaky.domain.StudentFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemStudentsTest {

    private final StudentFactory studentFactory = new DefaultStudentFactory();

    @Test
    void add() {
        var students = new MemStudents();
        var student = studentFactory.createStudent("John", "Doe", new Email("john@doe.com"));
        students.add(student);
        assertThat(students.findById(student.getId())).isPresent();
    }

    @Test
    void findById() {
        var students = new MemStudents();
        var student = studentFactory.createStudent("John", "Doe", new Email("john@doe.com"));
        assertThat(students.findById(student.getId())).isEmpty();
        students.add(student);
        assertThat(students.findById(student.getId())).isPresent();
    }

    @Test
    void existsByEmail() {
        var students = new MemStudents();
        var student = studentFactory.createStudent("John", "Doe", new Email("john@doe.com"));
        students.add(student);
        assertThat(students.existsByEmail(student.getEmail())).isTrue();
    }

}