create database university;
use university;

CREATE TABLE users(
	id int not null AUTO_INCREMENT,
    name varchar(255) not null,
    surname varchar(255) not null,
    personal_id int not null,
    email varchar (255) not null,
    PRIMARY KEY (id)
); 

CREATE TABLE students(
	id int not null AUTO_INCREMENT,
    enrollment int not null,
    user_id int not null,
	PRIMARY KEY (id),
    FOREIGN KEY (user_id) references users (id)
);

CREATE TABLE proffessors(
	id int not null AUTO_INCREMENT,
    degree varchar(255) not null,
    user_id int not null,
    PRIMARY KEY(id),
    FOREIGN KEY (user_id) references users(id)
);

CREATE TABLE employees(
	id int not null AUTO_INCREMENT,
    position varchar(255) not null,
    user_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) references users(id)
);

CREATE TABLE carreers(
	id int not null AUTO_INCREMENT,
    title varchar(255) not null UNIQUE,
    duration int not null,
    cost float not null,
    PRIMARY KEY (id)
);

CREATE TABLE subjects(
	id int not null AUTO_INCREMENT,
    name varchar(255) not null UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE carreer_subject(
	id int not null AUTO_INCREMENT,
    carreer_id int not null,
    subject_id int not null,
    FOREIGN KEY (carreer_id) references carreers (id),
    FOREIGN KEY (subject_id) references subjects (id),
    PRIMARY KEY (id)
);

CREATE TABLE carreer_student(
	id int not null AUTO_INCREMENT,
    PRIMARY KEY (id),
    carreer_id int not null,
    student_id int not null,
    FOREIGN KEY (carreer_id) references carreers (id),
    FOREIGN KEY (student_id) references students (id)
);

CREATE TABLE commissions(
	id int not null AUTO_INCREMENT,
    code varchar(255) not null,
    subject_id int not null,
    head int,
    PRIMARY KEY (id),
    FOREIGN KEY (subject_id) references subjects (id),
    FOREIGN KEY (head) references proffessors (id)
);

CREATE TABLE commission_student(
	id int not null AUTO_INCREMENT,
    student_id int not null,
    commission_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) references students (id),
    FOREIGN KEY (commission_id) references commissions (id)
);

CREATE TABLE departments(
	id int not null AUTO_INCREMENT,
    area varchar(255) not null,
    head int, 
    PRIMARY KEY (id),
    FOREIGN KEY (head) references proffessors (id)
);

CREATE TABLE proffessor_department(
	id int not null AUTO_INCREMENT,
    proffessor_id int not null,
    department_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (proffessor_id) references proffessors (id),
    FOREIGN KEY (department_id) references departments (id)
);

CREATE TABLE exams(
	id int not null AUTO_INCREMENT,
    mark int not null,
    student_id int not null,
    subject_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) references students (id),
    FOREIGN KEY (subject_id) references subjects (id)
);

CREATE TABLE academic_record(
	id int not null AUTO_INCREMENT, 
    student_id int not null,
    subject_id int not null,
    PRIMARY KEY (id),
	FOREIGN KEY (student_id) references students (id),
    FOREIGN KEY (subject_id) references subjects (id),
    completed boolean not null,
    mark float
);

CREATE TABLE worked_hours(
	id int not null AUTO_INCREMENT,
    amount int,
    proffessor_id int,
    employee_id int,
	month varchar(55),
    PRIMARY KEY (id),
    FOREIGN KEY (proffessor_id) references proffessors (id),
    FOREIGN KEY (employee_id) references employees (id)
);

-- Data insertion

-- People
INSERT into users (name, surname, personal_id, email) VALUES ('John', 'Wick', '398749', 'johnwick@gmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Homer', 'Simpson', '3218749', 'homer@gmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Bruce', 'Banner', '56749', 'hulk@hotmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Scarlet', 'Johanson', '125639', 'blackwidow@gmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Morgan', 'Freeman', '998749', 'god@yahoo.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Dua', 'Lipa', '24549', 'dualipa@gmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Ken', 'Block', '35728749', 'monsterenergy@gmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('William', 'Shakespeare', '3549', 'romeoandjuliet@gmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Albert', 'Einstein', '352349', '140iq@gmail.com');
INSERT into users (name, surname, personal_id, email) VALUES ('Stephen', 'Hawkins', '12352349', 'wormhole@gmail.com');

INSERT into proffessors (user_id, degree) VALUES (3, 'Nuclear Engineer');
INSERT into proffessors (user_id, degree) VALUES (8, 'Legendary Writter');
INSERT into proffessors (user_id, degree) VALUES (9, 'Physisist');
INSERT into proffessors (user_id, degree) VALUES (10, 'Cientist');
INSERT into employees (user_id, position) VALUES (5, 'Janitor');
INSERT into students (user_id, enrollment) VALUES (1, 2385723);
INSERT into students (user_id, enrollment) VALUES (2, 2324723);
INSERT into students (user_id, enrollment) VALUES (4, 2645973);
INSERT into students (user_id, enrollment) VALUES (6, 2897453);
INSERT into students (user_id, enrollment) VALUES (7, 2785723);

-- Careers and subjects
INSERT into careers (title, duration, cost) VALUES ('Physicist', 5, 100000);
INSERT into careers (title, duration, cost) VALUES ('Literary', 3, 80000);

INSERT into subjects (name) VALUES ('physics');
INSERT into subjects (name) VALUES ('maths');
INSERT into subjects (name) VALUES ('literature');
INSERT into subjects (name) VALUES ('writting');
INSERT into subjects (name) VALUES ('english');
INSERT into subjects (name) VALUES ('algebra');

-- Corresponding subjects to each carreer
INSERT into career_subject (carreer_id, subject_id) VALUES (1, 1);
INSERT into career_subject (carreer_id, subject_id) VALUES (1, 2);
INSERT into career_subject (carreer_id, subject_id) VALUES (1, 5);
INSERT into career_subject (carreer_id, subject_id) VALUES (1, 6);
INSERT into career_subject (carreer_id, subject_id) VALUES (2, 3);
INSERT into career_subject (carreer_id, subject_id) VALUES (2, 4);
INSERT into career_subject (carreer_id, subject_id) VALUES (2, 5);

-- Students carreers
INSERT into career_student (carreer_id, student_id) VALUES (2, 1);
INSERT into career_student (carreer_id, student_id) VALUES (1, 2);
INSERT into career_student (carreer_id, student_id) VALUES (1, 3);
INSERT into career_student (carreer_id, student_id) VALUES (2, 3);
INSERT into career_student (carreer_id, student_id) VALUES (1, 5);