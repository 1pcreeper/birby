
INSERT INTO staff (id, uid, name, display_name, email) VALUES 
('11111111-1111-1111-1111-111111111111', 'JSF9t87TF9ZJDadN6T8k9fEtchg1', 'linchikin', 'Lin Chi Kin', 'linchikin116@gmail.com'),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', 'GEiqIpVcrvUwnhQR4wcv25H0JlW2', 'H0001', 'Bob B.', 'bob@gmail.com'),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', 'TsnwLqrHFKUmVPxg0c8enIn7p7F3', 'H0002', 'Charlie C.', 'charlie@@gmail.com'),
('e7361b16-8163-4486-abe9-83c891920fa3', 'RH6zoQzlqGccxpfPFFcUWIgyv1f2', 'A0001', 'David D.', 'david@@gmail.com');


INSERT INTO department (id, name) VALUES 
('1d855068-8e93-47b9-b3d8-90cbf528734b', 'IT'),
('2f6de9ae-2095-4700-90d0-1d26acaf0189', 'HR'),
('88d05bb4-22d0-4bd0-9e78-f1701dc5fa8f', 'Sales'),
('2c0b3ee4-b869-4702-a4cd-ff5883d34742', 'BA'),
('a416ea57-848d-4bf6-a035-09c965a6d1e7', 'Default');


INSERT INTO vocation (id, name, depart_id, is_admin) VALUES 
('75425458-db2e-4411-a2d8-66db0efe5284', 'Root', '1d855068-8e93-47b9-b3d8-90cbf528734b', TRUE),
('4c7346a8-a9c6-4c1e-93fe-a4e14e104af9', 'Admin', '2f6de9ae-2095-4700-90d0-1d26acaf0189', TRUE),
('2a555d72-8728-4e8b-b877-d0719c7f9f8d', 'Recruit', '2f6de9ae-2095-4700-90d0-1d26acaf0189', FALSE),
('615ef133-fe38-4297-9ea3-1ad572c7136b', 'Admin', '88d05bb4-22d0-4bd0-9e78-f1701dc5fa8f', TRUE),
('fe28c7a1-faf3-418d-89c1-44b203facadf','General','88d05bb4-22d0-4bd0-9e78-f1701dc5fa8f', FALSE),
('041991b9-2ecc-4c46-8cbc-b651ae28f5d3', 'Admin', '2c0b3ee4-b869-4702-a4cd-ff5883d34742', TRUE),
('4b57a34f-2a3d-4349-81ff-9e56a9a0ad98', 'Staff', 'a416ea57-848d-4bf6-a035-09c965a6d1e7', FALSE);


INSERT INTO role (id, name, voc_id) VALUES 
('70f461e4-029b-4e38-935a-6a9520e3c5a7', 'IT_ROOT', '75425458-db2e-4411-a2d8-66db0efe5284'),
('1767e0f0-7a35-4b28-b5be-86a8e9d58dc0', 'HR_ADMIN', '4c7346a8-a9c6-4c1e-93fe-a4e14e104af9'),
('525b04a2-f9ef-4b22-b387-26f5bfa5b384', 'HR_RECRUIT', '2a555d72-8728-4e8b-b877-d0719c7f9f8d'),
('67577630-b051-416d-9fc0-3a1c570fbfde', 'SALES_ADMIN', '615ef133-fe38-4297-9ea3-1ad572c7136b'),
('ea8231eb-daf2-4f07-a1c0-fa5e517439eb', 'SALES_GENERAL', 'fe28c7a1-faf3-418d-89c1-44b203facadf'),
('71f4b734-b2e9-481c-bc61-246ece8cf7f4', 'BA_GENERAL', '041991b9-2ecc-4c46-8cbc-b651ae28f5d3'),
('08760e01-ee0e-4a55-a3d3-e43a701eb0bf', 'DEFAULT_STAFF', '4b57a34f-2a3d-4349-81ff-9e56a9a0ad98');


INSERT INTO staff_role (staff_id, role_id) VALUES 
('11111111-1111-1111-1111-111111111111', '70f461e4-029b-4e38-935a-6a9520e3c5a7'),
('11111111-1111-1111-1111-111111111111', '1767e0f0-7a35-4b28-b5be-86a8e9d58dc0'),
('11111111-1111-1111-1111-111111111111', '08760e01-ee0e-4a55-a3d3-e43a701eb0bf'),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', '1767e0f0-7a35-4b28-b5be-86a8e9d58dc0'),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', '525b04a2-f9ef-4b22-b387-26f5bfa5b384'),
('3f22aec3-5bd1-4e00-85b5-f74c8b32c8d6', '08760e01-ee0e-4a55-a3d3-e43a701eb0bf'),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', '525b04a2-f9ef-4b22-b387-26f5bfa5b384'),
('e7361b16-8163-4486-abe9-83c891920fa3', '08760e01-ee0e-4a55-a3d3-e43a701eb0bf'),
('679aa5c6-5700-4a02-aec3-d7ff4d1c07e8', '08760e01-ee0e-4a55-a3d3-e43a701eb0bf');


INSERT INTO properties (id, props_value) VALUES 
('p1', 'Value 1');