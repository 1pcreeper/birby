CREATE TABLE staff(
    id VARCHAR(255) NOT NULL,
    uid VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(20) NOT NULL UNIQUE,
    display_name VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id)
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
CREATE TABLE properties(
	id VARCHAR(255) NOT NULL,
    props_value VARCHAR(255) NULL,
    PRIMARY KEY (id)
);

