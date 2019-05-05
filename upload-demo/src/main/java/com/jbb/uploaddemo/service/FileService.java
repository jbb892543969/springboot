package com.jbb.uploaddemo.service;

import cn.soesoft.soefastdfs.common.BaseResult;
import cn.soesoft.soefastdfs.dto.UploadDTO;

/**
 * 文件Service
 *
 * @author jbb
 * @date 19-4-30
 */
public interface FileService {
    /**
     * 检查文件是否已上传，已上传秒传成功
     *
     * @param dto 文件信息
     * @return
     */
    BaseResult checkFile(UploadDTO dto);

    /**
     * 分片上传
     *
     * @param dto 文件信息
     * @return
     */
    BaseResult upload(UploadDTO dto);

    /**
     * 分片合并上传
     *
     * @param dto 文件信息
     * @return
     */
    BaseResult merge(UploadDTO dto);
}
