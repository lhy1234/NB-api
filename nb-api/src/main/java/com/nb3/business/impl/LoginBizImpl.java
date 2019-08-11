package com.nb3.business.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.base.Strings;
import com.nb3.annotation.Authentication;
import com.nb3.beans.HeadBean;
import com.nb3.beans.ProtocolCodeMsg;
import com.nb3.business.BaseBiz;
import com.nb3.core.entity.Member;
import com.nb3.core.entity.Token;
import com.nb3.core.service.IMemberService;
import com.nb3.core.service.ITokenService;
import com.nb3.exception.BusinessException;
import com.nb3.utils.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 登录接口
 */
@Authentication(value = false)
@Component("10130101")
public class LoginBizImpl implements BaseBiz{

    private static Logger LOGGER = LoggerFactory.getLogger(LoginBizImpl.class);

    @Autowired
    private IMemberService memberService;

    @Autowired
    private ITokenService tokenService;

    @Override
    public Map<String, Object> validateParam(Map<String, String> paramMap) throws BusinessException {
        Map<String, Object> resultMap = new HashMap<>();

        // 用户名
        String username = paramMap.get("username");
        if(Strings.isNullOrEmpty(username)){
            resultMap.put("resCode", ProtocolCodeMsg.USER_NOT_EXIST.getCode());
            resultMap.put("message", ProtocolCodeMsg.USER_NOT_EXIST.getMsg());
            return resultMap;
        }
        String password = paramMap.get("password");
        if(Strings.isNullOrEmpty(password)){
            resultMap.put("resCode", ProtocolCodeMsg.USER_NOT_EXIST.getCode());
            resultMap.put("message", ProtocolCodeMsg.USER_NOT_EXIST.getMsg());
            return resultMap;
        }

        return null;
    }

    @Override
    public Map<String, Object> processLogic(HeadBean head, Map<String, String> body) throws BusinessException {
        Map<String, Object> map = new HashMap<>();
        // 用户名
        String username = body.get("username");
        String password = body.get("password");

        Member member = memberService.selectOne(new EntityWrapper<Member>().eq("username",username));
        if(member == null){
            map.put("resCode", ProtocolCodeMsg.USER_NOT_EXIST.getCode());
            map.put("message", ProtocolCodeMsg.USER_NOT_EXIST.getMsg());
            return map;
        }
        if(!StringUtils.equals(member.getPassword(),password)){
            map.put("resCode", ProtocolCodeMsg.USER_NOT_EXIST.getCode());
            map.put("message", ProtocolCodeMsg.USER_NOT_EXIST.getMsg());
            return map;
        }

        map.put("memberId",member.getId());//会员id


        //insert or update token
        Token token = tokenService.findByMemberId(member.getId());
        if(token == null){
            token = new Token();
            token.setUserId(member.getId());
            token.setAccessToken(UUID.randomUUID().toString());
            token.setAppSecret(UUID.randomUUID().toString());
            token.setCreateTime(new Date());
            token.setExpireTime(DateUtils.addDays(new Date(),30));
            token.setClientType("APP");
            tokenService.insert(token);
            LOGGER.info("新增一条token:{}",token.toString());
        }else{
            token.setUserId(member.getId());
            token.setAccessToken(UUID.randomUUID().toString());
            token.setAppSecret(UUID.randomUUID().toString());
            token.setCreateTime(new Date());
            token.setExpireTime(DateUtils.addDays(new Date(),30));
            token.setClientType("APP");
            tokenService.updateById(token);
            LOGGER.info("更新一条token:{}",token.toString());
        }
        map.put("accessToken",token.getAccessToken());//
        map.put("appSecret",token.getAppSecret());

        return map;
    }
}
