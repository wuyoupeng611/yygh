package com.wyp.yygh.vo.mail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
@ApiModel(description = "邮箱实体")
public class MailVo {

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "短信模板code")
    private String templateCode;

    @ApiModelProperty(value = "短信模板参数")
    private Map<String, Object> param;
}


