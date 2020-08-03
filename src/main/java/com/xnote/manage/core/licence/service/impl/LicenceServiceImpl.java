package com.xnote.manage.core.licence.service.impl;

import com.xnote.manage.core.exception.LicenceFileNotFoundException;
import com.xnote.manage.core.licence.bean.Licence;
import com.xnote.manage.core.licence.generate.GenerateLic;
import com.xnote.manage.core.licence.service.LicenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(LicenceServiceImpl.class);

//    private ManageLog manageLog = null;

    @Override
    public Licence getLocalLicence(String licencePath) throws LicenceFileNotFoundException {
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

            //添加日志
            /*
            manageLog = new ManageLog(UUIDUtils.getUUID(),"检查许可","","",);
            logger.info(manageLog.toString());
            */
        }
        catch (FileNotFoundException e)
        {
            throw new LicenceFileNotFoundException();
        }
        catch (IOException e)
        {
            throw new LicenceFileNotFoundException();
        }

        if(StringUtils.isEmpty(licenceString))
        {
            return null;
        }

        Licence licence = GenerateLic.decodeLicence(licenceString);

        return licence != null ? licence : null;
    }
}
