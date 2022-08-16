package com.yy.springbootdubbo01.interface01;

import java.util.concurrent.CompletableFuture;

public interface DemoService {
    String sayHello(String name);

    default CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }
}
