<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.std.haofeng.vo.*"%>
<%@ page import="java.util.List"%>
<%
if(request.getSession().getAttribute("user")==null)
{
	response.sendRedirect("login.jsp");
	return;
}
%>
<%
	List<LunBo> lunbo = (List<LunBo>) request.getAttribute("lunbodata");
	if (lunbo == null) {
		response.sendRedirect("Chakanlunbo");
		return;
	}
%>
<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js" lang="ch">
	<!--<![endif]-->

	<head>
		<meta charset="utf-8">

		<title>浩枫道馆-后台</title>
		<meta name="robots" content="noindex, nofollow">

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Icons -->
		<!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
		<link rel="shortcut icon" href="img/favicon.png">
		<link rel="apple-touch-icon" href="img/icon57.png" sizes="57x57">
		<link rel="apple-touch-icon" href="img/icon72.png" sizes="72x72">
		<link rel="apple-touch-icon" href="img/icon76.png" sizes="76x76">
		<link rel="apple-touch-icon" href="img/icon114.png" sizes="114x114">
		<link rel="apple-touch-icon" href="img/icon120.png" sizes="120x120">
		<link rel="apple-touch-icon" href="img/icon144.png" sizes="144x144">
		<link rel="apple-touch-icon" href="img/icon152.png" sizes="152x152">
		<link rel="apple-touch-icon" href="img/icon180.png" sizes="180x180">
		<!-- END Icons -->

		<!-- Stylesheets -->
		<!-- Bootstrap is included in its original form, unaltered -->
		<link rel="stylesheet" href="css/bootstrap.min.css">

		<!-- Related styles of various icon packs and plugins -->
		<link rel="stylesheet" href="css/plugins.css">

		<!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
		<link rel="stylesheet" href="css/main.css">

		<!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->

		<!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
		<link rel="stylesheet" href="css/themes.css">
		<!-- END Stylesheets -->

		<!-- Modernizr (browser feature detection library) -->
		<script src="js/vendor/modernizr-3.3.1.min.js"></script>
	</head>

	<body>
		<!-- Page Wrapper -->
		<!-- In the PHP version you can set the following options from inc/config file -->
		<!--
            Available classes:

            'page-loading'      enables page preloader
        -->
		<div id="page-wrapper" class="page-loading">
			<!-- Preloader -->
			<!-- Preloader functionality (initialized in js/app.js) - pageLoading() -->
			<!-- Used only if page preloader enabled from inc/config (PHP version) or the class 'page-loading' is added in #page-wrapper element (HTML version) -->
			<div class="preloader">
				<div class="inner">
					<!-- Animation spinner for all modern browsers -->
					<div class="preloader-spinner themed-background hidden-lt-ie10"></div>

					<!-- Text for IE9 -->
					<h3 class="text-primary visible-lt-ie10">
					<strong>Loading..</strong>
				</h3>
				</div>
			</div>
			<!-- END Preloader -->

			<!-- Page Container -->
			<!-- In the PHP version you can set the following options from inc/config file -->
			<!--
                Available #page-container classes:

                'sidebar-light'                                 for a light main sidebar (You can add it along with any other class)

                'sidebar-visible-lg-mini'                       main sidebar condensed - Mini Navigation (> 991px)
                'sidebar-visible-lg-full'                       main sidebar full - Full Navigation (> 991px)

                'sidebar-alt-visible-lg'                        alternative sidebar visible by default (> 991px) (You can add it along with any other class)

                'header-fixed-top'                              has to be added only if the class 'navbar-fixed-top' was added on header.navbar
                'header-fixed-bottom'                           has to be added only if the class 'navbar-fixed-bottom' was added on header.navbar

                'fixed-width'                                   for a fixed width layout (can only be used with a static header/main sidebar layout)

                'enable-cookies'                                enables cookies for remembering active color theme when changed from the sidebar links (You can add it along with any other class)
            -->
			<div id="page-container" class="header-fixed-top sidebar-visible-lg-full">

				<!-- Main Sidebar -->
				<div id="sidebar">
					<!-- Sidebar Brand -->
					<div id="sidebar-brand" class="themed-background">
						<a href="index.html" class="sidebar-title"> 
							<i class="fa fa-cube"></i> <span class="sidebar-nav-mini-hide">浩枫道馆后台</span>
						</a>
					</div>
					<!-- END Sidebar Brand -->

					<jsp:include page="header.jsp?active=3" flush="true"></jsp:include>
				</div>
				<!-- END Main Sidebar -->

				<!-- Main Container -->
				<div id="main-container">
					<!-- Header -->
					<!-- In the PHP version you can set the following options from inc/config file -->
					<!--
                        Available header.navbar classes:

                        'navbar-default'            for the default light header
                        'navbar-inverse'            for an alternative dark header

                        'navbar-fixed-top'          for a top fixed header (fixed main sidebar with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar())
                            'header-fixed-top'      has to be added on #page-container only if the class 'navbar-fixed-top' was added

                        'navbar-fixed-bottom'       for a bottom fixed header (fixed main sidebar with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar()))
                            'header-fixed-bottom'   has to be added on #page-container only if the class 'navbar-fixed-bottom' was added
                    -->
					<header class="navbar navbar-inverse navbar-fixed-top">
						<!-- Left Header Navigation -->
						<ul class="nav navbar-nav-custom">
							<!-- Main Sidebar Toggle Button -->
							<li>
								<a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar');this.blur();"> 
									<i class="fa fa-ellipsis-v fa-fw animation-fadeInRight" id="sidebar-toggle-mini"></i> 
									<i class="fa fa-bars fa-fw animation-fadeInRight" id="sidebar-toggle-full"></i>
								</a>
							</li>
							<!-- END Main Sidebar Toggle Button -->
						</ul>
						<!-- END Left Header Navigation -->
						<!-- Right Header Navigation -->
						<ul class="nav navbar-nav-custom pull-right">
							<!-- User Dropdown -->
							<li class="dropdown">
								<a href="Logout"><button type="button" class="btn btn-default">注销</button></a>
							</li>
							<!-- END User Dropdown -->
						</ul>
						<!-- END Right Header Navigation -->
					</header>
					<!-- END Header -->

					<!-- Page content -->
					<div id="page-content">

						<div class="col-lg-6 col-lg-offset-1" style="width: 1000px;">
							<!-- Row Styles Block -->
							<div class="block">
								<!-- Row Styles Title -->
								<div class="block-title">
									<h2>查看轮播</h2>
								</div>
								<!-- END Row Styles Title -->

								<!-- Row Styles Content -->
								<div class="table-responsive">
									<table class="table table-borderless table-vcenter">
										<thead>
											<tr>
												<th>编号</th>
												<th>背景图</th>
												<th>上层图</th>
												<th>标题</th>
												<th>详细</th>
												<th>颜色</th>
												<th>跳转路径</th>

												<th style="width: 80px;" class="text-center">操作</i>
												</th>
											</tr>
										</thead>
										<tbody>
											<%
											for (int i = 0; i < lunbo.size(); i++) {
												String[] _split = lunbo.get(i).getContent().split("!");
												String[] _img = lunbo.get(i).getPhotoPath().split("!");
										%>
											<tr class="active">
												<td><strong><%=lunbo.get(i).getID()%></strong></td>
												<td><img src="../images/<%=_img[0]%>" width="150" height="100" /></td>
												<td><img src="../images/<%=_img[1]%>" width="150" height="100" /></td>
												<td>
													<%=_split[0]%>
												</td>
												<td>
													<%=_split[1]%>
												</td>
												<td>
													<%=_split[2]%>
												</td>
												<td>
													<%=lunbo.get(i).getLink()%>
												</td>
												<td class="text-center">
													<a href="ChangeLunBo?id=<%=lunbo.get(i).getID() %>&lunboimg1=<%=_img[0] %>&lunboimg2=<%=_img[1] %>&lunbotext1=<%=_split[0] %>&lunbotext2=<%=_split[1] %>&lunbolink=<%=lunbo.get(i).getLink() %>" data-toggle="tooltip" title="修改轮播" class="btn btn-effect-ripple btn-xs btn-success"><i class="fa fa-pencil"></i></a>
													<a href="DeleteLunBo?id=<%=lunbo.get(i).getID() %>" data-toggle="tooltip" title="删除轮播" class="btn btn-effect-ripple btn-xs btn-danger"><i class="fa fa-times"></i></a>
												</td>
											</tr>
											<%
											}
										%>

										</tbody>
									</table>
								</div>
								<!-- END Row Styles Content -->
							</div>
							<!-- END Row Styles Block -->
						</div>

					</div>
					<!-- END Page Content -->
				</div>
				<!-- END Main Container -->
			</div>
			<!-- END Page Container -->
		</div>
		<!-- END Page Wrapper -->

		<!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
		<script src="js/vendor/jquery-2.2.4.min.js"></script>
		<script src="js/vendor/bootstrap.min.js"></script>
		<script src="js/plugins.js"></script>
		<script src="js/app.js"></script>
	</body>

</html>