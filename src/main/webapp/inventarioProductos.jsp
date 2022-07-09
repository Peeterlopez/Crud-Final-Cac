<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp" />
<jsp:include page="WEB-INF/pages/comunes/inicioHead.jsp" />
<title>Inventario</title>
<jsp:include page="WEB-INF/pages/comunes/finHead.jsp" />

<body>

    <jsp:include page="WEB-INF/pages/comunes/nav.jsp" />
    <jsp:include page="WEB-INF/pages/alumnos/partes/barraDeBusqueda.jsp" />
    <section class="py-5">
        <div class="container">
            <div class="pb-4">
                    <div class="row text-center">
                    <h1 class="h3">Inventario de productos</h1>
                    <p class="lead">Aquí puedes ver todos tus productos de la Base de Datos</p>
                    <div>
                        <a href="#" class="btn btn-success"
                   data-bs-toggle="modal" data-bs-target="#modalAgregarProducto">Agregar producto</a>
                    </div>
                </div>
             </div>
        
            
            <c:choose>
                <c:when test="${Productos!= null && !Productos.isEmpty()}">
                    <div class="row">
                    <jsp:include page="WEB-INF/pages/alumnos/partes/cardsAlumnos.jsp" />
                    </div>
                </c:when>
                    
                <c:otherwise>
                    <p class="lead text-center">No hay productos en la Base de Datos. Puede que todavía no hayas cargado ninguno</p>
                </c:otherwise>
            </c:choose>
            
        </div>
    </section>
    <jsp:include page="WEB-INF/pages/alumnos/partes/modalAgregarAlumno.jsp" />
    <script src="scripts/fotobase64.js"> </script>
    <jsp:include page="WEB-INF/pages/comunes/footer.jsp" />
    <jsp:include page="WEB-INF/pages/comunes/finHTML.jsp" />
