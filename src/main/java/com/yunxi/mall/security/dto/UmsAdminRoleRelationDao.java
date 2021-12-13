package com.yunxi.mall.security.dto;

import com.yunxi.mall.security.entity.UmsPermission;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: TODO 后台用户与角色管理自定义Dao
 * @author: qpf
 * @date: 2021/12/13
 * @version: 1.0
 */

public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
