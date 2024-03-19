package com.project.crowdfund.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarResponse {
    private String funderEmail;
    private Double totalPaidAmount;
}
