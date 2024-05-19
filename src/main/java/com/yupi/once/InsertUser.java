package com.yupi.once;

import com.yupi.Mapper.UserMapper;
import com.yupi.model.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

@Component
public class InsertUser {
    @Resource
    private UserMapper userMapper;

    /**
     * 循环插入用户
     */
//    @Scheduled(initialDelay = 5000,fixedRate = Long.MAX_VALUE )
    public void doInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假心火");
            user.setUserAccount("xinhuo");
            user.setAvatarUrl("https://wbe-tilas.oss-cn-hangzhou.aliyuncs.com/123.jpg");
            user.setProfile("一条咸鱼");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123456789108");
            user.setEmail("xinhuo@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("1234567899");
            user.setTags("[\"男\",\"大二\"]");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println( stopWatch.getLastTaskTimeMillis());

    }
}
