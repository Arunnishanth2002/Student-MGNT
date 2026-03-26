package com.example.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService
{
    @Autowired
    private StudentRepository repo;

    public Student addStudent(StudentDTO dto)
    {
        Student s=new Student();
        s.setAge(dto.getAge());
        s.setName(dto.getName());
        s.setCourse(dto.getCourse());
        s.setMarks(dto.getMarks());

        return repo.save(s);
    }

    public List<Student>getAllStudents()
    {
        return repo.findAll();
    }


    //find by id
    public Student getStudentById(int id)
    {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
    //delete
    public void deleteStudent(int id)
    {
        Student s=getStudentById(id);
        repo.delete(s);
    }

    //update
    public Student updateStudent(int id, StudentDTO dto)
    {
        Student s=getStudentById(id);

        s.setAge(dto.getAge());
        s.setName(dto.getName());
        s.setCourse(dto.getCourse());
        s.setMarks(dto.getMarks());

        return repo.save(s);
    }

    public String getPerformance(int id)
    {
        Student s=repo.findById(id).orElseThrow(()-> new RuntimeException("Student not fund"));

        double marks=s.getMarks();

        if(marks <40) {
            return "Fail - Needs Improvement. Suggestion: Study daily.";
        }
        else if (marks < 60){
            return "Average";
        }
        else if (marks<80){
            return "Good";
        }
        else
        {
            return "Excellent";
        }

    }
}
