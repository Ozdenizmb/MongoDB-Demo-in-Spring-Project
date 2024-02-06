package com.mongo.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field("user_username")
    @Indexed(unique = true)
    private String username;
    @Field("user_first_name")
    private String firstName;
    @Field("user_last_name")
    private String lastName;
    @Field("user_password")
    private String password;
    @Field("user_status")
    private String status;

}
