package com.xnote.manage.core.listener;

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
    @Value("${licence.path}")
    private String licencePath;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        ApplicationContext applicationContext = event.getApplicationContext();
        LicenceService licenceService = applicationContext.getBean(LicenceService.class);
        ServletContext servletContext = applicationContext.getBean(ServletContext.class);

        //  获取本地licence文件配置信息
        Licence licence = licence = licenceService.getLocalLicence(licencePath);
        if(ObjectUtils.isEmpty(licence))
        {
            String machinCode = LicenceUtils.getMachinCode();
            System.out.println("================================================");
            System.out.println("许可验证失败，请上传许可文件！");
            System.out.println("产品密钥："+ machinCode);
            System.out.println("================================================");

            servletContext.setAttribute("machinCode",machinCode);
        }
        else
        {
            servletContext.setAttribute("licence",licence);
        }
    }
}
