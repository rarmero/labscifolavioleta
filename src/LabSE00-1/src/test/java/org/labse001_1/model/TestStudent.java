package org.labse001_1.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestStudent {

    @Test
    void testCreateStudent(){

        Student student = new Student(5,5,5,5,5,5,5,5,5,5);
        student.setName("rafa");
        student.setSurname("carrion");
        student.setAge(47);


        assertEquals(5,student.getGrowthMindset());
        assertEquals("rafa",student.getName());

    }

}
