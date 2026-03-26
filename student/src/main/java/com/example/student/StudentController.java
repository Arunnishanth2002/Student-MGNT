package com.example.student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    private StudentService service;


    @PostMapping
    public ResponseEntity<ApiResponse<Student>>
    add(@Valid @RequestBody StudentDTO dto)
    {
        Student s=service.addStudent(dto);
        return ResponseEntity.status(201).body(new ApiResponse<>("Success",s,null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>>getAll()
    {
        List<Student>list=service.getAllStudents();
        return ResponseEntity.ok(new ApiResponse<>("Success",list,null));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>>getById(@PathVariable int id)
    {
        Student s=service.getStudentById(id);
        return ResponseEntity.ok(new ApiResponse<>("Success",s,null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>>update(@PathVariable int id,@RequestBody StudentDTO dto)
    {
        Student updated=service.updateStudent(id,dto);
        return ResponseEntity.ok(new ApiResponse<>("Success",updated,"Student updated successfully"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>>delete(@PathVariable int id)
    {
        service.deleteStudent(id);
        return ResponseEntity.ok(new ApiResponse<>("Success",null,"Student deleted successfully"));
    }

    @GetMapping("/performance/{id}")
    public ResponseEntity<ApiResponse<String>>performance(@PathVariable int id)
    {
        String result=service.getPerformance(id);

        return ResponseEntity.ok(new ApiResponse<>("Success",result,null));
    }


}
