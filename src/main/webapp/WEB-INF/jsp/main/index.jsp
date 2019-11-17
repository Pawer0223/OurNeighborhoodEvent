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
  </head>
  <body>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/first/main/start.do">우리동네 이벤트</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="/first/main/start.do" class="nav-link">Home</a></li>
	            <li class="nav-item"><a href="/first/main/events.do" class="nav-link">Events</a></li>
	          <li class="nav-item"><a href="/first/main/services.do" class="nav-link">Services</a></li>
	          <li class="nav-item"><a href="/first/main/contact.do" class="nav-link">Contact</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
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
          	<span class="subheading">Work flow</span>
            <h2 class="mb-3">How it works</h2>
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
        	<div class="col-md-4">
        		<div class="property-wrap ftco-animate">
        			<a href="#" class="img" style="background-image: url(/first/resources/mainPage/images/foods/chicken.jpg);"></a>
        			<div class="text">
        				<p class="price"  style=" text-align : center ;"><span class="old-price">20,000<small>￦</small></span><span class="orig-price">8,000<small>￦</small></span></p>
        				<ul class="property_list" style=" text-align : center ;">
        					<li><img src=/first/resources/mainPage/images/running.gif width="30" height="30" >&nbsp;남은 수량 : 5&nbsp; <img src=/first/resources/mainPage/images/Delivery.png width="20" height="20" ></li>
        					<li><small>종료 : 물량 소진 시</small></li>
        				</ul>
        				<h3 style=" text-align : center ;"><a href="#">오늘은 결혼기념일 3주년</a></h3>
        				<h6 style=" text-align : center ;"><span class="location">동네 통닭집</span></h6>
        				<a href="#" class="d-flex align-items-center justify-content-center btn-custom">
        					<span class="ion-ios-link"></span>
        				</a>
        			</div>
        		</div>
        	</div>
        	<div class="col-md-4">
        		<div class="property-wrap ftco-animate">
        			<a href="#" class="img" style="background-image: url(/first/resources/mainPage/images/foods/jokbal.jpg);"></a>
        			<div class="text">
        				<p class="price"  style=" text-align : center ;"><span class="old-price">30,000<small>￦</small></span><span class="orig-price">17,000<small>￦</small></span></p>
        				<ul class="property_list" style=" text-align : center ;">
        					<li><img src=/first/resources/mainPage/images/running.gif width="30" height="30" >&nbsp남은 수량 : 2<br></li>
        					<li><small>종료 : 물량 소진 시</small></li>
        				</ul>
        				<h3 style=" text-align : center ;"><a>당일 삶은족발 2개</a></h3>
        				<h6 style=" text-align : center ;"><span class="location">동네 족발집</span></h6>
        				<a href="#" class="d-flex align-items-center justify-content-center btn-custom">
        					<span class="ion-ios-link"></span>
        				</a>
        			</div>
        		</div>
        	</div>
        	<div class="col-md-4">
        		<div class="property-wrap ftco-animate">
        			<a href="#" class="img" style="background-image: url(/first/resources/mainPage/images/foods/Jajang.jpg);"></a>
        			<div class="text">
        				<p class="price"  style=" text-align : center ;"><span class="old-price">5,500<small>￦</small></span><span class="orig-price">0<small>￦</small></span></p>
        				<ul class="property_list" style=" text-align : center ;">
        					<li><img src=/first/resources/mainPage/images/running.gif width="30" height="30" >&nbsp남은 수량 : 2</li>
        					<li><small>종료 : 2019.11.18</small></li>
        				</ul>
        				<h3 style=" text-align : center ;"><a>수능 본 학생 짜장면 제공</a></h3>
        				<h6 style=" text-align : center ;"><span class="location">동네 중국집</span></h6>
        				<a href="#" class="d-flex align-items-center justify-content-center btn-custom">
        					<span class="ion-ios-link"></span>
        				</a>
        			</div>
        		</div>
        	</div>
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
              <div class="item">
                <div class="testimony-wrap py-4">
                  <div class="text">
                    <p class="mb-4">평소 당일 남는 수량의 족발들의 처리가 불편하였는데 좋은 서비스를 제공해주셔서 감사합니다.</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(/first/resources/mainPage/images/person_1.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">동네 족발집</p>
		                    <span class="position">종료한 서비스 명</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                  <div class="text">
                    <p class="mb-4">저렴한 식사 한끼와 좋은 맛집을 발견할 수 있었습니다.</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(/first/resources/mainPage/images/person_2.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">강x산</p>
		                    <span class="position">참여한 이벤트 명</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                  <div class="text">
                    <p class="mb-4">맨날 먹던데서만 먹다가 싸고 맛있게 먹엇네요 감사합니다 ㅎㅎ</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(/first/resources/mainPage/images/person_3.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">고x님</p>
		                    <span class="position">참여한 이벤트 명</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                  <div class="text">
                    <p class="mb-4">리뷰내용을 적어주세요1</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(/first/resources/mainPage/images/person_1.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">고객님1</p>
		                    <span class="position">참여한 이벤트 명1</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                  <div class="text">
                    <p class="mb-4">리뷰내용을 적어주세요2</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(/first/esources/mainPage/images/person_1.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">고객님2</p>
		                    <span class="position">참여한 이벤트 명2</span>
		                  </div>
	                  </div>
                  </div>
                </div>
                
                
              </div>
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

    <footer class="ftco-footer ftco-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">WooDong2</h2>
              <p>자영업자들을 위한 효율적인 재고처리 서비스 우리동네 이벤트 입니다.</p>
              <ul class="ftco-footer-social list-unstyled mt-5">
                <li class="ftco-animate"><a href="https://github.com/Taesan94/OurNeighborhoodEvent"><span class="icon-github"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">Community</h2>
              <ul class="list-unstyled">
                <li><a href="/first/main/start.do"><span class="icon-long-arrow-right mr-2"></span>동네검색</a></li>
                <li><a href="/first/main/events.do"><span class="icon-long-arrow-right mr-2"></span>Events</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">About Us</h2>
              <ul class="list-unstyled">
                <li><a href="/first/main/services.do"><span class="icon-long-arrow-right mr-2"></span>Services</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Developer</h2>
              <ul class="list-unstyled">
                <li><a href="/first/main/contact.do"><span class="icon-long-arrow-right mr-2"></span>Contact</a></li>
                <li><a href="https://github.com/Taesan94/OurNeighborhoodEvent/issues"><span class="icon-long-arrow-right mr-2"></span>Issue History</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">경기도 용인시 기흥구 구성로</span></li>
	                <li><a><span class="icon icon-phone"></span><span class="text">010-4586-8427</span></a></li>
	                <li><a><span class="icon icon-envelope pr-4"></span><span class="text">gbgo77@naver.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">
	
            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <div><small>아이콘 이미지 출처 : 아이콘 제작자 <a href="https://www.flaticon.com/kr/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a></small></div>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
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