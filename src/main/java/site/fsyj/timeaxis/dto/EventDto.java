package site.fsyj.timeaxis.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fsyj on 2022/6/1
 */
@ApiModel("事件模型")
@Data
public class EventDto {

    private String name;
    @ApiModelProperty("直接老师名字就行了")
    private String teacher;
    private String major;
    private String time;

}
