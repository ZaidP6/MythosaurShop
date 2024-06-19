document.getElementById('editButton').addEventListener('click', function(){
        let inputs = document.querySelectorAll('input[disabled]');
        inputs.forEach(input => input.removeAttribute('disabled'));

        document.getElementById('editButton').style.display = 'none';
        document.getElementById('saveButton').style.display = 'block';
});

