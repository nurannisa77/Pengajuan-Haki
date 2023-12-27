package id.metrodataacademy.clientapp.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pengajuan {


    private Integer id;
    private List<StatusPengajuan> statusPengajuans;
    private List<ProfilePengajuan> profilePengajuans;
    private List<File> files;
    private Profile profile;


}