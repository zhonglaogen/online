package com.zlx.resume.controller;

import com.zlx.resume.entity.Admin;
import com.zlx.resume.myentity.CompanyApply;
import com.zlx.resume.result.CodeMsg;
import com.zlx.resume.result.Result;
import com.zlx.resume.service.AdminService;
import com.zlx.resume.vo.CompanyAndApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    //查看审批结果
    //进行审批操作(可以批量)，查看已经审批和未审批

    public Result<List<CompanyAndApply>> cancelApply(Admin admin) {
        if (admin == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        List<CompanyAndApply> applies = adminService.getAllApply();
        return Result.success(applies);

    }

}
