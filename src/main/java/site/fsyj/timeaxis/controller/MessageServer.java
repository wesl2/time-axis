package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.websocket.server.ServerEndpoint;

/**
 * @author fsyj on 2022/5/27
 */
@Api("消息聊天模块")
@ApiOperation("发送消息，userid:发消息的用户，to：需要发给谁")
@ServerEndpoint("/message/send/{userid}/{to}")
public class MessageServer {
    
}
