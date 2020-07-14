package com.xnote.manage.core.exception;

import com.xnote.manage.core.exception.exceptionEnum.LicenceEnum;

import java.io.IOException;

/**
 * @DESC:
 * @ClassName: LicenceFileNotFoundException
 */
public class LicenceFileNotFoundException extends IOException
{
    private static final long serialVersionUID = -897856973823710492L;
    public LicenceFileNotFoundException() {
        super();
    }

    public LicenceFileNotFoundException(String s)
    {
        super(s);
    }

    public LicenceFileNotFoundException(LicenceEnum licenceEnum)
    {

    }
    public LicenceFileNotFoundException(String path, String reason) {
        super(path + ((reason == null)
                ? ""
                : " (" + reason + ")"));
    }

    public void printMessage()
    {
        System.out.println(
                "错误码: "+LicenceEnum.FILE_NOT_FOUND.getCode() + "\n" +
                "错误消息: "+LicenceEnum.FILE_NOT_FOUND.getMsg());
    }
}
