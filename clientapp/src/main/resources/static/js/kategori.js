

$(document).ready(function () {
    $("#table-kategori").DataTable({
      ajax: {
        method: "GET",
        url: "api/kategori",
        dataSrc: "",
      },
      columns: [
        {data: null,
          render: (data, row, type, meta) => {
            return meta.row + 1; }},
        { data: "name" },
        {data: null,
            render: (data) => {
              return `
                <!-- Button trigger modal update -->
                <button
    type="button"
    class="btn btn-warning update"
    data-bs-toggle="modal"
    data-bs-target="#updatek"
    onclick="beforeUpdate(${data.id})"
>
    Update
</button>
                <!-- Button trigger modal delete -->
                <button
                  type="button"
                  class="btn btn-danger delete"
                  data-bs-toggle="modal"
                  onclick="deletekategori(${data.id})"
                >
                  Delete
                </button>
              </div>`;
            },
          },
        ],
    });
  });

    // Create
    $("#create-kategori").click((event) => {
        event.preventDefault();
        let valueNama = $("#create-name").val();
        $.ajax({
            method: "POST",
            url: "api/kategori",
            dataType: "JSON",
            contentType: "application/json",
            beforeSend: addCSRFToken(),
            data: JSON.stringify({
                name: valueNama,
            }),
            success: (res) => {
                $("#create").modal("hide");
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Kategori anda berhasil dibuat!",
                    showConfirmButton: false,
                    timer: 2000,
                });
                $("#create-nama").val("");
                $("#table-kategori").DataTable().ajax.reload();
            },
            error: (err) => {
                // console.log(err);
                $("#create").modal("hide");
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: "Kategori anda tidak dapat dibuat!",
                });
                $("#create-nama").val("");
            },
        });
    });

    // Detail
    function getById(id) {
        $.ajax({
            method: "GET",
            url: "api/kategori/" + id,
            dataType: "JSON",
            contentType: "application/json",
            success: (res) => {
                $("#detail-id").val(res.id); 
                $("#detail-nama").val(res.nama);
            },
            error: (err) => {
                // console.log(err);
            },
        });
    }

    // Update
    function beforeUpdate(id) {
      console.log(id);
        $.ajax({
            method: "GET",
            url: "api/kategori/" + id,
            dataType: "JSON",
            contentType: "application/json",
            success: (res) => {
                $("#update-id").val(res.id);
                $("#update-name").val(res.name);
            },
            error: (err) => {
                console.error("Error:", err);
                $("#update").modal("hide");
                // Handle error
            },
        });
    }
    $("#update-kategori").click((event) => {
        event.preventDefault();
        beforeUpdate(id);
        let valueId = $("#update-id").val();
        let valueNama = $("#update-name").val();
    
        $.ajax({
            method: "PUT",
            url: "api/kategori/" + valueId,
            dataType: "JSON",
            contentType: "application/json",
            beforeSend: addCSRFToken(),
            data: JSON.stringify({
                name: valueNama,
            }),
            success: (res) => {
                $("#update").modal("hide");
                Swal.fire({
                    position: "center",
                    icon: "success",
                    title: "Kategori anda berhasil diedit!",
                    showConfirmButton: false,
                    timer: 2000,
                });
                $("#update-nama").val("");
                $("#table-kategori").DataTable().ajax.reload();
            },
            error: (err) => {
                // console.log(err);
                $("#update").modal("hide");
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: "Kategori anda tidak dapat diedit!",
                });
                $("#update-nama").val("");
            },
        });
    });   
    
    
// delete 
function deletekategori(id) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger",
      },
      buttonsStyling: false,
    });
    swalWithBootstrapButtons.fire({
        title: "Apakah Kamu yakin ingin menghapus Kategori ini?",
        text: "You won't be able to revert this!",
        html: '<lottie-player src="/img/ask.json" background="transparent" speed="1.5" style="width: 400px; height: 200px;" class="mx-auto text-center" loop autoplay></lottie-player>',
        showCancelButton: true,
        confirmButtonText: "Ya Hapus Sekarang!",
        cancelButtonText: "Jangan Hapus!",
        customClass: {
          confirmButton: "btn btn-success mx-2", 
          cancelButton: "btn btn-danger mx-2" 
        },
        reverseButtons: true,
      })
      .then((result) => {
        if (result.isConfirmed) {
          $.ajax({
            method: "DELETE",
            url: "api/kategori/del/" + id,
            dataType: "JSON",
            contentType: "application/json",
            beforeSend: addCSRFToken(),
            success: (res) => {
              swalWithBootstrapButtons.fire({
                title: "Datamu Sudah Terhapus!!",
              text: "Datamu Sudah Terhapus ",
              html: '<lottie-player src="/img/delete.json" background="transparent" speed="1" style="width: 400px; height: 200px;" class="mx-auto text-center" loop autoplay></lottie-player>',
              });
              $("#table-kategori").DataTable().ajax.reload();
            },
            error: (err) => {
              console.log(err);
            },
          });
        } else if (
          /* Read more about handling dismissals below */
          result.dismiss === Swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire({
            title: "Datamu Tidak Jadi Dihapus!",
            text: "Datamu Dalam Keadaan Aman",
            html: '<lottie-player src="/img/gagal.json" background="transparent" speed="1.5" style="width: 400px; height: 200px;" class="mx-auto text-center" autoplay></lottie-player>',
          });
        }
      });
  }
  