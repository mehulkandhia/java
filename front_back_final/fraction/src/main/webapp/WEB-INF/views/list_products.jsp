
  <div class="container container mt-4 mb-5">
        <h3 class="display-4 text-center"> Products </h3>
       
        <hr class="bg-dark mb-4 w-25">
        
        <div class="row">
       <c:forEach items="${productList}" var="product"> 
            <div class="col-md-4">
                
                <div class="card">
                
                
<img class="card-img-top" src="${images}/${product.productid}.jpg"  style="width:300px;height:250px;" alt="Card image cap"></td>
<div class="card-block p-3">
<h4 class="card-title text-center">Price: <strong>&#8377; ${product.price} /-</strong></h4>
<h4 class="card-title text-center">Product Name: ${product.productname}</h4>
<h4 class="card-title text-center">Description:<br> ${product.productdesc }</h4>
<h4 class="card-title text-center">Stock: ${product.stock }</h4>

<center><a href="/fraction/show/${product.productid}/product"><input type="submit" value="Show Product" class="btn btn-success" style="width:300px;"/></a></center>
<center><b><p>_______________________________________</p></b></center>
</div>
</div>
</div>
</c:forEach>
</div>
                    </div>
                    
        