package id.metrodataacademy.clientapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import id.metrodataacademy.clientapp.models.Profile;



@Service
public class ProfileService {

        @Value("${server.base.url}/profile")
        private String url;

        @Autowired
        private RestTemplate restTemplate;
  
        

        public List<Profile> getAll() {
                return restTemplate
                .exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Profile>>() {})
                .getBody();
        }

//          public ResponseEntity<Profile> All(String name) {
//     Profile profile = restTemplate
//         .exchange(
//             url.concat("/profile?username=" + name),
//             HttpMethod.GET,
//             null,
//             Profile.class)
//         .getBody();
//     return ResponseEntity.ok().body(profile);
// }

public Profile All(String name){
         return restTemplate
                .exchange(
                url + "/profile?username=" + name,
                HttpMethod.GET,
                null,
                Profile.class)
                .getBody();

}


        public Profile getById(Integer id) {
                return restTemplate
                .exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                Profile.class)
                .getBody();
        }

        public Profile update(Integer id, Profile profile) {
                return restTemplate
                .exchange(
                url.concat("/" + id),
                HttpMethod.PUT,
                new HttpEntity<>(profile),
                Profile.class)
                .getBody();
        }

        public Profile delete(Integer id) {
                return restTemplate
                .exchange(
                url.concat("/" + id),
                HttpMethod.DELETE,
                null,
                Profile.class)
                .getBody();
        }

        public Profile getProfile(String name) {
                return restTemplate
                        .exchange(
                                url.concat("?username=" + name),
                                HttpMethod.GET,
                                null,
                                Profile.class)
                        .getBody();
            }
    }

