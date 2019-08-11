package com.nb3.controller;

import com.google.common.base.Strings;
import com.nb3.beans.HeadBean;
import com.nb3.beans.Message;
import com.nb3.beans.ProtocolCodeMsg;
import com.nb3.beans.ProtocolParamDto;

import com.nb3.core.entity.Token;
import com.nb3.core.service.ITokenService;
import com.nb3.enums.BlacklistEnum;
import com.nb3.utils.JsonUtils;
import com.nb3.utils.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by: 李浩洋 on 2019-07-25
 **/
@Controller
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private ITokenService tokenService;


    /**
     * 登录校验
     * @param head
     * @return
     */
    protected ProtocolParamDto validSign(HeadBean head,Map reqBody,ProtocolParamDto result){
        //校验签名
        System.err.println("这里校验签名: ");
        //方法是黑名单，需要登录，校验签名
        String accessToken = head.getToken();
        //token为空
        if(StringUtils.isBlank(accessToken)){
            LOGGER.warn("[{}]:token ---{}",ProtocolCodeMsg.TOKEN_IS_NULL.getMsg(),accessToken);
            return buildErrMsg(result,ProtocolCodeMsg.TOKEN_IS_NULL.getCode(),ProtocolCodeMsg.TOKEN_IS_NULL.getMsg(),head);
        }
        //黑名单接口，校验token和签名

        // 2.使用MD5进行加密，在转化成大写
        Token token = tokenService.findByAccessToken(accessToken);
        if(token == null){
            LOGGER.warn("[{}]:token ---{}",ProtocolCodeMsg.SIGN_ERROR.getMsg(),accessToken);
            return buildErrMsg(result,ProtocolCodeMsg.SIGN_ERROR.getCode(),ProtocolCodeMsg.SIGN_ERROR.getMsg(),head);
        }
        //token已过期
        if(new Date().after(token.getExpireTime())){
            //token已经过期
            System.err.println("token已过期");
            LOGGER.warn("[{}]:token ---{}",ProtocolCodeMsg.TOKEN_EXPIRED.getMsg(),accessToken);
            return buildErrMsg(result,ProtocolCodeMsg.TOKEN_EXPIRED.getCode(),ProtocolCodeMsg.TOKEN_EXPIRED.getMsg(),head);
        }
        //签名规则： 1.已指定顺序拼接字符串 secret+method+param+token+timestamp+secret
        String signStr = token.getAppSecret()+head.getTransactionType()+JsonUtils.objectToJson(reqBody)+token.getAccessToken()+head.getTimestamp()+token.getAppSecret();
        System.err.println("待签名字符串:"+signStr);
        String sign = Md5Util.md5(signStr);
        System.err.println("md5签名："+sign);
        if(!StringUtils.equals(sign,head.getSign())){
            LOGGER.warn("[{}]:token ---{}",ProtocolCodeMsg.SIGN_ERROR.getMsg(),sign);
            return buildErrMsg(result,ProtocolCodeMsg.SIGN_ERROR.getCode(),ProtocolCodeMsg.SIGN_ERROR.getMsg(),head);
        }
        return null;
    }



    /**
     *  构建错误信息
     * @param result 返回结果Dto
     * @param resCode 状态码
     * @param resMsg 状态消息
     * @return
     */
    protected ProtocolParamDto buildErrMsg(ProtocolParamDto result, String resCode, String resMsg,HeadBean head){
        Map<String, Object> resultBody = new HashMap<>();
        //协议消息
        Message message = new Message();
        //消息头
        head.setResCode(resCode);//
        head.setMessage(resMsg);
        message.setHead(head);
        //消息体
        resultBody.put("resCode", resCode);
        resultBody.put("message", resMsg);
        message.setBody(resultBody);
        result.setMessage(message);
        return result;
    }

    /**
     * 数据校验
     * @param paramDto
     * @param result
     * @return
     */
    protected ProtocolParamDto validParam(ProtocolParamDto paramDto, ProtocolParamDto result){
        //paramDto为空
        if(paramDto == null){
            LOGGER.warn("[{}]: ProtocolParamDto---{}" , ProtocolCodeMsg.PARAMETER_STRING_TO_OBJECT_FAILED.getMsg() , paramDto);
            return buildErrMsg(result,ProtocolCodeMsg.PARAMETER_STRING_TO_OBJECT_FAILED.getCode(),
                    ProtocolCodeMsg.PARAMETER_STRING_TO_OBJECT_FAILED.getMsg(),new HeadBean());
        }
        // Message 为空
        if(paramDto.getMessage() == null){
            LOGGER.warn("[{}]:  Message---{}" + ProtocolCodeMsg.MESSAGE_NULL.getMsg() , paramDto.getMessage());
            return buildErrMsg(result, ProtocolCodeMsg.MESSAGE_NULL.getCode(),
                    ProtocolCodeMsg.MESSAGE_NULL.getMsg(),new HeadBean());
        }

        HeadBean head = paramDto.getMessage().getHead();

        //head 为空
        if(head == null){
            LOGGER.warn("[{}]: Head ---{}" + ProtocolCodeMsg.HEAD_NULL.getMsg() ,head);
            return buildErrMsg(result, ProtocolCodeMsg.HEAD_NULL.getCode(),
                    ProtocolCodeMsg.HEAD_NULL.getMsg(),head);
        }

        // 校验协议号为空
        if(Strings.isNullOrEmpty(head.getTransactionType())){
            LOGGER.warn("[{}]:transactionType---{}", ProtocolCodeMsg.TRANSACTIONTYPE_NOT_ASSIGNED.getMsg() , head.getTransactionType());
            return buildErrMsg(result,
                    ProtocolCodeMsg.TRANSACTIONTYPE_NOT_ASSIGNED.getCode(),
                    ProtocolCodeMsg.TRANSACTIONTYPE_NOT_ASSIGNED.getMsg(),head);
        }
        //时间戳失效
        long interval = Math.abs(Long.valueOf(head.getTimestamp()) - System.currentTimeMillis());
        if(interval > 60 * 60 * 1000){ //10min
            LOGGER.warn("[{}]:系统时间-客户端请求间隔毫秒数: ---{}",ProtocolCodeMsg.TIMESTAMP_TIMEOUT.getMsg(),interval);
            return buildErrMsg(result,
                    ProtocolCodeMsg.TIMESTAMP_TIMEOUT.getCode(),
                    ProtocolCodeMsg.TIMESTAMP_TIMEOUT.getMsg(),head);
        }

        // 校验时间戳
        if (Strings.isNullOrEmpty(head.getTimestamp())) {
            LOGGER.warn("[{}]:Timestamp---{}" + ProtocolCodeMsg.TIMESTAMP_NOT_ASSIGNED.getMsg(), head.getTimestamp());
            return buildErrMsg(result,
                    ProtocolCodeMsg.TIMESTAMP_NOT_ASSIGNED.getCode(),
                    ProtocolCodeMsg.TIMESTAMP_NOT_ASSIGNED.getMsg(),head);
        }
        return null;
    }

}
