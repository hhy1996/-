<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

		<link rel="stylesheet" href="assets/revolution_slider/css/rs-style.css" media="screen">
		<link rel="stylesheet" href="assets/revolution_slider/rs-plugin/css/settings.css" media="screen">

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
		<jsp:include page="header.jsp?active=6" flush="true"></jsp:include>
    <!--header end-->

    <!--breadcrumbs start-->
    <div class="breadcrumbs">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-sm-12">
                    <h1>给我留言</h1>
                    <br/>
					<p>我馆长期招收热爱跆拳道的4-40岁年龄段的学员。同时广招贤才，欢迎对教学助理，教练，行政助理/经理，馆长等岗位感兴趣的社会精英加入我们。并欢迎热爱体育教育的各界人士合作加盟。</p>
                </div>
            </div>
        </div>
    </div>
    <!--breadcrumbs end-->

     <!--container start-->
    <div class="container">
        <div class="row">
            <div class="col-lg-5 col-sm-5 address">
                <h4>公司地址</h4>
                <p>
                   	 南京市江宁区<br/>
                                                             清水亭东路9号万科社区营地二楼<br/>
                </p>
                <br>
                <br>
                <br>
                <p>
                    电话 <br/>
                    <span class="muted">13675162950</span><br/>
                    微信 <br/>
                    <span class="muted">13675162950</span><br/>
                    邮箱 <br/>
                    <span class="muted">wanlijack@163.com</span>
                </p>
            </div>
            <div class="col-lg-7 col-sm-7 address">
                <h4>在线申请</h4>
                <div class="contact-form">
                    <form role="form" action="SendEmail" method="post">
                        <div class="form-group">
                            <label for="name">姓名</label>
                            <input type="text" placeholder="请输入你的姓名" id="name" name="name" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="email">邮箱</label>
                            <input type="text" placeholder="请输入你的邮箱" id="email" name="mail" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="phone">联系电话</label>
                            <input type="text" id="phone" placeholder="请输入你的电话" name="tel" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="phone">留言</label>
                            <textarea placeholder="" rows="5" class="form-control" name="liuyan" style="resize:none;"></textarea>
                        </div>
                        <button class="btn btn-danger" type="submit">提交</button>
                    </form>

                </div>
            </div>
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
    <script type="text/javascript" src="assets/bxslider/jquery.bxslider.js"></script>
    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>

  </body>
</html>
