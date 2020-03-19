package com.workhub.z.servicechat.VO;

import com.workhub.z.servicechat.config.SocketMsgDetailTypeEnum;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author:zhuqz
 * description:应答前端消息体
 * date:2019/10/16 14:32
 **/
@Data
public class SocketMsgDetailVo implements Serializable {
    private static final long serialVersionUID = -820977987664126610L;
    /**编码 与 MessageType编码一一对应*/
    private String code;
    /**消息内容*/
    private Object data;

    public String getCode() {
        return code;
    }
   //使用枚举限制code，防止后期编码增加不好维护
    public void setCode(SocketMsgDetailTypeEnum code) {
        this.code = code.getCode();
    }
    public void setCode(String code) throws Exception{
        boolean check = false;
        for(SocketMsgDetailTypeEnum item : SocketMsgDetailTypeEnum.values()){
            if(item.getCode().equals(code)){
                check = true;
                break;
            }
        }
        if(!check){
            throw new Exception("消息体编码不再枚举范围内");

        }
        this.code = code;
    }
}
