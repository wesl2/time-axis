package site.fsyj.timeaxis.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author fsyj on 2022/6/1
 */
@ApiModel("登录用户模型")
@Data
public class LoginDto {

    private String email;
    private String password;
}
