package com.project.crowdfund.controller;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.crowdfund.dto.StudentDto;
import com.project.crowdfund.dto.StudentRegDto;
import com.project.crowdfund.model.Student;
import com.project.crowdfund.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@ModelAttribute StudentDto student) throws IOException {
        System.out.println(student);
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PostMapping("/savestudent")
    public ResponseEntity<Student> save(@RequestBody StudentRegDto student) throws IOException {
        System.out.println(student);
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<Student> getStudent(@PathVariable String email) {
        System.out.println("get called ..........");
        return ResponseEntity.ok(studentService.getStudent(email));
    }

    @PatchMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @GetMapping("/findall")
    public ResponseEntity<Page<Student>> findAll(@RequestParam(defaultValue = "0") Integer pageIndex,
            @RequestParam(defaultValue = "3") Integer pageSize) {
        return ResponseEntity.ok(studentService.findAll(pageIndex, pageSize));
    }

    @GetMapping("/getallapproved")
    public ResponseEntity<Page<Student>> getAllApproved(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println("called");
        return ResponseEntity.ok(studentService.getAllApproved(pageNo, pageSize));
    }

    @GetMapping("/getallpending")
    public ResponseEntity<Page<Student>> getAllPending(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println("called");
        return ResponseEntity.ok(studentService.getAllPending(pageNo, pageSize));
    }

    @PutMapping("/approved/{name}")
    public ResponseEntity<Student> setApproved(@PathVariable String name, @RequestBody Student request) {
        System.out.println(request);
        return ResponseEntity.ok(studentService.setApproved(name, request));
    }

    @PatchMapping("/rejected")
    public ResponseEntity<Student> setRejected(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.setRejected(student));
    }

    @PatchMapping("/updateProfile/{email}")
    public ResponseEntity<Student> updateProfile(@RequestParam("file")  MultipartFile file, @PathVariable String email)
            throws IOException {
        return ResponseEntity.ok(studentService.updateProfile(file, email));
    }

    @GetMapping("/searchbygroup/{group}")
    public ResponseEntity<Page<Student>> searchByGroup(@RequestParam(defaultValue = "0") Integer pageNo,
    @RequestParam(defaultValue = "10") Integer pageSize, @PathVariable String group) {
        return ResponseEntity.ok(studentService.searchByGroup(pageNo, pageSize, group));
    }

    @GetMapping("/searchbyyear/{year}")
    public ResponseEntity<Page<Student>> searchByYear(@RequestParam(defaultValue = "0") Integer pageNo,
    @RequestParam(defaultValue = "10") Integer pageSize, @PathVariable String year) {
        return ResponseEntity.ok(studentService.searchByYear(pageNo, pageSize, year));
    }

    @GetMapping("/searchbycollege/{college}")
    public ResponseEntity<Page<Student>> searchByCollege(@RequestParam(defaultValue = "0") Integer pageNo,
    @RequestParam(defaultValue = "10") Integer pageSize, @PathVariable String college) {
        return ResponseEntity.ok(studentService.searchByCollege(pageNo, pageSize, college));
    }

    @PutMapping("/updatestudent/{email}")
    public ResponseEntity<Student> updateStudent(  @RequestParam("file1") MultipartFile file1,
    @RequestParam("file2") MultipartFile file2,
    @RequestParam("file3") MultipartFile file3,
    @RequestParam("file4") MultipartFile file4,
    @RequestParam("file5") MultipartFile file5,
    @PathVariable String email) throws IOException{
        return ResponseEntity.ok(studentService.updateStudent(file1, file2, file3, file4, file5, email));
    }


}
