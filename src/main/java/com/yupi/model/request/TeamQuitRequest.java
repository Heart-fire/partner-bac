package com.yupi.model.request;

import lombok.Data;
import java.io.Serializable;

/**
 * @author Xinhuo
 * @date 2024年05月15日 11:31
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 4901776424145048370L;
    /**
     * id
     */
    private Long teamId;
}
