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


let birthInput = document.getElementById('inputBirthDay');
    let ageError = document.getElementById('ageError');

    function validateAge() {
        let birthDate = new Date(birthInput.value);
        let today = new Date();
        let age = today.getFullYear() - birthDate.getFullYear();
        let monthDifference = today.getMonth() - birthDate.getMonth();

        if (monthDifference < 0 || (monthDifference === 0 && today.getDate() < birthDate.getDate())) {
            age--;
        }

        if (age < 18) {
            ageError.textContent = 'Debes tener al menos 18 años';
            birthInput.classList.add('is-invalid');
            return false;
        } else {
            ageError.textContent = '';
            birthInput.classList.remove('is-invalid');
            birthInput.classList.add('is-valid');
            return true;
        }
    }

    birthInput.addEventListener('change', validateAge);

    let formBirth = document.querySelector('form');
    formBirth.addEventListener('submit', function (event) {
        if (!validateAge()) {
            event.preventDefault();
        }
    });
