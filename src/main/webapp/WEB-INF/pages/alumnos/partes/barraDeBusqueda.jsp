<%-- 
    Document   : barra de busqueda
    Created on : 7 jul. 2022, 10:55:24
    Author     : Pedro López
--%>

<div class="container-fluid">
    <form class= "form-control my-2" id="buscarProducto" action="${pageContext.request.contextPath}/Search" method="get" target="_self">
      <div class="row">
          
        <div class="col-md-6 mb-3">
            <input class="form-control" type="number" placeholder="Buscar por id" id="id" name="id">
            
        </div>
          
        <div class="col-md-6 mb-3">
            <input class="form-control" type="text" placeholder="Buscar por nombre" id="nombre" name="nombre">
                    
        </div>
      </div>
      <button class="btn bg-warning" type="submit" value="Submit">Buscar</button>
    </form>
      
     
</div>