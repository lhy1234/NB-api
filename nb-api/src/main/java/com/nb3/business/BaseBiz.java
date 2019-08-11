package com.nb3.business;

import com.nb3.beans.HeadBean;
import com.nb3.exception.BusinessException;

import java.util.Map;

/**
 * 所有的biz类实现此接口
 */
public interface BaseBiz {

    /**
     * 参数校验
     * @param paramMap
     * @return
     */
    Map<String, Object> validateParam(Map<String,String> paramMap) throws BusinessException;


    /**
     * 处理业务逻辑
     * @param head
     * @param body
     * @return
     * @throws BusinessException
     */
    Map<String, Object> processLogic(HeadBean head,Map<String,String> body) throws BusinessException;
}
