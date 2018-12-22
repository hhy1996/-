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
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/font-awesome.min.css" rel="stylesheet">

		<link href="../css/theme.css" rel="stylesheet">
		<link href="../css/bootstrap-reset.css" rel="stylesheet">
		<!--external css-->
		<link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link rel="stylesheet" href="../css/flexslider.css" />
		<link href="../assets/bxslider/jquery.bxslider.css" rel="stylesheet" />
		<link href="../assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />

		<link rel="stylesheet" href="../assets/revolution_slider/css/rs-style.css" media="screen">
		<link rel="stylesheet" href="../assets/revolution_slider/rs-plugin/css/settings.css" media="screen">

		<!-- Custom styles for this template -->
		<link href="../css/style.css" rel="stylesheet">
		<link href="../css/style-responsive.css" rel="stylesheet" />

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
		<!--[if lt IE 9]>
      <script src="../js/html5shiv.js"></script>
      <script src="../js/respond.min.js"></script>
    <![endif]-->
	</head>

  <body>
     <!--header start-->
		<jsp:include page="../header.jsp?active=5&needback=1" flush="true"></jsp:include>
    <!--header end-->
	<hr />

    <!--container start-->
    <div class="container">
        <div class="row">
            <!--blog start-->
            <div class="col-lg-9">
                <div class="blog-item">
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-3 hidden-xs">
                            <div class="date-wrap">
                                <span class="date">#MONTH#.#DAY#</span>
                                <span class="month">#YEAR#</span>
                            </div>
                        </div>
                        <div class="col-lg-10 col-md-10 col-sm-9 ">
                            <h1 style="text-align:center"><a href="#"><strong>#TITLE#</strong></a></h1>
                            <p style="text-align:center" class="visible-xs">发表时间:#PUBTIME#</p>
                            #CONTENT#
						</div>
                    </div>				
                </div>
				<div class="col-lg-2 col-sm-2"></div>
                <div class="col-lg-10 col-sm-10" style="text-align:center">
					<a href="../Course"><button class="btn btn-primary" type="button"><i class="fa fa-eye"></i> 了解浩枫课程</button></a>
					<button class="btn btn-info " type="button"><a href="https://jinshuju.net/f/LE57dn" target="_blank" style="color:white"><i class="icon-refresh"></i> 立即预约课程</a></button>
				</div>
            </div>

            <div class="col-lg-3">
                <div class="blog-side-item">
					<div class="category">
                        <h3>关于浩枫</h3>
                        <p>WTF体系道馆<br/>中国跆拳道协会会员单位</p>
                    </div>
                    <jsp:include page="../GetInfo" flush="true"></jsp:include>
                </div>
            </div>
			
            <!--blog end-->
        </div>

    </div>
    <!--container end-->
		<jsp:include page="../yuyue.jsp" flush="true"></jsp:include>
     <!--footer start-->
		<jsp:include page="../footer.jsp?needback=1" flush="true"></jsp:include>
     <!--footer end-->

  <!-- js placed at the end of the document so the pages load faster -->
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/hover-dropdown.js"></script>
    <script defer src="../js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="../assets/bxslider/jquery.bxslider.js"></script>

    <script src="../js/jquery.easing.min.js"></script>
    <script src="../js/link-hover.js"></script>


     <!--common script for all pages-->
    <script src="../js/common-scripts.js"></script>

  </body>
</html>
