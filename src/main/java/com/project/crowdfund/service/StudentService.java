package com.project.crowdfund.service;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.project.crowdfund.dto.StudentDto;
import com.project.crowdfund.dto.StudentRegDto;
import com.project.crowdfund.model.Student;

public interface StudentService {

    Student saveStudent(StudentDto student) throws IOException;

    Student getStudent(String email);

    Student updateStudent(Student student);

    Page<Student> findAll(int pageNo, int pageSize);

    Page<Student> getAllApproved(int pageNo, int pageSize);

    Student setApproved(String name, Student request);

    Student setRejected(Student student);

    Student updateProfile(MultipartFile file, String email) throws IOException;

    Page<Student> searchByGroup(Integer pageNo, Integer pageSize, String group);

    Page<Student> searchByYear(Integer pageNo, Integer pageSize, String year);

    Page<Student> searchByCollege(Integer pageNo, Integer pageSize,String college);

    Page<Student> getAllPending(Integer pageNo, Integer pageSize);

    Student save(StudentRegDto student);

    Student updateStudent(MultipartFile file1,
            MultipartFile file2,
            MultipartFile file3,
            MultipartFile file4,
            MultipartFile file5,String email) throws IOException;

}
