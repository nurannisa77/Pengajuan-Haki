package id.metrodataacademy.serverapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.metrodataacademy.serverapp.models.Profile;
import id.metrodataacademy.serverapp.models.ProfilePengajuan;

@Repository
public interface ProfilePengajuanRepository extends JpaRepository<ProfilePengajuan,Integer> {
    
}