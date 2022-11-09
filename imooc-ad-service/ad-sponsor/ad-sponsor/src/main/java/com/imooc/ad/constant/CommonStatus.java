package com.imooc.ad.constant;

import lombok.Getter;

@Getter
public enum CommonStatus {
    VALID(1, "有效状态"),
    InVALID(0, "无效状态");

    private  Integer status;
    private String desc;
    CommonStatus(Integer status, String Desc){
        this.status = status;
        this.desc = Desc;
    }
}
