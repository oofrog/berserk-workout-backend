INSERT INTO workout_session(title) VALUES ('PUSH DAY');
INSERT INTO workout_session(title) VALUES ('PULL DAY');
INSERT INTO workout_session(title) VALUES ('LEG DAY');

INSERT INTO exercise(name) VALUES ('Bench Press');
INSERT INTO exercise(name) VALUES ('Squat');
INSERT INTO exercise(name) VALUES ('Deadlift');

INSERT INTO session_order(workout_session_id,exercise_no,exercise_id) VALUES(1,1,1);
INSERT INTO session_order(workout_session_id,exercise_no,exercise_id) VALUES(1,2,3);
INSERT INTO session_order(workout_session_id,exercise_no,exercise_id) VALUES(1,3,2);
