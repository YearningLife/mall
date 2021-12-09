package com.yunxi.mall.tiny.service;

import com.yunxi.mall.common.CommonResult;
import com.yunxi.mall.tiny.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author 齐鹏飞
 * @since 2021-12-09
 */
public interface IUmsMemberService extends IService<UmsMember> {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
