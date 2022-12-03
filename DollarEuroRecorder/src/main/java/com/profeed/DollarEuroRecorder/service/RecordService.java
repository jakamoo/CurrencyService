package com.profeed.DollarEuroRecorder.service;

import com.profeed.DollarEuroRecorder.dto.RecordDto;
import com.profeed.DollarEuroRecorder.entity.Record;

import java.util.List;

public interface RecordService {

    List<RecordDto> getRecords();
    RecordDto createRecord(RecordDto recordDto);

    RecordDto getRecord(long id);
}
