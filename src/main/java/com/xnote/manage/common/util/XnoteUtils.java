package com.xnote.manage.common.util;

import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

public class XnoteUtils {

    public static String getLocalIPv4addr()
    {
        String ip = null;

        SystemInfo systemInfo = new SystemInfo();
        NetworkIF[] networkIFs = systemInfo.getHardware().getNetworkIFs();
        for (NetworkIF net: networkIFs)
        {
            String[] iPv4addr = net.getIPv4addr();
            for (String ipp : iPv4addr)
            {
                ip = ipp;
            }
        }
        return ip;
    }
}
