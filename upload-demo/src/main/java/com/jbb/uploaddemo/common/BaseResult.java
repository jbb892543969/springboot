package cn.soesoft.soefastdfs.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果集封装类
 *
 * @author jbb
 * @date 19-3-26
 */
@Data
@ApiModel("结果封装实体")
public class BaseResult<T> implements Serializable {
    /**
     * 返回状态码
     *
     * @see cn.soesoft.soefastdfs.common.StatusConstant
     */
    @ApiModelProperty(value = "状态码", required = true)
    private Integer code;
    /**
     * 返回数据
     */
    @ApiModelProperty("数据")
    private T data;
    /**
     * 返回消息
     */
    @ApiModelProperty(value = "消息", required = true)
    private String message;

    public BaseResult() {
    }

    public BaseResult(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BaseResult error(String message) {
        return new BaseResult(StatusConstant.INNER_ERROR, message);
    }

    public static BaseResult success(String message) {
        return new BaseResult(StatusConstant.SUCCESS, message);
    }
}
