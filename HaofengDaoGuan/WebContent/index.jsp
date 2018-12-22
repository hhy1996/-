<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.std.haofeng.vo.*"%>
<%@ page import="java.util.List"%>
<% 
	List<LunBo> lunbo=(List<LunBo>)request.getAttribute("lunbodata");
	if (lunbo == null) {
		response.sendRedirect("HomePage");
		return;
	}
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
	<!-- 可无视 -->
	<link href="css/styles.css" rel="stylesheet">
	
	<!-- Load jQuery -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	
	<!-- 必要样式 -->
	<link href="css/mislider.css" rel="stylesheet">
	<link href="css/mislider-skin-cameo.css" rel="stylesheet">
	
	<script type="text/javascript" src="js/mislider.js"></script>
	<script type="text/javascript">
	jQuery(function ($) {
		var slider = $('.mis-stage').miSlider({
			//  The height of the stage in px. Options: false or positive integer. false = height is calculated using maximum slide heights. Default: false
			stageHeight: 380,
			//  Number of slides visible at one time. Options: false or positive integer. false = Fit as many as possible.  Default: 1
			slidesOnStage: false,
			//  The location of the current slide on the stage. Options: 'left', 'right', 'center'. Defualt: 'left'
			slidePosition: 'center',
			//  The slide to start on. Options: 'beg', 'mid', 'end' or slide number starting at 1 - '1','2','3', etc. Defualt: 'beg'
			slideStart: 'mid',
			//  The relative percentage scaling factor of the current slide - other slides are scaled down. Options: positive number 100 or higher. 100 = No scaling. Defualt: 100
			slideScaling: 150,
			//  The vertical offset of the slide center as a percentage of slide height. Options:  positive or negative number. Neg value = up. Pos value = down. 0 = No offset. Default: 0
			offsetV: -5,
			//  Center slide contents vertically - Boolean. Default: false
			centerV: true,
			//  Opacity of the prev and next button navigation when not transitioning. Options: Number between 0 and 1. 0 (transparent) - 1 (opaque). Default: .5
			navButtonsOpacity: 1
		});
	});
	</script>
	<body>
		<!--header start-->
			<jsp:include page="header.jsp?active=1" flush="true"></jsp:include>
		<!--header end-->

		<!-- revolution slider start -->
		<div class="fullwidthbanner-container main-slider">
			<div class="fullwidthabnner">
				<ul id="revolutionul" style="display:none;">
					<%for(int i=0;i<lunbo.size();i++){ 
						String []_split=lunbo.get(i).getContent().split("!");
						String []_img=lunbo.get(i).getPhotoPath().split("!");
					%>
					<li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
						<!-- THE MAIN IMAGE IN THE FIRST SLIDE -->
						<img src="./images/<%=_img[0] %>" alt="">
						<div class="caption lft slide_title" data-x="30" data-y="120" data-speed="400" data-start="1500" data-easing="easeOutExpo">
							<font class="hidden-xs" size="12"><%=_split[0] %></font>
							<font class="visible-xs" size="6"><%=_split[0] %></font>
						</div>
						<div class="caption lft slide_desc dark-text" data-x="30" data-y="260" data-speed="400" data-start="2500" data-easing="easeOutExpo">
							<font class="hidden-xs" color="<%=_split[2] %>" size="5"><%=_split[1] %></font>
							<font class="visible-xs" color="<%=_split[2] %>" size="3"><%=_split[1] %></font>
						</div>
						<a class="caption lft slide_btn btn red slide_item_left" href="<%=lunbo.get(i).getLink()%>" target="_blank" data-x="30" data-y="420" data-speed="400" data-start="3000" data-easing="easeOutExpo">
							<font class="hidden-xs" size="4">点击进入</font>
							<font class="visible-xs" style="margin-top:8px;margin-bottom:8px" size="3">点击进入</font>
						</a>
						<div class="caption lft start" data-x="640" data-y="55" data-speed="400" data-start="2000" data-easing="easeOutBack">
							<img src="./images/<%=_img[1] %>" alt="man">
						</div>
					</li>
					<%} %>
				</ul>
				<div class="tp-bannertimer tp-top"></div>
			</div>
		</div>
		<!-- revolution slider end -->
		<!--container start-->
		<div>
			<div>
				<!--feature start-->
				<div class="text-center feature-head" style="margin-bottom:-20px;">
					<h1>浩枫优势</h1>
					<p>身心同步发展，体魄与智慧共鸣</p>
				</div>
				<div>
					<div class="mis-stage">
						<!-- The element to select and apply miSlider to - the class is optional -->
						<ol class="mis-slider">
							<!-- The slider element - the class is optional -->
							<li class="mis-slide">
								<!-- A slide element - the class is optional -->
								<a href="#" class="mis-container">
									<!-- A slide container - this element is optional, if absent the plugin adds it automatically -->
									<figure>
										<!-- Slide content - whatever you want -->
										<img src="images/1.jpg" alt="Pink Water Lillies">
										<br/><br/>
										<figcaption>主动式学习</figcaption>
									</figure>
								</a>
							</li>
							<li class="mis-slide">
								<a href="#" class="mis-container">
									<figure>
										<img src="images/2.jpg" alt="Pond with Lillies">
										<br/><br/>
										<figcaption>分年龄教学</figcaption>
									</figure>
								</a>
							</li>
							<li class="mis-slide">
								<a href="#" class="mis-container">
									<figure>
										<img src="images/3.jpg" alt="Hidden Pond">
										<br/><br/>
										<figcaption>80分钟时长</figcaption>
									</figure>
								</a>
							</li>
							<li class="mis-slide">
								<a href="#" class="mis-container">
									<figure>
										<img src="images/4.jpg" alt="Shrine">
										<br/><br/>
										<figcaption>小班化教学</figcaption>
									</figure>
								</a>
							</li>
							<li class="mis-slide">
								<a href="#" class="mis-container">
									<figure>
										<img src="images/5.jpg" alt="White Water Lillies">
										<br/><br/>
										<figcaption>国际先进课程</figcaption>
									</figure>
								</a>
							</li>
							<li class="mis-slide">
								<a href="#" class="mis-container">
									<figure>
										<img src="images/6.jpg" alt="Garden Walkway">
										<br/><br/>
										<figcaption>资深教练亲授</figcaption>
									</figure>
								</a>
							</li>
							<li class="mis-slide">
								<a href="#" class="mis-container">
									<figure>
										<img src="images/7.jpg" alt="Lilly with Bee">
										<br/><br/>
										<figcaption>融合国学经典</figcaption>
									</figure>
								</a>
							</li>
						</ol>
					</div>
				</div>
			</div>
			<br/><br/><br/>
		</div>

		<!--property start-->
		<section class="gray-bg">
			<div class="container">
				<div class="text-center feature-head" style="margin-bottom:-70px;">
					<h1>核心课程</h1>
					<p>时尚快乐跆拳道打造强健体魄</p>
					<p>原创管理拓展培养基础领导力</p>
				</div>
				<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 feature-head">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-center">
						<div class="element flat item view view-tenth" data-zlname="reverse-effect" style="margin-bottom:10px;">
							<img src="images/taiquandao.jpg" alt="" />
							<div class="mask" style="background-color:rgba(	219,112,147,0.5);">
								<h2 style="margin-top:5%;color:white;">时尚、快乐跆拳道打造强健体魄</h2>
								<a href="Course?chooseType=0" data-zl-popup="link" href="javascript:;">
									<i class="icon-link"></i>
								</a>
							</div>
						</div>
						<p><a href="Course?chooseType=0">跆拳道</a></p>
						<br/>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-center">
						<div class="element flat item view view-tenth" data-zlname="reverse-effect" style="margin-bottom:10px;">
							<img src="images/zonghe.jpg" alt="" />
							<div class="mask" style="background-color:rgba(	100,149,237,0.5);">
								<h2 style="margin-top:5%;color:white;">原创、刺激拓展培养基础领导力</h2>
								<a href="Course?chooseType=1" data-zl-popup="link" href="javascript:;">
									<i class="icon-link"></i>
								</a>
							</div>
						</div>
						<p><a href="Course?chooseType=1">管理拓展</a></p>
						<br/>
					</div>
				</div>
				<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			</div>
		</section>
		<!--property end-->

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

		<script type="text/javascript" src="js/jquery.parallax-1.1.3.js"></script>

		<script src="js/jquery.easing.min.js"></script>
		<script src="js/link-hover.js"></script>

		<script src="assets/fancybox/source/jquery.fancybox.pack.js"></script>

		<script type="text/javascript" src="assets/revolution_slider/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
		<script type="text/javascript" src="assets/revolution_slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

		<!--common script for all pages-->
		<script src="js/common-scripts.js"></script>

		<script src="js/revulation-slide.js"></script>

		<script>
			RevSlide.initRevolutionSlider();

			$(window).load(function() {
				$('[data-zlname = reverse-effect]').mateHover({
					position: 'y-reverse',
					overlayStyle: 'rolling',
					overlayBg: '#fff',
					overlayOpacity: 0.7,
					overlayEasing: 'easeOutCirc',
					rollingPosition: 'top',
					popupEasing: 'easeOutBack',
					popup2Easing: 'easeOutBack'
				});
			});

			$(window).load(function() {
				$('.flexslider').flexslider({
					animation: "slide",
					start: function(slider) {
						$('body').removeClass('loading');
					}
				});
			});

			//    fancybox
			jQuery(".fancybox").fancybox();
		</script>

	</body>

</html>