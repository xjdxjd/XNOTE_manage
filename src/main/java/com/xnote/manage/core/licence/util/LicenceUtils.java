package com.xnote.manage.core.licence.util;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import sun.security.provider.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @DESC:
 * @ClassName: commonUtils
 */
public class LicenceUtils
{
    /**
     * @DESC:   获取机器码
     * @methodName: getMachinCode
     */
    public static String getMachinCode()
    {
        String machinCode = null;

        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem os = systemInfo.getOperatingSystem();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        StringBuffer machinCodeBuffer = new StringBuffer();
        machinCodeBuffer.append(getOSParam(os)+"-");
        machinCodeBuffer.append(getMotherboardSn(hardware)+"-");
        machinCodeBuffer.append(getCPUSn(hardware));

        try
        {
            MD5 md5 = new MD5(); MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(machinCodeBuffer.toString().getBytes());
            machinCode = new BigInteger(1, md.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException e){
            System.out.println("获取机器码出错");
            e.printStackTrace();
        }
        return machinCode;
    }

    /**
     * @DESC:   获取CPU序列号
     * @methodName: getCPUSn
     */
    public static String getCPUSn (HardwareAbstractionLayer hardware)
    {
        CentralProcessor processor = hardware.getProcessor();
        String processorID = processor.getProcessorIdentifier().getProcessorID();
        return processorID;
    }

    /**
     * @DESC:   获取主板序列号
     * @methodName: getMotherboardSn
     */
    public static String getMotherboardSn(HardwareAbstractionLayer hardware)
    {
        ComputerSystem computer = hardware.getComputerSystem();
        String serialNumber = computer.getBaseboard().getSerialNumber();
        return serialNumber;
    }

    /**
     * @DESC:   获取系统参数
     * @methodName: getOSParam
     */
    public static String getOSParam(OperatingSystem os)
    {
        return os.toString();
    }
}
