package com.xnote.manage.core.licence.service.impl;

import com.xnote.manage.core.licence.bean.Licence;
import com.xnote.manage.core.licence.generate.GenerateLic;
import com.xnote.manage.core.licence.service.LicenceService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @DESC:
 * @ClassName: LicenceServiceImpl
 */
@Service("licenceService")
public class LicenceServiceImpl implements LicenceService
{
    @Override
    public Licence getLocalLicence(String licencePath)
    {
        if(StringUtils.isEmpty(licencePath))
        {
            return null;
        }

        String licenceString = null;
        try
        {
            Resource resource = new ClassPathResource(licencePath);
            File file = resource.getFile();
            InputStreamReader isReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(isReader);
            StringBuffer content = new StringBuffer();

            String s = "";
            while ((s=br.readLine())!=null)
            {
                content = content.append(s);
            }
            licenceString = content.toString();

            isReader.close();
            file.delete();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

        if(StringUtils.isEmpty(licenceString))
        {
            return null;
        }

        Licence licence = GenerateLic.decodeLicence(licenceString);

        return licence != null ? licence : null;
    }
}
