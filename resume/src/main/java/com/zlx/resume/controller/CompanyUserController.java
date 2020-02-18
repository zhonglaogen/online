package com.zlx.resume.controller;

import com.zlx.resume.dto.CuCheckState;
import com.zlx.resume.dto.Expirence;
import com.zlx.resume.entity.Company;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.myentity.CompanyApply;
import com.zlx.resume.result.CodeMsg;
import com.zlx.resume.result.Result;
import com.zlx.resume.service.AddExpirenceService;
import com.zlx.resume.service.CompanyService;
import com.zlx.resume.service.FindUserService;
import com.zlx.resume.vo.FindVo;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(description = "公司人员账户操作")
@RestController
@RequestMapping("/find")
public class CompanyUserController {

    //登录
    @Autowired
    CompanyService companyService;
    //验证
    @Autowired
    FindUserService findUserService;
    //添加经历
    @Autowired
    AddExpirenceService addExpirenceService;

    /**
     * 为账号添加关联公司申请
     *
     * @return
     */
    @ApiOperation(value = "申请关联公司接口")
    @ApiImplicitParam(name = "companyApply", value = "申请信息", required = true, dataType = "CompanyApply")

    @PostMapping("/apply")
    public Result<Object> addCompanyApply(Companyuser user, CompanyApply companyApply, Company company) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        companyService.cuApply(user, companyApply,company);


        //实名制添加
        //添加要关联公司的名称
        //公司位置
        //
        return Result.success(companyApply);

    }

    /**
     * 查看申请结果
     *
     * @return
     */
    @GetMapping("/getresult")
    public Result<List<CompanyApply>> getApplyResult(Companyuser user) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        List<CompanyApply> apply = companyService.findApply(user);

        return Result.success(apply);

    }

    /**
     * 取消申请
     */
    public Result cancelApply(Companyuser user,CompanyApply companyApply){
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        companyService.cancelApply(companyApply);
        return Result.success("取消成功");

    }

    /**
     * @param user
     * @param findVo
     * @return
     * @Valid 发送验证码
     */
    @ApiOperation(value = "发送验证码接口")
    @ApiImplicitParam(name = "findVo", value = "主要是传入需要查询的身份证号码，通过身份证号给此人手机发送验证码", required = true, dataType = "FindVo")
    @PostMapping("/sendcode")
    public Result<Object> sendCode(Companyuser user, FindVo findVo) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        findUserService.sendCode(user, findVo);
        return Result.success("已经发送");
    }


    /**
     * 检验验证码，检验成功生成token，和redis的key（token）和v（stat）
     * 验证通过生成查询token
     *
     * @param user
     * @param findVo
     * @return
     */
    @ApiOperation(value = "核对验证码接口")
    @ApiImplicitParam(name = "findVo", value = "主要是传入手机收到的验证码进行核对", required = true, dataType = "FindVo")
    @PostMapping("/checkcode")
    public Result<String> checkCode(HttpServletResponse response, Companyuser user, FindVo findVo, CuCheckState state) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        if (state != null) {
            return Result.success("验证已经通过");
        }
        //将验证码信息以 userid：code的形式存入redis
        findUserService.checkCode(response, user, findVo);
        return Result.success("验证通过");

    }

    /**
     * 移除此条查询缓存
     *
     * @param user
     * @return
     */
    @GetMapping("/clean_history")
    public Result<String> cleanFind(HttpServletRequest request,
                                    HttpServletResponse response, Companyuser user) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        findUserService.cleanFindHistory(request,response,user);
        return Result.success("已清理");
    }

    /**
     * 拿到简历信息
     *
     * @param user
     * @param state
     * @return
     */
    @ApiOperation(value = "进行获取工作经历信息,state信息存在redis,超时失效无法获取")
    @ApiImplicitParam(name = "state", value = "负责检验用户是否具备查询此id的条件，如果具备，显示此身份证的基本信息", required = true, dataType = "CuCheckState")
    @GetMapping("/getuser")
    public Result<User1> getUser(Companyuser user, CuCheckState state) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        if (state == null) {
            //未验证的用户
            return Result.error(CodeMsg.USER_NOT_CHECK);
        }
        User1 user1 = findUserService.getUser(user, state);
        return Result.success(user1);
    }

    /**
     * 添加工作经历
     *
     * @param user
     * @param state
     * @param expirence
     * @return
     */
    @ApiOperation(value = "为此身份证添加工作经历信息，使用此功能用户必须已经关联公司id")
    @ApiImplicitParam(name = "state", value = "负责检验用户是否具备查询此id的条件，如果具备，显示此身份证的基本信息", required = true, dataType = "CuCheckState")
    @PostMapping("/addexpir")
    public Result<String> addExpir(Companyuser user, CuCheckState state, Expirence expirence) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        if (state == null) {
            //未验证的用户
            return Result.error(CodeMsg.USER_NOT_CHECK);
        }
        if (user.getcId() == null) {
            //未注册公司的账号,不可添加经历
            return Result.error(CodeMsg.USER_NOT_RESIT);
        }
        addExpirenceService.addExpir(user, state, expirence);
        return Result.success("添加成功");

    }

    /**
     * 查询工作经历
     *
     * @param user
     * @param state
     * @return
     */

    @ApiImplicitParam(name = "state", value = "负责检验用户是否具备查询此id的条件，如果具备，显示此身份证的基本信息", required = true, dataType = "CuCheckState")
    @GetMapping("/findexpri")
    public Result<List<Expirence>> findExpir(Companyuser user, CuCheckState state) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        if (state == null) {
            //未验证的用户
            return Result.error(CodeMsg.USER_NOT_CHECK);
        }
        List<Expirence> expir = addExpirenceService.findExpir(user, state);
        return Result.success(expir);
    }

}
