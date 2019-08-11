package com.nb3.core.service.impl;

import com.nb3.core.entity.Project;
import com.nb3.core.mapper.ProjectMapper;
import com.nb3.core.service.IProjectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试验项目表 服务实现类
 * </p>
 *
 * @author lihaoyang
 * @since 2019-08-06
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

}
