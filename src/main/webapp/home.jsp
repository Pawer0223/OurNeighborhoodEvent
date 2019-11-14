<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

<!-- 내가 정의 한 css -->
<link rel="stylesheet" href="resources/css/home.css">


<title>우리동네 이벤트</title>
</head>
<body>

<!-- 상단 바 -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="/">About Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="?page=new">Event List</a>
                </li>
            </ul>
            <ul class="navbar-nav flex-row">
                <li class="nav-item">
                    <a class="nav-link " href="login.jsp">Login</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link " href="?page=new">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!--  사진있는거 -->
<div class="container-fluid px-0">
    <div id="carouselExampleControls" class="carousel slide " data-ride="carousel">
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                <img src="https://visualhunt.com/photos/13/anchor.jpg?s=m" />
            </div>
            <div class="carousel-item">
                <img src="https://visualhunt.com/photos/4/boat-ship-anchor-buildings-skyline-night-dark.jpg?s=m" />
            </div>
            <div class="carousel-item">
                <img src="https://visualhunt.com/photos/13/anchor.jpg?s=m" />
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon bg-dark rounded-circle p-2 shadow d-block" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon bg-dark rounded-circle p-2 shadow d-block" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>


<!-- 테니스공 6개 -->
<!-- 
추가하고싶은기능

있으면 아이콘 전구로, 없으면 없는걸로

동네 검색하기전에 안보여주기로.



 -->
<div class="section section-padding choose-course">
    <div class="container">
        <div class="group-title-index"><br><br><br>
            <h1 class="center-title" align="center">Event List</h1><br><br><br>
            <div class="bottom-title"><i class="bottom-icon icon-a-1-01-01"></i></div>
        </div>
        <div class="choose-course-wrapper row">
            <div class="col-md-4 col-xs-6">
                <div class="item-course item-1">
                    <div class="icon-circle">
                        <div class="icon-background"><i class="icons-img fa fa-question"></i></div>
                        <div class="info">
                            <div class="info-back"><a href="courses.html">You already learned one, remember?</a></div>
                        </div>
                    </div>
                    <div class="name-course"><a href="courses.html">치킨</a><i class="fa fa-long-arrow-right"></i></div>
                </div>
            </div>
            <div class="col-md-4 col-xs-6">
                <div class="item-course item-2">
                    <div class="icon-circle">
                        <div class="icon-background"><i class="icons-img fa fa-question"></i></div>
                        <div class="info">
                            <div class="info-back"><a href="courses.html">You already learned one, remember?</a></div>
                        </div>
                    </div>
                    <div class="name-course"><a href="courses.html">햄버거</a><i class="fa fa-long-arrow-right"></i></div>
                </div>
            </div>
            <div class="col-md-4 col-xs-6">
                <div class="item-course item-3">
                    <div class="icon-circle">
                        <div class="icon-background"><i class="icons-img fa fa-question"></i></div>
                        <div class="info">
                            <div class="info-back"><a href="courses.html">You already learned one, remember?</a></div>
                        </div>
                    </div>
                    <div class="name-course"><a href="courses.html">중국집</a><i class="fa fa-long-arrow-right"></i></div>
                </div>
            </div>
            <div class="col-md-4 col-xs-6">
                <div class="item-course item-4">
                    <div class="icon-circle">
                        <div class="icon-background"><i class="icons-img fa fa-question"></i></div>
                        <div class="info">
                            <div class="info-back"><a href="courses.html">You already learned one, remember?</a></div>
                        </div>
                    </div>
                    <div class="name-course"><a href="courses.html">피자/양식</a><i class="fa fa-long-arrow-right"></i></div>
                </div>
            </div>
            <div class="col-md-4 col-xs-6">
                <div class="item-course item-5">
                    <div class="icon-circle">
                        <div class="icon-background"><i class="icons-img fa fa-question"></i></div>
                        <div class="info">
                            <div class="info-back"><a href="courses.html">You already learned one, remember?</a></div>
                        </div>
                    </div>
                    <div class="name-course"><a href="courses.html">한식</a><i class="fa fa-long-arrow-right"></i></div>
                </div>
            </div>
            <div class="col-md-4 col-xs-6">
                <div class="item-course item-6">
                    <div class="icon-circle">
                        <div class="icon-background"><i class="icons-img fa fa-question"></i></div>
                        <div class="info">
                            <div class="info-back"><a href="courses.html">You already learned one, remember?</a></div>
                        </div>
                    </div>
                    <div class="name-course"><a href="courses.html">분식</a><i class="fa fa-long-arrow-right"></i></div>
                </div>
            </div>
        </div>
    </div>
</div>
 <br><br><br><br><br><br>

<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-6 col-sm-6 col-md-3 column">
                <h4>Information</h4>
                <ul class="nav">
                    <li><a href="about-us.html">Products</a></li>
                    <li><a href="about-us.html">Services</a></li>
                    <li><a href="about-us.html">Benefits</a></li>
                    <li><a href="elements.html">Developers</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Follow Us</h4>
                <ul class="nav">
                    <li><a href="#">Twitter</a></li>
                    <li><a href="#">Facebook</a></li>
                    <li><a href="#">Google+</a></li>
                    <li><a href="#">Pinterest</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Contact Us</h4>
                <ul class="nav">
                    <li><a href="#">Email</a></li>
                    <li><a href="#">Headquarters</a></li>
                    <li><a href="#">Management</a></li>
                    <li><a href="#">Support</a></li>
                </ul>
            </div>
            <div class="col-xs-6 col-md-3 column">
                <h4>Customer Service</h4>
                <ul class="nav">
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Delivery Information</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Terms &amp; Conditions</a></li>
                </ul>
            </div>
        </div>
        <!--/row-->
        <p class="text-right">©2019</p>
    </div>
</footer>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>