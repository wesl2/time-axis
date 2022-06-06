package site.fsyj.timeaxis.controller;

import io.swagger.annotations.Api;

import javax.websocket.server.ServerEndpoint;

/**
 * @author fsyj on 2022/5/27
 */
@Api("消息聊天模块")
@ServerEndpoint("/message/send/{type}/{to}")
public class MessageServer {

}
