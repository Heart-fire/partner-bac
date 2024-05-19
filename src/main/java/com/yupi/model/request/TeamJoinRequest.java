package com.yupi.model.request;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户加入队伍请求体
 *
 * @author Xinhuo
 * @date 2024年05月15日 9:11
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 7146187682613298972L;
    /**
     * 队伍id
     */
    private Long teamId;
    /**
     * 私有队伍需要填写密码
     */
    private String password;
}
