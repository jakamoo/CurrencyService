package com.profeed.DollarEuroRecorder.service;


import com.profeed.DollarEuroRecorder.dto.RecordDto;
import com.profeed.DollarEuroRecorder.entity.RecordEntity;
import com.profeed.DollarEuroRecorder.exception.ResponseIsNullException;
import com.profeed.DollarEuroRecorder.repository.RecordRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class CurrencyService {
    private RestTemplate restTemplate;


    private RecordRepository recordRepository;

    @Scheduled(fixedRate = 2000L)
    public void dollarRecorder() throws InterruptedException {
        System.out.println("Hey" + new Date());
        restTemplate = new RestTemplate();
        LinkedHashMap<String, List<Map<String, Object>>> map = restTemplate
                .getForObject("http://hasanadiguzel.com.tr/api/kurgetir", LinkedHashMap.class);
        log.info("Object is get from the url!");
        Map<String, Object> valueList = map.get("TCMB_AnlikKurBilgileri").get(0);
        if (valueList.isEmpty()) {
            log.error("Response is null!");
            throw new ResponseIsNullException();
        }
        RecordEntity recordEntity = RecordEntity.builder()
                .buyPrice((Double) valueList.get("ForexBuying"))
                .source("http://hasanadiguzel.com.tr/api/kurgetir")
                .currencyType("USD")
                .releaseDate(LocalDateTime.now())
                .sellPrice((Double) valueList.get("ForexSelling")).build();


        recordRepository.save(recordEntity);

    }
    @Scheduled(fixedRate = 2000L)
    public void euroRecorder() throws InterruptedException {
        System.out.println("Hey" + new Date());
        restTemplate = new RestTemplate();
        LinkedHashMap<String, List<Map<String, Object>>> map = restTemplate
                .getForObject("http://hasanadiguzel.com.tr/api/kurgetir", LinkedHashMap.class);
        log.info("Object is get from the url!");
        Map<String, Object> valueList = map.get("TCMB_AnlikKurBilgileri").get(3);
        if (valueList.isEmpty()) {
            log.error("Response is null!");
            throw new ResponseIsNullException();
        }
        RecordEntity recordEntity = RecordEntity.builder()
                .buyPrice((Double) valueList.get("ForexBuying"))
                .source("hasanAdiGuzel")
                .currencyType("EURO")
                .releaseDate(LocalDateTime.now())
                .sellPrice((Double) valueList.get("ForexSelling")).build();


        recordRepository.save(recordEntity);

    }


   // @Scheduled(fixedRate = 2000L)
    public void EuroRecorderX() throws InterruptedException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization","apikey 62bYAQflkagblLSuolfSk1:6GB4dki5eQkx4Ha69Jx28m");
        headers.add("content-type", "application/json");

        HttpEntity<RecordService> entity=new HttpEntity<RecordService>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url="https://api.collectapi.com/economy/currencyToAll?int=10&base=USD";

        ResponseEntity<RecordEntity>responseEntity=restTemplate.exchange(url, HttpMethod.GET,entity,RecordEntity.class);
        LinkedHashMap<String, List<Map<String, Object>>> map = restTemplate.exchange(url, HttpMethod.GET,entity,LinkedHashMap.class).getBody();

        log.info("Object is get from the url collectApi!");
        Map<String, Object> valueList = map.get("result").get(1);
        if (valueList.isEmpty()) {
            log.error("Response is null!");
            throw new ResponseIsNullException();
        }
        RecordEntity recordEntity = RecordEntity.builder()
                .buyPrice((Double) valueList.get("data"))
                .source("collectApi")
                .currencyType("EURO")
                .releaseDate(LocalDateTime.now())
                .sellPrice((Double) valueList.get("rate")).build();


        recordRepository.save(recordEntity);





    }


}
