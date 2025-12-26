CREATE TABLE IF NOT EXISTS session (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS exercise(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS session_order(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    session_id BIGINT,
    exercise_no INT,
    exercise_id BIGINT,
    FOREIGN KEY(session_id) REFERENCES session(id),
    FOREIGN KEY(exercise_id) REFERENCES exercise(id)
);