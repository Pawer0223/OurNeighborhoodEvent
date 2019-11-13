<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">

	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

 <style type="text/css">
 
 /* make images fill height and width or clip */
.carousel-item > img {
    object-fit: cover;
    height: calc(100vh - 56px);
    width: 100%;
}
 
 
</style>
	

<title>메인쪽</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar1">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#">Brand</a>
  <div class="collapse navbar-collapse" id="navbar1">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Link</a>
      </li>
    </ul>
  </div>
</nav>
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