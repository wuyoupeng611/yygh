package com.wyp.yygh.vo.order;

import com.wyp.yygh.vo.msm.MsmVo;
import com.wyp.yygh.vo.mail.MailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
@ApiModel(description = "OrderMqVo")
public class OrderMqVo {

	@ApiModelProperty(value = "可预约数")
	private Integer reservedNumber;

	@ApiModelProperty(value = "剩余预约数")
	private Integer availableNumber;

	@ApiModelProperty(value = "排班id")
	private String scheduleId;

	@ApiModelProperty(value = "短信实体")
	private MsmVo msmVo;

	@ApiModelProperty(value = "邮箱实体")
	private MailVo MailVo;

}

