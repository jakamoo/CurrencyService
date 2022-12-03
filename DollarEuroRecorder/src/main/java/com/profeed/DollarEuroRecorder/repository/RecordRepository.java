package com.profeed.DollarEuroRecorder.repository;

import com.profeed.DollarEuroRecorder.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {

    Record findBySource(String Url);
    Record findByCurrencyType(String currencyType);
    Record findByBuyPrice(float buyPrice);
    Record findBySellPrice(float sellPrice);

}
