package com.yunxi.mall.security.service.impl;

import com.yunxi.mall.security.entity.UmsAdminPermissionRelation;
import com.yunxi.mall.security.mapper.UmsAdminPermissionRelationMapper;
import com.yunxi.mall.security.service.IUmsAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author 齐鹏飞
 * @since 2021-12-13
 */
@Service
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationMapper, UmsAdminPermissionRelation> implements IUmsAdminPermissionRelationService {

}
