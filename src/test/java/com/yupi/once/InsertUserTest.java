package com.yupi.once;

import com.yupi.Mapper.UserMapper;
import com.yupi.model.domain.User;
import com.yupi.service.UserService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xinhuo
 * @date: 2024/5/10
 * @ClassName: yupao-backend
 * @Description:  用户插入单元测试，注意打包时要删掉或忽略，不然打一次包就插入一次
 */
@SpringBootTest
class InsertUserTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    /**
     * 循环插入用户  耗时：1895ms
     * 批量插入用户   1000  耗时： 769ms
     */
    @Test
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

    @Test
    public void doInsertUserTwo() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假心火2");
            user.setUserAccount("xinhuo2");
            user.setAvatarUrl("https://wbe-tilas.oss-cn-hangzhou.aliyuncs.com/123.jpg");
            user.setProfile("心火拉拉");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123456789108");
            user.setEmail("xinhuo2@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("1234567898");
            user.setTags("[]");
            userList.add(user);
        }
        //分批每100执行一次
        userService.saveBatch(userList,100);
        stopWatch.stop();
        System.out.println( stopWatch.getLastTaskTimeMillis());
    }

    @Resource
    private RedissonClient redissonClient;

    @Test
    void test() {
        // list，数据存在本地 JVM 内存中
        List<String> list = new ArrayList<>();
        list.add("xinhuo");
        System.out.println("list:" + list.get(0));

        list.remove(0);

        // 数据存在 redis 的内存中
        RList<String> rList = redissonClient.getList("test-list");
        rList.add("xinhuo");
        System.out.println("rlist:" + rList.get(0));
        rList.remove(0);

        // map
        Map<String, Integer> map = new HashMap<>();
        map.put("xinhuo", 10);
        map.get("xinhuo");
        RMap<Object, Object> map1 = redissonClient.getMap("test-map");
        // set
        // stack
    }
}