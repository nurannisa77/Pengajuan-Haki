package id.metrodataacademy.serverapp.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_pengajuan")
public class Pengajuan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pengajuan_id")
  private Integer id;

  @OneToMany(mappedBy = "pengajuan")
  private List<StatusPengajuan> statusPengajuans;

  @OneToMany(mappedBy = "pengajuan")
  private List<ProfilePengajuan> profilePengajuans;
  
  @OneToMany(mappedBy = "pengajuan")
  private List<File> files;

  @ManyToOne
  @JoinColumn(name = "profile_id", nullable = false)
  private Profile profile;
}