package com.xnote.manage.core.licence;

import com.xnote.manage.core.licence.bean.Licence;
import com.xnote.manage.core.licence.generate.GenerateLic;
import com.xnote.manage.core.licence.util.LicenceUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @DESC:
 * @ClassName: lincenceTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class lincenceTest
{
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
}
