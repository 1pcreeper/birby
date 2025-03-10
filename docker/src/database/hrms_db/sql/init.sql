CREATE TABLE staff(
    id VARCHAR(255) NOT NULL,
    uid VARCHAR(255) NOT NULL UNIQUE,
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

INSERT INTO staff (id, uid) VALUES 
('11111111-1111-1111-1111-111111111111', 'JSF9t87TF9ZJDadN6T8k9fEtchg1'),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', 'GEiqIpVcrvUwnhQR4wcv25H0JlW2'),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', 'TsnwLqrHFKUmVPxg0c8enIn7p7F3'),
('e7361b16-8163-4486-abe9-83c891920fa3', 'RH6zoQzlqGccxpfPFFcUWIgyv1f2');

INSERT INTO job_type (id,name) VALUES
('cbaa31eb-cb34-4322-aa8c-1336a88c1d74','Full Time'),
('2c57b5af-d8f9-42ff-b4c1-508e26cb29d5','Part Time'),
('b5e16a3f-8ed9-42cc-bc65-b652fe8f1bda','Contractor'),
('2f3978f2-5dd6-495b-9d13-6a8b4c6be6b4','Intern'),
('cd1325a1-af52-4345-8a49-0b17069139b9','Temporary');

INSERT INTO staff_detail (staff_id,gender,birth,hk_phone,job_type_id) VALUES
('11111111-1111-1111-1111-111111111111', TRUE , '2001-11-06','55444071','cbaa31eb-cb34-4322-aa8c-1336a88c1d74'),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', FALSE , '1998-09-23','38629173','2c57b5af-d8f9-42ff-b4c1-508e26cb29d5'),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', TRUE, '1990-03-12','58284881','b5e16a3f-8ed9-42cc-bc65-b652fe8f1bda'),
('e7361b16-8163-4486-abe9-83c891920fa3', FALSE,'2004-07-13','58266993','2f3978f2-5dd6-495b-9d13-6a8b4c6be6b4');

INSERT INTO leave_wage_type (id,name,ratio) VALUES
('1ae308be-1894-4128-9fec-5f56b683155d','Hourly Paid',1),
('173cd54a-1a99-4ada-aeb7-804bf2b43eee','HalfDay Paid',0.5),
('dd2c404e-1300-4326-a4a6-752e7e08ad56','WholeDay Paid',1),
('908caaa8-1a19-403a-883b-8122a4ef0d70','HalfDay Unpaid',0.5),
('12282323-40c5-46c9-9e59-bae4261676ae','WholeDay Unpaid',0);

INSERT INTO sick_leave (id,name,leave_wage_type_id) VALUES 
('5232cbe6-c181-4ff2-b479-9af5c01ec031','Public Holiday','12282323-40c5-46c9-9e59-bae4261676ae'),
('d3f1a48b-6e8c-4318-8308-d4106b08b279','Office Holiday','12282323-40c5-46c9-9e59-bae4261676ae'),
('41fed9ce-8f6b-463f-8133-a5cce26a5c25','Annual Leave','dd2c404e-1300-4326-a4a6-752e7e08ad56'),
('8b3b0e67-99a7-4a30-8291-8ea1ace891ce','Sick Leave','12282323-40c5-46c9-9e59-bae4261676ae'),
('05e3e8a4-c623-4086-b6b9-e99cb29adeed','Personal Leave','12282323-40c5-46c9-9e59-bae4261676ae'),
('816e8e58-6685-4273-9d11-1f1a972a6b19','Paternity Leave','12282323-40c5-46c9-9e59-bae4261676ae'),
('12cc77a9-f63e-4eb4-99d8-c37908a9e9d7','Compensatory Leave','1ae308be-1894-4128-9fec-5f56b683155d');

INSERT INTO venue (id,name,address,staff_amount,is_active) VALUES
('c48f5956-2d60-4eef-857d-bfdc8e09acd3','Main Office','Hong Kong Tai Wo',100,TRUE),
('e5809d77-63fe-4d23-ab0b-aaa903823edd','Building A','Hong Kong Tai Po Market',50,TRUE),
('7bb36e78-5e20-4d34-8173-11016356e8a9','Building B','Hong Kong Tin Shui Wai',70,TRUE);

INSERT INTO staff_venue_preference (staff_id,venue_id,z_index) VALUES
('11111111-1111-1111-1111-111111111111', 'c48f5956-2d60-4eef-857d-bfdc8e09acd3',0),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', 'c48f5956-2d60-4eef-857d-bfdc8e09acd3',0),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', 'e5809d77-63fe-4d23-ab0b-aaa903823edd',0),
('e7361b16-8163-4486-abe9-83c891920fa3', '7bb36e78-5e20-4d34-8173-11016356e8a9',1),
('e7361b16-8163-4486-abe9-83c891920fa3', 'e5809d77-63fe-4d23-ab0b-aaa903823edd',0);

INSERT INTO staff_salary (staff_id,hourly,daily,monthly) VALUES
('11111111-1111-1111-1111-111111111111', 70,700,21000),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', 60,600,18000),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', 50,500,15000),
('e7361b16-8163-4486-abe9-83c891920fa3', 40,400,12000);
