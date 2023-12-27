package id.metrodataacademy.serverapp.models.dto.request;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PengajuanRequest {
    private String judul;
    private String link_file;
    private String deskripsi;
    private String pencipta;
    private Integer kategori_id;
}
