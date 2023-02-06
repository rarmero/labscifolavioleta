package org.labse001_1.model;

import org.junit.jupiter.api.Test;
import org.labse001_1.manager.StudentManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStudentManager {

    @Test
    void testSetGrowthMindset(){

        Student student = new Student();
        StudentManager studentManager = new StudentManager(student);

        studentManager.SetGrowthMindset(60,0);

        assertEquals(5,studentManager.student.getGrowthMindset());


    }

}
