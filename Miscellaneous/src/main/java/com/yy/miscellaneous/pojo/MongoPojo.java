package com.yy.miscellaneous.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@AllArgsConstructor
@Document("admin")
public class MongoPojo {
    @Id
    private int id;
//    @MongoId
//    private String id;

    @Field("name")
    private String  name;
    @Field("age")
    private int age;

}
