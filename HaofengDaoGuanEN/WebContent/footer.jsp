<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	boolean needback=false;
	if(request.getParameter("needback")!=null)
		needback=true;
%>
<footer class="footer">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-sm-6 col-xs-6">
				<h1>About Maple Do Kwan</h1>
				<p>WTF Standard Do Kwan<br/>Member of Chinese Taekwondo Association</p>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-6">
				<h1>Contact Us</h1>
				<address>
					<p>Tel:136-7516-2950</p>
					<p>WeChat:Maple_Do_Kwan</p>
					<p>
						Email:<a href="javascript:;">wanlijack@163.com</a>
					</p>
					<br/>
				</address>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-6">
				<h1>Main Courses</h1>
				<address>
					<p><a href="<%if(needback){%>../<%} %>Course?chooseType=0"><font color="white">> Taekwondo Course</font></a></p>
					<p><a href="<%if(needback){%>../<%} %>Course?chooseType=1"><font color="white">> Management Course</font></a></p>
				</address>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-6">
				<h1>Follow Us</h1>
				<ul class="social-link-footer list-unstyled">
					<li><a target="_blank" href="https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzIyNDgxOTE1OQ==&scene=124#wechat_redirect"><i class="fa fa-wechat"></i></a></li>
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
</footer>