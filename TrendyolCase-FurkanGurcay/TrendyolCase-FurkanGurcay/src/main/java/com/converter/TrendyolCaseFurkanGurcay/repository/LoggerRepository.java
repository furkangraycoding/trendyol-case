package com.converter.TrendyolCaseFurkanGurcay.repository;


import com.converter.TrendyolCaseFurkanGurcay.model.Logger;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {

}
