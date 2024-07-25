package com.callibrity.squeaky.app;

import com.callibrity.squeaky.domain.Email;
import com.callibrity.squeaky.domain.StudentFactory;
import com.callibrity.squeaky.domain.Students;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCreateStudentUseCase implements CreateStudentUseCase {

    private final StudentFactory factory;
    private final Students students;

    @Override
    public CreateStudentResponse createStudent(CreateStudentRequest request) {
        var email = new Email(request.email());
        if (students.existsByEmail(email)) {
            throw new IllegalArgumentException(String.format("Student with email %s already exists", email));
        }

        var student = factory.createStudent(request.firstName(), request.lastName(), email);
        students.add(student);
        var dto = new StudentDto(student.getId().toString(), student.getFirstName(), student.getLastName(), student.getEmail().getAddress());
        return new CreateStudentResponse(dto);
    }
}
