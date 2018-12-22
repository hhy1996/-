<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	
%>
<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">

        <title>浩枫道馆-后台</title>

        <meta name="description" content="AppUI is a Web App Bootstrap Admin Template created by pixelcave and published on Themeforest">
        <meta name="author" content="pixelcave">
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
        <!-- Login Container -->
        <div id="login-container">
            <!-- Login Header -->
            <h1 class="h2 text-light text-center push-top-bottom animation-slideDown">
                <i class="fa fa-cube"></i> <strong>浩枫道馆后台系统</strong>
            </h1>
            <!-- END Login Header -->

            <!-- Login Block -->
            <div class="block animation-fadeInQuickInv">
                <!-- Login Title -->
                <div class="block-title">
                    <h2>请先登录</h2>
                </div>
                <!-- END Login Title -->

                <!-- Login Form -->
                <form id="loginForm" action="Login" method="post" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input type="text" id="user" name="user" class="form-control" placeholder="账户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input type="password" id="pswd" name="pwd" class="form-control" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group form-actions">
                        <div class="col-xs-8">
                            <label class="csscheckbox csscheckbox-primary">
                                <input type="checkbox" id="remember" >
                                <span></span>
                            </label>
                            	记住密码?
                        </div>
                        <div class="col-xs-4 text-right">
                            <button type="submit" class="btn btn-effect-ripple btn-sm btn-primary"><i class="fa fa-check"></i> 登陆</button>
                        </div>
                    </div>
                </form>
                <!-- END Login Form -->
            </div>
            <!-- END Login Block -->
        </div>
        <!-- END Login Container -->

        <!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/app.js"></script>
        <script>	
        <%if(request.getParameter("error")!=null){%>
        	alert("密码错误");
        <%}%>
        	
    	window.onload = function(){
	    var oForm = document.getElementById('loginForm');
	    var oUser = document.getElementById('user');
	    var oPswd = document.getElementById('pswd');
	    var oRemember = document.getElementById('remember');
	    //页面初始化时，如果帐号密码cookie存在则填充
	    if(getCookie('user') && getCookie('pswd')){
	      oUser.value = getCookie('user');
	      oPswd.value = getCookie('pswd');
	      oRemember.checked = true;
	    }
	    //复选框勾选状态发生改变时，如果未勾选则清除cookie
	    oRemember.onchange = function(){
	      if(!this.checked){
	        delCookie('user');
	        delCookie('pswd');
	      }
	    };
	    //表单提交事件触发时，如果复选框是勾选状态则保存cookie
	    oForm.onsubmit = function(){
	      if(remember.checked){ 
	        setCookie('user',oUser.value,7); //保存帐号到cookie，有效期7天
	        setCookie('pswd',oPswd.value,7); //保存密码到cookie，有效期7天
	      }
	    };
	  };
	  //设置cookie
	  function setCookie(name,value,day){
	    var date = new Date();
	    date.setDate(date.getDate() + day);
	    document.cookie = name + '=' + value + ';expires='+ date;
	  };
	  //获取cookie
	  function getCookie(name){
	    var reg = RegExp(name+'=([^;]+)');
	    var arr = document.cookie.match(reg);
	    if(arr){
	      return arr[1];
	    }else{
	      return '';
	    }
	  };
	  //删除cookie
	  function delCookie(name){
	    setCookie(name,null,-1);
	  };
	    </script>
    </body>
</html>