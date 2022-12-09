package com.profeed.DollarEuroRecorder.controller;


import com.profeed.DollarEuroRecorder.dto.RecordDto;
import com.profeed.DollarEuroRecorder.service.RecordService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;



    @GetMapping("/getBySource/{source}")
    public ResponseEntity<List<RecordDto>> getRecordBySource(@PathVariable("source") String source) {
        List<RecordDto> record = recordService.getRecords(source,"source");

        return ResponseEntity.ok(record);
    }

    @GetMapping("/getByDate/{date}")
    public ResponseEntity<List<RecordDto>> getRecordByDate(@PathVariable("date") String date) {
        List<RecordDto> record = recordService.getRecords(date,"date");

        return ResponseEntity.ok(record);
    }

    @GetMapping("/getByCurrencyType/{type}")
    public ResponseEntity<List<RecordDto>> getRecordByCurrencyType(@PathVariable("type") String type) {
        List<RecordDto> record = recordService.getRecords(type,"currencyType");

        return ResponseEntity.ok(record);
    }



    @PostMapping("/create")
    public ResponseEntity<RecordDto> createRecord(@RequestBody RecordDto recordDto) {

        RecordDto returnRecordDto = recordService.createRecord(recordDto);
        return ResponseEntity.ok(returnRecordDto);

    }



}
