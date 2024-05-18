let baseUrl = "http://localhost:8080";

axios.get(`${baseUrl}/api/docs/all`)
    .then(function (response){
        var documentos = response.data;
        var select = document.getElementById('idDocument');
        documentos.forEach(function (documento){
            var option = document.createElement('option');
            option.value = documento.id;
            option.text = documento.nameDocument;
            select.appendChild(option);
        })
    })
    .catch(function (error) {
        console.log(error);
    });

axios.get(`${baseUrl}/api/roles/all`)
    .then(function (response) {
        var roles = response.data;
        var select = document.getElementById('idRole');
        roles.forEach(function (role) {
            var option = document.createElement('option');
            option.value = role.id;
            option.text = role.nameRole;
            select.appendChild(option);
        });
    })
    .catch(function (error) {
        console.log(error);
    });

document.querySelector('.registro-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita el envío del formulario por defecto

    // Obtener el valor seleccionado del campo "Tipo de Documento"
    var idTypeDocument = document.getElementById('idDocument').value;
    var gender = document.getElementById('gender').value;

    // Verificar si el valor seleccionado es "null" (es decir, "Seleccionar")
    if (idTypeDocument === "null") {
        // Mostrar un mensaje de error al usuario o realizar alguna acción adecuada
        alert("Por favor selecciona un tipo de documento válido.");
        return; // Detener la ejecución del script
    }
    if(gender === "null"){
        alert("Por favor selecciona un tipo de genero");
        return;
    }

    // Continuar con el proceso de envío del formulario si el tipo de documento es válido

    // Obtener los valores de los demás campos del formulario
    var name = document.getElementById('name').value;
    var surname = document.getElementById('surname').value;
    var emailUser = document.getElementById('emailUser').value;
    var numDocument = document.getElementById('numDocument').value;
    var telephone = document.getElementById('telephone').value;
    var mobile = document.getElementById('mobile').value;
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var idRole = document.getElementById('idRole').value;

    // Construir el objeto con la información del usuario
    var userData = {
        "name": name,
        "surname": surname,
        "emailUser": emailUser,
        "gender": gender,
        "idTypeDocument": parseInt(idTypeDocument), // Convertir a entero
        "numDocument": numDocument,
        "telephone": telephone !== '' ? telephone : null, // Si está vacío, enviar null
        "mobile": mobile !== '' ? mobile : null,
        "username": username,
        "password": password,
        "idRole": parseInt(idRole) // Convertir a entero
    };

    // Enviar la información mediante una solicitud POST usando Axios
    axios.post(`${baseUrl}/api/users/print`, userData)
        .then(function(response) {
            console.log('Respuesta del servidor:', response.data);
            // Aquí puedes manejar la respuesta del servidor, como mostrar un mensaje de éxito al usuario
        })
        .catch(function(error) {
            console.error('Error al enviar la solicitud:', error);
            // Aquí puedes manejar el error, como mostrar un mensaje de error al usuario
        });
});

