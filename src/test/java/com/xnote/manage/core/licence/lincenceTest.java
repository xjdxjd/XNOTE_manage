package com.xnote.manage.core.licence;

import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.core.licence.bean.Licence;
import com.xnote.manage.core.licence.generate.GenerateLic;
import com.xnote.manage.core.licence.service.LicenceService;
import com.xnote.manage.core.licence.util.LicenceUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;

/**
 * @DESC:
 * @ClassName: lincenceTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class lincenceTest
{
    @Value("${xnote.licence.path}")
    private String licencePath;
    @Autowired
    private LicenceService licenceService;

    @Test
    public void getLicence()
    {
        Licence licence = new Licence();

        licence.setMachinCode(LicenceUtils.getMachinCode());
        licence.setIpAddr("127.0.0.1");
        licence.setDuration(90);
        licence.setCreateTime(new Date());
        licence.setExpiresTime(new Date());

        String lic = GenerateLic.getLicence(licence);
        System.out.println(lic);

        Licence licence1 = GenerateLic.decodeLicence(lic);
        System.out.println(licence1.toString());
    }

    @Test
    public void getLicence1() throws IOException {

        System.out.println("path = " + licencePath);
        Licence localLicence = licenceService.getLocalLicence(licencePath);
        System.out.println(localLicence);
    }

    @Test
    public void getRemainingDays() {

        String dataString = "2010-06-25 00:00:00";

        Date date = DateUtils.unFormat(dataString);
        Integer remainingDays = DateUtils.getRemainingDays(date);
        if(remainingDays > 0){
            System.out.println("剩余：" + remainingDays + "天");
        }else{
            System.out.println("已过期：" + -remainingDays + "天");
        }
    }
}
