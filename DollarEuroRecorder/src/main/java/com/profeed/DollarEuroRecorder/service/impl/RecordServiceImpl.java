package com.profeed.DollarEuroRecorder.service.impl;

import com.profeed.DollarEuroRecorder.dto.RecordDto;
import com.profeed.DollarEuroRecorder.entity.Record;
import com.profeed.DollarEuroRecorder.repository.RecordRepository;
import com.profeed.DollarEuroRecorder.service.RecordService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final ModelMapper modelMapper;

  /*  public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
*/

    @Override
    public List<RecordDto> getRecords() {
        List<Record> records = recordRepository.findAll();
        List<RecordDto> dtos= records.stream().map(record-> modelMapper.map(record,RecordDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public RecordDto createRecord(RecordDto recordDto) {
        Record record = modelMapper.map(recordDto,Record.class);

        return modelMapper.map(recordRepository.save(record),RecordDto.class);
    }

    @Override
    public RecordDto getRecord(long id) {

        Optional <Record> record = recordRepository.findById(id);

        if(record.isPresent())
                return modelMapper.map(record.get(),RecordDto.class);

        return null;
    }
}
