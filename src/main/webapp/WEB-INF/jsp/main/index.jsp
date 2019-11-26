<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
  <head>
    <title>Woo Dong 2</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:200,300,400,600,700,800,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/first/resources/mainPage/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/first/resources/mainPage/css/animate.css">
    
    <link rel="stylesheet" href="/first/resources/mainPage/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/first/resources/mainPage/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/first/resources/mainPage/css/magnific-popup.css">

    <link rel="stylesheet" href="/first/resources/mainPage/css/aos.css">

    <link rel="stylesheet" href="/first/resources/mainPage/css/ionicons.min.css">

    <link rel="stylesheet" href="/first/resources/mainPage/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="/first/resources/mainPage/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="/first/resources/mainPage/css/flaticon.css">
    <link rel="stylesheet" href="/first/resources/mainPage/css/icomoon.css">
    <link rel="stylesheet" href="/first/resources/mainPage/css/style.css">
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  </head>
  <body>
  
  	<%@ include file = "header.jsp" %>
		
	<div class="hero-wrap ftco-degree-bg" style="background-image: url('/first/resources/mainPage/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center align-items-center">
          <div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-end">
          	<div class="text text-center" style = " width : 100%; " >
 				<h1 class="mb-4">우리동네를 검색해 주세요</h1>
	            <form action="#" class="search-location mt-md-5">
		        		<div class="row justify-content-center">
		        			<div class="col-lg-10 align-items-end" align="center">
		        				<div class="form-group" style = " width : 70% ">
		          				<div class="form-field">
				                <input onclick="sample6_execDaumPostcode()" type="text" class="form-control" placeholder="Search location" id="sample6_address" >
				                <button><span class="ion-ios-search"></span></button>
				              </div>
			              </div>
		        			</div>
		        		</div>
		        	</form>
            </div>
          </div>
        </div>
      </div>
      <div class="mouse">
				<a href="/first/main/start.do" class="mouse-icon">
					<div class="mouse-wheel"><span class="ion-ios-arrow-round-down"></span></div>
				</a>
			</div>
    </div>
    <!-- END nav -->
    <section class="ftco-section ftco-no-pb">
      <div class="container">
      	<div class="row justify-content-center">
          <div class="col-md-12 heading-section text-center ftco-animate mb-5">
          	<span class="subheading">Our Services</span>
            <h2 class="mb-2">소소한 행복을 나누다</h2>
          </div>
        </div>
        <div class="row d-flex">
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
            	<div class="icon d-flex justify-content-center align-items-center"><img src=/first/resources/mainPage/images/soccer.png width="100" height="100" ></div>
              <div class="media-body py-md-4">
                <h3>축구경기가 있는날에 !</h3>
                <p>그냥 볼 수 없는 축구경기, 오늘은 자주시키던 치킨집이아니라 우리동네 치킨집에서 저렴하게 !</p>
              </div>
            </div>      
          </div>
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
            	<div class="icon d-flex justify-content-center align-items-center"><img src=/first/resources/mainPage/images/happy.png width="100" height="100" ></div>
              <div class="media-body py-md-4">
                <h3>사장님 기분에따라 !</h3>
                <p>사장님 마음대로 이벤트를 등록하고 즐길수 있도록 !</p>
              </div>
            </div>      
          </div>
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
            	<div class="icon d-flex justify-content-center align-items-center"><img src=/first/resources/mainPage/images/stock.png width="100" height="100" ></div>
              <div class="media-body py-md-4">
                <h3>당일 재고가 남은날에 !</h3>
                <p>사장님은 효율적인 재고처리를 이웃들은 저렴한 가격에 맛있는 음식을 !</p>
              </div>
            </div>      
          </div>
          <div class="col-md-3 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
            	<div class="icon d-flex justify-content-center align-items-center"><img src=/first/resources/mainPage/images/give.png width="100" height="100" ></div>
              <div class="media-body py-md-4">
                <h3>베풀고 싶을때 !</h3>
                <p>따듯한 정을 나누고 싶을 때 !</p>
              </div>
            </div>      
          </div>
        </div>
      </div>
    </section>
    
    <section class="ftco-section ftco-degree-bg services-section img mx-md-5" style="background-image: url(/first/resources/mainPage/images/bg_2.jpg);">
    	<div class="overlay"></div>
    	<div class="container">
    		<div class="row justify-content-start mb-5">
          <div class="col-md-6 text-center heading-section heading-section-white ftco-animate">
          	<span class="subheading">How To Use</span>
            <h2 class="mb-3">The Service</h2>
          </div>
        </div>
    		<div class="row">
    			<div class="col-md-6">
    				<div class="row">
		    			<div class="col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate">
		            <div class="media block-6 services services-2">
		              <div class="media-body py-md-4 text-center">
		              	<div class="icon mb-3 d-flex align-items-center justify-content-center"><span>01</span></div>
		                <h3>동네 검색</h3>
		                <p>먼저, 우리동네를 검색해주세요</p>
		              </div>
		            </div>      
		          </div>
		          <div class="col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate">
		            <div class="media block-6 services services-2">
		              <div class="media-body py-md-4 text-center">
		              	<div class="icon mb-3 d-flex align-items-center justify-content-center"><span>02</span></div>
		                <h3>이벤트 검색</h3>
		                <p>우리동네 이벤트를 찾아주세요</p>
		              </div>
		            </div>      
		          </div>
		          <div class="col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate">
		            <div class="media block-6 services services-2">
		              <div class="media-body py-md-4 text-center">
		              	<div class="icon mb-3 d-flex align-items-center justify-content-center"><span>03</span></div>
		                <h3>결제</h3>
		                <p>결제완료시 이벤트 참여완료 !</p>
		              </div>
		            </div>      
		          </div>
		          <div class="col-md-12 col-lg-6 d-flex align-self-stretch ftco-animate">
		            <div class="media block-6 services services-2">
		              <div class="media-body py-md-4 text-center">
		              	<div class="icon mb-3 d-flex align-items-center justify-content-center"><span>04</span></div>
		                <h3>배달</h3>
		                <p>배달 아이콘이 있다면 배달 ok !<br>없다면 직접 Pickup !</p>
		              </div>
		            </div>      
		          </div>
		        </div>
		      </div>
    		</div>
    	</div>
    </section>

    <section class="ftco-section goto-here">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12 heading-section text-center ftco-animate mb-5">
					<span class="subheading">Event List</span>
				</div>
			</div>
			<div class="row">
				<c:choose>
					<c:when test="${fn:length(latestEvents) > 0}">
						<c:forEach items="${latestEvents}" var="row" varStatus ="status">
							<div class="col-md-4">
								<div class="property-wrap ftco-animate">
									<a href="#" class="img"
										style="background-image: url(${ row.PRODUCT_PIC });"></a>
									<div class="text">
										<p class="price" style="text-align: center;">
											<span class="old-price">${ row.ORIGIN_PRICE }<small>￦</small></span><span
												class="orig-price">${ row.EVENT_PRICE }<small>￦</small></span>
										</p>
										<ul class="property_list" style="text-align: center;">
											<li><img src=/first/resources/mainPage/images/running.gif width="30" height="30">&nbsp;남은 수량 : ${ row.AMOUNT }&nbsp; 
											<c:if test="${ row.DELIVERY_YN eq 'Y' }"><img src=/first/resources/mainPage/images/Delivery.png width="20" height="20"></c:if>
										</ul>
										<h3 style="text-align: center;">
											<a href="#">${ row.EVENT_NM }</a>${status.count}
										</h3>
										<h6 style="text-align: center;">
											<span class="location">${ row.PTN_NM }</span>
										</h6>
										<a href="#"
											class="d-flex align-items-center justify-content-center btn-custom">
											<span class="ion-ios-link"></span>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise><h3 align="center">최근 등록된 이벤트가 없습니다</h3></c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>
    
    <section class="ftco-section testimony-section">
      <div class="container">
			<div class="row justify-content-center mb-5">
				<div class="col-md-7 text-center heading-section ftco-animate">
					<span class="subheading">Service Review</span>
					<h2 class="mb-3">Happy Clients</h2>
				</div>
			</div>

			<div class="row ftco-animate">

				<div class="col-md-12">
					<div class="carousel-testimony owl-carousel ftco-owl">

						<c:choose>
							<c:when test="${fn:length(latestReviews) > 0}">
								<c:forEach items="${latestReviews}" var="row">

									<div class="item">
										<div class="testimony-wrap py-4">
											<div class="text">
												<p class="mb-4">${ row.REVIEW_DESC }</p>
												<div class="d-flex align-items-center">
													<div class="user-img"
														style="background-image: url(${ row.PROFILE_PIC })"></div>
													<div class="pl-3">
														<p class="name">${ row.USER_NM }</p>
														<span class="position">${ row.EVENT_NM }</span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise><h3 align="center">최근 후기가 없습니다</h3></c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
      </div>
    </section>

    <section class="ftco-section ftco-no-pb">
			<div class="container">
				<div class="row no-gutters">
					<div class="col-md-6 p-md-5 img img-2 d-flex justify-content-center align-items-center" style="background-image: url(/first/resources/mainPage/images/about.jpg);">
					</div>
					<div class="col-md-6 wrap-about py-md-5 ftco-animate">
	          <div class="heading-section p-md-5">
	            <h2 class="mb-4">기획의도</h2>

	            <p>요즘 많은 배달 사이트들을 활용하여 다양한 할인 및 서비스를 제공하는 여러 프렌차이즈에 비하여 특별한 홍보수단 및 경쟁력이 부족하다고 느낀 주변의 자영업자들을 기획하게 되었습니다.</p>
	            <p>우리 동네 이벤트를 이용함으로써, 효율적인 재고 처리와 동네의 작은 이벤트들로 소소한 행복을 느낄 수 있기를 바랍니다.</p>
	          </div>
					</div>
				</div>
			</div>
		</section>

		<section class="ftco-counter img" id="section-counter">
    	<div class="container">
    		<div class="row">
          <div class="col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
            <div class="block-18 py-4 mb-4">
              <div class="text text-border d-flex align-items-center">
                <strong class="number" data-number="305">0</strong>
                <span>Ongoing <br>Event</span>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
            <div class="block-18 py-4 mb-4">
              <div class="text text-border d-flex align-items-center">
                <strong class="number" data-number="1090">0</strong>
                <span>End <br>Event</span>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
            <div class="block-18 py-4 mb-4">
              <div class="text text-border d-flex align-items-center">
                <strong class="number" data-number="209">0</strong>
                <span>Review <br>Count</span>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
            <div class="block-18 py-4 mb-4">
              <div class="text d-flex align-items-center">
                <strong class="number" data-number="67">0</strong>
                <span>Today<br>hits</span>
              </div>
            </div>
          </div>
        </div>
    	</div>
    </section>
    
	<%@ include file = "footer.jsp" %>
	
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  <script src="/first/resources/mainPage/js/jquery.min.js"></script>
  <script src="/first/resources/mainPage/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="/first/resources/mainPage/js/popper.min.js"></script>
  <script src="/first/resources/mainPage/js/bootstrap.min.js"></script>
  <script src="/first/resources/mainPage/js/jquery.easing.1.3.js"></script>
  <script src="/first/resources/mainPage/js/jquery.waypoints.min.js"></script>
  <script src="/first/resources/mainPage/js/jquery.stellar.min.js"></script>
  <script src="/first/resources/mainPage/js/owl.carousel.min.js"></script>
  <script src="/first/resources/mainPage/js/jquery.magnific-popup.min.js"></script>
  <script src="/first/resources/mainPage/js/aos.js"></script>
  <script src="/first/resources/mainPage/js/jquery.animateNumber.min.js"></script>
  <script src="/first/resources/mainPage/js/bootstrap-datepicker.js"></script>
  <script src="/first/resources/mainPage/js/jquery.timepicker.min.js"></script>
  <script src="/first/resources/mainPage/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="/first/resources/mainPage/js/google-map.js"></script>
  <script src="/first/resources/mainPage/js/main.js"></script>
  
  <!--  주소API -->
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="/first/resources/js/mapAPI.js"></script>
  </body>
</html>