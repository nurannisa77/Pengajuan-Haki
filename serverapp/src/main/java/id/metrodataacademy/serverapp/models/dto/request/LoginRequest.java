package id.metrodataacademy.serverapp.models.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
