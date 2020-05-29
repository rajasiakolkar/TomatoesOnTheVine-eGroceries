
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img class="first-slide"
				src="<c:url value="/resources/images/bg1.jpg" />"
				alt="First slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>Your Health, at your doorstep</h1>
					<p>
						Organic foods, delivered.
					</p>
					<p>
						<a class="btn btn-lg btn-primary" href="#" role="button">Sign
							up today</a>
					</p>
				</div>
			</div>
		</div>
		<div class="item">
			<img class="second-slide"
				src="<c:url value="/resources/images/bg2.jfif" />"
				alt="Second slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>An apple a day keeps the doctor away</h1>
					
				</div>
			</div>
		</div>
		<div class="item">
			<img class="third-slide"
				src="<c:url value="/resources/images/bg3.jpg" />"
				alt="Third slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>Happy To Help</h1>
					<p></p>
					<p>
						<a class="btn btn-lg btn-primary" href="#" role="button">Browse
							gallery</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>
<!-- /.carousel -->


	<%@include file="/WEB-INF/views/common/footer.jsp"%>