package com.anyin.guwentong.utils;

import com.cp.mylibrary.utils.LogCp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Encryp {

	public static String getsign(String agent_id, String agent_pass) {
		Map<String, String> mapData = new HashMap<String, String>();
		mapData.put("agent_id", agent_id);// 访问ID
		Calendar calTime = Calendar.getInstance();
		long time = calTime.getTimeInMillis();
		mapData.put("timestamp", String.valueOf(time));
		// 生成SIGN 需要将签名KEY加入后MD5
		mapData.put("key", agent_pass);// 签名需要加入KEY
		String sign = Md5Tool.get32Md5(mapData.toString()).toLowerCase();
		return sign;
	}
	/**
	 * 
	 * 获取签名
	 * anyin.common 
	 * 方法名：getsign
	 * 创建人：LiBoMing 
	 * 时间：2016年7月19日-上午10:06:06 
	 * @param data //传入的数据
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
//	public static String getsign(String data) {
//		// 获取时间戳
//		String signData = data + Common.K_MD5_APPID + Common.K_MD5_KEY;
//		String sign = Md5Tool.get32Md5(signData.toString());
//		return sign;
//	}

	/**
	 * 
	 * 3DES加密方法
	 * anyin.common 
	 * 方法名：encrypData
	 * 创建人：LiBoMing 
	 * 时间：2016年7月19日-上午10:23:59 
	 * @param agent_pass
	 * @param data
	 * @return
	 * @throws Exception String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String encrypData(String agent_pass, String data) throws Exception {

		LogCp.i(LogCp.CP, Encryp.class + "    加 ，   : " + data   + " agent_pass： " + agent_pass  );

		return ThreeDES.encryptMode(agent_pass.getBytes(), data.getBytes());
	}

	/**
	 * 
	 * 3DES解密方法
	 * anyin.common 
	 * 方法名：decryptData
	 * 创建人：LiBoMing 
	 * 时间：2016年7月19日-上午10:23:35 
	 * @param agent_pass
	 * @param data
	 * @return
	 * @throws Exception String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String decryptData(String agent_pass, String data) throws Exception {
		byte[] byt = ThreeDES.decryptMode(agent_pass.getBytes(), data);
		String str = new String(byt,"UTF-8");
		return str;

	}

}
