package id.metrodataacademy.serverapp.models.dto.request;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfileRequest {
    private String name;
    private String email;
    private String username;
    private String password;
    private Integer role_id;
}