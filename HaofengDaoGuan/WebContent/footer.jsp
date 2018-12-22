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
				<h1>关于浩枫</h1>
				<p>WTF体系道馆<br/>中国跆拳道协会会员单位</p>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-6">
				<h1>联系我们</h1>
				<address>
					<p>电话:136-7516-2950</p>
					<p>微信:purun_team</p>
					<p>
						Email:<a href="javascript:;">wanlijack@163.com</a>
					</p>
					<br/>
				</address>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-6">
				<h1>教学课程</h1>
				<address>
					<p><a href="<%if(needback){%>../<%} %>Course?chooseType=0"><font color="white">> 跆拳道</font></a></p>
					<p><a href="<%if(needback){%>../<%} %>Course?chooseType=1"><font color="white">> 管理拓展</font></a></p>
				</address>
			</div>
			<div class="col-lg-3 col-sm-6 col-xs-6">
				<h1>关注我们</h1>
				<ul class="social-link-footer list-unstyled">
					<li><a target="_blank" href="https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzIyNDgxOTE1OQ==&scene=124#wechat_redirect"><i class="fa fa-wechat"></i></a></li>
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				</ul>
			</div>
		</div>
	</div>
</footer>