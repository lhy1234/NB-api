package com.nb3.business.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.base.Strings;
import com.nb3.annotation.Authentication;
import com.nb3.beans.HeadBean;
import com.nb3.beans.ProtocolCodeMsg;
import com.nb3.business.BaseBiz;
import com.nb3.core.entity.Member;
import com.nb3.core.entity.Project;
import com.nb3.core.entity.Token;
import com.nb3.core.service.IMemberService;
import com.nb3.core.service.IProjectService;
import com.nb3.core.service.ITokenService;
import com.nb3.exception.BusinessException;
import com.nb3.utils.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 登录接口
 */
@Authentication(value = true)
@Component("10130103")
public class ProjectListBizImpl implements BaseBiz{

    private static Logger LOGGER = LoggerFactory.getLogger(ProjectListBizImpl.class);


    @Autowired
    private IProjectService projectService;

    @Override
    public Map<String, Object> validateParam(Map<String, String> paramMap) throws BusinessException {
        Map<String, Object> resultMap = new HashMap<>();

        String userId = paramMap.get("userId");
        if(Strings.isNullOrEmpty(userId)){
            resultMap.put("resCode", ProtocolCodeMsg.ID_IS_NULL.getCode());
            resultMap.put("message", ProtocolCodeMsg.ID_IS_NULL.getMsg());
            return resultMap;
        }
        // 用户名
        String hospitalId = paramMap.get("hospitalId");
        if(Strings.isNullOrEmpty(hospitalId)){
            resultMap.put("resCode", ProtocolCodeMsg.ID_IS_NULL.getCode());
            resultMap.put("message", ProtocolCodeMsg.ID_IS_NULL.getMsg());
            return resultMap;
        }
        return null;
    }

    @Override
    public Map<String, Object> processLogic(HeadBean head, Map<String, String> body) throws BusinessException {
        Map<String, Object> map = new HashMap<>();
        // 用户名
        String hospitalId = body.get("hospitalId");

        List<Project> list = projectService.selectList(new EntityWrapper<Project>().eq("hospital_id",hospitalId));

        map.put("list",list);

        return map;
    }
}
