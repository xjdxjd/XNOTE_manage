package com.xnote.manage.core.listener;

import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.core.exception.LicenceFileNotFoundException;
import com.xnote.manage.core.licence.bean.Licence;
import com.xnote.manage.core.licence.service.LicenceService;
import com.xnote.manage.core.licence.util.LicenceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletContext;

/**
 * @DESC:
 * @ClassName: LicenceListener
 */

@Component
public class LicenceListener implements ApplicationListener<ContextRefreshedEvent>
{
    @Value("${xnote.licence.path}")
    private String LICENCEPATH;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        ApplicationContext applicationContext = event.getApplicationContext();
        LicenceService licenceService = applicationContext.getBean(LicenceService.class);
        ServletContext servletContext = applicationContext.getBean(ServletContext.class);

        //  获取本地licence文件配置信息
        Licence licence = null;
        try
        {
            licence = licence = licenceService.getLocalLicence(LICENCEPATH);
        }
        catch (LicenceFileNotFoundException e)
        {
            e.printMessage();
        }

        if(ObjectUtils.isEmpty(licence))
        {
            String machinCode = LicenceUtils.getMachinCode();
            printResult(machinCode);
            servletContext.setAttribute("machinCode",machinCode);
            servletContext.setAttribute("licMessage","许可验证失败，请上传许可文件！");
        }
        else
        {
            licence.setResidue(DateUtils.getRemainingDays(licence.getExpiresTime()));
            printResult(licence);
            servletContext.setAttribute("licence",licence);
        }
    }

    private void printResult(String machinCode)
    {
        System.out.println("<<< ===============[ licence ]============== >>>");
        System.out.println("    许可验证失败，请上传许可文件！");
        System.out.println("    产品密钥："+ machinCode);
        System.out.println("<<< ======================================== >>>");

    }

    private void printResult(Licence licence)
    {
        System.out.println("<<< ===============[ licence ]============== >>>");
        System.out.println("    产品密钥："+ licence.getMachinCode());
        System.out.println("    有效期限："+ licence.getDuration()+" 年");
        System.out.println("    到期时间："+ DateUtils.format(licence.getExpiresTime()));
        System.out.println("    剩余期限："+ licence.getResidue()+ " 天");
        System.out.println("<<< ======================================== >>>");
    }
}
