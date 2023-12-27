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
import id.metrodataacademy.clientapp.models.Pengajuan;
import id.metrodataacademy.clientapp.models.StatusPengajuan;

@Service
public class PengajuanService {

        @Value("${server.base.url}/pengajuan")
        private String url;

        @Autowired
        private RestTemplate restTemplate;

        // get all
        public List<Pengajuan> getAll() {
                return restTemplate
                 .exchange(
                 url,
                 HttpMethod.GET,
                 null,
                 new ParameterizedTypeReference<List<Pengajuan>>() {
                 })
                 .getBody();

//                 ResponseEntity<List<Pengajuan>> response = restTemplate.exchange(
//   url,
//   HttpMethod.GET,  null,
//   new ParameterizedTypeReference<List<Pengajuan>>(){});
// List<Pengajuan> listPengajuan = response.getBody();

//  return listPengajuan;
        }

        public Pengajuan create(Pengajuan pengajuan) {
                return restTemplate
                                .exchange(
                                 url,
                                 HttpMethod.POST,
                                 new HttpEntity<>(pengajuan),
                                 Pengajuan.class)
                                .getBody();
        }

        public Pengajuan getById(Integer id) {
                return restTemplate
                                .exchange(
                                url + "/" + id,
                                HttpMethod.GET,
                                null,
                                Pengajuan.class)
                                .getBody();
        }

        public Pengajuan update(Integer id, Pengajuan pengajuan) {
                return restTemplate
                                .exchange(
                                                url.concat("/" + id),
                                                HttpMethod.PUT,
                                                new HttpEntity<>(pengajuan),
                                                Pengajuan.class)
                                .getBody();
        }

        public Pengajuan delete(Integer id) {
                return restTemplate
                                .exchange(
                                                url.concat("/del/" + id),
                                                HttpMethod.DELETE,
                                                null,
                                                Pengajuan.class)
                                .getBody();
        }
}
