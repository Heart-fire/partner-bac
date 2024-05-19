package com.yupi.service;

import com.yupi.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.model.domain.User;
import com.yupi.model.dto.TeamQuery;
import com.yupi.model.request.TeamJoinRequest;
import com.yupi.model.request.TeamQuitRequest;
import com.yupi.model.request.TeamUpdateRequest;
import com.yupi.model.vo.TeamUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Fen919771
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-05-13 16:32:37
*/
public interface TeamService extends IService<Team> {

    long addTeam(Team team, User logininUser);

    List<TeamUserVO> listTeams (TeamQuery teamQuery, boolean isAdmin);

    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);


    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    boolean deleteTeam(long id, User loginUser);

}
