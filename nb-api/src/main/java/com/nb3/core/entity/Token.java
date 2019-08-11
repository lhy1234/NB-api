package com.nb3.core.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihaoyang
 * @since 2019-07-24
 */
@TableName("tb_token")
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增长 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * Token/索引 
     */
    @TableField("access_token")
    private String accessToken;
    /**
     * 密钥 
     */
    @TableField("app_secret")
    private String appSecret;
    /**
     * 创建时间 
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 有效期至 
     */
    @TableField("expire_time")
    private Date expireTime;
    /**
     * 客户端IP 
     */
    @TableField("client_ip")
    private String clientIp;
    /**
     * 客户端类别 
     */
    @TableField("client_type")
    private String clientType;
    /**
     * 设备标识 
     */
    @TableField("e_code")
    private String eCode;
    /**
     * 设备用户标识
     */
    @TableField("u_code")
    private String uCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public String getuCode() {
        return uCode;
    }

    public void setuCode(String uCode) {
        this.uCode = uCode;
    }

    @Override
    public String toString() {
        return "Token{" +
        "id=" + id +
        ", userId=" + userId +
        ", accessToken=" + accessToken +
        ", appSecret=" + appSecret +
        ", createTime=" + createTime +
        ", expireTime=" + expireTime +
        ", clientIp=" + clientIp +
        ", clientType=" + clientType +
        ", eCode=" + eCode +
        ", uCode=" + uCode +
        "}";
    }
}
