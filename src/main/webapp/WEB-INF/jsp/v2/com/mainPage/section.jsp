<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>


<section class="pt-80 pb-80 bg-light content_1">
	<div class="container px-xl-0">
		<div class="row justify-content-center">
			<div class="col-xl-7 col-lg-10 text-center" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
					<form name="testAutoComplete" method="post">
						<div class="input-group mb-3">
							<input type="text"  name="keyword" id="keyword" class="form-control" placeholder="동네를 검색해 주세요" aria-label="동네 검색" aria-describedby="button-addon2" style="height: 50px;">
							<div class="input-group-append">
								<button class="btn btn-secondary border-gray color-main" type="button" id="button-addon2" >검색</button>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
			</div>
		</div>
	</div>
</section>
<!-- Showcase 1 -->

<section class="pt-65 pb-65 bg-light application_2">
	<div class="container px-xl-0">
		<div class="row justify-content-center justify-content-md-between align-items-center">
			<div class="mb-15 mb-md-0 col-12 col-md-5 col-xl-6 d-flex justify-content-center">
				<img srcset="/resources/i/application_2_img_1@2x.png 2x" src="/resources/i/about.jpg" alt="" class="img-fluid application_2_left_img" data-aos-duration="600" data-aos="fade-down" data-aos-delay="750" />
			</div>
			<div class="col-md-7 col-xl-6">
				<h2 class="col-lg-11 color-main" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">우리동네 이벤트 ?</h2>
				<div class="mt-25 col-lg-9 color-heading f-18 text-adaptive" data-aos-duration="600" data-aos="fade-down" data-aos-delay="150">우리 동네 이벤트를 이용함으로써, 효율적인 재고 처리와 소소한 이벤트로 행복을 느낄 수 있기를 바랍니다.</div>
				<div class="mt-95 row">
					<div class="col-6 col-lg-4 pb-25 with_borders" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300"> 
						<img srcset="/resources/application_2_img_2@2x.png 2x" src="/resources/i/application_2_img_2.png" alt="" class="pl-15" />
						<div class="mt-15 col-xl-11 color-main f-14 bold sp-20 text-uppercase">Ready to Present</div>
					</div>
					<div class="col-6 col-lg-4 pb-25 with_borders" data-aos-duration="600" data-aos="fade-down" data-aos-delay="450">
						<img srcset="/resources/i/application_2_img_3@2x.png 2x" src="/resources/i/application_2_img_3.png" alt="" class="pl-15" />
						<div class="mt-15 col-xl-11 color-main f-14 bold sp-20 text-uppercase">Crops and Layers</div>
					</div>
					<div class="col-6 col-lg-4 pb-25 with_borders" data-aos-duration="600" data-aos="fade-down" data-aos-delay="600">
						<img srcset="/resources/i/application_2_img_4@2x.png 2x" src="/resources/i/application_2_img_4.png" alt="" class="pl-15" />
						<div class="mt-15 col-xl-11 color-main f-14 bold sp-20 text-uppercase">Free Google Fonts</div>
					</div>
					<div class="col-6 col-lg-4 pb-25 pt-35 with_borders" data-aos-duration="600" data-aos="fade-down" data-aos-delay="750">
						<img srcset="/resources/i/application_2_img_5@2x.png 2x" src="/resources/i/application_2_img_5.png" alt="" class="pl-15" />
						<div class="mt-15 col-xl-11 color-main f-14 bold sp-20 text-uppercase">Based on Bootstrap 3</div>
					</div>
					<div class="col-6 col-lg-4 pb-25 pt-35 with_borders" data-aos-duration="600" data-aos="fade-down" data-aos-delay="900">
						<img srcset="/resources/i/application_2_img_6@2x.png 2x" src="/resources/i/application_2_img_6.png" alt="" class="pl-15" />
						<div class="mt-15 col-xl-11 color-main f-14 bold sp-20 text-uppercase">HTML5, CSS3, LESS</div>
					</div>
			 		<div class="col-6 col-lg-4 pb-25 pt-35 with_borders" data-aos-duration="600" data-aos="fade-down" data-aos-delay="1050">
						<img srcset="/resources/i/application_2_img_7@2x.png 2x" src="/resources/i/application_2_img_7.png" alt="" class="pl-15" />
						<div class="mt-15 col-xl-11 color-main f-14 bold sp-20 text-uppercase">Powerful Components</div>
					</div>	
						
				</div>
			</div>
		</div>
	</div>
</section><!-- forms alerts -->



</html>