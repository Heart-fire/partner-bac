package com.yupi.once;

import com.yupi.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @author: xinhuo
 * @ClassName: yupao-backend
 * @Description:    Redis测试
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;


    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("xinhuoString", "fish");
        valueOperations.set("xinhuoInt", 1);
        valueOperations.set("xinhuoDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("xinhuo");
        valueOperations.set("xinhuoUser", user);

        // 查
        Object xinhuo = valueOperations.get("xinhuoString");
        Assertions.assertTrue("fish".equals((String) xinhuo));
        xinhuo = valueOperations.get("xinhuoInt");
        Assertions.assertTrue(1 == (Integer) xinhuo);
        xinhuo = valueOperations.get("xinhuoDouble");
        Assertions.assertTrue(2.0 == (Double) xinhuo);
        System.out.println(valueOperations.get("xinhuoUser"));
        valueOperations.set("xinhuoString", "fish");

        //删
//        redisTemplate.delete("xinhuoString");
    }

}
