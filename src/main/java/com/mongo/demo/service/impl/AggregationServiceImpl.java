package com.mongo.demo.service.impl;

import com.mongo.demo.dto.UserCountResultDto;
import com.mongo.demo.service.AggregationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AggregationServiceImpl implements AggregationService {

    private final MongoTemplate mongoTemplate;

    @Override
    public Long getRegisteredUserCount() {

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.group().count().as("totalUsers"));
        AggregationResults<UserCountResultDto> result = mongoTemplate.aggregate(aggregation, "user", UserCountResultDto.class);
        List<UserCountResultDto> userCountResult = result.getMappedResults();

        if(!userCountResult.isEmpty()) {
            return userCountResult.get(0).totalUsers();
        }
        else {
            return 0L;
        }
    }
}
