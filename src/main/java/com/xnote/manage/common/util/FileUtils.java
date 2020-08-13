package com.xnote.manage.common.util;

import com.xnote.manage.common.constant.CommonConstant;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 */
public class FileUtils
{
    /**
     * 保存在本地
     * @param file  上传的文件
     * @param path  保存路径
     * @return
     */
    public static Integer saveLocally(MultipartFile file, String path, String fileName)
    {
        try
        {
            if(!ObjectUtils.isEmpty(file))
            {
                File sfile = new File(path, file.getOriginalFilename());

                if(!sfile.getParentFile().exists())
                {
                    sfile.getParentFile().mkdirs();
                }

                File tempFile = new File(path + fileName);
                file.transferTo(tempFile);
            }

            return CommonConstant.STATUS_NORMAL.getInt();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return CommonConstant.STATUS_UNNORMAL.getInt();
        }
    }

    /**
     * 获取文件新名称 -- UUID
     * @param oName 原文件文件
     * @return  新文件名
     */
    public static String getFileName(String oName)
    {
        String str = UUIDUtils.getUUID() + oName.substring(oName.lastIndexOf("."));
        return str;
    }
}
