package id.metrodataacademy.clientapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.metrodataacademy.clientapp.models.ProfilePengajuan;



@Service
public class ProfilePengajuanService {

        @Value("${server.base.url}/profilePengajuan")
        private String url;

        @Autowired
        private RestTemplate restTemplate;
  
        

        public List<ProfilePengajuan> getAll() {
                return restTemplate
                .exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProfilePengajuan>>() {})
                   .getBody();
        }

        public ProfilePengajuan create(ProfilePengajuan profilePengajuan) {
                return restTemplate
                .exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(profilePengajuan),
                    ProfilePengajuan.class)
                    .getBody();
        }

        public ProfilePengajuan getById(Integer id) {
                return restTemplate
                .exchange(
                    url + "/" + id,
                    HttpMethod.GET,
                    null,
                    ProfilePengajuan.class)
                    .getBody();
        }

        public ProfilePengajuan update(Integer id, ProfilePengajuan profilePengajuan) {
                return restTemplate
                .exchange(
                    url.concat("/" + id),
                    HttpMethod.PUT,
                    new HttpEntity<>(profilePengajuan),
                    ProfilePengajuan.class)
                   .getBody();
        }

        public ProfilePengajuan delete(Integer id) {
                return restTemplate
                .exchange(
                    url.concat("/" + id),
                    HttpMethod.DELETE,
                    null,
                    ProfilePengajuan.class)
                    .getBody();
        }
    }

