package com.profeed.DollarEuroRecorder.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RecordDto {
    private String source;
    private Double buyPrice;
    private Double sellPrice;
    private String releaseDate;
    private String currencyType;
}
