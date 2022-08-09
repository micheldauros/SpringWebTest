package com.yy.springboottest02;

import com.yy.springboottest02.utils.JwtUtil;
import org.junit.jupiter.api.Test;

public class JwtTest {

    @Test
    public void test01(){
        System.out.println(JwtUtil.getJwtToken("aaa"));
    }
}
