package com.nb3.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nb3.core.entity.Token;
import com.nb3.core.mapper.TokenMapper;
import com.nb3.core.service.ITokenService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaoyang
 * @since 2019-07-24
 */
@Service
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements ITokenService {

    @Override
    public Token findByAccessToken(String token) {
        return this.selectOne(new EntityWrapper<Token>().eq("access_token",token));
    }

    @Override
    public Token findByMemberId(int memberId) {
        return this.selectOne(new EntityWrapper<Token>().eq("user_id",memberId));
    }
}
