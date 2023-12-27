package id.metrodataacademy.clientapp.models;

import java.util.List;

// import javax.management.relation.Role;

// import org.springframework.context.annotation.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private Boolean isEnabled;
    private Boolean isAccountNonLocked;
    private String username;
    private String password;
    private Profile profile;
    private List<Role> roles;    
    
}
