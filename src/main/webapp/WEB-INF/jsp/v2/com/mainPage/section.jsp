<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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

<section class="pt-105 pb-95 bg-light showcase_1">
	<div class="container px-xl-0">
		<div class="row justify-content-center text-center">
			<div class="col-xl-8 col-lg-10">
				<h2 class="small" data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">Event List</h2>
<!-- 				<div class="mt-15 mb-30 f-22 color-heading text-adaptive description" data-aos-duration="600" data-aos="fade-down" data-aos-delay="300"> -->
<!-- 					최근 등록이벤트 리스트 -->
<!-- 				</div> -->
			</div>
		</div>



			<div class="mt-10 row justify-content-center text-center text-md-left">

				<c:forEach items="${latestEvents}" var="row" varStatus="status">
					<div class="mt-70 col-lg-4 col-md-6 col-sm-9 block"
						data-aos-duration="600" data-aos="fade-down" data-aos-delay="0">
						<a href="#" class="d-block"> <img src=${ row.productPic } srcset="/resources/i/showcase_1_img_1@2x.jpg 2x" class="img-fluid radius10" alt="" />
						</a> <a href="#" class="mt-20 mb-10 f-22 link color-main title">남은 수량 : ${ row.amount }</a>
						<div class="color-heading text-adaptive">${ row.eventNm }</div>
					</div>

			</c:forEach>
		</div>
		
	</div>
</section>



</html>