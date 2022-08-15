package com.yy.springsecurity01;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.junit.jupiter.api.Test;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class SpringSecurity01ApplicationTests {

    @Test
    void contextLoads() {
        Map<String ,Object> headers=new HashMap<>();
        headers.put("alg","HS265");
        headers.put("typ","JWT");
        Map<String ,Object> claims=new HashMap<>();
        claims.put("username","Terry");
        claims.put("id",1233);
        Jwt a = new Jwt("abcdefg", null, null, headers, claims);
        System.out.println(a.getClaims());
    }

    @Test
    void Jwt01(){
        Map<String ,Object> claims=new HashMap<>();
        claims.put("username","Terry");
        claims.put("id",1233);
        JwtClaimsSet.Builder builder = JwtClaimsSet.builder();
        builder.claim("username","Terry");
            builder.claim("id",1233);

        builder.claims((T)->{
            T.forEach((key,value)->{
                System.out.println(key);
            });
        });
        JwtClaimsSet build = builder.build();

        JwtEncoderParameters parameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), build);
        NimbusJwtEncoder encoder = new NimbusJwtEncoder(new ImmutableSecret("abcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefg".getBytes()));
        Jwt jwt = encoder.encode(parameters);

        System.out.println(jwt.getTokenValue());
        SecretKey secretKey = new SecretKeySpec("abcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefgabcdefg".getBytes(), "HMACSHA256");
        Jwt decode = NimbusJwtDecoder.withSecretKey(secretKey).build().decode(jwt.getTokenValue());
        System.out.println(decode.getClaims());
    }

}
