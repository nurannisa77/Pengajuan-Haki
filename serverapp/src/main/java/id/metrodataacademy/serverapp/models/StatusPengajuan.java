package id.metrodataacademy.serverapp.models;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_status_pengajuan")
public class StatusPengajuan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "status_pengajuan_id")
  private Integer id;

  @Column(nullable = false)
  private String catatan;

  @ManyToOne
  @JoinColumn(name = "status_id", nullable = false)
  private Status status;

  @ManyToOne
  @JoinColumn(name = "pengajuan_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Pengajuan pengajuan;  
}