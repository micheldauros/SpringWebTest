package com.yy.miscellaneous;
import java.util.
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@Slf4j
public class HttpClientTest {
    @Test
    void test01(){

        CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();

        httpClient.start();

        SimpleHttpRequest request = SimpleRequestBuilder.get("http://httpbin.org/get").build();
        request.addHeader("connection","keep-alive");
        afd.aff

        Future<CloseableHttpResponse> future = httpClient.execute(request, null);

        try {

            CloseableHttpResponse response = future.get();
            log.info("{}\t\t{}", response.getCode(), response.getBodyText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
