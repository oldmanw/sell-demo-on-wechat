package com.oldmanw.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号码必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    //买家微信openId
    @NotEmpty(message = "openid必填")
    private String openid;

    //购物车
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
