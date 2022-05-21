package site.fsyj.timeaxis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="site-fsyj-timeaxis-entity-GroupMember")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMember {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 群成员ID
    */
    @ApiModelProperty(value="群成员ID")
    private Integer menberId;

    /**
    * 0：群主，1：普通群员
    */
    @ApiModelProperty(value="0：群主，1：普通群员")
    private String type;
}