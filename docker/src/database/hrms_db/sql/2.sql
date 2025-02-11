USE hrms_db;
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

-- INSERT INTO shift (id,name,start_time,end_time) VALUES
-- ();