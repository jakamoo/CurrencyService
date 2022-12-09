package com.profeed.DollarEuroRecorder.service;

import com.profeed.DollarEuroRecorder.dto.RecordDto;
import org.aspectj.weaver.ast.Var;


import java.util.List;

public interface RecordService {

    List<RecordDto> getRecords(String var, String type);
    RecordDto createRecord(RecordDto recordDto);

    //RecordDto getRecord(String var, String Type);

}
