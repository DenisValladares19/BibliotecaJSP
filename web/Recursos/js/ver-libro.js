$(document).ready(function() {
       $("#agregar").click(function(){
           if($("#cant").val()===""){
               Swal.fire(
                    'Bibliote Online',
                    'Debe seleccionar una cantidad de libro',
                    'error'
                 )
           }else{
                var idLibro = $("#idLibro").val();
                var cant = $("#cant").val();
                var accion = "agregar";
                $.post("carro",{
                    idLibro,
                    cant,
                    accion
                },function(res){
                    alert(res);
                });
           }
            
       });
    });


