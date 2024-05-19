package com.yupi.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {


    private static  final  long serialVersionUID = 4937135769026142493L;



    /**
     * 页面大小
     */
    private long pageSize = 10;

    /**
     * 当前第几页
     */
    private int pageNum = 1;

}
