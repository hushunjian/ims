package com.me2me.ims.base;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

/**
 * 产生各种序列号。基于UUID算法。
 * 
 * @author Gene.zhang
 * @date 2013-6-19
 */
public class SNUtils {
	private static String clientID;
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	/**
	 * 生成一个UUID。
	 * 
	 * @date 2013-6-19
	 * @return
	 */
	public static synchronized String createUUID() {
		String uid = UUID.randomUUID().toString().replace("-", "");
		return uid;
	}

	/**
	 * 产生一个年月日时分秒毫秒随机3位的数字组成的序列号
	 * @date 2014-12-5
	 * @author jiwei.zhang
	 * @return
	 */
	public static synchronized String createTimeSn() {
		
		String ret = format.format(new Date());
		ret += createRndNumber(3);
		return ret;
	}
	/**
	 * 产生一个年月日时分秒毫秒随机3位的数字
	 * @date 2014-12-5
	 * @author jiwei.zhang
	 * @return
	 */
	public static synchronized String createTimeSn(String prefix) {
		String ret = format.format(new Date());
		ret += createRndNumber(3);
		return prefix+ret;
	}
	/**
	 * 随机产生n个0~9之间的数字
	 * @date 2014-12-5
	 * @author jiwei.zhang
	 * @param n 数字个数。
	 * @return
	 */
	public static String createRndNumber(int n) {
		String ret = "";
		for (int i = 0; i < n; i++) {
			ret += (int) (Math.random() * 10);
		}
		return ret;
	}

	public static final int getProcessID() {
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		return Integer.valueOf(runtimeMXBean.getName().split("@")[0]).intValue();
	}
	public static String getClientID(){
		if(clientID==null){
			clientID=getProcessID() + "@" + getIp();
		}
		return clientID;
	}
	public static String getIp() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (!netInterface.isLoopback() && addresses.hasMoreElements()) {
					InetAddress ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						return ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(createTimeSn("pd"));
	}
}
