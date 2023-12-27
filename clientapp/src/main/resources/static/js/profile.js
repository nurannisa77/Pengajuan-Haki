// // Sticky Top Navbar
// $(document).ready(function () {
//   $(window).scroll(function () {
//       if ($(window).scrollTop() > 30) {
//           $(".navbar").addClass("top-nav");
//       } else {
//           $(".navbar").removeClass("top-nav");
//       }
//   });
// });

// // // Get Profile
// // const getUserProfile = () => {
// //   const profileId = $("#userId");
// //   const profileName = $("#userName");
// //   const porfileEmail = $("#userEmail");
// //   const profilePhone = $("#userPhone");
// //   const iduser = $("#iduser");

// //   $.ajax({
// //       url: "/profile" + iduser,
// //       type: "GET",
// //       success: (res) => {
// //           profileId.val(res.id);
// //           profileName.val(res.name);
// //           porfileEmail.val(res.email);
// //           profilePhone.val(res.phone);
// //       },
// //       error: () => {
// //           Swal.fire({
// //               position: "center",
// //               icon: "error",
// //               title: "Sorry, user not found!",
// //               showConfirmButton: false,
// //               timer: 2000,
// //           });
// //       },
// //   });}

// // $("#userUpdateId").on("click", () => {
// //   $.ajax({
// //     url: `/api/profile/${profileId.text()}`,
// //     type: "GET",
// //     success: (res) => {
// //       $("#e-profileId").val(res.id);
// //       $("#e-profileName").val(res.name);
// //       $("#e-profileEmail").val(res.email);
// //       $("#e-profilePhone").val(res.phone);
// //       $("#e-profileAlamat_perusahaan").val(res.alamat_perusahaan);

// //     },
// //     error: () => {
// //       Swal.fire({
// //         position: "center",
// //         icon: "error",
// //         title: "Sorry, user not found!",
// //         showConfirmButton: false,
// //         timer: 2000,
// //       });
// //     },
// //   });
// // });

// // // update profile user
// // $("#u-profUser").click((e) => {
// //   e.preventDefault();

// //   const id = $("#e-profileId").val();
// //   const name = $("#e-profileName").val();
// //   const email = $("#e-profileEmail").val();
// //   const phone = $("#e-profilePhone").val();
// //   const alamat_perusahaan = $("e-profileAlamat_perusahaan").val();

// // console.log(id, name, email, phone, alamat_perusahaan )

// //   $.ajax({
// //     url: `/api/profile/${id}`,
// //     method: "PUT",
// //     dataType: "JSON",
// //     contentType: "application/json",
// //     beforeSend: addCSRFToken(),
// //     data: JSON.stringify({
// //       name: name,
// //       email: email,
// //       phone: phone,
// //       alamat_perusahaan: alamat_perusahaan
// //     }),
// //     success: (res) => {
// //       console.log(res);
// //       Swal.fire({
// //         position: "center",
// //         icon: "success",
// //         title: "Profile has been updated!",
// //         showConfirmButton: false,
// //         timer: 2000,
// //       });
// //       $("#updateProfile").modal("hide");
// //       $("#profileModal").modal("hide");
// //     },
// //     error: () => {
// //       Swal.fire({
// //         position: "center",
// //         icon: "error",
// //         title: "Sorry, profile not updated!",
// //         showConfirmButton: false,
// //         timer: 2000,
// //       });
// //     },
// //   });
// // });
// function getUserProfile() {
//   const profileId = $("#userId");
//   const profileName = $("#userName");
//   const profileEmail = $("#userEmail");
//   const profilePhone = $("#userPhone");
//   const profileAlamat_perusahaan = $("#userAlamat_perusahaan");

//   $.ajax({
//     method: "GET",
//     url: "/api/profile/profile?username=sandi",
//     // data: { name: username },
//     dataType: "JSON",
//     contentType: "application/json",
//     beforeSend: addCSRFToken(),
//     success: (res) => {
//       console.log(res)
//       console.log(res.id);
//       profileId.text(res.id);
//       profileName.text(res.name);
//       profileEmail.text(res.email);
//       profilePhone.text(res.phone);
//       profileAlamat_perusahaan.text(res.alamat_perusahaan);
//     },
//     error: (err) => {
//       console.log("error = " + err);
//       Swal.fire({
//         position: "center",
//         icon: "error",
//         title: "Sorry, user not found!",
//         showConfirmButton: false,
//         timer: 2000,
//       });
//     },
//   });
// }

// $("#UpdateId").click(() => {
//   $.ajax({
//     url: "/employee/" + profilId.val(),
//     method: "GET",
//     success: (res) => {
//       // console.log(res.id);
//       $("#profileId").val(res.id);
//       $("#nameProfile").val(res.name);
//       $("#emailProfile").val(res.email);
//       $("#phoneProfile").val(res.phone);
//       console.log(res.id);
//     },
//   });
// });

// $("#updateProfile").click((event) => {
//   event.preventDefault();
//   const updatedName = $("#nameProfile").val();
//   const updatedEmail = $("#emailProfile").val();
//   const updatedPhone = $("#phoneProfile").val();

//   const profileUpdate = {
//     name: updatedName,
//     email: updatedEmail,
//     phone: updatedPhone,
//   };

//   $.ajax({
//     url: "/employee/" + profilId.val(),
//     method: "PUT",
//     contentType: "application/json",
//     beforeSend: addCSRFToken(),
//     data: JSON.stringify(profileUpdate),
//     success: (res) => {
//       console.log(res);
//       $("#exampleModal").modal("hide");
//       Swal.fire({
//         position: "center",
//         icon: "success",
//         title: "Your Profile has been Updated!",
//         showConfirmButton: false,
//         timer: 2000,
//       });
//     },
//     error: () => {
//       Swal.fire({
//         position: "center",
//         icon: "error",
//         title: "Failed to update profile!",
//         showConfirmButton: false,
//         timer: 2000,
//       });
//     },
//   });
// });

function beforeUpdateProfile() {
  let userId = $("#userId").text();
  // console.log(userId);

  $.ajax({
    method: "GET",
    url: "api/profile/" + userId,
    dataType: "JSON",
    contentType: "application/json",
    success: (res) => {
      console.log(res);
      $("#updateId").val(`${res.id}`);
      $("#updateName").val(`${res.name}`);
      $("#updateEmail").val(`${res.email}`);
      $("#updatePhone").val(`${res.phone}`);
      $("#updateAlamat").val(`${res.alamat}`);
    },
    error: (err) => {
      console.log(err);
    },
  });
}

$("#update").click((event) => {
  event.preventDefault();

  let Id = $("#updateId").val();
  let name = $("#updateName").val();
  let email = $("#updateEmail").val();
  let phone = $("#updatePhone").val();
  let alamat = $("#updateAlamat").val();

  $.ajax({
    method: "PUT",
    url: "api/profile/update/" + Id, // Use the user's ID here
    dataType: "JSON",
    contentType: "application/json",
    beforeSend: addCSRFToken(),
    data: JSON.stringify({
      name: name,
      email: email,
      phone: phone,
      alamat: alamat,
    }),
    success: (res) => {
      // Update successful
      $("#updateProfile").modal("hide");
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Your Profile has been updated...",
        showConfirmButton: false,
        timer: 2000,
      });
      
    },
    error: (err) => {
      console.log(err);
    },
  });
});
