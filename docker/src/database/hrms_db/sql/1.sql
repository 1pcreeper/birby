CREATE TABLE staff(
    id VARCHAR(255) NOT NULL,
    display_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE job_type(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE staff_salary(
    staff_id VARCHAR(255) NOT NULL,
    hourly DECIMAL(8,2) DEFAULT 0.0,
    daily DECIMAL(8,2) DEFAULT 0.0,
    monthly DECIMAL(8,2) DEFAULT 0.0,
    PRIMARY KEY (staff_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);
CREATE TABLE staff_detail(
	staff_id VARCHAR(255) NOT NULL,
    gender BOOLEAN NOT NULL,
    birth DATE NULL,
    hk_phone VARCHAR(8) UNIQUE CHECK (REGEXP_LIKE(hk_phone, '^[0-9]{8}$')),
    job_type_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (staff_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (job_type_id) REFERENCES job_type(id)
);
CREATE TABLE leave_wage_type(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    ratio DECIMAL(8,2) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE sick_leave(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    leave_wage_type_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (leave_wage_type_id) REFERENCES leave_wage_type(id)
);
CREATE TABLE venue(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    address TEXT NOT NULL,
    staff_amount INT NOT NULL,
    is_active BOOL DEFAULT true,
    PRIMARY KEY (id)
);
CREATE TABLE staff_venue_preference(
	staff_id VARCHAR(255) NOT NULL,
    venue_id VARCHAR(255) NOT NULL,
    z_index INT DEFAULT 0,
    PRIMARY KEY (staff_id,venue_id),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (venue_id) REFERENCES venue(id)
);
CREATE TABLE shift (
	id VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE duty (
	id VARCHAR(255) NOT NULL,
    staff_id VARCHAR(255) NOT NULL,
    `date` DATE NOT NULL,
    shift_id VARCHAR(255) NOT NULL,
    sick_leave_id VARCHAR(255) NULL,
    venue_id VARCHAR(255) NOT NULL,
    task TEXT NULL,
    PRIMARY KEY (id),
    UNIQUE (staff_id,`date`),
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (sick_leave_id) REFERENCES sick_leave(id),
    FOREIGN KEY (venue_id) REFERENCES venue(id),
    FOREIGN KEY (shift_id) REFERENCES shift(id)
);
CREATE TABLE attendance (
	id VARCHAR(255) NOT NULL,
    duty_id VARCHAR(255) NOT NULL UNIQUE,
    arrive_time TIME NULL,
    leave_time TIME NULL,
    report TEXT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (duty_id) REFERENCES duty(id)
);
CREATE TABLE staff_wage(
	id VARCHAR(255) NOT NULL,
    attend_id VARCHAR(255) NOT NULL UNIQUE,
    wage DECIMAL(8,2) NOT NULL,
    is_paid BOOL DEFAULT FALSE,
    PRIMARY KEY (id),
    FOREIGN KEY (attend_id) REFERENCES attendance(id)
);
CREATE TABLE request_method(
	id VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE request(
	id VARCHAR(255) NOT NULL,
    req_method_id VARCHAR(255) NOT NULL,
    from_staff_id VARCHAR(255) NOT NULL,
    time DATETIME NOT NULL,
    is_approved BOOLEAN NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (req_method_id) REFERENCES request_method(id),
    FOREIGN KEY (from_staff_id) REFERENCES staff(id)
);
CREATE TABLE sickleave_request(
	req_id VARCHAR(255) NOT NULL,
    sick_leave_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (req_id),
    FOREIGN KEY (req_id) REFERENCES request(id),
    FOREIGN KEY (sick_leave_id) REFERENCES sick_leave(id)
);

CREATE TABLE properties(
	id VARCHAR(255) NOT NULL,
    props_value VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

