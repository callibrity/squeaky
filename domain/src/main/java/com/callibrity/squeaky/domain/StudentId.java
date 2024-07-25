package com.callibrity.squeaky.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public final class StudentId {

    @EqualsAndHashCode.Include
    private final UUID id;

    public static StudentId fromString(String string) {
        return new StudentId(UUID.fromString(string));
    }

    private StudentId(UUID id) {
        this.id = id;
    }

    public StudentId() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
