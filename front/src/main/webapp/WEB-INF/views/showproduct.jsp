<div class="container">
<!-- BreadCrumb -->
<div class="row">
<div class="col-xs-12">
<ol class="breadcrumb">
<li><a href="front/home">Home</a></li>
<li><a href="front/listproducts/products">Products</a></li>
<li class="active">${prod.productname}</li>
</ol>
</div>
</div>

<div class="row">
<div class="col-xs-12 col-sm-4">
<div class="thumbnail">
<img src="${images}/vivo-v11.jpg" class="img img-responsive"/>
</div>
</div>
<div class="col-xs-12 col-sm-8">
<h3>${prod.productname}</h3>
<hr/>
<p>${prod.productdesc}</p>
<hr/>
<h4>Price :<strong>&#8377; ${product.price} /- </strong></h4>
<hr/>
<h6>Quantity Available : ${product.quantity}</h6>
<a href="front/addcart/${product.productid}/product" class="btn btn-success">
<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
<a href="front/listproducts/products" class="btn btn-success"> Back</a>
</div>
</div>
</div>