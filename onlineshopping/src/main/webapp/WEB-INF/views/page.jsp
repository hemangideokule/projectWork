 <body bgcolor="#00000">
 <div class="container">

        <div class="row">

            <div class="col-md-3">
               <!-- include dynamic sidebar -->
             <!--  <p class="lead">Categories</p>
<div class="list-group">

	<a href="#" class="list-group-item">abc</a> 
	
</div>-->
    <%@include file="./shared/sidebar.jsp" %>           
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="${images}/c1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="${images}/c4.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="${images}/c5.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

 <%-- <div class="row" id="featuresHeading">
				<div class="col-12">
					<h2>FOOD ITEMS</h2>
					
				 </div><!-- end col-12 -->
			</div><!-- end featuresHeading -->
			
			
			<div class="row" id="features">
				<div class="col-sm-4 feature">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title" align="center">CAKES</h3>
						</div><!-- end panel-heading -->
						<img src="${img}/4.jpg" alt="cakes" height="200" width="200" ">
						
						<p>CAKES CAKES</p>
						
						<!-- <a href="/onlinebakery/cakes" class="btn btn-warning btn-block">Click To Buy</a> -->
					</div><!-- end panel -->
				</div><!-- end feature -->
				
				<div class="row" id="features">
				<div class="col-sm-4 feature">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title" align="center">CUP CAKES</h3>
						</div><!-- end panel-heading -->
						<img src="${img}/5.jpg" alt="cakes" height="200" width="200">
						
						<p>CAKES CAKES</p>
						
						<!-- <a href="/onlinebakery/cakes" class="btn btn-warning btn-block">Click To Buy</a> -->
					</div><!-- end panel -->
				</div><!-- end feature -->
				<div class="row" id="features">
				<div class="col-sm-4 feature">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title" align="center">CHEESE CAKES</h3>
						</div><!-- end panel-heading -->
						<img src="${img}/6.jpg" alt="cakes" height="200" width="200">
						
						<p>CAKES CAKES</p>
						
						<!-- <a href="/onlinebakery/cakes" class="btn btn-warning btn-block">Click To Buy</a> -->
					</div><!-- end panel -->
				</div><!-- end feature --> 
</div>
</div>
</div>
             </div>

        </div>
 --%>
 <div align="left">
 <%-- <img src="${img}/4.jpg" alt="cakes" height="200" width="200"> --%>
 <img alt="" src="${images}/m1.JPG" height="500" width="900">
 </div>
    </div>
   </body>