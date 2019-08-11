package com.nb3.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.nb3.annotation.Authentication;
import com.nb3.beans.*;
import com.nb3.business.BaseBiz;
import com.nb3.core.entity.Token;
import com.nb3.core.service.ITokenService;
import com.nb3.enums.BlacklistEnum;
import com.nb3.utils.JsonUtils;
import com.nb3.utils.Md5Util;
import com.nb3.utils.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by: 李浩洋 on 2019-07-24
 **/
@RestController
public class ProtocolController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolController.class);



    @PostMapping("/protocol")
    public ProtocolParamDto dispatchCenter(@RequestParam("transMessage") String transMessage){
        long start = System.currentTimeMillis();
        //请求协议参数
        LOGGER.info("transMessage---" + transMessage);
        //响应对象
        ProtocolParamDto result = new ProtocolParamDto();
        Message message = new Message();
        //协议号
        String transactionType = "";

        //请求header
        HeadBean head = null;
        //响应参数body map
        Map<String, Object> body = null;

        try {
            //1-请求消息为空
            if (Strings.isNullOrEmpty(transMessage)) {
                LOGGER.info("[" + ProtocolCodeMsg.REQUEST_TRANS_MESSAGE_NULL.getMsg() + "]:transMessage---" + transMessage);
                return buildErrMsg(result,ProtocolCodeMsg.REQUEST_TRANS_MESSAGE_NULL.getCode(),
                        ProtocolCodeMsg.REQUEST_TRANS_MESSAGE_NULL.getMsg(),new HeadBean());
            }
            // 请求参数json转换为对象
            ProtocolParamDto paramDto = JsonUtils.jsonToPojo(transMessage,ProtocolParamDto.class);
            //2-json解析错误
            if(paramDto == null){
                return buildErrMsg(result,ProtocolCodeMsg.JSON_PARS_ERROR.getCode(),
                        ProtocolCodeMsg.JSON_PARS_ERROR.getMsg(),new HeadBean());
            }

            // 校验数据
            ProtocolParamDto validParamResult = validParam(paramDto, result);
            if (null != validParamResult) {
                return validParamResult;
            }

            head = paramDto.getMessage().getHead();
            //消息业务参数
            Map reqBody = paramDto.getMessage().getBody();


            //判断是否需要登录
            //协议号
            transactionType = head.getTransactionType();

            //从spring容器获取bean
            BaseBiz baseBiz = SpringUtil.getBean(transactionType);
            if (null == baseBiz) {
                LOGGER.error("[" + ProtocolCodeMsg.TT_NOT_ILLEGAL.getMsg() + "]:协议号---" + transactionType);
                return buildErrMsg(result, ProtocolCodeMsg.TT_NOT_ILLEGAL.getCode(), ProtocolCodeMsg.TT_NOT_ILLEGAL.getMsg(), head);
            }
            //获取是否需要登录注解
            Authentication authentication = baseBiz.getClass().getAnnotation(Authentication.class);
            boolean needLogin = authentication.value();
            System.err.println("获取Authentication注解，是否需要登录："+needLogin);
            if(authentication != null && needLogin){
                ProtocolParamDto validSignResult = validSign(head, reqBody, result);
                if(validSignResult != null){
                    return  validSignResult;
                }
            }
            // 参数校验
            final Map<String, Object>  validateParams = baseBiz.validateParam(reqBody);
            if(validateParams != null){
                // 请求参数(body)校验失败
                body = validateParams;
            }else {
                //请求参数body校验成功，执行业务逻辑
                body = baseBiz.processLogic(head, reqBody);
                if (null == body) {
                    body = new HashMap<>();
                    body.put("resCode", ProtocolCodeMsg.SUCCESS.getCode());
                    body.put("message", ProtocolCodeMsg.SUCCESS.getMsg());
                }
                body.put("message", "成功");
            }
            // 将请求头更新到返回对象中 更新时间戳
            head.setTimestamp(String.valueOf(System.currentTimeMillis()));
            //
            head.setResCode(ProtocolCodeMsg.SUCCESS.getCode());
            head.setMessage(ProtocolCodeMsg.SUCCESS.getMsg());
            message.setHead(head);
            message.setBody(body);
            result.setMessage(message);

        }catch (Exception e){
            LOGGER.error("[" + ProtocolCodeMsg.SERVER_BUSY.getMsg() + "]:协议号---" + transactionType, e);
            return buildErrMsg(result, ProtocolCodeMsg.SERVER_BUSY.getCode(), ProtocolCodeMsg.SERVER_BUSY.getMsg(), head);
        }finally {
            LOGGER.error("[" + transactionType + "] 调用结束返回消息体:" + JsonUtils.objectToJson(result));
            long currMs = System.currentTimeMillis();
            long interval = currMs - start;
            LOGGER.error("[" + transactionType + "] 协议耗时: " + interval + "ms-------------------------protocol time consuming----------------------");
        }
        return result;
    }



}
