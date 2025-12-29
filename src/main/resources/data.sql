INSERT INTO workout_session(title) VALUES ('PUSH DAY');
INSERT INTO workout_session(title) VALUES ('PULL DAY');
INSERT INTO workout_session(title) VALUES ('LEG DAY');

INSERT INTO exercise(name) VALUES ('Bench Press');
INSERT INTO exercise(name) VALUES ('Squat');
INSERT INTO exercise(name) VALUES ('Deadlift');

INSERT INTO session_order(workout_session_id,exercise_no,exercise_id) VALUES(1,1,1);
INSERT INTO session_order(workout_session_id,exercise_no,exercise_id) VALUES(1,2,3);
INSERT INTO session_order(workout_session_id,exercise_no,exercise_id) VALUES(1,3,2);

INSERT INTO set_log(session_order_id,set_no,weight,reps,complete) VALUES(1,1,40,10,'가벼움');
INSERT INTO set_log(session_order_id,set_no,weight,reps,complete) VALUES(1,2,40,10,'힒듬');
INSERT INTO set_log(session_order_id,set_no,weight,reps,complete) VALUES(2,3,40,9,'실패');