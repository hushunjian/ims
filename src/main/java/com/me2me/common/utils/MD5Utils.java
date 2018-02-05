package com.me2me.common.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * md5工具包
 * @author Gene.zhang
 * @date 2012-9-29
 */
public class MD5Utils {

    public static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public MD5Utils() {
    }

    /**
     * 取字符串的md5编码，小写形式
     * Computes the MD5 fingerprint of a string.
     * @return the MD5 digest of the input <code>String</code>
     */
    public static String getMd5(String str) {
    	MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = md5Bytes[i] & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String getHash(String fileName) throws Exception {
        InputStream fis;
        int count = 0;
        fis = new FileInputStream(fileName);
        byte[] buffer = new byte[1024];
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int numRead = 0;
        while ((numRead = fis.read(buffer)) > 0) {
            md5.update(buffer, 0, numRead);
            count++;
        }
        //System.out.println(count);
        fis.close();
        return toHexString(md5.digest());
    }

    public static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        // StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(MD5Utils.getMd5("123"));
    }
}