<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.std.haofeng.vo.*"%>
<%@ page import="java.util.List"%>

<%
	String a1 = (String) request.getAttribute("a");
	String b1 = (String) request.getAttribute("b");
	String idint1 = (String) request.getAttribute("idint");
	String size1 = (String) request.getAttribute("size");
	Boolean is1display = (Boolean) request.getAttribute("is1display");
	Boolean is2display = (Boolean) request.getAttribute("is2display");
	List<Article> article = (List<Article>) request.getAttribute("articledata");
	List<FirstLevel> firstLevel = (List<FirstLevel>) request.getAttribute("firstLeveldata");

	if (article == null || a1 == null || b1 == null || idint1 == null || size1 == null || is1display == null
			|| is2display == null || firstLevel == null) {
		response.sendRedirect("Blog");
		return;
	}
	int a = Integer.parseInt(a1);
	int b = Integer.parseInt(b1);
	int id = Integer.parseInt(idint1);
	int size = Integer.parseInt(size1);
%>
<!DOCTYPE html>
<html lang="ch">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="STD studio">
<meta name="keyword" content="浩枫, 道馆, 跆拳道, 健身, 体育, 运动">
<link rel="shortcut icon" href="img/favicon.png">

<title>浩枫道馆</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">

<link href="css/theme.css" rel="stylesheet">
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/flexslider.css" />
<link href="assets/bxslider/jquery.bxslider.css" rel="stylesheet" />
<link href="assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />

<link rel="stylesheet" href="assets/revolution_slider/css/rs-style.css"
	media="screen">
<link rel="stylesheet"
	href="assets/revolution_slider/rs-plugin/css/settings.css"
	media="screen">

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!--header start-->
		<jsp:include page="header.jsp?active=5" flush="true"></jsp:include>
	<!--header end-->

	<!--breadcrumbs start-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12">
					<h1>浩枫动态</h1>
					<br />
					<p style="color: white">
						了解浩枫道馆最新新闻动态、媒体报道、活动信息</p>
				</div>
			</div>
		</div>
	</div>
	<!--breadcrumbs end-->

	<!--container start-->
	<div class="container">
		<div class="row">
			<!--blog start-->
			<div class="col-lg-9 ">
				<div class="blog-item">
					<div class="row">
						<%
							for (int i = a; i < b; i++) {
								String[] _split = article.get(i).getPath().split("!");
								String[] _time = article.get(i).getPubTime().split("-");
						%>

						<div class="col-lg-2 col-md-2 col-sm-3 hidden-xs">
							<br />
							<div class="date-wrap">
								<span class="date" style="font-size: 16px"><%=_time[1]%>.<%=_time[2]%></span>
								<span class="month" style="font-size: 14px"><%=_time[0]%></span>
							</div>
						</div>
						<div class="col-lg-10 col-md-10 col-sm-9 col-xs-12">


							<h1>
								<a href="Article/<%=_split[2]%>"><%=_split[0]%></a>
							</h1>
							<p class="visible-xs">
								<strong>发布时间:<%=_time[0]%>.<%=_time[1]%>.<%=_time[2]%></strong>
							</p>
							<p><%=_split[1]%></p>
							<a href="Article/<%=_split[2]%>" class="btn btn-danger">阅读全文</a>

						</div>
						<%
							}
						%>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-3 col-xs-4">
						<div class="text-center">
							<ul class="pagination">
								<%
									if (is1display) {
								%>
								<li><a href="Blog?pageid=<%=id - 1%>">上一页</a></li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
					<div class="col-lg-8 col-md-8 col-sm-6 col-xs-4"></div>
					<div class="col-lg-2 col-md-2 col-sm-3 col-xs-4">
						<div class="text-center">
							<ul class="pagination">
								<%
									if (is2display) {
								%>
								<li><a href="Blog?pageid=<%=id + 1%>">下一页</a></li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
				</div>


			</div>

			<div class="col-lg-3">
				<div class="blog-side-item">
					<div class="category">
						<h3>关于浩枫</h3>
						<p>WTF体系道馆<br/>中国跆拳道协会会员单位</p>
					</div>
					<div class="category">
						<h3>课程分类</h3>
						<ul class="list-unstyled">
							<%
								for (int i = 0; i < firstLevel.size(); i++) {
							%>
							<li><a href="Course"><i class="icon-angle-right"></i> <%=firstLevel.get(i).getTypeName()%></a></li>
							<%
								}
							%>

						</ul>
					</div>

					<div class="blog-post">
						<h3>最新发布</h3>
						<%
							for (int i = 0; i < size; i++) {
								String[] _split = article.get(i).getPath().split("!");
						%>

						<div class="media">
							<div class="media-body">
								<h5 class="media-heading">
									<a href="<%=_split[2]%>"><%=_split[0]%></a>
								</h5>
								<p><%=_split[1]%></p>
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>

			<!--blog end-->
		</div>

	</div>
	<!--container end-->
		<jsp:include page="yuyue.jsp" flush="true"></jsp:include>
	<!--footer start-->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	<!--footer end-->


	<!-- js placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/hover-dropdown.js"></script>
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="assets/bxslider/jquery.bxslider.js"></script>

	<script src="js/jquery.easing.min.js"></script>
	<script src="js/link-hover.js"></script>


	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>


	<script>
		
	</script>

</body>
</html>
