package com.callibrity.squeaky.persistence.mem;

import com.callibrity.squeaky.domain.Email;
import com.callibrity.squeaky.domain.Student;
import com.callibrity.squeaky.domain.StudentId;
import com.callibrity.squeaky.domain.Students;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemStudents implements Students {

    private final Map<StudentId, Student> students = new ConcurrentHashMap<>();

    @Override
    public Optional<Student> findById(StudentId id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public void add(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return students.values().stream()
                .map(Student::getEmail)
                .anyMatch(e -> e.equals(email));
    }
}
