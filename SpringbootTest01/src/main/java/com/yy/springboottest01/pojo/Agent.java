package com.yy.springboottest01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class Agent {
    @Autowired
    private Actor actor;
    private LocalDateTime lastUpdate;
    public Agent(Actor actor){
        this.lastUpdate=actor.getLastUpdate();
    }
    public void setActor(Actor actor){
        this.actor=actor;
        System.out.println("set actor方法调用");
    }

}
