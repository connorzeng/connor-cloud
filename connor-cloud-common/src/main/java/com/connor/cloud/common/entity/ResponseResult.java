package com.connor.cloud.common.entity;

import com.connor.cloud.common.exception.BaseException;
import com.connor.cloud.common.exception.ErrorType;
import com.connor.cloud.common.exception.SystemErrorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;


@Getter
@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
public class ResponseResult<T> {

    public static final String SUCCESSFUL_CODE = "000000";
    public static final String SUCCESSFUL_MESG = "处理成功";

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String mesg;
    @ApiModelProperty(value = "请求结果生成时间戳")
    private Instant time;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseResult() {
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @param errorType
     */
    public ResponseResult(ErrorType errorType) {
        this.code = errorType.getCode();
        this.mesg = errorType.getMesg();
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @param errorType
     * @param data
     */
    public ResponseResult(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param mesg
     * @param data
     */
    private ResponseResult(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * 快速创建成功结果并返回结果数据
     *
     * @param data
     * @return ResponseResult
     */
    public static ResponseResult success(Object data) {
        return new ResponseResult<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    /**
     * 快速创建成功结果
     *
     * @return ResponseResult
     */
    public static ResponseResult success() {
        return success(null);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @return ResponseResult
     */
    public static ResponseResult fail() {
        return new ResponseResult(SystemErrorType.SYSTEM_ERROR);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @param baseException
     * @return ResponseResult
     */
    public static ResponseResult fail(BaseException baseException) {
        return fail(baseException, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return ResponseResult
     */
    public static ResponseResult fail(BaseException baseException, Object data) {
        return new ResponseResult<>(baseException.getErrorType(), data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @param data
     * @return ResponseResult
     */
    public static ResponseResult fail(ErrorType errorType, Object data) {
        return new ResponseResult<>(errorType, data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @return ResponseResult
     */
    public static ResponseResult fail(ErrorType errorType) {
        return ResponseResult.fail(errorType, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return ResponseResult
     */
    public static ResponseResult fail(Object data) {
        return new ResponseResult<>(SystemErrorType.SYSTEM_ERROR, data);
    }


    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}
