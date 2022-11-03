select * from employees;

select e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.hire_date, e.salary, 
e.job_id, j.job_title, e.department_id, d.department_name, 
d.location_id, l.state_province, l.city, 
l.country_id, c.country_name
from employees e left outer join jobs j on e.job_id = j.job_id
left outer join departments d on e.department_id = d.department_id
left outer join locations l on d.location_id = l.location_id
left outer join countries c on l.country_id = c.country_id;

create table role_tbl(
    role_id varchar2(20) constraint role_pk primary key,
    role_name varchar2(20) not null  
    );    
insert into role_tbl(role_id, role_name) values('admin', '관리자');    
insert into role_tbl(role_id, role_name) values('user', '일반사용자');    

--drop table user_tbl cascade constraints;
create table user_tbl(   
	id varchar2(20) constraint user_id_pk primary key,  
	pwd varchar2(20),  
	name varchar2(50),  
	email varchar2(100), 
	role_id varchar2(20) constraint role_id_fk references role_tbl(role_id),  
	joindate  date default sysdate	
);


create table simple_board (
     no number(5),
     title varchar(50)  not null,
     content  varchar(1000) not null,
     id varchar(20)  not null,
     hit number (5) default 0,
     regdate date default sysdate,
     constraint simple_board_pk primary key(no),
     constraint simple_board_id_fk foreign key(id) references user_tbl(id)
       );
create sequence seq_simple_board increment by 1 start with 1;
commit;
