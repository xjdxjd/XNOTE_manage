package com.xnote.manage.core.licence.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * AES加密解密工具类
 */
public class AESUtils
{
//    B0478C5A4E00DC3EFDA9BF695F32FF95
    private final static String ALGORITHM_AES = "AES";
    private static final String ENCODING = "UTF-8";
    private static final String PASSWORD = "B0478C5A4E00DC3EFDA9BF695F32FF95E00DC5F32F0478C5A4E00DC";

    /**
     * @DESC:   AES加密
     * @methodName:
     * @param licence
     */
    public static String encodeForAES(String licence)
    {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM_AES);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(PASSWORD.getBytes());
            kgen.init(256, secureRandom);

            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM_AES);
            Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
            byte[] byteContent = licence.getBytes(ENCODING);

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++)
            {
                String hex = Integer.toHexString(result[i] & 0xFF);
                if (hex.length() == 1)
                {
                    hex = '0' + hex;
                }
                sb.append(hex.toUpperCase());
            }

            BASE64Encoder base64encoder = new BASE64Encoder();
            String str = sb.toString();
            String base64 = null;
            if (str != null && str.length() > 0)
            {
                try {
                    byte[] encodeByte = str.getBytes(ENCODING);
                    base64 = base64encoder.encode(encodeByte);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String string = base64.replaceAll("\r\n", "")
                    .replaceAll("\r", "")
                    .replaceAll("\n", "");

            return string;
        }
        catch (Exception e) {
           e.printStackTrace();
           return null;
        }

    }

    /**
     * @DESC:   AES解密
     * @methodName:
     */
    public static String decodeForAES(String licenceString)
    {
        BASE64Decoder base64decoder = new BASE64Decoder();
        try
        {
            byte[] encodeByte = base64decoder.decodeBuffer(licenceString);
            String hexStr = new String(encodeByte);

            byte[] decryptFrom = new byte[hexStr.length() / 2];
            for (int i = 0; i < hexStr.length() / 2; i++)
            {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                decryptFrom[i] = (byte) (high * 16 + low);
            }

            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM_AES);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(PASSWORD.getBytes());
            kgen.init(256, secureRandom);

            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM_AES);

            Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] result = cipher.doFinal(decryptFrom);

            return new String(result);
        }
        catch (Exception e) {
            return null;
        }
    }
}