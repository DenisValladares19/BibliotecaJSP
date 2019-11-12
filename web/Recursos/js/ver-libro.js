$(document).ready(function() {
    $("#cant").val(1);
       $("#agregar").click(function(){
           if($("#cant").val()===""){
               Swal.fire(
                    'Bibliote Online',
                    'Debe seleccionar una cantidad de libro',
                    'error'
                 )
           }else{
                $("#modalTipoLibro").modal("show");
               /*
                var idLibro = $("#idLibro").val();
                var cant = $("#cant").val();
                var accion = "agregar";
                window.setInterval(
                    $.post("carro",{
                        idLibro,
                        cant,
                        accion
                    },function(res){
                        const Toast = Swal.mixin({
                            toast: true,
                            position: 'top-end',
                            showConfirmButton: false,
                            timer: 2000
                          });

                          Toast.fire({
                            icon: 'success',
                            title: res
                          });  
                          location.reload();
                    }),"2000"    
                );
                $("#cant").val(1);*/
           }
            
       });
    });


