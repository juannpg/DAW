----1
create view DEP30 as 
    select apellido, oficio, salario
    from emple
    where dept_no = 30
;

select * from DEP30;

----2
create or replace view DEP30 (ape, ofi, sal) as 
    select apellido, oficio, salario
    from emple
    where dept_no = 30
;

select * from DEP30;

----3
create view VDEP as
    select dept_no, dnombre
    from depart
;

update VDEP
set dnombre = 'nuevo20'
where dept_no = 20;

select * from VDEP;

----4





