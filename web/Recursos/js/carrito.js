$(document).ready(function(){
    $(".eliminar").click(function(){
        var idLibro = $(this).attr("id");
        var accion = "eliminar";
        
        $.post("carro",{
            idLibro,
            accion
        },function (res) {
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
        //$(this).closest('tr').remove();
    });
});


