package site.fsyj.timeaxis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="site-fsyj-timeaxis-entity-User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty(value="")
    private Integer id;

    @ApiModelProperty(value="")
    private String email;

    @ApiModelProperty(value="")
    private String password;

    /**
    * 姓名
    */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
    * 学号
    */
    @ApiModelProperty(value="学号")
    private String no;

    /**
    * 专业
    */
    @ApiModelProperty(value="专业")
    private String major;

    /**
    * m:男，f:女
    */
    @ApiModelProperty(value="m:男，f:女")
    private String sex;

    /**
    * 头像地址
    */
    @ApiModelProperty(value="头像地址")
    private String avatar;

    /**
    * 0:true,1：false
    */
    @ApiModelProperty(value="0:true,1：false")
    private Boolean enable;
}