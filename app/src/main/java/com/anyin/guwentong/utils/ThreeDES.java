package com.anyin.guwentong.utils;


import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;


public class ThreeDES {
	private static final String Algorithm = "DESede"; // 定义 加密算法,可用

	
	public static String encryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			// 开始加密运算
			byte[] encryptedByteArray = c1.doFinal(src);
			// 加密运算之后 将byte[]转化为base64的String
			//BASE64Encoder enc = new BASE64Encoder();
			String retVal = Base64.encodeToString(encryptedByteArray, Base64.DEFAULT);
			//return Base64.encodeBase64String(encryptedByteArray);
			return  retVal;
			//return enc.encode(encryptedByteArray);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
    /**
     * 将表示16进制值的字符串转换为byte数组， 和public static String byteArr2HexStr(byte[] arrB)
     * 互为可逆的转换过程
     * 
     * @param strIn
     *            需要转换的字符串
     * @return 转换后的byte数组
     * @throws Exception
     *             本方法不处理任何异常，所有异常全部抛出
     * @author <a href="mailto:leo841001@163.com">LiGuoQing</a>
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可逆的转换过程
     * 
     * @param arrB
     *            需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception
     *             本方法不处理任何异常，所有异常全部抛出
     */
    public static  String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍..一个byte转成16进制最多不会超过两位。FF
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16)); // 16代表进制
        }
        return sb.toString();
    }

	// keybyte为加密密钥，长度为24字节
	// src为加密后的缓冲区
	public static byte[] decryptMode(byte[] keybyte, String src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			// 解密运算之前
			BASE64Decoder dec = new BASE64Decoder();
			byte[] encryptedByteArray = dec.decodeBuffer(src);
			// 解密运算 将base64的String转化为byte[]
			return c1.doFinal(encryptedByteArray);

		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		String key = "oicq1487oicq1487oicq1487";
//		final byte[] keyBytes = { 0x11, 0x22, 0x4F, 0x58, (byte) 0x88, 0x10, 0x40, 0x38, 0x28, 0x25, 0x79, 0x51,
//				(byte) 0xCB, (byte) 0xDD, 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x30, 0x40, 0x36, (byte) 0xE2 }; // 24字节的密钥

		String szSrc = "{\"md5\":\"A0B67C818DDAC804AABCEA8B6399941D\",\"data\":{\"_nianShouYiFlag\":1,\"page\":1,\"key\":\"\",\"timeStamp\":\"1468230751.500278\",\"_jinZhiFlag\":1,\"_flag\":1}}";
		System.out.println("加密前的字符串:" + szSrc);

		String encoded = encryptMode(key.getBytes(), szSrc.getBytes());
		System.out.println("加密后的字符串:" + encoded);

		byte[] srcBytes = decryptMode(key.getBytes(), encoded);
		System.out.println("解密后的字符串:" + (new String(srcBytes)));
	}

}
