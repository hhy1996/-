package com.std.haofeng.service.impl;

import com.std.haofeng.service.IAdminService;
import com.std.haofeng.service.IArticleService;
import com.std.haofeng.vo.Admin;
import com.std.haofeng.vo.Article;

public class Test {

	public static void main(String[] args) {
		IAdminService adminService=new AdminService();
		Admin a=new Admin();
		a.setID("1");
		a.setPwd("1");
		adminService.AddAdmin(a);
	}

}
