DROP TABLE IF EXISTS activity;
DROP TABLE IF EXISTS session;
DROP TABLE IF EXISTS charity;
DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS date;

CREATE TABLE activity
(
    activity_code VARCHAR(8),
    title VARCHAR(20) NOT NULL,
    PRIMARY KEY (activity_code)
);

CREATE TABLE session
(
    session_id INTEGER PRIMARY KEY,
    num_day TINYINT NOT NULL,
    start_hour TIME NOT NULL,
    end_hour TIME NOT NULL,
    is_weekly BOOLEAN NOT NULL,
    nb_max INTEGER,
    activity_code VARCHAR(8) NOT NULL,
    CONSTRAINT activity_code_fk FOREIGN KEY (activity_code) REFERENCES activity(activity_code)
);

CREATE TABLE charity
(
    charity_code VARCHAR(8),
    name VARCHAR(20) NOT NULL,
    contact VARCHAR(20) NOT NULL,
    address VARCHAR(20),
    city VARCHAR(20),
    country VARCHAR(20),
    zip_code VARCHAR(10),
    PRIMARY KEY (charity_code)
);

CREATE TABLE booking
(
    booking_id INTEGER,
    last_name VARCHAR(30) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    amount DOUBLE NOT NULL,
    is_paid BOOLEAN NOT NULL,
    phone VARCHAR(20) NOT NULL,
    birth_date DATE,
    email VARCHAR(20),
    date DATE NOT NULL,
    charity_code VARCHAR(8) NOT NULL,
    session_id INTEGER NOT NULL,
    PRIMARY KEY (booking_id),
    CONSTRAINT charity_code_fk FOREIGN KEY (charity_code) REFERENCES charity(charity_code),
    CONSTRAINT session_id_fk FOREIGN KEY (session_id) REFERENCES session(session_id)
);

CREATE TABLE date
(
    date_id INTEGER,
    type VARCHAR(10) NOT NULL,
    date DATE NOT NULL,
    session_id INTEGER NOT NULL,
    PRIMARY KEY (date_id),
    CONSTRAINT session_id_fk FOREIGN KEY (session_id) REFERENCES session(session_id)
);