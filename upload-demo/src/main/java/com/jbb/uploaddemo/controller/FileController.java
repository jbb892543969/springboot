package com.jbb.uploaddemo.controller;

import cn.soesoft.soefastdfs.common.BaseResult;
import cn.soesoft.soefastdfs.common.StatusConstant;
import cn.soesoft.soefastdfs.dto.UploadDTO;
import com.jbb.uploaddemo.service.FileService;
import com.jbb.uploaddemo.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * 大文件上传Controller
 *
 * @author jbb
 * @date 19-4-30
 */
@RestController
@RequestMapping(value = "api/file", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "文件服务")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("checkFile")
    @ApiOperation("秒传检验")
    public BaseResult checkFile(UploadDTO dto) {
        return fileService.checkFile(dto);
    }

    @PostMapping("checkChunk")
    @ApiOperation("断点续传检验")
    public BaseResult checkChunked(UploadDTO dto) {
        String filePath = FileUtils.TEMP_HOME + dto.getMd5() + File.separator + dto.getChunk() + ".tmp";
        File tempFile = new File(filePath);
        return new BaseResult(StatusConstant.SUCCESS, tempFile.exists(), "查询成功");
    }

    @PostMapping("upload")
    @ApiOperation("分片上传")
    public BaseResult upload(UploadDTO dto) {
        return fileService.upload(dto);
    }

    @PostMapping("merge")
    @ApiOperation("分片合并上传文件服务器")
    public BaseResult merge(UploadDTO dto) {
        return fileService.merge(dto);

    }
}
