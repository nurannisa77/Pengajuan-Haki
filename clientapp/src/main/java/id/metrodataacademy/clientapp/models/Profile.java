package id.metrodataacademy.clientapp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String alamat;
    private User user;
    private List<ProfilePengajuan> profilePengajuans;
    private List<Pengajuan> pengajuans;
    
}
