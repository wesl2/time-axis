package site.fsyj.timeaxis.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fsyj on 2022/6/1
 */
@ApiModel
@Data
public class RegisterUser {

    private String email;
    private String password;
    private String name;
    private String no;
    private String major;
    @ApiModelProperty("m：男， f：女")
    private String sex;
    @ApiModelProperty("邮箱验证码")
    private String emailCode;
}
