package id.metrodataacademy.clientapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.metrodataacademy.clientapp.models.StatusPengajuan;

@Service
public class StatusPengajuanService {

        @Value("${server.base.url}/statusPengajuan")
        private String url;

        @Autowired
        private RestTemplate restTemplate;

        // get all
        public List<StatusPengajuan> getAll() {
                return restTemplate
                                .exchange(
                                                url,
                                                HttpMethod.GET,
                                                null,
                                                new ParameterizedTypeReference<List<StatusPengajuan>>() {
                                                })
                                .getBody();
                
        }

        public StatusPengajuan create(StatusPengajuan statusPengajuan) {
                return restTemplate
                                .exchange(
                                                url,
                                                HttpMethod.POST,
                                                new HttpEntity<>(statusPengajuan),
                                                StatusPengajuan.class)
                                .getBody();
        }

        public StatusPengajuan getById(Integer id) {
                return restTemplate
                                .exchange(
                                                url + "/" + id,
                                                HttpMethod.GET,
                                                null,
                                                StatusPengajuan.class)
                                .getBody();
        }

        public StatusPengajuan update(Integer id, StatusPengajuan statusPengajuan) {
                return restTemplate
                                .exchange(
                                                url.concat("/" + id),
                                                HttpMethod.PUT,
                                                new HttpEntity<>(statusPengajuan),
                                                StatusPengajuan.class)
                                .getBody();
        }

        public StatusPengajuan delete(Integer id) {
                return restTemplate
                                .exchange(
                                                url.concat("/" + id),
                                                HttpMethod.DELETE,
                                                null,
                                                StatusPengajuan.class)
                                .getBody();
        }
}
