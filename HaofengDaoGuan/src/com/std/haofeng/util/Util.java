package com.std.haofeng.util;

public class Util {
	public static int CreateRandomID()
	{
		return (int)(System.currentTimeMillis()%1000000000);
	}
}
