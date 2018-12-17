<!-- Page Content -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



          <h1 class="my-4">Shop Name</h1>
          <div class="list-group">
          <c:forEach items="${cat}" var="Category">
            <a href="/front/category1/${Category.categoryid}/products" class="list-group-item">${Category.categoryname}</a>
            </c:forEach>
          </div>

        