package org.labse001_1.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPerson {

    @Test
    void createPerson(){
        Person person = new Person("rafa","carrion", 47);

        assertEquals("rafa",person.getName());

    }

}
