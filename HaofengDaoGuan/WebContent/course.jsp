<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.std.haofeng.vo.*"%>
<%
	List<FirstLevel> courseType=(List<FirstLevel>)request.getAttribute("courseType");
	List<SecondLevel> courseInfo=(List<SecondLevel>)request.getAttribute("courseInfo");
	String chooseType=request.getParameter("chooseType");
	if(courseType==null||courseInfo==null)
	{
		response.sendRedirect("Course");
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
                    <h1>浩枫课程</h1>
					<br />
					<p>我馆通过引进先进的WTTP（World Taekwondo Training Program），结合国内各年龄段学员的身心特点，开发出适合4-6岁幼儿，7-9岁少儿，10-14岁青少年，及15岁以上成人的特色训练课程。自课程实施以来，广受好评，培养出了一批批热情高、技术好的学员。</p>
                 </div>
             </div>
         </div>
     </div>
     <!--breadcrumbs end-->

    <!--container start-->
    <div class="container">
        <!--portfolio start-->
        <div class="gallery-container">
            <ul id="filters" class="list-unstyled">
                <li><a href="#" data-filter="*"> 所有课程</a></li>
                <%for(int i=0;i<courseType.size();i++){%>
                	<li><a id="eeeee<%=i%>" href="#" data-filter="<%=".type"+courseType.get(i).getID() %>"><%=courseType.get(i).getTypeName() %></a></li>
                <%} %>
            </ul>
            <div id="gallery" class="col-4">
            	<%for(int i=0;i<courseInfo.size();i++){ 
            		String []_split = courseInfo.get(i).getTypeIntroduce().split("!");
            	%>
				<div class="element <%="type"+courseInfo.get(i).getRootID() %> item view view-tenth" data-zlname="reverse-effect">
					<div>
						<img src="images/<%=_split[0] %>" alt="" />
						<div class="mask">
							<h2><%=courseInfo.get(i).getTypeName() %> </h2>
							<a data-zl-popup="link" href="Class?productID=<%=courseInfo.get(i).getProductID() %>&productType=<%=courseInfo.get(i).getRootID() %>">
								<i class="icon-link"></i>
							</a>
						</div>
					</div>
					<div class="item_description">
						<a href="Class?productID=<%=courseInfo.get(i).getProductID() %>&productType=<%=courseInfo.get(i).getRootID() %>"><span><%=courseInfo.get(i).getTypeName() %></span></a><br>
						<%=_split[1] %>
					</div>
				</div>
				<%} %>
            </div>
        </div>
        <!--portfolio end-->
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

      $(function() {
          var $container = $('#gallery');
          $container.isotope({
              itemSelector: '.item',
              animationOptions: {
                  duration: 750,
                  easing: 'linear',
                  queue: false
              }
          });

          // filter items when filter link is clicked
          $('#filters a').click(function() {
              var selector = $(this).attr('data-filter');
              $container.isotope({filter: selector});
              return false;
          });
          
      	<%if(chooseType!=null){ %>
			document.getElementById("eeeee<%=chooseType%>").click();
		<%} %>
      });



  </script>

  </body>
</html>
