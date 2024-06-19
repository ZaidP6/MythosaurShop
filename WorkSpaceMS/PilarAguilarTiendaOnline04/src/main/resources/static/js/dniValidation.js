document.addEventListener('DOMContentLoaded', function () {
    let letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
        'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

    let dniInput = document.getElementById('dni');
    let dniError = document.getElementById('dniError');

    dniInput.addEventListener('input', function () {
        let dniValue = dniInput.value;
        let dniNumber = dniValue.slice(0, -1);
        let dniLetter = dniValue.slice(-1).toUpperCase();

        dniError.innerText = '';

        if (dniNumber.length !== 8 || isNaN(dniNumber)) {
            dniError.innerText = 'El número de DNI debe tener 8 caracteres numéricos';
        } else if (dniNumber <= 0 || dniNumber > 99999999) {
            dniError.innerText = 'Este número no está dentro del rango';
        } else {
            let numLetra = dniNumber % 23;
            if (dniLetter !== letras[numLetra]) {
                dniError.innerText = 'La letra indicada no es correcta';
            }
        }
    });

});

document.addEventListener('DOMContentLoaded', function () {

    let phoneInput = document.getElementById('phone');
    let phoneError = document.getElementById('phoneError');

    phoneInput.addEventListener('input', function () {
        let phoneValue = phoneInput.value;
        phoneError.innerText = '';

        if (phoneValue.length !== 9 || isNaN(phoneValue)) {
            phoneError.innerText = 'El número de teléfono debe contener 9 números';
        }
    });

});

let birthInput = document.getElementById('birth');
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

    let form = document.querySelector('form');
    form.addEventListener('submit', function (event) {
        if (!validateAge()) {
            event.preventDefault();
        }
    });

