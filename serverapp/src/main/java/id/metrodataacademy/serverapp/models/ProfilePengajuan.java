package id.metrodataacademy.serverapp.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_profile_pengajuan")
public class ProfilePengajuan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "profile_pengajuan_id")
  private Integer id;

  @Column(nullable = false, name = "tanggal_pengajuan")
  private LocalDateTime tanggal;

  @ManyToOne
  @JoinColumn(name = "profile_id", nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Profile profile;

  @ManyToOne
  @JoinColumn(name = "pengajuan_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Pengajuan pengajuan;  
}