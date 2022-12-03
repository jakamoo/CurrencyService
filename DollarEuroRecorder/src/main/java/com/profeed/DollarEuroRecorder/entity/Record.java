package com.profeed.DollarEuroRecorder.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(nullable = false)
    private long id;
   // @Column(unique = true,nullable = false)
    private Date releaseDate;
   // @Column(nullable = false)
    private String currencyType;
   // @Column(nullable = false)
    private String source;
   // @Column(nullable = false)
    private float buyPrice;
    //@Column(nullable = false)
    private float sellPrice;
}
