package org.labse001_1.manager;

import lombok.AllArgsConstructor;
import org.labse001_1.model.Student;



@AllArgsConstructor
public class StudentManager {
  public Student student = new Student();

  public void SetGrowthMindset(int time,int effort){
      //A growth mindset is a deeply held belief that a person can learn anything given enough time and effort.
    int growthMindset=0;

    if (time >=60 && time <=120){
       growthMindset=5;
     } else if (time >120 && time <180) {
      growthMindset=10;
    }
    else growthMindset=0;

    student.setGrowthMindset(growthMindset);
  }
}
