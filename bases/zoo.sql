-- 1. Devuelve el listado de los animales (todos los campos) que nacieron en 2009
SELECT * FROM animales WHERE EXTRACT(YEAR FROM nacimiento) = 2009;

-- 2. Devuelve el listado de proveedores que no tienen fecha de baja en la base de datos y además el tipo de
-- sociedad comience por S.
SELECT p.*, s.descripcion FROM proveedores p 
JOIN sociedades s
ON (p.tipo_sociedad = s.Id_tipo_sociedad)
WHERE p.fecha_baja IS NULL AND LOWER(s.descripcion) LIKE 's%';

-- 3. Devuelve el listado de los cuidadores y los animales. Se debe mostrar el id y nombre de empleado, la especie
-- (nombre común) y el nombre del animal.
SELECT E.Id_empleado, e.nombre, a.nombre_pila, e.nombre_comun FROM empleados e
LEFT JOIN animales a ON (e.Id_empleado = a.id_cuidador)
LEFT JOIN especies e ON(a.id_especie = e.Id_especie);

-- 4. Muestra un listado con la medicación que toma cada animal. Se debe mostrar en nombre de pila del animal y
-- la descripción de la medicación. En caso de no tomar medicación, debe aparecer 'Sin medicación'.
SELECT a.nombre_pila, m.descripcion FROM animales a
LEFT JOIN medicacion m USING (id_medicacion);

-- 5. Devuelve un listado con la alimentación que debe tomar cada animal. Se debe mostrar el nombre de pila y la
-- alimentación
SELECT a.nombre_pila, al.descripcion FROM animales a
JOIN especies USING (id_especie)
JOIN alimentacion al USING (id_alimentacion);

-- 6. Devuelve un listado con los productos de cada proveedor, mostrando id de producto, nombre de producto,
-- stock y nombre de proveedor.
SELECT pr.id_producto, pr.nombre, pr.stock, p.nombre FROM proveedores p 
JOIN productos pr USING (id_proveedor);

-- 7. Devuelve un listado de empleados que no cuidan de ningún animal. Muestra el id y el nombre.
SELECT e.id_empleado, e.nombre FROM empleados e
LEFT JOIN animales a ON (e.id_empleado = a.id_cuidador)
WHERE a.id_cuidador IS NULL;

-- 8. Devuelve un listado de empleados que no cuidan de ningún animal y donde están ubicados. Muestra id,
-- nombre y descripción de la ubicación.
SELECT e.id_empleado, e.nombre, u.descripcion FROM empleados e
LEFT JOIN animales a ON (e.id_empleado = a.id_cuidador)
LEFT JOIN ubicaciones u ON (e.ubicacion = u.id_ubicacion)
WHERE a.id_cuidador IS NULL;

-- 9. Devuelve el nombre y la fecha de nacimiento de la hembra animal más joven.
SELECT nombre_pila, nacimiento FROM animales
WHERE nacimiento = (SELECT MIN(nacimiento) FROM animales WHERE sexo = 'hembra')
AND sexo = 'hembra';

-- 10. Devuelve un listado con los empleados y el número de animales que cuida. Muestra el id y nombre de
-- empleado, descripción de la ubicación y una columna que se llame CANT que refleje la cantidad de animales
-- que cuida. Se deben mostrar los empleados que tengan cero animales a su cargo también. Ordenar por id de
-- empleado ascendente y ubicación descendente
SELECT e.nombre, COUNT(a.id_animal) AS "CANT", u.descripcion FROM empleados e
LEFT JOIN animales a ON (e.id_empleado = a.id_cuidador)
JOIN ubicaciones u ON (e.ubicacion = u.id_ubicacion)
GROUP BY e.nombre, u.descripcion, e.id_empleado
ORDER BY e.id_empleado ASC, u.descripcion DESC;












