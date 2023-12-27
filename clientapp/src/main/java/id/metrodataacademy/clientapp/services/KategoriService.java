package id.metrodataacademy.clientapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.metrodataacademy.clientapp.models.Kategori;

@Service
public class KategoriService {

        @Value("${server.base.url}/kategori")
        private String url;

        @Autowired
        private RestTemplate restTemplate;

        // get all
        public List<Kategori> getAll() {
                return restTemplate
                                .exchange(
                                                url,
                                                HttpMethod.GET,
                                                null,
                                                new ParameterizedTypeReference<List<Kategori>>() {
                                                })
                                .getBody();
        }

        public Kategori create(Kategori kategori) {
                return restTemplate
                                .exchange(
                                                url,
                                                HttpMethod.POST,
                                                new HttpEntity<>(kategori),
                                                Kategori.class)
                                .getBody();
        }

        public Kategori getById(Integer id) {
                return restTemplate
                                .exchange(
                                                url + "/" + id,
                                                HttpMethod.GET,
                                                null,
                                                Kategori.class)
                                .getBody();
        }

        public Kategori update(Integer id, Kategori kategori) {
                return restTemplate
                                .exchange(
                                                url.concat("/" + id),
                                                HttpMethod.PUT,
                                                new HttpEntity<>(kategori),
                                                Kategori.class)
                                .getBody();
        }

        public Kategori delete(Integer id) {
                return restTemplate
                                .exchange(
                                                url.concat("/" + id),
                                                HttpMethod.DELETE,
                                                null,
                                                Kategori.class)
                                .getBody();
        }
}
