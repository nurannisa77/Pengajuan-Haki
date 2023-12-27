package id.metrodataacademy.clientapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.metrodataacademy.clientapp.models.File;



@Service
public class FileService {

        @Value("${server.base.url}/File")
        private String url;

        @Autowired
        private RestTemplate restTemplate;
  
        
// get all 
        public List<File> getAll() {
                return restTemplate
                .exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<File>>() {})
                   .getBody();
        }

        public File create(File file) {
                return restTemplate
                .exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(file),
                    File.class)
                    .getBody();
        }

        public File getById(Integer id) {
                return restTemplate
                .exchange(
                    url + "/" + id,
                    HttpMethod.GET,
                    null,
                    File.class)
                    .getBody();
        }

        public File update(Integer id, File file) {
                return restTemplate
                .exchange(
                    url.concat("/" + id),
                    HttpMethod.PUT,
                    new HttpEntity<>(file),
                    File.class)
                   .getBody();
        }

        public File delete(Integer id) {
                return restTemplate
                .exchange(
                    url.concat("/" + id),
                    HttpMethod.DELETE,
                    null,
                    File.class)
                    .getBody();
        }
    }

