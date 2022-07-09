<%-- 
    Document   : barra de busqueda
    Created on : 7 jul. 2022, 10:55:24
    Author     : Pedro López
--%>

<div class="container">
    <div class="row-cols-12">
        <form id="buscarProducto" action="${pageContext.request.contextPath}/Search" method="get" target="_blank">
        <input type="number" placeholder="Buscar por id" id="id" name="id">
        <input type="submit" value="Submit">
        </form>
    </div>
    
</div>