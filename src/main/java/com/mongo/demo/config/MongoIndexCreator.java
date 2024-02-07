package com.mongo.demo.config;

import com.mongo.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MongoIndexCreator implements ApplicationListener<ContextRefreshedEvent> {

    private final MongoTemplate mongoTemplate;

    // MongoDb'deki Username verisinin index'ini unique yapar.

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        mongoTemplate.indexOps(User.class).ensureIndex(new Index().on("username", Sort.Direction.ASC).unique());

    }
}
