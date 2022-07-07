<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${Productos}" var="producto">  
    <div class="col-sm-12 col-md-6 col-lg-4 col-xl-3 mt-4">
        <div class="card h-100">
            <!-- Foto -->
            <img class="card-img-top" src="${producto.foto}" alt="Foto de ${producto.nombre}" />
            <!-- Detalles -->
            <div class="card-body p-4">
                <div class="text-center">
                    <c:choose>
                        <c:when test="${producto.cantidad>20}">
                            <span class="badge rounded-pill bg-success text-uppercase" data-bs-toggle="tooltip" data-bs-placement="top" title="${producto.cantidad}">En Stock</span>
                        </c:when>
                        <c:when test="${producto.cantidad<20 && producto.cantidad>0}">
                            <span class="badge rounded-pill bg-warning text-uppercase" data-bs-toggle="tooltip" data-bs-placement="top" title="${producto.cantidad}">
                                Bajo Stock
                            </span>
                        </c:when>
                        <c:otherwise>
                            <span class="badge rounded-pill bg-secondary text-uppercase" data-bs-toggle="tooltip" data-bs-placement="top" title="${producto.cantidad}">Sin Stock</span>
                        </c:otherwise>
                    </c:choose>
                </div>            
                    
                 <div class="text-center mt-2 mb-2">
                    <h4 class="card-title " >${producto.nombre}</h4>
                 </div>
                
                 <div class="text-center">
                    <h4 class="card-subtitle display-6">$${producto.precio}</h4>
                 </div>
            </div>
            <!-- Product actions-->
            <div class="card-footer border-top-0 bg-transparent">
                <div class="row justify-content-center">
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/inventario?accion=edit&id=${producto.id}" class="btn btn-success btn-block w-100">Editar</a>
                    </div>
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/inventario?accion=remove&id=${producto.id}" class="btn btn-danger btn-block w-100">Borrar</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>



