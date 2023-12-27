package id.metrodataacademy.clientapp.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    private Integer id;
    private String judul;
    private String link;
    private String deskripsi;
    private String pencipta;
    private Kategori kategori;
    private Pengajuan pengajuan;


    
}