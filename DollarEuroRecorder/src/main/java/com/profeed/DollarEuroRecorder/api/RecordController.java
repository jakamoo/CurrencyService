package com.profeed.DollarEuroRecorder.api;


import com.profeed.DollarEuroRecorder.dto.RecordDto;
import com.profeed.DollarEuroRecorder.entity.Record;
import com.profeed.DollarEuroRecorder.service.RecordService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@AllArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping("/getAll")
    public ResponseEntity<List<RecordDto>> getRecords(){

        List<RecordDto> returnList= recordService.getRecords();

        return ResponseEntity.ok(returnList);


    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<RecordDto> getRecord(@PathVariable("id") long id){
        RecordDto record= recordService.getRecord(id);

        return ResponseEntity.ok(record);
    }

    @PostMapping("/create")
    public ResponseEntity <RecordDto> createRecord(@RequestBody RecordDto recordDto){

        RecordDto returnRecordDto = recordService.createRecord(recordDto);
        return ResponseEntity.ok(returnRecordDto);

    }



}
