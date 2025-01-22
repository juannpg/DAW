-- 1
SELECT codigo_oficina, ciudad FROM oficina;

-- 2
SELECT ciudad, telefono FROM oficina WHERE LOWER(pais) = 'españa';

-- 3
SELECT nombre, apellido1, apellido2, email FROM empleado2 WHERE codigo_jefe = 7;

-- 4
SELECT puesto, nombre, apellido1, apellido2, email FROM empleado2 WHERE codigo_jefe IS NULL;

-- 5
SELECT nombre, apellido1, apellido2, puesto FROM empleado2 WHERE NOT LOWER(puesto) = 'representante ventas';

-- 6
SELECT nombre_cliente FROM cliente2 WHERE LOWER(pais) = 'spain';

-- 7
SELECT DISTINCT estado FROM pedido;

-- 8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron
-- algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de
-- cliente que aparezcan repetidos. Resuelva la consulta:
SELECT DISTINCT codigo_cliente
FROM pedido
WHERE EXTRACT(YEAR FROM fecha_pedido) = 2008;

-- 9
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido
WHERE fecha_esperada < fecha_entrega;

-- 10
SELECT codigo_pedido, fecha_esperada, fecha_entrega FROM pedido
WHERE fecha_entrega < fecha_esperada - 2;

-- 11
SELECT * FROM pedido WHERE EXTRACT(YEAR FROM fecha_entrega) = 2009 AND LOWER(estado) = 'rechazado';

-- 12
SELECT * FROM pedido WHERE EXTRACT(MONTH FROM fecha_entrega) = 1;

-- 13
SELECT * FROM pago WHERE EXTRACT(YEAR FROM fecha_pago) = 2008 AND LOWER(forma_pago) = 'paypal' ORDER BY total DESC;




