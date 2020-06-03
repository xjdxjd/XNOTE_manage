package com.xnote.manage.modules.licence.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @DESC:   许可类
 * @ClassName: Licence
 */
public class Licence
{
    //  机器码/产品密钥
    private String machinCode;
    // ip地址
    private String ipAddr;
    // 时长
    private Integer duration;
    // 创建时间
    private Date createTime;
    // 到期时间
    private Date expiresTime;

    public Licence() {
    }

    public Licence(String machinCode, String ipAddr, Integer duration, Date createTime, Date expiresTime) {
        this.machinCode = machinCode;
        this.ipAddr = ipAddr;
        this.duration = duration;
        this.createTime = createTime;
        this.expiresTime = expiresTime;
    }

    public String getMachinCode() {
        return machinCode;
    }

    public void setMachinCode(String machinCode) {
        this.machinCode = machinCode;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(Date expiresTime) {
        this.expiresTime = expiresTime;
    }

    @Override
    public String toString() {
        return "Licence{" +
                "machinCode='" + machinCode + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", duration=" + duration +
                ", createTime=" + createTime +
                ", expiresTime=" + expiresTime +
                '}';
    }

    public String format()
    {
        DateFormat format= new SimpleDateFormat("yyyyMMddHHmmss");
        return machinCode + '-' + ipAddr + '-' + duration + '-' + format.format(createTime) + '-' + format.format(expiresTime);
    }

    public Licence restore(String licenceString)
    {
        Licence licence = new Licence();
        DateFormat format= new SimpleDateFormat("yyyyMMddHHmmss");

        try
        {
            String[] strings = licenceString.split("-");

            licence.setMachinCode(strings[0]);
            licence.setIpAddr(strings[1]);
            licence.setDuration(Integer.parseInt(strings[2]));

            licence.setCreateTime(format.parse(strings[3]));
            licence.setExpiresTime(format.parse(strings[4]));
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return licence;
    }
}
