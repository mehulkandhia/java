<div class="container">
<!-- BreadCrumb -->
<div class="row">
<div class="col-xs-12">
<ol class="breadcrumb">
<li><a href="/fraction/home4">Home</a></li>
<li><a href="/fraction/listproducts/products">Products</a></li>
<li class="active">${prod.productname}</li>
</ol>
</div>
</div>

<div class="row">
<div class="col-xs-12 col-sm-4">
<div class="thumbnail">
<img src="${images}/${product.productid}.jpg" class="img img-responsive"/>
</div>
</div>
<div class="col-xs-12 col-sm-8">
<form action="<c:url value="/cartedit/${product.productid}/addition"/>" method="post">
<h3>${product.productname}</h3>
<hr/>
<p>${product.productdesc}</p>
<hr/>
<h4>Price :<strong>&#8377; ${product.price} /- </strong></h4>
<hr/>

<label for="quantity">Quantity</label>
<input type="number" name="quantity" min="1" id="quant" class="form-control mb-3 input-lg" placeholder="Choose the quantity">
<h6>Stock Available : ${product.stock}</h6>

<span class="glyphicon glyphicon-shopping-cart"><input type="submit" value="Add to cart" class="btn btn-success"></span>
<a href="/fraction/listproducts/products" class="btn btn-success"> Back</a>

</form>
</div>
</div>
</div>
 