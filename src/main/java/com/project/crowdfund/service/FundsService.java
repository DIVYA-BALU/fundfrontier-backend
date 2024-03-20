package com.project.crowdfund.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.project.crowdfund.dto.BarResponse;
import com.project.crowdfund.model.Funds;

public interface FundsService {

    Funds saveFunds(Funds funds);

    Page<Funds> getAllFunds(Integer pageNo, Integer pageSize);

    List<Funds> getStudentsByFunder(String email);

    List<BarResponse> getFundersAndAmount();

    Map<String, Double> getSumOfAmounts();

}
