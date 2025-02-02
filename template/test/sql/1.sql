CREATE DATABASE birby_hrms_db;
USE birby_hrms_db;
CREATE TABLE staff(
    id VARCHAR(255) NOT NULL,
    uid VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL UNIQUE,
    display_name VARCHAR(5) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
CREATE TABLE staff_detail(
	staff_id VARCHAR(255) NOT NULL,
    gender BOOL NOT NULL,
    hk_phone VARCHAR(8) UNIQUE CHECK (REGEXP_LIKE(hk_phone, '^[0-9]{8}$')),
    PRIMARY KEY (staff_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);

CREATE TABLE department(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE vocation(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    depart_id VARCHAR(255) NOT NULL,
    is_admin BOOL DEFAULT FALSE,
    PRIMARY KEY (id),
    FOREIGN KEY (depart_id) REFERENCES department(id) 
);

CREATE TABLE role(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    voc_id VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (voc_id) REFERENCES vocation(id)
);
CREATE TABLE staff_role(
    staff_id VARCHAR(255) NOT NULL,
    role_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (staff_id,role_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);











CREATE TABLE update_log(
    id VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    table_name VARCHAR(20) NOT NULL,
    content TEXT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(date,user_id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);


CREATE TABLE job_type(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);







CREATE TABLE sick_leave(
    id VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    staff_id VARCHAR(100) NOT NULL,
    reason TEXT,
    PRIMARY KEY (id),
    UNIQUE(date,staff_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);
CREATE TABLE venue(
    id VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(300) NOT NULL,
    staff_amount INT NOT NULL DEFAULT 0,
    time_start TIME NOT NULL,
    time_end TIME NOT NULL,
    is_active BOOL DEFAULT true,
    PRIMARY KEY (id),
    CHECK (time_end > time_start)
);




CREATE TABLE duty(
    id VARCHAR(100) NOT NULL,
    venue_id VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    time_start TIME NOT NULL,
    time_end TIME NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(venue_id,date),
    FOREIGN KEY (venue_id) REFERENCES venue(id),
    CHECK (time_end > time_start)
);
CREATE TABLE staff_duty(
    id VARCHAR(100) NOT NULL,
    staff_id VARCHAR(100) NOT NULL,
    duty_id VARCHAR(100) NOT NULL,
    hourly_wage DECIMAL(10,3) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(staff_id,duty_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (duty_id) REFERENCES duty(id)
);CREATE TABLE user_detail(  user_id VARCHAR(100) NOT NULL,     hk_phone VARCHAR(8) UNIQUE CHECK (REGEXP_LIKE(hk_phone, '^[0-9]{8}$')),     PRIMARY KEY (user_id),     FOREIGN KEY (user_id) REFERENCES user(id) )
