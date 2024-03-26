package com.project.crowdfund.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.crowdfund.model.Student;
import com.project.crowdfund.model.Users;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByEmail(Users email);

    Page<Student> findByStatus(String string, PageRequest pageRequest);

    @Query("{ 'course': { $regex: ?0, $options: 'i' } }")
    Page<Student> findByCourse(String group, PageRequest pageRequest);

    // @Query("{ 'yearOfStudy': { $regex: ?0, $options: 'i' } }")
    Page<Student> findByYearOfStudy(String year, PageRequest pageRequest);

    List<Student> findByStatus(String string);

    @Query("{ 'collegeName': { $regex: ?0, $options: 'i' } }")
    Page<Student> findByCollegeName(String college, PageRequest pageRequest);

}
