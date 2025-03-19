create view v_departamento as select * from departamento;
select * from v_departamento;

update departamento set nombre = 'sexo' where id = 1;
select * from v_departamento;

update v_departamento set nombre = 'coñete' where id = 2;
select * from v_departamento;
select * from departamento;

create or replace view v_departamento2 (nombre_sexy) as select nombre from departamento;
select * from v_departamento2;

create or replace view v_departamento3 as 
    select d.id, d.nombre, count(p.id) as num_prof
    from departamento d join profesor p on d.id = p.id_departamento
    group by d.id, d.nombre
    order by num_prof desc
;
select avg(num_prof) from v_departamento3;

select * from user_views;
select * from all_views;

drop view v_departamento;

---------------------------------

create synonym departamentos for departamento;
select * from departamentos;
select * from departamento;
drop synonym departamentos;

CREATE INDEX i_departamento_nombre on departamento (nombre);
drop index i_departamento_nombre;

create sequence secuencia_id_departamento 
increment by 1
start with 0
minvalue 0
nocache
nocycle;

select * from user_sequences;

select secuencia_id_departamento.nextval as "siguiente valor y lo actualiza al usarlo",
secuencia_id_departamento.currval as "valor actual y no actualiza"
from dual;

insert into departamento
values (secuencia_id_departamento.nextval, 'chochito');

drop sequence secuencia_id_departamento;

