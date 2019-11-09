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
                $.post("carro",{
                    idLibro,
                    cant
                },function(res){
                    alert(res);
                });
           }
            
       });
    });


