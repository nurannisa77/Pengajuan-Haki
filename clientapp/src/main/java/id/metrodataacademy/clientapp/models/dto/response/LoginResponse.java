package id.metrodataacademy.clientapp.models.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String username;
    private Integer id;
    private String alamat;
    private String name;
    private String email;
    private String phone;
    private List<String> authorities;
    
}
