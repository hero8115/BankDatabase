package com.example.springbootjpa.controller;

import com.example.springbootjpa.model.Student;
import com.example.springbootjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;



    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> studentList(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student){

        studentRepository.save(student);
        return "Student added";

    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public Optional<Student> getStudent(@PathVariable Integer id){
        Optional<Student> find = studentRepository.findById(id);

        return find;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);

        return "Student deleted";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String updateStudent(@PathVariable Integer id, @RequestBody Student student){
        List<Student> studentList = studentRepository.findAll();
        for (Student s: studentList){
            if (s.getId()==id){
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setPhoneNumber(student.getPhoneNumber());
                studentRepository.save(s);
                return "Student updated";
            }
        }
        return "Student not found!!!";
    }



}
