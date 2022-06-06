package site.fsyj.timeaxis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="site-fsyj-timeaxis-entity-Message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 消息发送者
    */
    @ApiModelProperty(value="消息发送者")
    private Integer from;

    /**
    * 接收消息的群号
    */
    @ApiModelProperty(value="接收消息的群号")
    private Integer to;

    /**
    * 消息时间
    */
    @ApiModelProperty(value="消息时间")
    private Long time;

    /**
    * 0：普通文本消息，1：多媒体消息
    */
    @ApiModelProperty(value="0：普通文本消息，1：多媒体消息")
    private String type;

    /**
    * 消息内容，如果是文本，则直接存储，否则，存路径
    */
    @ApiModelProperty(value="消息内容，如果是文本，则直接存储，否则，存路径")
    private String content;
}