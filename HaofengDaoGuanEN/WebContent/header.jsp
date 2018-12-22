<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String _index=request.getParameter("active");
	if(_index==null)
		_index="0";
	boolean needback=false;
	if(request.getParameter("needback")!=null)
		needback=true;
	int index=Integer.parseInt(_index);
%>
	<header class="header-frontend">
		<div class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand hidden-xs" href="<%if(needback){%>../<%} %>HomePage"><img style="position:absolute;top:15px;left:10%;" alt="123" src="<%if(needback){%>../<%} %>images/logo.jpg" width="160px"></a>
					<a class="navbar-brand visible-xs" href="<%if(needback){%>../<%} %>HomePage"><img style="position:absolute;top:15px;left:35%;" alt="123" src="<%if(needback){%>../<%} %>images/logo.jpg" width="100px"></a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li id="1" <%if(index==1){%>class="active"<%}%>><a href="<%if(needback){%>../<%} %>HomePage">Home</a></li>
						<li id="2" <%if(index==2){%>class="active"<%}%>><a href="<%if(needback){%>../<%} %>Course">Course</a></li>
						<li id="4" <%if(index==4){%>class="active"<%}%>><a href="<%if(needback){%>../<%} %>Map">Center Location</a></li>
						<li id="5" <%if(index==5){%>class="active"<%}%>><a href="<%if(needback){%>../<%} %>Blog">Haofeng News</a></li>
						<li id="6" <%if(index==6){%>class="active"<%}%> class="dropdown "><a href="#" class="dropdown-toggle "
							data-toggle="dropdown" data-hover="dropdown" data-delay="0"
							data-close-others="false">About Maple Do Kwan<b class=" icon-angle-down"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<%if(needback){%>../<%} %>about.jsp">Company Profile</a></li>
								<li><a href="<%if(needback){%>../<%} %>contact.jsp">Contact Us</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</header>