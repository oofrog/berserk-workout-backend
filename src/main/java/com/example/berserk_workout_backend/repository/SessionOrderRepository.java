package com.example.berserk_workout_backend.repository;

import com.example.berserk_workout_backend.model.SessionOrder;
import com.example.berserk_workout_backend.model.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionOrderRepository extends JpaRepository<SessionOrder, Long> {
    List<SessionOrder> findAllByWorkoutSessionId(Long workoutSessionId);

    @Query("""
        select distinct so
        from SessionOrder so
        left join fetch so.setLogs sl
        where so.workoutSession.id = :workoutSessionId
        order by so.exerciseNo asc
    """)
    List<SessionOrder> findAllWithSetLogByWorkoutSessionId(@Param("workoutSessionId")Long workoutSessionId);

    @Query("SELECT MAX(s.exerciseNo) FROM SessionOrder s WHERE s.workoutSession = :workoutSession")
    Integer findMaxExerciseNoByWorkoutSession(WorkoutSession workoutSession);

    SessionOrder findByWorkoutSessionAndExerciseNo(WorkoutSession workoutSession, Integer exerciseNo);

    void deleteAllByWorkoutSessionId(Long workoutSessionId);
}
