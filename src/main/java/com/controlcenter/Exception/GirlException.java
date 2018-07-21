package com.controlcenter.Exception;

import com.controlcenter.enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer code;

    private  String girlExpDes;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
