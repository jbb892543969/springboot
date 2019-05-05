package cn.soesoft.soefastdfs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 上传文件DTO
 *
 * @author jbb
 * @date 19-4-24
 */
@Data
@ApiModel("文件上传DTO")
public class UploadDTO {
    @ApiModelProperty(value = "文件", required = true)
    @NotNull(message = "文件不允许为空")
    private MultipartFile file;
    @ApiModelProperty(value = "拥有者", required = true)
    @NotBlank(message = "拥有者不允许为空")
    private String ownerCode;
    @ApiModelProperty("拥有者所属人")
    private String parentCode;

    @ApiModelProperty("文件md5，用户下文件唯一码，大文件上传使用")
    private String md5;
    @ApiModelProperty(value = "分片序号，大文件上传使用", example = "1")
    private Integer chunk;
    @ApiModelProperty(value = "分片总数，大文件上传使用", example = "20")
    private Integer chunks;
    @ApiModelProperty("文件名，大文件上传使用")
    private String name;
}
