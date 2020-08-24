function guardar(){
    var placa = document.getElementById("placa").value;
    var marca = document.getElementById("marca").value;

    
    var jsonParametro = {"placa": placa, "marca": marca};
    
    $.ajax({
       type: "POST" ,
       url: "http://localhost:8080/ufide-progra-iii-proyecto/miApi/bus/buses",
       data: JSON.stringify(jsonParametro),
       contentType: "application/json; charset=utf-8",
       dataType: "json",
       success: function(data){
           if(parseInt(data.operacionExitosa) === 1){
               document.getElementById("placa").value = "";
               document.getElementById("marca").value = "";
               alert("Se almacenó de forma correcta");
           }               
           else
               alert("Ocurrió un error");
       }
    });
}

function cargar(){
    $.get("http://localhost:8080/ufide-progra-iii-proyecto/miApi/bus/buses", function(data, status){
        var buses = data.buses;
        var busesString = "";
        for(i in buses){
            busesString += " Placa: " + buses[i].placa + " Marca: " +
                    buses[i].marca + "\n";
        }
        $("#resultado").val(busesString);
    });
}


//Corremos la app, agregamos la info y nos sale una ventana que dice que se almaceno de forma correcta