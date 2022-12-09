package com.profeed.DollarEuroRecorder.repository;

import com.profeed.DollarEuroRecorder.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity,Long> {

    List<RecordEntity> findBySource(String url);
    List<RecordEntity> findByCurrencyType(String currencyType);
    List<RecordEntity> findByReleaseDate(String date);


}
