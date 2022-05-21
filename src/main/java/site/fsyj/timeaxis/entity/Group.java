package site.fsyj.timeaxis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="site-fsyj-timeaxis-entity-Group")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 群昵称
    */
    @ApiModelProperty(value="群昵称")
    private String name;

    /**
    * 群主
    */
    @ApiModelProperty(value="群主")
    private Integer creator;
}