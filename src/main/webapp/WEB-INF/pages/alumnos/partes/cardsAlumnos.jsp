<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${Productos}" var="producto">  
    <div class="col-sm-12 col-md-6 col-lg-4 col-xl-3 mt-4">
        <div class="card h-100">
            <!-- Foto -->
            <img class="card-img-top" src="${producto.foto}" alt="Foto de ${producto.nombre}" />
            <!-- Detalles -->
            <div class="card-body p-4">
                <div class="text-center">
                    <h5 class="fw-bolder">${producto.nombre}</h5>
                    <p class="mb-1"> $ ${producto.precio}</p>
                    <ins>${producto.estado}</ins> 
                </div>
            </div>
            <!-- Product actions-->
            <div class="card-footer border-top-0 bg-transparent">
                <div class="row justify-content-center">
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/app?accion=edit&id=${producto.id}" class="btn btn-warning btn-block w-100">Editar</a>
                    </div>
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/app?accion=remove&id=${producto.id}" class="btn btn-danger btn-block w-100">Borrar</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>


