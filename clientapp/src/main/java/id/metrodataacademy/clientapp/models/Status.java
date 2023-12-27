package id.metrodataacademy.clientapp.models;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    private Integer id;
    private String status;
    private List<StatusPengajuan> statusPengajuans;
    
}
