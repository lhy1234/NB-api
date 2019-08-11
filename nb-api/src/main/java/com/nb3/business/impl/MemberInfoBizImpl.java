package com.nb3.business.impl;

import com.google.common.base.Strings;
import com.nb3.annotation.Authentication;
import com.nb3.beans.HeadBean;
import com.nb3.beans.ProtocolCodeMsg;
import com.nb3.business.BaseBiz;
import com.nb3.core.entity.Member;
import com.nb3.core.service.IMemberService;
import com.nb3.core.service.ITokenService;
import com.nb3.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取会员信息,需要登录
 */
@Authentication(value = true)
@Component("10130102")
public class MemberInfoBizImpl implements BaseBiz {


    @Autowired
    private IMemberService memberService;

    @Autowired
    private ITokenService tokenService;


    @Override
    public Map<String, Object> validateParam(Map<String, String> paramMap) throws BusinessException {
        Map<String, Object> resultMap = new HashMap<>();

        // 校验会员id
        String memberId = paramMap.get("memberId");
        if(Strings.isNullOrEmpty(memberId)){
            resultMap.put("resCode", ProtocolCodeMsg.REQUEST_USER_MESSAGE_ERROR.getCode());
            resultMap.put("message", ProtocolCodeMsg.REQUEST_USER_MESSAGE_ERROR.getMsg());
            return resultMap;
        }
        return null;
    }

    @Override
    public Map<String, Object> processLogic(HeadBean head, Map<String, String> body) throws BusinessException {
        Map<String, Object> map = new HashMap<>();
        String memberId = body.get("memberId");
        Member member = memberService.selectById(memberId);
        if(member == null){
            map.put("resCode", ProtocolCodeMsg.USER_NOT_EXIST.getCode());
            map.put("message", ProtocolCodeMsg.USER_NOT_EXIST.getMsg());
            return map;
        }
        map.put("memberId",member.getId());//会员id
        map.put("username",member.getUsername());//用户名
        return map;
    }
}
