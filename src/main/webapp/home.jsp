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

<style type="text/css">
body {
    padding: 30px;
}

.top-courses {
    text-align: center
}

.top-courses .group-btn-top-courses-slider {
    display: inline-block;
    margin: 0 auto;
    text-align: center;
    margin-top: 30px
}

.top-courses .group-btn-top-courses-slider .btn-prev,
.top-courses .group-btn-top-courses-slider .btn-next {
    width: 40px;
    height: 40px;
    line-height: 36px;
    text-align: center;
    color: #fff;
    background-color: #86bc42;
    display: inline-block;
    font-size: 24px;
    font-family: Helvetica, Arial, sans-serif;
    cursor: pointer;
    transition: all 0.2s linear
}

.top-courses .group-btn-top-courses-slider .btn-prev:hover,
.top-courses .group-btn-top-courses-slider .btn-next:hover {
    background-color: #242c42
}

.top-courses .group-btn-top-courses-slider .btn-prev {
    margin-right: 10px
}

.top-courses .top-courses-item {
    padding: 30px 0;
    text-align: left
}

.top-courses .top-courses-slider {
    margin-bottom: 30px
}

.top-courses .top-courses-wrapper {
    position: relative;
    top: -30px;
    margin-bottom: -30px
}

.choose-course .icon-circle {
    position: relative;
    width: 170px;
    height: 170px;
    border-radius: 50%;
    margin: 0 auto
}

.choose-course .icon-circle .icon-background {
    position: absolute;
    bottom: 12px;
    width: 146px;
    left: 50%;
    margin-left: -73px;
    height: 146px;
    border-radius: 50%;
    background-color: #86bc42;
    color: #fff;
    z-index: 11;
    display: table;
    transition: all .5s ease-in-out;
    -webkit-transform-origin: 50% 0;
    transform-origin: 50% 0
}

.choose-course .icon-circle .icon-background .icons-img {
    text-align: center;
    margin: 0 auto;
    color: #fff;
    display: table-cell;
    vertical-align: middle;
    font-size: 70px;
    line-height: 1;
    transition: all 0.4s ease
}

.choose-course .icon-circle .icon-background:after {
    position: absolute;
    content: '';
    top: -2px;
    left: -2px;
    bottom: -2px;
    right: -2px;
    border: 3px solid #fff;
    border-radius: 50%;
    transition: all 0.4s ease
}

.choose-course .icon-circle .info {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    text-align: center;
    border-radius: 50%;
    -webkit-backface-visibility: hidden;
    backface-visibility: hidden
}

.choose-course .icon-circle .info .info-back {
    opacity: 1;
    border-radius: 50%;
    background-color: #242c42;
    width: 100%;
    height: 100%;
    display: table;
    position: relative;
    transition: all 0.3s ease
}

.choose-course .icon-circle .info .info-back:before {
    position: absolute;
    z-index: 20;
    content: '';
    top: -1px;
    left: -1px;
    bottom: -1px;
    right: -1px;
    border: 12px solid #86bc42;
    border-radius: 50%
}

.choose-course .icon-circle .info .info-back a {
    color: #fff;
    vertical-align: middle;
    padding: 20px;
    display: table-cell;
    position: relative;
    z-index: 2;
    transition: all 0.7s ease
}

.choose-course .icon-circle:hover .icon-background {
    background-color: #86bc42;
    bottom: 90%
}

.choose-course .icon-circle:hover .icon-background:after {
    border: 2px solid #fff
}

.choose-course .icon-circle:hover .info .info-back:before {
    box-shadow: inset 0 0 10px rgba(0, 0, 0, 0.6)
}

.choose-course .icon-circle:hover .info .info-back a {
    transition-delay: 1s;
    z-index: 21
}

.choose-course .name-course {
    margin-top: 25px;
    color: #49575f;
    text-align: center;
    font-size: 16px
}

.choose-course .name-course a,
.choose-course .name-course p,
.choose-course .name-course span {
    color: #49575f;
    font-size: 16px;
    text-transform: uppercase;
    font-weight: 700;
    transition: all 0.2s linear
}

.choose-course .name-course i {
    margin-left: 5px;
    transition: all 0.2s linear
}

.choose-course .name-course:hover a,
.choose-course .name-course:hover p,
.choose-course .name-course:hover span,
.choose-course .name-course:hover i {
    color: #86bc42
}

.choose-course .choose-course-wrapper .col-md-4.col-xs-6 {
    margin-bottom: 70px
}

.choose-course .choose-course-wrapper .col-md-4.col-xs-6:nth-last-child(-n+3) {
    margin-bottom: 0
}

.choose-course-2 .item-course {
    width: 100%;
    cursor: pointer;
    border: 1px solid #e1e1e1;
    position: relative;
    text-align: center;
    overflow: hidden;
    padding: 70px 0;
    transition: all .5s ease-in-out
}

.choose-course-2 .item-course .icon-course .icons-img {
    font-size: 64px;
    line-height: 80px;
    color: #86bc42;
    transition: all .5s ease-in-out
}

.choose-course-2 .item-course .info-course {
    margin-top: 15px
}

.choose-course-2 .item-course .info-course .name-course {
    font-size: 21px;
    color: #49575f;
    margin-bottom: 10px;
    font-weight: 700
}

.choose-course-2 .item-course .info-course .info {
    font-size: 18px;
    color: #6f8190
}

.choose-course-2 .item-course .hover-text {
    position: absolute;
    top: 100%;
    width: 100%;
    height: 100%;
    background-color: #86bc42;
    color: #fff;
    transition: all .5s ease-in-out
}

.choose-course-2 .item-course .hover-text .wrapper-hover-text {
    display: table;
    height: 100%;
    width: 100%
}

.choose-course-2 .item-course .hover-text .wrapper-hover-content {
    display: table-cell;
    vertical-align: middle;
    text-align: center;
    padding: 0 30px;
    line-height: 24px
}

.choose-course-2 .item-course .hover-text .wrapper-hover-content .title {
    text-transform: uppercase;
    margin-bottom: 20px;
    color: #fff
}

.choose-course-2 .item-course .hover-text .wrapper-hover-content .title:hover {
    border-bottom: 1px solid #fff
}

.choose-course-2 .item-course:hover {
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.15)
}

.choose-course-2 .item-course:hover .hover-text {
    top: 0
}

.choose-course-2 .choose-course-wrapper .col-md-4.col-xs-6 {
    margin-bottom: 30px
}

.choose-course-2 .choose-course-wrapper .col-md-4.col-xs-6:nth-last-child(-n+3) {
    margin-bottom: 0
}

.choose-course-3 .choose-course-3-wrapper.row {
    margin: 0
}

.choose-course-3 .item-course {
    width: 33.33333333%;
    float: left;
    cursor: pointer;
    border: 1px solid #e1e1e1;
    border-left: 0;
    border-bottom: 0;
    position: relative;
    display: inline-block;
    transition: all .5s ease-in-out
}

.choose-course-3 .item-course:hover {
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.15)
}

.choose-course-3 .item-course:hover .icon-course .icons-img {
    color: #242c42
}

.choose-course-3 .item-course:hover:before {
    position: absolute;
    content: '';
    left: -1px;
    right: -1px;
    top: -1px;
    bottom: -1px;
    border: 1px solid #e1e1e1
}

.choose-course-3 .item-course:nth-child(3n-2) {
    border-left: 1px solid #e1e1e1
}

.choose-course-3 .item-course:nth-last-child(-n+3) {
    border-bottom: 1px solid #e1e1e1
}

.choose-course-3 .item-course-wrapper {
    display: table;
    padding: 16% 10%
}

.choose-course-3 .item-course-wrapper .icon-course {
    display: table-cell;
    vertical-align: top;
    padding-right: 30px;
    position: relative
}

.choose-course-3 .item-course-wrapper .icon-course:after {
    position: absolute;
    content: '';
    background: #e1e1e1;
    right: 0;
    top: 0;
    bottom: 0;
    width: 1px;
    height: 100%;
    min-height: 90px
}

.choose-course-3 .item-course-wrapper .icon-course .icons-img {
    font-size: 64px;
    width: 64px;
    line-height: 1;
    color: #86bc42;
    transition: all .5s ease-in-out
}

.choose-course-3 .item-course-wrapper .info-course {
    display: table-cell;
    vertical-align: top;
    padding-left: 30px;
    color: #49575f
}

.choose-course-3 .item-course-wrapper .info-course .name-course {
    font-size: 16px;
    text-transform: uppercase;
    margin-bottom: 20px;
    display: block;
    position: relative;
    z-index: 2;
    color: #49575f
}

.choose-course-3 .item-course-wrapper .info-course .info {
    line-height: 24px
}


 /* make images fill height and width or clip */
.carousel-item > img {
    object-fit: cover;
    height: calc(100vh - 56px);
    width: 100%;
}

footer {
	background-color:#2b2b2b;
    color:#ddd;
    min-height:100px;
    padding-top:20px;
    padding-bottom:40px;
}

footer .nav>li>a {
    padding: 3px;
    color: #f44d3c;
}

footer .nav>li>a:hover {
    background-color:transparent;
	color:#fff;
}

</style>

<title>Insert title here</title>
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
                    <a class="nav-link " href="?page=new">Login</a>
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