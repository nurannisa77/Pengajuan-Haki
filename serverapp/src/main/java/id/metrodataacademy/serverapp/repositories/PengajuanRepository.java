package id.metrodataacademy.serverapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.metrodataacademy.serverapp.models.Pengajuan;

@Repository
public interface PengajuanRepository extends JpaRepository<Pengajuan,Integer> {

}
