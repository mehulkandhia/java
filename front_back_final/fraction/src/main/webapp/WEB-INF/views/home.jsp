<!-- Page Content -->

    <!-- Carousel Slider -->
    <div class="col-lg-9">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- <hr class="bg-dark mb-4 w-25">
    <div class="row"> -->
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">
      <div class="item active">
        <center><img src="${images}/vivo-v11.jpg"  style="width:200px;height:200px;"></center>
      </div>

      <div class="item">
        <center><img src="${images}/Dell-Inspiron-3567.jpg"  style="width:350px;"></center>
      </div>
    
      <div class="item">
        <center><img src="${images}/HP-2018.jpg"  style="width:300px;"></center>
      </div>
      
     <%--  <div class="item">
        <center><img src="${images}/vivo-v11-1.jpg"  style="width:175px;"></center>
      </div> --%>
    </div>

	<!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  </div>    <!-- Carousel Slider -->

    <!-- Card -->
    <div class="container container mt-4 mb-5">
        <h3 class="display-4 text-center"> Products </h3>
        <hr class="bg-dark mb-4 w-25">
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="${images}/Dell-Inspiron-3565.jpg" style="width:300px;height:250px;" alt="Card image cap">
                    <div class="card-block p-3">
                        <h4 class="card-title">Dell Laptop</h4>
                        <p class="card-text">Dell Inspiron 3565 AMD E2 7th Gen 15.6-inch Laptop (4GB/1TB HDD/ Windows 10/Black/2.5kg).</p>
                        
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="${images}/HP-2018.jpg" style="width:300px;height:250px;" alt="Card image cap">
                    <div class="card-block p-3">
                        <h4 class="card-title">HP</h4>
                        <p class="card-text">HP 15 15q-bu028TU 2018 15.6-inch Laptop (7th Gen Core i3-7020u/4GB/1TB/Windows 10/Integrated Graphics), Smoke Gray.</p>
                        
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="${images}/vivo-v11.jpg" style="width:300px;height:250px;" alt="Card image cap">
                    <div class="card-block p-3">
                        <h4 class="card-title">Vivo V11</h4>
                        <p class="card-text">Vivo V11 Pro (Starry Night Black, 6GB RAM, 64GB Storage)</p>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Card -->

    
        
     <!-- Footer -->
 	<%@include file="./shared/footer.jsp" %> 