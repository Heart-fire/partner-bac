package com.yupi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.model.domain.UserTeam;
import com.yupi.service.UserTeamService;
import  com.yupi.Mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author xinhuo
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-05-13 16:33:55
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




