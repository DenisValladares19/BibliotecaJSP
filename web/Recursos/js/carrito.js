$(document).ready(function(){
    $(".eliminar").click(function(){
        //$(this).closest('tr').remove();
        var idLibro = $(this).attr("id");
        var accion = "eliminar";
        $.post("carro",{
            idLibro,
            accion
        },function(res){
            alert(res);
        });
    });
});


