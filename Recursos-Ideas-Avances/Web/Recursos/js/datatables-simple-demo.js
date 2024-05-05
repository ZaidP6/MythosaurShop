window.addEventListener('DOMContentLoaded', event => {
    let dataTable = document.getElementById('dataTable');
    if (dataTable) {
        new simpleDatatables.DataTable(dataTable);
    }
});
