package com.profeed.DollarEuroRecorder.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RecordDto {
    private Date releaseDate;
    private String currencyType;
    private String source;
    private float buyPrice;
    private float sellPrice;
}
