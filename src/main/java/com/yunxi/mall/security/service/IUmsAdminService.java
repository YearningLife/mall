package com.yunxi.mall.security.service;

import com.yunxi.mall.security.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunxi.mall.security.entity.UmsPermission;

import java.util.List;

/**
 * <p>
 * 后台管理员Service
 * </p>
 *
 * @author 齐鹏飞
 * @since 2021-12-13
 */
public interface IUmsAdminService extends IService<UmsAdmin> {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
