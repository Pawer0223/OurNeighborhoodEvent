<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" >
		<title>Startup 3.3 - Project</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
				<link rel="icon" href="../resources/i/favicon.png" type="image/x-icon">
		<!-- Google Fonts -->
				<link href="https://fonts.googleapis.com/css?family=DM+Sans:100,200,300,400,600,500,700,800,900|DM+Sans:100,200,300,400,500,600,700,800,900&amp;subset=latin" rel="stylesheet">
				<!-- Bootstrap 4.3.1 CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<!-- Slick 1.8.1 jQuery plugin CSS (Sliders) -->
		<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
		<!-- Fancybox 3 jQuery plugin CSS (Open images and video in popup) -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css" />
		<!-- AOS 2.3.4 jQuery plugin CSS (Animations) -->
		<link href="https://unpkg.com/aos@2.3.4/dist/aos.css" rel="stylesheet">
		<!-- FontAwesome CSS -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<!-- Startup 3 CSS (Styles for all blocks) -->
					<link href="../resources/css/style.css" rel="stylesheet" />
				<!-- jQuery 3.3.1 -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		
		
</head> 
	<body>

<!-- Navigation 2 -->

<nav class="pt-30 pb-30 bg-light lh-40 navigation_2">
	<div class="container px-xl-0">
		<div class="row align-items-center justify-content-between">
			<div class="col-xl-2 col-lg-3 text-center text-lg-left" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
				<a href="#" class="mr-20 link color-main f-24 bold">Startup 3</a>
			</div>
			<div class="col-xl-10 col-lg-9 d-flex flex-wrap align-items-center justify-content-center justify-content-md-between">
				<div class="mb-10 mb-md-0" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300">
					<div class="d-inline-block px-20 dropdown">
						<a href="#" class="link color-main  dropdown-toggle" id="navigation_2_dropdown_1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Products</a>
						<div class="bg-light dropdown-menu" aria-labelledby="navigation_2_dropdown_1">
					<div><a href="#" class="link color-main ">Startup 3</a></div>
					<div><a href="#" class="link color-main ">Slides</a></div>
					<div><a href="#" class="link color-main ">Qards</a></div>
						</div>
					</div>
					<a href="#" class="mx-15 link color-main ">Pricing</a>
					<a href="#" class="mx-15 link color-main ">Community</a>
				</div>
				<div class="text-md-right" data-aos-duration="600" data-aos="fade-down" data-aos-delay="600">
					<a href="#" class="mr-15 link color-main ">API</a>
					<a href="#" class="mx-15 link color-main ">Help</a>
					<a href="#" class="mx-15 link color-main ">Login</a>
					<a href="#" class="mx-15 btn sm color-main border-gray f-16">Sign Up</a>
				</div>
			</div>
		</div>
	</div>
</nav>
<!-- Content 1 -->

<section class="pt-80 pb-80 bg-light content_1">
	<div class="container px-xl-0">
		<div class="row justify-content-center">
			<div class="col-xl-7 col-lg-10 text-center" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
					<form name="testAutoComplete" action="check();" method="post">
						<div class="input-group mb-3">
							<input type="text" id="inputData" class="form-control" placeholder="동네를 검색해 주세요" aria-label="Example text with button addon" aria-describedby="button-addon1" style="height:55px;" autocomplete ="on">
						</div>
					</form>
					<div class="buttons" data-aos-duration="600" data-aos="fade-down" data-aos-delay="600">
					<a href="#" class="mt-25 mx-15 btn border-gray color-main">검색</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Showcase 1 -->

<section class="pt-105 pb-95 bg-light showcase_1">
	<div class="container px-xl-0">
		<div class="row justify-content-center text-center">
			<div class="col-xl-8 col-lg-10">
				<h2 class="small" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">Better design for your content</h2>
				<div class="mt-15 mb-30 f-22 color-heading text-adaptive description" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300">
					Startup Framework contains components and complex blocks which 
					can easily be integrated into almost any design. 
				</div>
			</div>
		</div>
		<div class="mt-10 row justify-content-center text-center text-md-left">
			<div class="mt-70 col-lg-4 col-md-6 col-sm-9 block" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
				<a href="#" class="d-block">
					<img src="../resources/i/showcase_1_img_1.jpg" srcset="../resources/i/showcase_1_img_1@2x.jpg 2x" class="img-fluid radius10" alt="" />
				</a>
				<a href="#" class="mt-20 mb-10 f-22 link color-main title">iPhone Features</a>
				<div class="color-heading text-adaptive">
					Startup Framework works fine on devices 
					supporting Retina Display. Feel the clarity!				</div>
			</div>
			<div class="mt-70 col-lg-4 col-md-6 col-sm-9 block" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300">
				<a href="#" class="d-block">
					<img src="../resources/i/showcase_1_img_2.jpg" srcset="../resources/i/showcase_1_img_2@2x.jpg 2x" class="img-fluid radius10" alt="" />
				</a>
				<a href="#" class="mt-20 mb-10 f-22 link color-main title">Bootstrap Based Design</a>
				<div class="color-heading text-adaptive">
					HTML layout is based on one of the most 
					common and reliable framework - Bootstrap.				</div>
			</div>
			<div class="mt-70 col-lg-4 col-md-6 col-sm-9 block" data-aos-duration="600" data-aos="fade-down" data-aos-delay="600">
				<a href="#" class="d-block">
					<img src="../resources/i/showcase_1_img_3.jpg" srcset="../resources/i/showcase_1_img_3@2x.jpg 2x" class="img-fluid radius10" alt="" />
				</a>
				<a href="#" class="mt-20 mb-10 f-22 link color-main title">Prototyping</a>
				<div class="color-heading text-adaptive">
					We used only time-tested technologies for <br />
					the best results.				</div>
			</div>
			<div class="mt-70 col-lg-4 col-md-6 col-sm-9 block" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
				<a href="#" class="d-block">
					<img src="../resources/i/showcase_1_img_4.jpg" srcset="../resources/i/showcase_1_img_4@2x.jpg 2x" class="img-fluid radius10" alt="" />
				</a>
				<a href="#" class="mt-20 mb-10 f-22 link color-main title">More than Image</a>
				<div class="color-heading text-adaptive">
					We prepared some high-quality photos, that 
					you can use in your projects.				</div>
			</div>
			<div class="mt-70 col-lg-4 col-md-6 col-sm-9 block" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300">
				<a href="#" class="d-block">
					<img src="../resources/i/showcase_1_img_5.jpg" srcset="../resources/i/showcase_1_img_5@2x.jpg 2x" class="img-fluid radius10" alt="" />
				</a>
				<a href="#" class="mt-20 mb-10 f-22 link color-main title">Startup Framework Generator</a>
				<div class="color-heading text-adaptive">
					Startup Framework contains components <br />
					and complex blocks which can easily.				</div>
			</div>
			<div class="mt-70 col-lg-4 col-md-6 col-sm-9 block" data-aos-duration="600" data-aos="fade-down" data-aos-delay="600">
				<a href="#" class="d-block">
					<img src="../resources/i/showcase_1_img_6.jpg" srcset="../resources/i/showcase_1_img_6@2x.jpg 2x" class="img-fluid radius10" alt="" />
				</a>
				<a href="#" class="mt-20 mb-10 f-22 link color-main title">More than Design</a>
				<div class="color-heading text-adaptive">
					Carefully crafted precise design, with 
					harmonious typography and perfect padding.				</div>
			</div>
		</div>
	</div>
</section>
<!-- Footer 2 -->

<footer class="pt-70 pb-65 bg-light text-center footer_2">
	<div class="container px-xl-0">
		<div class="row justify-content-center">
			<div class="col-12 lh-40" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
				<a href="#" class="link color-main mx-20">Portfolio</a>
				<a href="#" class="link color-main mx-20">How it Works</a>
				<a href="#" class="link color-main mx-20">Pricing</a>
				<a href="#" class="link color-main mx-20">About</a>
				<a href="#" class="link color-main mx-20">Contacts</a>
			</div>
			<div class="mt-20 col-12" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300">
				<div class="color-heading text-adaptive">
					Be sure to take a look at our <a href="#" class="link color-heading">Terms of Use</a> 
					and <a href="#" class="link color-heading">Privacy Policy</a>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- forms alerts -->
<div class="alert alert-success alert-dismissible fixed-top alert-form-success" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	Thanks for your message!
</div>
<div class="alert alert-warning alert-dismissible fixed-top alert-form-check-fields" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	Please, fill in required fields.
</div>
<div class="alert alert-danger alert-dismissible fixed-top alert-form-error" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	<div class="message">An error occurred while sending data :( Please, check if your hosting supports PHP and check how to set form data sending <a href="https://designmodo.com/startup/documentation/#form-handler" target="_blank" class="link color-transparent-white">here</a>.</div>
</div>

<!-- gReCaptcha popup (uncomment if you need a recaptcha integration) -->
<!--
<div class="bg-dark op-8 grecaptcha-overlay"></div>
<div class="bg-light radius10 w-350 h-120 px-20 pt-20 pb-20 grecaptcha-popup">
	<div class="w-full h-full d-flex justify-content-center align-items-center">
		<div id="g-recaptcha" data-sitekey="PUT_YOUR_SITE_KEY_HERE"></div>
	</div>
</div>
<script src="https://www.google.com/recaptcha/api.js?render=explicit" async defer></script>
-->

<!-- Bootstrap 4.3.1 JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<!-- Fancybox 3 jQuery plugin JS (Open images and video in popup) -->
<script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>
<!-- Google maps JS API -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3&key=AIzaSyDP6Ex5S03nvKZJZSvGXsEAi3X_tFkua4U"></script>
<!-- Slick 1.8.1 jQuery plugin JS (Sliders) -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<!-- AOS 2.3.4 jQuery plugin JS (Animations) -->
<script src="https://unpkg.com/aos@2.3.4/dist/aos.js"></script>
<!-- Maskedinput jQuery plugin JS (Masks for input fields) -->
<script src="../resources/js/jquery.maskedinput.min.js"></script>
<!-- Startup 3 JS (Custom js for all blocks) -->
<script src="../resources/js/script.js"></script>

</body>
</html>