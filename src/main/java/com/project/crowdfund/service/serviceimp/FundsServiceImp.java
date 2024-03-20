package com.project.crowdfund.service.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import com.project.crowdfund.Repository.FundsRepository;
import com.project.crowdfund.dto.BarResponse;
import com.project.crowdfund.model.Funds;
import com.project.crowdfund.service.FundsService;
import com.project.crowdfund.service.StudentFundsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FundsServiceImp implements FundsService {
    private final FundsRepository fundsRepository;
    private final StudentFundsService studentFundsService;
    private final MongoTemplate mongoTemplate;

    @Override
    public Funds saveFunds(Funds funds) {

        studentFundsService.addAmount(funds.getStudentEmail(), funds.getStudentAmount());

        return fundsRepository.save(funds);
    }

    @Override
    public Page<Funds> getAllFunds(Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Funds> pagingFunds = fundsRepository.findAll(pageRequest);
        return pagingFunds;
    }

    @Override
    public List<Funds> getStudentsByFunder(String email) {
        return fundsRepository.findByFunderEmail(email);
    }

    @Override
    public List<BarResponse> getFundersAndAmount() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("funderEmail")
                        .sum("studentAmount").as("totalPaidAmount")
                        .addToSet("funderEmail").as("funderEmail"));

        AggregationResults<BarResponse> results = mongoTemplate.aggregate(aggregation, Funds.class, BarResponse.class);
        return results.getMappedResults();
    }

    @Override
    public Map<String, Double> getSumOfAmounts() {
        List<Funds> fundsList = fundsRepository.findAll();

        double totalStudentAmount = 0.0;
        double totalMaintenanceAmount = 0.0;

        for (Funds fund : fundsList) {
            totalStudentAmount += fund.getStudentAmount();
            totalMaintenanceAmount += fund.getMaintainenceAmount();
        }

        Map<String, Double> result = new HashMap<>();
        result.put("totalStudentAmount", totalStudentAmount);
        result.put("totalMaintenanceAmount", totalMaintenanceAmount);

        return result;
    }
}
