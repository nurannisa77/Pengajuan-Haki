package id.metrodataacademy.serverapp.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.metrodataacademy.serverapp.models.File;

@Repository
public interface FileRepository extends JpaRepository<File,Integer> {
    public Optional<File> findByJudul(String judul);
}
