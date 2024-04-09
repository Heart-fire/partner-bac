package com.yupi.controller;

import com.yupi.common.BaseResponse;
import com.yupi.common.ResultUtil;
import com.yupi.service.OssService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
public class OssController {

    @Resource
    private OssService ossService;

    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public BaseResponse<String> uploadOssFile(@RequestParam(required = false) MultipartFile file) {
        //获取上传的文件
        if (file.isEmpty()) {
            return null;
        }
        //返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        //返回r对象
        return ResultUtil.success(url);
    }
}
