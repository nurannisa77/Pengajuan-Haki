package id.metrodataacademy.clientapp.models;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusPengajuan {

    private Integer id;
    private String catatan;
    private Status status;
    private Pengajuan pengajuan;  
}
