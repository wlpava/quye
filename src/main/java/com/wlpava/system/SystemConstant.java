/******************************************************************
 * Copyright (c) 2015 By Wlpava
 ******************************************************************/
package com.wlpava.system;

import java.util.Map;

import com.google.common.collect.Maps;
import com.wlpava.core.utils.ICommonEnum;

/**
 * 系统管理常量装
 * 
 * @author wenlp
 */
public class SystemConstant {
	/**
	 * 用户类型 1-超级管理员 2-运维管理员 3-运营管理员 4-普通用户
	 */
	public enum UserType implements ICommonEnum {
		超级管理员(1), 运维管理员(2), 运营管理员(3), 普通用户(4);
		public static final Map<Integer, String> map = Maps.newLinkedHashMap();
		static {
			for (UserType e : UserType.values()) {
				map.put(e.code, e.name());
			}
		}

		public static String get(Integer code) {
			return map.get(code);
		}

		private int code;

		private UserType(int code) {
			this.code = code;
		}

		@Override
		public Integer toInteger() {
			return this.code;
		}
	}

	// 系统类型
	public static final Map<Integer, String> SYSTEM_TYPE_MAP = Maps.newLinkedHashMap();
	static {
		SYSTEM_TYPE_MAP.put(1, "Android客户端");
		SYSTEM_TYPE_MAP.put(2, "IOS客户端");
	}

	// 上传文件路径
	public static final String CONFIG_UPLOAD_PATH = "upload_path";

	// 短信验证码名称
	public static final String SMS_RANDOM_CODE_KEY = "smsCode";

	// 操作枚举
	public static enum OperateEnum {
		create("新增"), update("修改"), delete("删除"), view("查询"), push("推送"), success("成功"), error("失败");

		private final String info;

		private OperateEnum(String info) {
			this.info = info;
		}

		public String getInfo() {
			return info;
		}
	}

}
