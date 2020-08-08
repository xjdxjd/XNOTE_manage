package com.xnote.manage.modules.function.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.modules.function.bean.AdminFunction;
import com.xnote.manage.modules.function.mapper.AdminFunctionMapper;
import com.xnote.manage.modules.function.service.AdminFuncService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * @DESC:   管理员功能service实现类
 * @ClassName: AdminFuncServiceImpl
 */
@Service("adminFuncService")
public class AdminFuncServiceImpl implements AdminFuncService
{
    @Resource
    private AdminFunctionMapper adminFunctionMapper;

    @Override
    public List<AdminFunction> getAdminFuncByRoleId(String id)
    {
        if (StringUtils.isEmpty(id))
        {
            return null;
        }

        List<AdminFunction> funcs = adminFunctionMapper.getFuncByRoleId(id);
        if(CollectionUtils.isEmpty(funcs))
        {
            return null;
        }

        Iterator<AdminFunction> iterator = funcs.iterator();
        while (iterator.hasNext())
        {
            AdminFunction func = iterator.next();
            if(CommonConstant.TOP_LEVEL_FLAG.getString().equals(func.getParentId()))
            {
                List<AdminFunction> secondFuncs = adminFunctionMapper.getFuncByFuncId(id, func.getId());

                func.setFunctionList(secondFuncs);
            }else {

                iterator.remove();
            }
        }

        return funcs;
    }
}
