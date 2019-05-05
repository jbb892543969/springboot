package com.jbb.uploaddemo.service.impl;

import cn.soesoft.soefastdfs.common.BaseResult;
import cn.soesoft.soefastdfs.common.StatusConstant;
import cn.soesoft.soefastdfs.dto.UploadDTO;
import com.jbb.uploaddemo.service.FileService;
import com.jbb.uploaddemo.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * FileServiceImpl
 *
 * @author jbb
 * @date 19-4-30
 */
@Service
public class FileServiceImpl implements FileService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BaseResult checkFile(UploadDTO dto) {
        boolean flag = false;
        // 校验文件md5若存在秒传成功
        if (flag) {
            new BaseResult(StatusConstant.SUCCESS, true, "秒传成功");
        }
        return new BaseResult(StatusConstant.SUCCESS, false, "文件不存在");
    }

    @Override
    public BaseResult upload(UploadDTO dto) {
        String dirPath = FileUtils.TEMP_HOME + dto.getMd5();
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File tempFile = new File(dirPath + File.separator + dto.getChunk() + ".tmp");
        try {
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            dto.getFile().transferTo(tempFile);
        } catch (IOException e) {
            logger.error("分片上传失败失败原因：", e);
            return new BaseResult(StatusConstant.INNER_ERROR, false, "分片上传失败：" + e.getMessage());
        }

        return new BaseResult(StatusConstant.SUCCESS, true, "分片上传成功");
    }

    @Override
    public BaseResult merge(UploadDTO dto) {
        byte[] content = new byte[1024];
        File dir = new File(FileUtils.TEMP_HOME + dto.getMd5());
        File file = new File(System.getProperty("user.home") + File.separator + dto.getName());

        try (OutputStream outputStream = new FileOutputStream(file);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {
            for (int i = 0; i < dto.getChunks(); i++) {
                FileInputStream inputStream = new FileInputStream(FileUtils.TEMP_HOME + dto.getMd5() + File.separator + i + ".tmp");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                int len = 0;
                while ((len = bufferedInputStream.read(content)) != -1) {
                    bufferedOutputStream.write(content, 0, len);
                }
                inputStream.close();
            }
        } catch (IOException e) {
            logger.error("分片合并失败：", e);
            return new BaseResult(StatusConstant.INNER_ERROR, false, "分片合并失败" + e.getMessage());
        }

        // 删除分片目录
        boolean flag = FileUtils.deleteDir(dir);
        if (!flag) {
            logger.warn("文件目录删除失败，路径" + dir.getAbsolutePath());
        }

        return new BaseResult(StatusConstant.SUCCESS, true, "上传成功");
    }
}
