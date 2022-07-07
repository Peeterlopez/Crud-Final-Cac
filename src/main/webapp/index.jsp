<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp" />
<jsp:include page="WEB-INF/pages/comunes/inicioHead.jsp" />
<title>Inicio- Kriger</title>
<jsp:include page="WEB-INF/pages/comunes/finHead.jsp" />


<body>
    
    <jsp:include page="WEB-INF/pages/comunes/nav.jsp" />
    
    <div class="p-5 mb-4 bg-light rounded-3">
        <div class="container-fluid py-5 col-8 text-center">
            <h1 class="display-6 fw-bold">WebApp Java MVC con DB MySQL</h1>
            <p class="fs-4 lead">¡Bienvenidos! Este es un inventario personalizado creado por <a target="_blank" href="https://github.com/Peeterlopez"> Pedro López </a>.</p>
            <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/inventario">Ir al inventario</a>
        </div>
    </div>
        
    <jsp:include page="WEB-INF/pages/comunes/footer.jsp" />
    
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp" />