package id.metrodataacademy.serverapp.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    private Integer id;
    private Boolean isEnabled = true;
    private Boolean isAccountNonLocked = true;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, name = "sandi")
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name = "profile_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Profile profile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    name = "tb_user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;    
}