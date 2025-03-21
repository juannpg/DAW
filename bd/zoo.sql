----vistas
----1
create or replace view v_especies (id, nombre, num_esp) as
    select e.Id_especie, e.nombre_comun, count(a.Id_animal) from especies e
    join animales a on a.id_especie = e.Id_especie
    group by e.Id_especie, e.nombre_comun
;

select * from v_especies;

----2
create or replace view v_trabajo as 
    select a.nombre_pila, e.nombre, u.descripcion from animales a
    join empleados e on e.Id_empleado = a.id_cuidador
    join ubicaciones u on u.Id_ubicacion = e.ubicacion
;

select * from v_trabajo;

----3
create or replace view v_alimentacion_animal (nombre, alimentacion) as
    select a.nombre_pila, al.descripcion from animales a
    join especies e on e.Id_especie = a.id_especie
    join alimentacion al on e.id_alimentacion = al.Id_alimentacion
;

select * from v_alimentacion_animal;

----4
create or replace view v_enfermos as
    select a.nombre_pila, e.nombre from animales a
    join manimales m on a.Id_animal = m.id_animal
    join tipoeventos t on t.Id_tipo = m.tipo_evento
    join empleados e on e.Id_empleado = a.id_cuidador
    where lower(t.descripcion) = 'enfermedad'
;

alter table mproductos
modify Id_producto default 1;

select * from v_enfermos;