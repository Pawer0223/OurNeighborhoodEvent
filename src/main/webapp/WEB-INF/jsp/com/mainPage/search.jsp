<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!--검색어 자동완성을위해서 추가 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

<div class="hero-wrap ftco-degree-bg" style="background-image: url('/resources/mainPage/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text justify-content-center align-items-center">
				<div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-end">
					<div class="text text-center" style="width: 100%;">
						<form action="/com/searchEvent.do" class="search-location mt-md-5" method="post" id="searchForm">
							<div class="row justify-content-center">
								<div class="col-lg-10 align-items-end" align="center">
									<div class="form-group" style="width: 70%">
										<div class="form-field" id="addressInfoParent">
											<input name="addressNm" id="addressNm" type="text" class="form-control" placeholder="우리동네를 검색해주세요">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											<input type="hidden" name="zoneNo" id="zoneNo" value="" />
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
			<a href="/com/start.do" class="mouse-icon">
				<div class="mouse-wheel">
					<span class="ion-ios-arrow-round-down"></span>
				</div>
			</a>
		</div>
</div>


</body>
</html>