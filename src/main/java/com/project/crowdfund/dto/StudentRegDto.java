package com.project.crowdfund.dto;


import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRegDto {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String countryOfBirth;
    private String countryOfResidence;
    private String dateOfBirth;
    private String address;
    private String city;
    private String state;
    private Integer zipCode;
    private String school;
    private String collegeName;
    private String yearOfStudy;
    private String course;
    private String studentId;
    private BigDecimal fundRequired;
    private String endDate;
    private String shortStory;
    private String status;
}
