$("#profileModal").click((event) => {
    event.preventDefault();
  
    let profileId = $("#userId");
    let profileName = $("#userName");
    let profileEmail = $("#userEmail");
    let profilePhone = $("#userPhone");
    let profileAlamat_perusahaan = $("#userAlamat_perusahaan");
  
    $.ajax({
      method: "GET",
      url: "/profile",
      dataType: "JSON",
      contentType: "application/json",
      success: (res) => {
        console.log(res.id);
        profileId.val(res.id);
        profileName.text(res.name);
        profileEmail.text(res.email);
        profilePhone.text(res.phone);
        profilePhone.text(res.phone);
        profileAlamat_perusahaan.text(res.alamat_perusahaan);
      },
      error: (err) => {
        console.log("error = " + err);
        Swal.fire({
          position: "center",
          icon: "error",
          title: "Sorry, user not found!",
          showConfirmButton: false,
          timer: 2000,
        });
      },
    });
    $("#UpdateId").click(() => {
      $.ajax({
        url: "/employee/" + profilId.val(),
        method: "GET",
        success: (res) => {
          // console.log(res.id);
          $("#profileId").val(res.id);
          $("#nameProfile").val(res.name);
          $("#emailProfile").val(res.email);
          $("#phoneProfile").val(res.phone);
          console.log(res.id);
        },
      });
    });
  
    $("#updateProfile").click((event) => {
      event.preventDefault();
      const updatedName = $("#nameProfile").val();
      const updatedEmail = $("#emailProfile").val();
      const updatedPhone = $("#phoneProfile").val();
  
      const profileUpdate = {
        name: updatedName,
        email: updatedEmail,
        phone: updatedPhone,
      };
  
      $.ajax({
        url: "/employee/" + profilId.val(),
        method: "PUT",
        contentType: "application/json",
        beforeSend: addCSRFToken(),
        data: JSON.stringify(profileUpdate),
        success: (res) => {
          console.log(res);
          $("#exampleModal").modal("hide");
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Your Profile has been Updated!",
            showConfirmButton: false,
            timer: 2000,
          });
        },
        error: () => {
          Swal.fire({
            position: "center",
            icon: "error",
            title: "Failed to update profile!",
            showConfirmButton: false,
            timer: 2000,
          });
        },
      });
    });
  });