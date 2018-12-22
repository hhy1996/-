package com.std.haofeng.common;

public class Config {
	//public static String databaseUrl="123.206.216.141";
	public static String databaseUrl="192.168.0.102";
	public static String port="3307";
	public static String databaseUser="haofeng";
	public static String databasePassword="haofengdaoguan";
	public static String databaseChoose="haofengdaoguan";
	public static String databaseCharset="UTF-8";
	public static String ArticleTemplate=
			"<%@ page language=\"java\" contentType=\"text/html; charset=utf-8\"\r\n" + 
			"	pageEncoding=\"utf-8\"%>\r\n" + 
			"<!DOCTYPE html>\r\n" + 
			"<html lang=\"ch\">\r\n" + 
			"	<head>\r\n" + 
			"		<meta charset=\"utf-8\">\r\n" + 
			"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
			"		<meta name=\"description\" content=\"\">\r\n" + 
			"		<meta name=\"author\" content=\"STD studio\">\r\n" + 
			"		<meta name=\"keyword\" content=\"浩枫, 道馆, 跆拳道, 健身, 体育, 运动\">\r\n" + 
			"		<link rel=\"shortcut icon\" href=\"img/favicon.png\">\r\n" + 
			"\r\n" + 
			"		<title>浩枫道馆</title>\r\n" + 
			"\r\n" + 
			"		<!-- Bootstrap core CSS -->\r\n" + 
			"		<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
			"		<link href=\"../css/font-awesome.min.css\" rel=\"stylesheet\">\r\n" + 
			"\r\n" + 
			"		<link href=\"../css/theme.css\" rel=\"stylesheet\">\r\n" + 
			"		<link href=\"../css/bootstrap-reset.css\" rel=\"stylesheet\">\r\n" + 
			"		<!--external css-->\r\n" + 
			"		<link href=\"../assets/font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\r\n" + 
			"		<link rel=\"stylesheet\" href=\"../css/flexslider.css\" />\r\n" + 
			"		<link href=\"../assets/bxslider/jquery.bxslider.css\" rel=\"stylesheet\" />\r\n" + 
			"		<link href=\"../assets/fancybox/source/jquery.fancybox.css\" rel=\"stylesheet\" />\r\n" + 
			"\r\n" + 
			"		<link rel=\"stylesheet\" href=\"../assets/revolution_slider/css/rs-style.css\" media=\"screen\">\r\n" + 
			"		<link rel=\"stylesheet\" href=\"../assets/revolution_slider/rs-plugin/css/settings.css\" media=\"screen\">\r\n" + 
			"\r\n" + 
			"		<!-- Custom styles for this template -->\r\n" + 
			"		<link href=\"../css/style.css\" rel=\"stylesheet\">\r\n" + 
			"		<link href=\"../css/style-responsive.css\" rel=\"stylesheet\" />\r\n" + 
			"\r\n" + 
			"		<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->\r\n" + 
			"		<!--[if lt IE 9]>\r\n" + 
			"      <script src=\"../js/html5shiv.js\"></script>\r\n" + 
			"      <script src=\"../js/respond.min.js\"></script>\r\n" + 
			"    <![endif]-->\r\n" + 
			"	</head>\r\n" + 
			"\r\n" + 
			"  <body>\r\n" + 
			"     <!--header start-->\r\n" + 
			"		<jsp:include page=\"../header.jsp?active=5&needback=1\" flush=\"true\"></jsp:include>\r\n" + 
			"    <!--header end-->\r\n" + 
			"	<hr />\r\n" + 
			"\r\n" + 
			"    <!--container start-->\r\n" + 
			"    <div class=\"container\">\r\n" + 
			"        <div class=\"row\">\r\n" + 
			"            <!--blog start-->\r\n" + 
			"            <div class=\"col-lg-9\">\r\n" + 
			"                <div class=\"blog-item\">\r\n" + 
			"                    <div class=\"row\">\r\n" + 
			"                        <div class=\"col-lg-2 col-md-2 col-sm-3 hidden-xs\">\r\n" + 
			"                            <div class=\"date-wrap\">\r\n" + 
			"                                <span class=\"date\">#MONTH#.#DAY#</span>\r\n" + 
			"                                <span class=\"month\">#YEAR#</span>\r\n" + 
			"                            </div>\r\n" + 
			"                        </div>\r\n" + 
			"                        <div class=\"col-lg-10 col-md-10 col-sm-9 \">\r\n" + 
			"                            <h1 style=\"text-align:center\"><a href=\"#\"><strong>#TITLE#</strong></a></h1>\r\n" + 
			"                            <p style=\"text-align:center\" class=\"visible-xs\">发表时间:#PUBTIME#</p>\r\n" + 
			"                            #CONTENT#\r\n" + 
			"						</div>\r\n" + 
			"                    </div>				\r\n" + 
			"                </div>\r\n" + 
			"				<div class=\"col-lg-2 col-sm-2\"></div>\r\n" + 
			"                <div class=\"col-lg-10 col-sm-10\" style=\"text-align:center\">\r\n" + 
			"					<button class=\"btn btn-primary\" type=\"button\"><i class=\"fa fa-eye\"></i> 了解浩枫课程</button>\r\n" + 
			"					<button class=\"btn btn-info \" type=\"button\"><i class=\"icon-refresh\"></i> 立即预约课程</button>\r\n" + 
			"				</div>\r\n" + 
			"            </div>\r\n" + 
			"\r\n" + 
			"            <div class=\"col-lg-3\">\r\n" + 
			"                <div class=\"blog-side-item\">\r\n" + 
			"					<div class=\"category\">\r\n" + 
			"                        <h3>关于浩枫</h3>\r\n" + 
			"                        <p>浩枫:专注于为国内热爱跆拳道的人士提供线上跆拳道教学服务</p>\r\n" + 
			"                    </div>\r\n" + 
			"                    <jsp:include page=\"../GetInfo\" flush=\"true\"></jsp:include>\r\n" + 
			"                </div>\r\n" + 
			"            </div>\r\n" + 
			"			\r\n" + 
			"            <!--blog end-->\r\n" + 
			"        </div>\r\n" + 
			"\r\n" + 
			"    </div>\r\n" + 
			"    <!--container end-->\r\n" + 
			"		<jsp:include page=\"../yuyue.jsp\" flush=\"true\"></jsp:include>\r\n" + 
			"     <!--footer start-->\r\n" + 
			"		<jsp:include page=\"../footer.jsp\" flush=\"true\"></jsp:include>\r\n" + 
			"     <!--footer end-->\r\n" + 
			"\r\n" + 
			"  <!-- js placed at the end of the document so the pages load faster -->\r\n" + 
			"    <script src=\"../js/jquery.js\"></script>\r\n" + 
			"    <script src=\"../js/bootstrap.min.js\"></script>\r\n" + 
			"    <script type=\"text/javascript\" src=\"../js/hover-dropdown.js\"></script>\r\n" + 
			"    <script defer src=\"../js/jquery.flexslider.js\"></script>\r\n" + 
			"    <script type=\"text/javascript\" src=\"../assets/bxslider/jquery.bxslider.js\"></script>\r\n" + 
			"\r\n" + 
			"    <script src=\"../js/jquery.easing.min.js\"></script>\r\n" + 
			"    <script src=\"../js/link-hover.js\"></script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"     <!--common script for all pages-->\r\n" + 
			"    <script src=\"../js/common-scripts.js\"></script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"  <script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"  </script>\r\n" + 
			"\r\n" + 
			"  </body>\r\n" + 
			"</html>\r\n";
	public static String mailName="";
	public static String mailPwd="";
	public static String sendTo="wanlijack@163.com";
}
