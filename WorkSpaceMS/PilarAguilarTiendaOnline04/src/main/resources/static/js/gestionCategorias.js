let deleteModal = document.getElementById('deleteModal');
		deleteModal.addEventListener('show.bs.modal', function (event) {

			let button = event.relatedTarget;
			let categoryId = button.getAttribute('data-category-id');
			let form = document.getElementById('deleteForm');

			if (button.classList.contains('btn-danger')) {
				form.setAttribute('action',
					`/admin/categoria/borrar/${categoryId}`);
			} else {
				form.setAttribute('action', '');
			}
		});