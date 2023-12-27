package id.metrodataacademy.serverapp.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.metrodataacademy.serverapp.models.Kategori;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori,Integer> {
    public Optional<Kategori> findByName(String name);
}
