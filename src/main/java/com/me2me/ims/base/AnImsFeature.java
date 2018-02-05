package com.me2me.ims.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能点。功能点是权限系统中的最小单位。它指定了系统每一个权限点的名称、url、sn等信息。
 * 功能点必须在每一个方法上面设置。
 * @author Gene.zhang
 * @date 2013-1-6
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnImsFeature {
	/**
	 * 功能点的名称，此名称将会出现后台功能点列表。
	 * @date 2013-1-6
	 * @return
	 */
	public String name();
	/**
	 * sn是指功能点的唯一标识，页面上的按钮权限通过此属性与功能点绑定。请使用UUID。
	 * @date 2013-1-6
	 * @return
	 */
	public String sn() default "";
	/**
	 * 是否显示为菜单，默认为显示。
	 * @date 2013-5-21
	 * @return
	 */
	public boolean isShow() default true;
}
