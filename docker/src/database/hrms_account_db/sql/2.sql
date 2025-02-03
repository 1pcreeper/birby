-- Mock Data for staff Table
INSERT INTO staff (id, uid, name, display_name, email) VALUES 
('1', 'uid_1', 'Alice', 'Alice W.', 'alice@example.com'),
('2', 'uid_2', 'Bob', 'Bob B.', 'bob@example.com'),
('3', 'uid_3', 'Charlie', 'Charlie C.', 'charlie@example.com'),
('4', 'uid_4', 'David', 'David D.', 'david@example.com');

-- Mock Data for department Table
INSERT INTO department (id, name) VALUES 
('d1', 'HR'),
('d2', 'Sales'),
('d3', 'Engineering'),
('d4', 'Marketing');

-- Mock Data for vocation Table
INSERT INTO vocation (id, name, depart_id, is_admin) VALUES 
('v1', 'Recruiter', 'd1', FALSE),
('v2', 'Sales Manager', 'd2', FALSE),
('v3', 'Software Engineer', 'd3', FALSE),
('v4', 'Marketing Specialist', 'd4', TRUE);

-- Mock Data for role Table
INSERT INTO role (id, name, voc_id) VALUES 
('r1', 'Junior Recruiter', 'v1'),
('r2', 'Senior Sales Manager', 'v2'),
('r3', 'Lead Software Engineer', 'v3'),
('r4', 'Digital Marketing Manager', 'v4');

-- Mock Data for staff_role Table
INSERT INTO staff_role (staff_id, role_id) VALUES 
('1', 'r1'),
('2', 'r2'),
('3', 'r3'),
('4', 'r4');

-- Mock Data for properties Table
INSERT INTO properties (id, props_value) VALUES 
('p1', 'Value 1'),
('p2', 'Value 2'),
('p3', 'Value 3'),
('p4', 'Value 4');