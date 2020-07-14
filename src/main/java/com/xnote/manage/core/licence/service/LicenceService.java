package com.xnote.manage.core.licence.service;

import com.xnote.manage.core.exception.LicenceFileNotFoundException;
import com.xnote.manage.core.licence.bean.Licence;

/**
 * @DESC:
 * @ClassName: LicenceService
 */
public interface LicenceService
{
    /**
     * @DESC:   获取本地licence文件
     * @methodName: getLocalLicence
     */
    public Licence getLocalLicence(String licencePath) throws LicenceFileNotFoundException;
}
