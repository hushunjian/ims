package com.me2me.ims.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 容器类工具，用来转换成指定的字符串。
 * @author Gene.zhang
 * @date 2012-4-1
 */
public class CollectionUtils {
	
	/**
	 * 统计集合中每个元素出现的次数，
	 * @date 2012-9-29
	 * @param <T> 元素的类型
	 * @param data 要统计的数据
	 * @return 统计结果，如果data=null,返回空map.
	 */
	public static <T> Map<T,Integer> groupCount(Collection<T> data){
		Map<T,Integer> group = new HashMap<T, Integer>();
		if(data!=null){
			for(T x: data){
				int value = group.get(x)==null?1:group.get(x)+1;
				group.put(x, value);
			}
		}
		return group;
	}
	/**
	 * 测试对象数组中是否包含对象，测试使用object.equals
	 * @date 2012-12-28
	 * @param array 待测试 的数组
	 * @param t 待测试的对象
	 * @return
	 */
	public static boolean contains(Object[] array,Object t){
		return search(array,t)>-1;
	}
	/**
	 * 测试数组中是否包含一个数字。
	 * @date 2012-12-28
	 * @param array 待测试 的数组
	 * @param t 待测试的对象
	 * @return
	 */
	public static boolean contains(int[] array,int t){
		return search(array,t)>-1;
	}
	/**
	 * 搜索key在array中的下标，下标以0开始
	 * @date 2013-1-15
	 * @param array  待搜寻的数组
	 * @param t 待搜寻的键
	 * @return 如果没有 返回-1
	 */
	public static int search(int[] array,int t){
		int ret = -1;
		if(array!=null){
			for(int i=0;i<array.length;i++){
				if(array[i]==t){
					return i;
				}
			}
		}
		return ret;
	}
	/**
	 * 搜索key在array中的下标，下标以0开始
	 * @date 2013-1-15
	 * @param array  待搜寻的对象数组
	 * @param t 待搜寻的键
	 * @return 如果没有 返回-1
	 */
	public static int search(Object[] array,Object t){
		int ret = -1;
		if(array!=null){
			for(int i=0;i<array.length;i++){
				if(array[i]!=null && array[i].equals(t)){
					return i;
				}
			}
		}
		return ret;
	}
	
	
}
