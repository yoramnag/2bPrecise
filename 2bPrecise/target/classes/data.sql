insert into manager(id, first_name, last_name) values(10001,'Yoram','Nagavker');
insert into manager(id, first_name, last_name) values(10002,'Alex','Fainberg');

insert into employee(id, first_name, last_name,position,manager_id) values(20001,'Chen','Belker','QA',10001);
insert into employee(id, first_name, last_name,position,manager_id) values(20002,'Alon','Hanukayev','software developer',10001);

insert into report(id, date , text ,employee_id) values(30001,TO_DATE('06-04-2022','dd-MM-yyyy'),'report 1',20001);
insert into report(id, date , text ,employee_id) values(30002,TO_DATE('06-04-2022','dd-MM-yyyy'),'report 2',20001);