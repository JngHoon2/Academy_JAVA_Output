CREATE TABLE dept(
deptno number(2) PRIMARY key,
dname varchar2(14),
loc varchar2(13)
);

CREATE TABLE emp(
empno NUMBER(4) PRIMARY KEY,
ename varchar2(10),
job varchar2(9),
mgr number(4),
hiredate DATE,
sal number(7, 2),
comm number(7, 2),
deptno number(2),
CONSTRAINT fk_emp FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

INSERT INTO dept values(10, '경리부', '서울');
INSERT INTO dept values(20, '인사부', '인천');
INSERT INTO dept values(40, '전산부', '수원');

UPDATE dept SET deptno = 30 WHERE dname = '전산부';

COMMIT;

SELECT * FROM dept;

INSERT INTO emp values(1001, '김사랑', '사원', 1013, to_date('2007-03-01','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO emp values(1002, '한예슬', '대리', 1005, to_date('2007-04-02','yyyy-mm-dd'), 250,   80, 30);
INSERT INTO emp values(1003, '오지호', '과장', 1005, to_date('2005-02-10','yyyy-mm-dd'), 500,  100, 30);
INSERT INTO emp values(1004, '이병헌', '부장', 1008, to_date('2003-09-02','yyyy-mm-dd'), 600, NULL, 20);
INSERT INTO emp values(1005, '신동협', '과장', 1005, to_date('2005-04-07','yyyy-mm-dd'), 450,  200, 30);
INSERT INTO emp values(1006, '장동건', '부장', 1008, to_date('2003-10-09','yyyy-mm-dd'), 480, NULL, 30);
INSERT INTO emp values(1007, '이문세', '부장', 1008, to_date('2004-01-08','yyyy-mm-dd'), 520, NULL, 10);
INSERT INTO emp values(1008, '감우성', '차장', 1003, to_date('2004-03-08','yyyy-mm-dd'), 500,    0, 30);
INSERT INTO emp values(1009, '안성기', '사장', NULL, to_date('1996-10-04','yyyy-mm-dd'),1000, NULL, 20);
INSERT INTO emp values(1010, '이병헌', '과장', 1003, to_date('2005-04-07','yyyy-mm-dd'), 500, NULL, 10);
INSERT INTO emp values(1011, '조향기', '사원', 1007, to_date('2007-03-01','yyyy-mm-dd'), 280, NULL, 30);
INSERT INTO emp values(1012, '강혜정', '사원', 1006, to_date('2007-08-09','yyyy-mm-dd'), 300, NULL, 20);
INSERT INTO emp values(1013, '박중훈', '부장', 1003, to_date('2002-10-09','yyyy-mm-dd'), 560, NULL, 20);
INSERT INTO emp values(1014, '조인성', '사원', 1006, to_date('2007-11-09','yyyy-mm-dd'), 250, NULL, 10);

select dname, count(*), sum(sal), ROUND(avg(sal), 2)
FROM dept d inner JOIN emp e ON d.deptno = e.deptno
GROUP BY dname;
