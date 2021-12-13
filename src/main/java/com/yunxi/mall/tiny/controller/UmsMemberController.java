package com.yunxi.mall.tiny.controller;


import com.yunxi.mall.common.CommonResult;
import com.yunxi.mall.tiny.service.IUmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员登录注册管理Controller
 * </p>
 *
 * @author 齐鹏飞
 * @since 2021-12-09
 */
@RestController("/tiny/ums-member")
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
public class UmsMemberController {
    @Autowired
    private IUmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }

}
