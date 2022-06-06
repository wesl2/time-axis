package site.fsyj.timeaxis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "t_event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 事件名
     */
    @ApiModelProperty(value = "事件名")
    private String name;

    /**
     * 老师信息
     */
    @ApiModelProperty(value = "老师信息")
    private String teacher;

    /**
     * 专业信息
     */
    @ApiModelProperty(value = "专业信息")
    private String major;

    /**
     * 截止时间
     */
    @ApiModelProperty(value = "截止时间")
    private String time;


    /**
    * 事件拥有者
    */
    @ApiModelProperty(value="事件拥有者")
    private Integer owner;
}