<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.std.haofeng.vo.*"%>
<%@ page import="java.util.List"%>
<%
	ProductInfo productInfo = (ProductInfo) request.getAttribute("productInfo");
	List<SecondLevel> productList = (List<SecondLevel>) request.getAttribute("productList");
	FirstLevel productType = (FirstLevel) request.getAttribute("pruductType");
	if (productInfo == null || productList == null || productType == null) {
		response.sendRedirect("Course");
		return;
	}
	String[] _split = productInfo.getThreeWords().split("!!!");
	String[] photoList = productInfo.getPhotoPath().split("!");
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
<style>
.item_description {
	position: relative;
	color: #767676;
	padding: 10px 15px;
	background-color: #e9e6e1;
	font-size: 13px;
	text-align: center;
	font-weight: 400;
	border-bottom: 2px solid #d3cdc4
}

.item_description:hover {
	border-bottom: 2px solid #bbb
}

.item_description a {
	color: #555;
	text-transform: uppercase;
	font-size: 12px;
	letter-spacing: 1.5px
}

.item_description a:hover {
	color: #888
}
</style>

<body>
	<!--header start-->
		<jsp:include page="header.jsp?active=2" flush="true"></jsp:include>
	<!--header end-->

	<!--breadcrumbs start-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12">
					<h1><%=productInfo.getProductName()%></h1>
					<br />
					<h4><%=productInfo.getProductIntroduce()%></h4>
				</div>
			</div>
		</div>
	</div>
	<!--breadcrumbs end-->

	<!--container start-->
	<div class="container">
		<div class="row mbot50">
			<div class="col-lg-4 col-md-5 about">
				<h2>
					<strong><%=productInfo.getProductName()%></strong>
				</h2>
				<br />
				<p>
					<i style="color: #E9967A" class="fa fa-heart"></i>&nbsp;&nbsp;&nbsp;<%=_split[0]%></p>
				<p>
					<i style="color: #E9967A" class="fa fa-flag-o"></i>&nbsp;&nbsp;&nbsp;<%=_split[1]%></p>
				<p>
					<i style="color: #E9967A" class="fa fa-graduation-cap"></i>&nbsp;&nbsp;&nbsp;<%=_split[2]%></p>
				<br />
				<br />
				<p style="font-size: 15px;">
					<%=productInfo.getPassage()%>
				</p>
				<br />
				<button class="btn btn-info " type="button">
					<a href="https://jinshuju.net/f/LE57dn" target="_blank" style="color:white"><i class="icon-refresh"></i> 立即预约课程</a>
				</button>
			</div>
			<div class="col-lg-8 col-md-7">
				<div class="span5 about-carousel">
					<div id="myCarousel" class="carousel slide">
						<!-- Carousel items -->
						<div class="carousel-inner">
							<%
								for (int i = 0; i < photoList.length; i++) {
							%>
							<div class="<%if (i == 0) {%>active <%}%>item">
								<img src="images/<%=photoList[i]%>" alt="">
								<div class="carousel-caption"
									style="margin-left: 70%; width: 30%;">
									<p>
										课程实景<%=i + 1%></p>
								</div>
							</div>
							<%
								}
							%>
						</div>
						<!-- Carousel nav -->
						<a class="carousel-control left" href="#myCarousel"
							data-slide="prev"> <i class="icon-angle-left"></i>
						</a> <a class="carousel-control right" href="#myCarousel"
							data-slide="next"> <i class="icon-angle-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr />
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h3 style="text-align: center;">相关课程</h3>
				<p style="text-align: center;"><%=productType.getTypeIntroduce() %></p>
				<br />
			</div>
		</div>
		<div class="gallery-container">
			<div id="gallery" class="col-4">
				<%for(int i=0;i<productList.size();i++){
					SecondLevel courseInfo=productList.get(i);
					String []infoSplit = courseInfo.getTypeIntroduce().split("!");
				%>
				<div class="element item view view-tenth"
					data-zlname="reverse-effect">
					<div>
						<img src="images/<%=infoSplit[0] %>" alt="" />
						<div class="mask">
							<h2><%=productList.get(i).getTypeName() %></h2>
							<a data-zl-popup="link" href="Class?productID=<%=courseInfo.getProductID() %>&productType=<%=courseInfo.getRootID() %>"> <i
								class="icon-link"></i>
							</a>
						</div>
					</div>
					<div class="item_description">
						<a href="Class?productID=<%=courseInfo.getProductID() %>&productType=<%=courseInfo.getRootID() %>"><span><%=courseInfo.getTypeName() %></span></a><br> <%=infoSplit[1] %>
					</div>
				</div>
				<%} %>
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
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/hover-dropdown.js"></script>

	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="assets/bxslider/jquery.bxslider.js"></script>


	<script src="js/superfish.js"></script>
	<script src="js/jquery.isotope.js"></script>

	<script src="js/jquery.easing.min.js"></script>
	<script src="js/link-hover.js"></script>

	<script src="assets/fancybox/source/jquery.fancybox.pack.js"></script>


	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>



	<script>
		$(window).load(function() {
			$('[data-zlname = reverse-effect]').mateHover({
				position : 'y-reverse',
				overlayStyle : 'rolling',
				overlayBg : '#fff',
				overlayOpacity : 0.7,
				overlayEasing : 'easeOutCirc',
				rollingPosition : 'top',
				popupEasing : 'easeOutBack',
				popup2Easing : 'easeOutBack'
			});
		});

		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				start : function(slider) {
					$('body').removeClass('loading');
				}
			});
		});

		//    fancybox
		jQuery(".fancybox").fancybox();

		$(function() {
			var $container = $('#gallery');
			$container.isotope({
				itemSelector : '.item',
				animationOptions : {
					duration : 750,
					easing : 'linear',
					queue : false
				}
			});

			// filter items when filter link is clicked
			$('#filters a').click(function() {
				var selector = $(this).attr('data-filter');
				$container.isotope({
					filter : selector
				});
				return false;
			});
		});
	</script>
</body>
</html>
