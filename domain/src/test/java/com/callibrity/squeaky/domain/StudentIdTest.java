package com.callibrity.squeaky.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class StudentIdTest {

    @Test
    void createStudentId() {
        var studentId = new StudentId();
        assertThat(studentId.getId()).isNotNull();

        assertThat(studentId).isNotNull();
    }

    @Test
    void createStudentIdWithId() {
        var uuid = UUID.randomUUID();

        var studentId = StudentId.fromString(uuid.toString());
        assertThat(studentId.getId()).isEqualTo(uuid);
    }

    @Test
    void studentIdToString() {
        var studentId = new StudentId();
        assertThat(studentId).hasToString(studentId.getId().toString());

    }

    @Test
    void studentIdDoesNotEqualNull() {
        var studentId = new StudentId();
        assertThat(studentId).isNotEqualTo(null);
    }

    @Test
    void studentIdEqualsSelf() {
        var studentId = new StudentId();
        assertThat(studentId).isEqualTo(studentId);
    }

    @Test
    void studentIdEqualsOtherWithSameId() {
        var studentId = new StudentId();
        var other = StudentId.fromString(studentId.toString());

        assertThat(studentId).isEqualTo(other);
    }
}