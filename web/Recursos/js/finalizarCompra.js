$(document).ready(function(){
   $("#enviar").click(function(e){
       e.preventDefault();
      var idCliente = $("#idCliente").val(); 
      var nombre = $("#nombre").val();
      var apellido = $("#apellido").val();
      var direccion = $("#direccion").val();
      var total = $("#total").val();
      $.post("procesarPago",{
          idCliente,
          nombre,
          apellido,
          direccion,
          total
      },function(res){
          alert(res);
      });
   }); 
});