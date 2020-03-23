package com.workhub.z.servicechat.config;

import static com.workhub.z.servicechat.config.MessageType.*;

/*
信息中心 消息详细类型枚举：群消息、会议变更消息、私聊等等
 */
public enum SocketMsgDetailTypeEnum {
    //消息类型对照表 必须保证消息的类型是唯一的
    //私聊
    PRIVATE_MSG(MessageType.PRIVATE_MSG+""),
    //消息发送应答
    PRIVATE_SEND_ANSWER(MessageType.MSG_SEND_ANSWER+""),
    //对方打开了聊天的消息面板
    PRIVATE_RECEIVER_OPEN_BOARD(MessageType.SOCKET_SINGLE_NOTE_SEEMSG),
    //对方已读(这个目前是客户端给服务器发送，后期可以作废)
    PRIVATE_RECEIVER_READ(MessageType.MSG_EDIT_READ+""),
    //接收应答
    PRIVATE_RECEIVER_ANSWER(MessageType.MSG_RECEIVE_ANSWER),
    //接收确认
    PRIVATE_RECEIVER_CONFIRM(MessageType.MSG_RECEIVB_CONFIRM),
    //离线消息
    PRIVATE_OFF_LINE_MSG(MessageType.SOCKET_SINGLE_OFFLINE_MSG),
    //握手反馈消息
    PRIVATE_HANDSHAKE_MSG(MessageType.SOCKET_SINGLE_HAND_SHAKE),

    //群聊
    GROUP_MSG(MessageType.GROUP_MSG+""),
    //群创建
    GROUP_CREATE(MessageType.GROUP_CREATE+""),
    //群编辑
    GROUP_EDIT(MessageType.GROUP_EDIT+""),
    //群组创建成功应答
    GROUP_CREATE_ANS(MessageType.CREATE_GROUP_ANS+""),

    //会议
    MEET_MSG(MessageType.MEET_MSG+""),
    //会议变更
    MEET_CHANGE(MessageType.MEET_CHANGE+""),
    //会议添加(审批通过)
    MEETING_ADD(MessageType.MEETING_ADD+""),

    //人员上线或者离线
    USER_LINE(MessageType.LINESTATUS+""),

    //特殊权限
    AUTHORITY(MessageType.APPROVE_AUTHORITY_CODE+""),

    //无需给前端编码时候的默认值,如绑定、解绑等等
    DEFAULT(MessageType.SOCKET_DETAIL_DEFAULT+"");

    //编码
    private final String code;

    SocketMsgDetailTypeEnum(String code){
        this.code = code;
    }

    public String getCode(){
        return  this.code;
    };

}
