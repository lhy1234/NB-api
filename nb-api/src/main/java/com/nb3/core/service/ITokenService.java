package com.nb3.core.service;

import com.nb3.core.entity.Token;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaoyang
 * @since 2019-07-24
 */
public interface ITokenService extends IService<Token> {


    Token findByAccessToken(String token);

    Token findByMemberId(int memberId);

}
