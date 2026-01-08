package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.model.SetLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SetLogRepository extends JpaRepository<SetLog, Long> {

    @Query("SELECT MAX(s.setNo) FROM SetLog s WHERE s.sessionOrder = :sessionOrder")
    Integer findMaxSetNoBySessionOrder(@Param("sessionOrder") SessionOrder sessionOrder);

    SetLog findBySessionOrderAndSetNo(SessionOrder sessionOrder,Integer setNo);
}
