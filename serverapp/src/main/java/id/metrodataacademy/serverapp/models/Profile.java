package id.metrodataacademy.serverapp.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer id;

    @Column(name = "profile_name", nullable = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true, length = 20)
    @Email(message = "Please input valid email!!")
    private String email;

    @Column(length = 16, unique = true)
    private String phone;

    @Column(name = "alamat_perusahaan", columnDefinition="TEXT")
    private String alamat;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy = "profile")
    private List<ProfilePengajuan> profilePengajuans;

    @OneToMany(mappedBy = "profile")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Pengajuan> pengajuans;
}