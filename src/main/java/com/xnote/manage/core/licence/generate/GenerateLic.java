package com.xnote.manage.core.licence.generate;

import com.xnote.manage.core.licence.bean.Licence;
import com.xnote.manage.core.licence.util.AESUtils;

/**
 * @DESC:   生成许可
 * @ClassName: GenerateLic
 */
public class GenerateLic
{

    public static String getLicence(Licence licence)
    {
        String lic = AESUtils.encodeForAES(licence.format());
        return lic;
    }

    public static Licence decodeLicence(String licenceString)
    {
        String lic = AESUtils.decodeForAES(licenceString);
        Licence licence = new Licence().restore(lic);

        return licence;
    }
}
