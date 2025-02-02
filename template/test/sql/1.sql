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
CREATE TABLE job_type(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE staff_detail(
	staff_id VARCHAR(255) NOT NULL,
    gender BOOL NOT NULL,
    hk_phone VARCHAR(8) UNIQUE CHECK (REGEXP_LIKE(hk_phone, '^[0-9]{8}$')),
    job_type_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (staff_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (job_type_id) REFERENCES job_type(id)
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

CREATE TABLE leave_approval(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE leave_wage_type(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE sick_leave(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    leave_approval_id VARCHAR(255) NOT NULL,
    leave_wage_type_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (leave_approval_id) REFERENCES leave_approval(id),
    FOREIGN KEY (leave_wage_type_id) REFERENCES leave_wage_type(id)
);
CREATE TABLE venue(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(300) NOT NULL,
    staff_amount INT NOT NULL DEFAULT 0,
    time_start TIME NOT NULL,
    time_end TIME NOT NULL,
    is_active BOOL DEFAULT true,
    PRIMARY KEY (id),
    CHECK (time_end > time_start)
);

CREATE TABLE attendance (
	id VARCHAR(255) NOT NULL,
    staff_id VARCHAR(255) NOT NULL,
    `date` DATE NOT NULL,
    sick_leave_id VARCHAR(255) NULL,
    wage_hour INT DEFAULT 0,
    venue_id VARCHAR(255) NOT NULL,
    mission TEXT NULL,
    PRIMARY KEY (id),
    UNIQUE (staff_id,`date`),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (sick_leave_id) REFERENCES sick_leave(id),
    FOREIGN KEY (venue_id) REFERENCES venue(id)
);
CREATE TABLE staff_duty (
	id VARCHAR(255) NOT NULL,
    attend_id VARCHAR(255) NOT NULL UNIQUE,
    is_paid BOOL DEFAULT FALSE,
    arrive_time TIME NULL,
    leave_time TIME NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (attendance) REFERENCES attendance(id),
    INDEX (attend_id)
);


