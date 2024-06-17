let passwordInput = document.getElementById('password');
let passwordConfInput = document.getElementById('passwordConf');
let passwordError = document.getElementById('passwordError');

function validarContraseña() {
    let password = passwordInput.value;
    let passwordConf = passwordConfInput.value;

    if (password !== passwordConf) {
        passwordError.innerText = 'Las contraseñas no coinciden';
        return false;
    } else {
        passwordError.innerText = '';
        return true;
    }
}

let form = document.getElementById('registroForm');

form.addEventListener('submit', function(event) {

    if (!validarContraseña()) {
        event.preventDefault();
    }
});

passwordInput.addEventListener('input', validarContraseña);
passwordConfInput.addEventListener('input', validarContraseña);