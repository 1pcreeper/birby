INSERT INTO staff (id, display_name) VALUES 
('11111111-1111-1111-1111-111111111111', 'Lin Chi Kin'),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', 'Bob B.'),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', 'Charlie C.'),
('e7361b16-8163-4486-abe9-83c891920fa3', 'David D.');

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

INSERT INTO sick_leave (id,name,leave_approval_id,leave_wage_type_id) VALUES 
('5232cbe6-c181-4ff2-b479-9af5c01ec031','Public Holiday'),
('d3f1a48b-6e8c-4318-8308-d4106b08b279','Office Holiday'),
('','Annual Leave'),
('','Sick Leave'),
('','Personal Leave'),
('','Paternity Leave');

INSERT INTO 