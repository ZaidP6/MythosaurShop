import DataTable from 'datatables.net-dt';
import DataTable from 'datatables.net-dt';
import 'datatables.net-responsive-dt';
 
 
 //Para la tabla dinamica
let table = new DataTable('#dataTable', {
    responsive: true
});

$(document).ready( function () {
    $('#dataTable').DataTable();
} );

//Al eliminar una linea de venta pregunta si quieres borrarla
$(document).ready(function() {
            $('.delete-link').click(function(e) {
                e.preventDefault(); // Evitar que el enlace se siga

                var orderLineId = $(this).data('orderlineid');
                deleteOrderLine(orderLineId);
            });
        });

        function deleteOrderLine(orderLineId) {
            if (confirm('¿Seguro que quieres borrarla?')) {
                fetch(`/api/orderlines/delete/${orderLineId}`, {
                    method: 'DELETE'
                }).then(response => {
                    if (response.ok) {
                        location.reload();
                    } else {
                        alert('Error');
                    }
                });
            }
        }
 