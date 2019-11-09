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
                    const Toast = Swal.mixin({
                        toast: true,
                        position: 'top-end',
                        showConfirmButton: false,
                        timer: 3000
                      });

                      Toast.fire({
                        icon: 'success',
                        title: res
                      });  
                });
           }
            
       });
    });


