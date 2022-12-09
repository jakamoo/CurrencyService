package com.profeed.DollarEuroRecorder.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "record")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecordEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(nullable = false)
    private Long id;
    // @Column(unique = true,nullable = false)
    private LocalDateTime releaseDate;
    // @Column(nullable = false)
    private String currencyType;
    // @Column(nullable = false)
    private String source;
    // @Column(nullable = false)
    private Double buyPrice;
    //@Column(nullable = false)
    private Double sellPrice;
}
