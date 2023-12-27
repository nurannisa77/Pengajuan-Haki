package id.metrodataacademy.serverapp.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import id.metrodataacademy.serverapp.models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    public Optional<Profile> findByName(String name);
    
    @Query("SELECT e FROM Profile e WHERE e.user.username = :username")
    public Profile findProfileByUsername(@Param("username") String username);
}
