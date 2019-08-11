package com.nb3.core.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 试验项目表
 * </p>
 *
 * @author lihaoyang
 * @since 2019-08-06
 */
@TableName("crc_project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 医院id
     */
    @TableField("hospital_id")
    private Integer hospitalId;
    /**
     * 医院名称
     */
    @TableField("hospital_name")
    private String hospitalName;
    /**
     * 申办方id
     */
    @TableField("sponsor_id")
    private Integer sponsorId;
    /**
     * 申办方名称
     */
    @TableField("sponsor_name")
    private String sponsorName;
    /**
     * 几期1,2,3,4的
     */
    private Integer phase;
    /**
     * 项目名
     */
    @TableField("project_name")
    private String projectName;
    /**
     * 专业Id(引用专业表)
     */
    @TableField("speciality_id")
    private Integer specialityId;
    /**
     * 专业名
     */
    @TableField("speciality_name")
    private String specialityName;
    /**
     * 项目开始时间
     */
    @TableField("start_date")
    private String startDate;
    /**
     * 项目结束时间
     */
    @TableField("end_date")
    private String endDate;
    /**
     * 项目状态1进行中2已完成
     */
    private Integer state;
    /**
     * 负责人id
     */
    @TableField("manager_id")
    private Integer managerId;
    /**
     * 负责人姓名
     */
    @TableField("manager_name")
    private String managerName;
    /**
     * smo_id
     */
    @TableField("smo_id")
    private Integer smoId;
    /**
     * smo_name
     */
    @TableField("smo_name")
    private String smoName;
    /**
     * smo所在省份
     */
    @TableField("smo_province")
    private String smoProvince;
    /**
     * smo所在城市
     */
    @TableField("smo_city")
    private String smoCity;
    /**
     * 是否确认0否1是
     */
    @TableField("is_confirm")
    private Integer isConfirm;
    /**
     * 创建人id
     */
    @TableField("create_user_id")
    private Integer createUserId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改人id
     */
    @TableField("update_user_id")
    private Integer updateUserId;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 是否删除0否1是
     */
    @TableField("is_del")
    private Integer isDel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Integer getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getSmoId() {
        return smoId;
    }

    public void setSmoId(Integer smoId) {
        this.smoId = smoId;
    }

    public String getSmoName() {
        return smoName;
    }

    public void setSmoName(String smoName) {
        this.smoName = smoName;
    }

    public String getSmoProvince() {
        return smoProvince;
    }

    public void setSmoProvince(String smoProvince) {
        this.smoProvince = smoProvince;
    }

    public String getSmoCity() {
        return smoCity;
    }

    public void setSmoCity(String smoCity) {
        this.smoCity = smoCity;
    }

    public Integer getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(Integer isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "Project{" +
        "id=" + id +
        ", hospitalId=" + hospitalId +
        ", hospitalName=" + hospitalName +
        ", sponsorId=" + sponsorId +
        ", sponsorName=" + sponsorName +
        ", phase=" + phase +
        ", projectName=" + projectName +
        ", specialityId=" + specialityId +
        ", specialityName=" + specialityName +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", state=" + state +
        ", managerId=" + managerId +
        ", managerName=" + managerName +
        ", smoId=" + smoId +
        ", smoName=" + smoName +
        ", smoProvince=" + smoProvince +
        ", smoCity=" + smoCity +
        ", isConfirm=" + isConfirm +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", updateUserId=" + updateUserId +
        ", updateTime=" + updateTime +
        ", isDel=" + isDel +
        "}";
    }
}
