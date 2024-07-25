package com.callibrity.squeaky.app;

import com.callibrity.squeaky.domain.DefaultStudentFactory;
import com.callibrity.squeaky.domain.Email;
import com.callibrity.squeaky.domain.Student;
import com.callibrity.squeaky.domain.StudentFactory;
import com.callibrity.squeaky.domain.Students;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultCreateStudentUseCaseTest {

    private final StudentFactory studentFactory = new DefaultStudentFactory();

    @Mock
    private Students students;

    @Captor
    private ArgumentCaptor<Student> studentCaptor;

    @Test
    void createStudent() {

        var useCase = new DefaultCreateStudentUseCase(studentFactory, students);

        var response = useCase.createStudent(new CreateStudentRequest("John", "Doe", "john@doe.com"));

        assertThat(response).isNotNull();
        assertThat(response.student().id()).isNotNull();
        assertThat(response.student().firstName()).isEqualTo("John");
        assertThat(response.student().lastName()).isEqualTo("Doe");
        assertThat(response.student().email()).isEqualTo("john@doe.com");

        verify(students).add(studentCaptor.capture());

        var student = studentCaptor.getValue();
        assertThat(student.getFirstName()).isEqualTo("John");
        assertThat(student.getLastName()).isEqualTo("Doe");
        assertThat(student.getEmail().getAddress()).isEqualTo("john@doe.com");
    }

    @Test
    void createStudentWithExistingEmail() {
        when(students.existsByEmail(new Email("john@doe.com"))).thenReturn(true);

        var useCase = new DefaultCreateStudentUseCase(studentFactory, students);

        var request = new CreateStudentRequest("John", "Doe", "john@doe.com");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> useCase.createStudent(request));
    }


}