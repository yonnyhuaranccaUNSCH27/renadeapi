package ipd.renade.renadeapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/dniipd")
@RequiredArgsConstructor
public class DniIPDController {

    private final RestTemplate restTemplate;

    @PostMapping("/dni/{dni}")
    public ResponseEntity<?> consultarDniIPD(@PathVariable String dni) {
        String authUrl = "http://172.16.10.112:81/ServiciosIPD/web/token";
        String consultaUrl = "http://172.16.10.112:81/ServiciosIPD/web/reniec/consulta-dni/" + dni;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("email", "nmamani@ipd.gob.pe");
        params.add("password", "Puno.2k24");

        HttpEntity<?> authRequest = new HttpEntity<>(params, headers);
        ResponseEntity<Map> authResponse = restTemplate.postForEntity(authUrl, authRequest, Map.class);

        String token = (String) authResponse.getBody().get("data");

        HttpHeaders consultaHeaders = new HttpHeaders();
        consultaHeaders.set("Authorization", token);
        consultaHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> consultaRequest = new HttpEntity<>(consultaHeaders);

        ResponseEntity<String> response = restTemplate.exchange(consultaUrl, HttpMethod.GET, consultaRequest, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
