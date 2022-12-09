package com.profeed.DollarEuroRecorder.service.impl;

import com.profeed.DollarEuroRecorder.dto.RecordDto;
import com.profeed.DollarEuroRecorder.entity.RecordEntity;
import com.profeed.DollarEuroRecorder.repository.RecordRepository;
import com.profeed.DollarEuroRecorder.service.RecordService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final ModelMapper modelMapper;

  /*  public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
*/

    @Override
    public List<RecordDto> getRecords(String var,String type) {

        List<RecordEntity> recordEntities;

       switch (type){
           case "date": recordEntities=recordRepository.findByReleaseDate(var);
               break;

               case "currencyType": recordEntities=recordRepository.findByCurrencyType(var);
                break;

           case "source":  recordEntities=recordRepository.findBySource(var);
                break;

           default: throw new RuntimeException("Invalid request");
       }


        return recordEntities.stream().map(recordEntity -> modelMapper.map(recordEntity, RecordDto.class)).collect(Collectors.toList());
    }

    @Override
    public RecordDto createRecord(RecordDto recordDto) {
        RecordEntity recordEntity = modelMapper.map(recordDto, RecordEntity.class);

        return modelMapper.map(recordRepository.save(recordEntity), RecordDto.class);
    }

}

