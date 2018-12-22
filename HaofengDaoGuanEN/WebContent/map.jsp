<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.std.haofeng.vo.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%
	List<String> provinceName=(List<String>)request.getAttribute("provinceName");
	List<List<ShopInfo>> shopList=(List<List<ShopInfo>>)request.getAttribute("shopList");
	if(provinceName==null||shopList==null)
	{
		response.sendRedirect("Map");
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

  <body>
    <!--header start-->
		<jsp:include page="header.jsp?active=4" flush="true"></jsp:include>
    <!--header end-->
	<hr />

    <!--container start-->
    <div class="container">
		<div>
			<ul id="filters" class="list-unstyled">
				<%for(int i=0;i<provinceName.size();i++){ %>
                <li><a href="javascript:ChangeProvince(<%=i%>);"><%=provinceName.get(i) %></a></li>
                <%} %>
            </ul>
		</div>
		<div id="ShopList" class="col-lg-3 col-md-3 col-sm-3 hidden-xs" style="height:500px;background:#00BFFF;margin-top:18px;">
			
		</div>
		
		<div id="ShopList2" class="visible-xs" style="background:#00BFFF;">
			
		</div>
		<br/>
		<div class="col-lg-9 col-md-9 col-sm-9" id="map" style="height:500px"></div>
    </div>
    <!--container end-->
		<jsp:include page="yuyue.jsp" flush="true"></jsp:include>
     <!--footer start-->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
     <!--footer end-->

  <!-- js placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.3&key=9b305ac866dd80e3aed2c1df5cde5ca5"></script> 
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/hover-dropdown.js"></script>
    <script defer src="js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="assets/bxslider/jquery.bxslider.js"></script>

    <script src="js/jquery.easing.min.js"></script>
    <script src="js/link-hover.js"></script>


     <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>


  <script>
	  	<%
	  		String positionXY="";
    		String shopPositionAll=""; 
    		String shopTelAll="";
    		String shopNameAll="";
    		String cityName="[";
	  		for(int i=0;i<provinceName.size();i++){
	  			if(i==0){
	  				positionXY+="[";
		  			shopPositionAll+="[";
		  			shopTelAll+="[";
		  			shopNameAll+="[";
		  			cityName+="'"+provinceName.get(i)+"'";
	  			}
	  			else{
	  				positionXY+=",[";
		  			shopPositionAll+=",[";
		  			shopTelAll+=",[";
		  			shopNameAll+=",[";
	  				cityName+=",'"+provinceName.get(i)+"'";
	  			}
	  			List<ShopInfo> provinceList=shopList.get(i);
	  			for(int j=0;j<provinceList.size();j++)
	  			{
	  				if(j==0)
	  				{
	  					positionXY+="["+provinceList.get(j).getShopAddress()+"]";
	  		  			shopPositionAll+="'"+provinceList.get(j).getShopWay()+"'";
	  		  			shopTelAll+="'"+provinceList.get(j).getShopTel()+"'";
	  		  			shopNameAll+="'"+provinceList.get(j).getShopName()+"'";
	  				}else{
	  					positionXY+=",["+provinceList.get(j).getShopAddress()+"]";
	  		  			shopPositionAll+=",'"+provinceList.get(j).getShopWay()+"'";
	  		  			shopTelAll+=",'"+provinceList.get(j).getShopTel()+"'";
	  		  			shopNameAll+=",'"+provinceList.get(j).getShopName()+"'";
	  				}
	  			}
	  			positionXY+="]";
	  			shopPositionAll+="]";
	  			shopTelAll+="]";
	  			shopNameAll+="]";
	  		}
	  		cityName+="]";
	  	
	  	
	  	%>
		var positionXY=[<%=positionXY%>];
		var ShopPositionAll=[<%=shopPositionAll%>];
		var ShopTelAll=[<%=shopTelAll%>];
		var ShopNameAll=[<%=shopNameAll%>];
		var cityNameAll=[<%=cityName%>];
		var lnglats;
		var ShopPosition;
		var ShopTel;
		var ShopName;
		var map = new AMap.Map("map", {
			resizeEnable: true, 
			zoom:14,
			center:positionXY[0][0]
		});
		var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -30)});
		function markerClick(e) {
			infoWindow.setContent(e.target.content);
			infoWindow.open(map, e.target.getPosition());
		}
		function clickPosition(i)
		{
			infoWindow.setContent('<h4>'+ShopName[i]+'</h4>地址:' + ShopPosition[i] + '<br />联系电话:'+ShopTel[i]);
			infoWindow.open(map,lnglats[i]);
		}
		
		function SearchCity(cityName) {
			//加载行政区划插件
			AMap.service('AMap.DistrictSearch', function() {
				var opts = {
					subdistrict: 1,   //返回下一级行政区
					extensions: 'all',  //返回行政区边界坐标组等具体信息
					level: 'city'  //查询行政级别为 市
				};
				//实例化DistrictSearch
				district = new AMap.DistrictSearch(opts);
				district.setLevel('district');
				//行政区查询
				district.search('北京市', function(status, result) {
					var bounds = result.districtList[0].boundaries;
					var polygons = [];
					if (bounds) {
						for (var i = 0, l = bounds.length; i < l; i++) {
							//生成行政区划polygon
							var polygon = new AMap.Polygon({
								map: map,
								strokeWeight: 1,
								path: bounds[i],
								fillOpacity: 0.7,
								fillColor: '#CCF3FF',
								strokeColor: '#CC66CC'
							});
							polygons.push(polygon);
						}
						map.setFitView();//地图自适应
					}
				});
			});
		}
		function ChangeProvince(index)
		{
			//SearchCity(cityNameAll[index]);
			lnglats=positionXY[index];
			ShopPosition=ShopPositionAll[index];
			ShopTel=ShopTelAll[index];
			ShopName=ShopNameAll[index];
			for (var i = 0, marker; i < lnglats.length; i++) {
				var marker = new AMap.Marker({
					position: lnglats[i],
					map: map
				});
				marker.content = '<h4>'+ShopName[i]+'</h4>地址:' + ShopPosition[i] + '<br />联系电话:'+ShopTel[i];
				marker.on('click', markerClick);
				marker.emit('click', {target: marker});
			}
			var htmlCode="<br/>";
			for(var i=0;i<ShopName.length;i++){
				htmlCode+="&nbsp;&nbsp;<a style=\"color:white;\" href=\"javascript:clickPosition("+i+");\">"+ShopName[i]+"</a>"+"<br /><br />";
			}
			document.getElementById('ShopList').innerHTML=htmlCode;
			document.getElementById('ShopList2').innerHTML=htmlCode;
		}
		ChangeProvince(0);
  </script>

  </body>
</html>
