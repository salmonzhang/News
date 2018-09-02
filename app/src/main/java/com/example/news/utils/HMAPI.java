package com.example.news.utils;

public class HMAPI {
	/**
	 * 类似公司的域名
	 */
	public static final String BASE_URL = "http://192.168.1.102:8080/zhbj";
//	public static final String BASE_URL = "http://192.168.1.7:8080/zhbj";
	/**
	 * 新闻中心
	 */
	public static final String NEW_CENTER = BASE_URL + "/categories.json";

	// 组图地址
	public static final String PHOTO_URL = BASE_URL + "/photos/photos_1.json";
	
	//数组json
	public static final String ArrayUrl = "http://192.168.1.102:8080/Array_Json.json";
}
