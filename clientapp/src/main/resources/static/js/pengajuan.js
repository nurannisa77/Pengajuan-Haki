$(document).ready(function () {
    $("#table-pengajuan").DataTable({
      ajax: {
        method: "GET",
        url: "api/pengajuan",
        dataSrc: "",
        cache: true,
      },
      columns: [
        {
          data: null,
          render: function (data, type, row, meta) {
            return meta.row + 1;
          },
        },
        {
          data: "files[0].pencipta"
        },
        {
            data: null,
            render: function (data, type, row) {
              // Memastikan bahwa data.profilePengajuans[0].tanggal tidak null atau undefined
              if (data && data.profilePengajuans && data.profilePengajuans.length > 0 && data.profilePengajuans[0].tanggal) {
                // Mengambil tanggal saja (tanpa jam)
                var tanggal = new Date(data.profilePengajuans[0].tanggal);
                var tanggalString = tanggal.toLocaleDateString(); // Format tanggal sesuai preferensi lokal
                return tanggalString;
              } else {
                return "-";
              }
            },
          },
        {
            data: "files", // Sesuaikan dengan nama kolom yang digunakan pada data dari server
            render: function (data) {
              // Pastikan data tidak null atau undefined
              if (data && data.length > 0) {
                // Menampilkan tautan dengan judul dari elemen pertama dalam array
                return `<a id="${data[0].id}" href="pengajuan/${data[0].link}">${data[0].judul}</a>`;
              } else {
                return "-";
              }
            },
          },
  
        {
            data: "statusPengajuans",
            render: (data) => {
              return data && data.length > 0 ? `<p>${data[0].status.status}</p>` : "-";
          },
        },
        {data: null,
            render: (data) => {
              return `
              <div class="d-flex gap-3 justify-content-center">
                <!-- Button trigger modal detail -->
                <button
                  type="button"
                  class="btn btn-primary detail"
                  data-bs-toggle="modal"
                  data-bs-target="#detail"
                  onclick="getById(${data.id})"
                >
                  Detail
                </button>
                <!-- Button trigger modal update -->
                <button
                  type="button"
                  class="btn btn-warning update"
                  data-bs-toggle="modal"
                  data-bs-target="#updatepengajuan"
                  onclick="tombolupdate(${data.id})"
                >
                  Update
                </button>
                <!-- Button trigger modal delete -->
                <button
                  type="button"
                  class="btn btn-danger delete"
                  onclick="deletePengajuan(${data.id})"
                  
                >
                  Delete
                </button>
              </div>`;
            },
          }

      ],
    });
  });
  

  $.ajax({
    method: "GET",
    url: "api/kategori",
    success: function (kategoris) {
      let select = $("#created-kategori");
      let selectupdate = $("#update-kategori");

      select.append('<option value="" selected hidden>-Select Kategori-</option>');
      selectupdate.append('<option value="" selected hidden>-Select Kategori-</option>');
      kategoris.forEach(function (kategori) {
        select.append(`<option each = "${kategori}" value = "${kategori.id}">${kategori.name}</option>`)
        selectupdate.append(`<option each = "${kategoris}" value = "${kategori.id}">${kategori.name}</option>`)
        console.log(kategori.name);

      });
    },
    error: function (err) {
      console.error("Error:", err);
    },
  });
 
  // Create
  $("#creating-pengajuan").click((event) => {
    event.preventDefault();

    let valueJudul = $("#created-judul").val();
    let valueLink = $("#created-link").val();
    let valueDeskripsi = $("#created-deskripsi").val();
    let valuePencipta = $("#created-pencipta").val();
    let valueKategori = $("#created-kategori").val();
  // $.ajax({
  //   method: "GET",
  //   url: "api/kategori/" + valueKategori,
  //   dataType: "JSON",
  //   contentType: "application/json",
  //   success: (detailKategori) => {
  //     console.log(detailKategori);

      $.ajax({
        method: "POST",
        url: "api/pengajuan",
        dataType: "JSON",
        contentType: "application/json",
        beforeSend: addCSRFToken(),
        data: JSON.stringify({
          judul: valueJudul,
          link_file: valueLink,
          deskripsi: valueDeskripsi,
          pencipta: valuePencipta,
          Kategori: detailKategori,

        }),
        success: (res) => {
          $("#create").modal("hide");
          $("#table-pengajuan").DataTable().ajax.reload();
          $("#created-name").val("");
          Swal.fire({
            position: "center",
            html:
              '<lottie-player src="/img/berhasil.json" background="transparent" speed="1" style="width: 300px; height: 150px;" class="mx-auto text-center" position: absolute; loop autoplay></lottie-player>',
            title: "pengajuan Sudah berhasil Ditambahkan",
            showConfirmButton: false,
            timer: 1000,
          });
        },
        error: (err) => {
          console.log(valueCode);
          console.log(valueName);
          console.log(err);
        },
      });
  //   },
  //   error: (err) => {
  //     console.log(err);
  //   },
  // });
});

 
 
 
  // $("#creating-pengajuan").click((event) => {
  //   event.preventDefault();

  //   let valueJudul = $("#created-judul").val();
  //   let valueLink = $("#created-link").val();
  //   let valueDeskripsi = $("#created-deskripsi").val();
  //   let valuePencipta = $("#created-pencipta").val();
  //   let valueJudule = $("#created-judul").val();
    // $.ajax({
    //   method: "POST",
    //   url: "api/kategori",
    //   dataType: "JSON",
    //   contentType: "application/json",
    //   beforeSend: addCSRFToken(),
    //   data: JSON.stringify({
    //     nama: valueNama,
    //   }),
  //     success: (res) => {
  //       $("#create").modal("hide");
  //       Swal.fire({
  //         position: "center",
  //         icon: "success",
  //         title: "Kategori anda berhasil dibuat!",
  //         showConfirmButton: false,
  //         timer: 2000,
  //       });
  //       $("#create-nama").val("");
  //       $("#table-kategori").DataTable().ajax.reload();
  //     },
  //     error: (err) => {
  //       // console.log(err);
  //       $("#create").modal("hide");
  //       Swal.fire({
  //         icon: "error",
  //         title: "Oops...",
  //         text: "Kategori anda tidak dapat dibuat!",
  //       });
  //       $("#create-nama").val("");
  //     },
  //   });
  // });
  
  // Detail
  function getById(id) {
    $.ajax({
      method: "GET",
      url: "api/pengajuan/" + id,
      dataType: "JSON",
      contentType: "application/json",
      success: (res) => {
        $("#detail-judul").text(res.files[0].judul);
        $("#detail-deskripsi").text(res.files[0].deskripsi);
        $("#detail-pencipta").text(res.files[0].pencipta);
        $("#detail-kategori").text(res.files[0].kategori.name);
        $("#detail-status").text(res.statusPengajuans[0].status.status);
        $("#detail-catatan").text(res.statusPengajuans[0].catatan);
        
        
      },
      error: (err) => {
        // console.log(err);
      },
    });
  }
  
  // Update
  function tombolupdate(id) {
    $("#updating-pengajuan").click((event) => {
        event.preventDefault();
        let date = new Date().toJSON();
        console.log(date)
        
        let valuestatus = "menunggu";
        let valuefiles = $("#updated-judul").val();
        let valuelink = $("#updated-link").val();
        let valuedeskripsi = $("#updated-deskripsi").val();
        let valuepencipta = $("#updated-pencipta").val();
        let valuekategori = $("#update-kategori").val();
        console.log(valuestatus);
    $.ajax({
      method: "GET",
      url: "api/pengajuan/" + id,
      dataType: "JSON",
      contentType: "application/json",
      success: (res) => {
console.log(res);
        if (res.statusPengajuans.status == valuestatus) {

            $.ajax({
                method: "PUT",
                url: "api/pengajuan/" + id,
                dataType: "json",
                contentType: "application/json",
                beforeSend: addCSRFToken(),
                data: JSON.stringify({
                  id: id,
                  status: valuestatus,
                  tanggal: valuedate,
                  judul: valuefiles,
                  link: valuelink,
                  deskripsi: valuedeskripsi,
                  pencipta: valuepencipta,
                  kategori: valuekategori  
                }),
                success: (res) => {
                  $("#update").modal("hide");
                  $("#table-pengajuan").DataTable().ajax.reload();
                  $("#updated-name").val("");
                  Swal.fire({
                    position: "center",
                    html:
                      '<lottie-player src="/img/update.json" background="transparent" speed="1.5" style="width: 400px; height: 200px;" class="mx-auto text-center" loop autoplay></lottie-player>',
                    title: "Pengajuan Sudah berhasil Diupdate",
                    showConfirmButton: false,
                    timer: 2000,
                  });
                  setTimeout(() => {
                   location.reload();
                 }, 2100);
                  console.log(res);
                },
                error: (err) => {
                  console.log(valueCode);
                  console.log(valueName);
                  console.log(detailregion);
                  console.log(err);
                },
              });
        } else {
            
        }
      },
      error: (err) => {
        // console.log(err);
      },
    });
});
  }
  



//   $("#update-kategori").click((event) => {
//     event.preventDefault();
//     let valueId = $("#update-id").val();
//     let valueNama = $("#update-nama").val();
  
//     $.ajax({
//       method: "PUT",
//       url: "api/kategori/" + valueId,
//       dataType: "JSON",
//       contentType: "application/json",
//       beforeSend: addCSRFToken(),
//       data: JSON.stringify({
//         nama: valueNama,
//       }),
//       success: (res) => {
//         $("#update").modal("hide");
//         Swal.fire({
//           position: "center",
//           icon: "success",
//           title: "Kategori anda berhasil diedit!",
//           showConfirmButton: false,
//           timer: 2000,
//         });
//         $("#update-nama").val("");
//         $("#table-kategori").DataTable().ajax.reload();
//       },
//       error: (err) => {
//         // console.log(err);
//         $("#update").modal("hide");
//         Swal.fire({
//           icon: "error",
//           title: "Oops...",
//           text: "Kategori anda tidak dapat diedit!",
//         });
//         $("#update-nama").val("");
//       },
//     });
//   });
  
//   // Delete
  function deletePengajuan(id) {
    const swalWithBootstrapButtons = swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger",
      },
      buttonStyling: false,
    });
    swalWithBootstrapButtons
      .fire({
        title: "Apa kamu yakin?",
        text: "Kamu tidak akan dapat memulihkannya!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Ya, hapus!",
        cancelButtonText: "Tidak!",
        reverseButtons: true,
      })
      .then((result) => {
        if (result.isConfirmed) {
          $.ajax({
            method: "DELETE",
            url: "api/pengajuan/del/" + id,
            dataType: "JSON",
            contentType: "application/json",
            beforeSend: addCSRFToken(),
            success: (res) => {
              swalWithBootstrapButtons.fire(
                "Terhapus!",
                "Data anda berhasil dihapus",
                "Berhasil"
              );
              $("#table-pengajuan").DataTable().ajax.reload();
            },
            error: (err) => {
              // console.log(err);
              Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Pengajuan anda tidak dapat dihapus!",
              });
            },
          });
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          swalWithBootstrapButtons.fire({
            title: "Dibatalkan",
            text: "Data anda aman",
            icon: "error",
          });
        }
      });
  }