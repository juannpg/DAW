set serveroutput on;

DECLARE
    num1 number := 2;
    num2 number := 2;
    pinta boolean := true;
BEGIN
    if pinta then
        dbms_output.put_line('num1: ' || num1);
        dbms_output.put_line('num2: ' || num2);
    
        if num1 > num2 then
            dbms_output.put_line(num1 || ' es mayor que ' || num2);
        elsif num2 > num1 then
            dbms_output.put_line(num2 || ' es mayor que ' || num1);
        else
            dbms_output.put_line(num1 || ' es igual que ' || num2);
        end if;
    end if;
END;
/

DECLARE
    nota number := 5;
    calificacion varchar2(30);
BEGIN
    CASE nota
    WHEN 10 THEN
        calificacion := 'Sobresaliente';
    WHEN 9 THEN
        calificacion := 'Sobresaliente';
    WHEN 8 THEN
        calificacion := 'Notable';
    WHEN 7 THEN
        calificacion := 'Notable';
    WHEN 6 THEN
        calificacion := 'Bien';
    WHEN 5 THEN
        calificacion := 'Suficiente';
    ELSE
        calificacion := 'Insuficiente';
   END CASE;
   
   dbms_output.put_line('La calificacion es: ' || nota || ', ' || calificacion);
END;
/

DECLARE
    num1 number := 0;
BEGIN
    LOOP
        num1 := num1 + 1;
        dbms_output.put_line('Linea: ' || num1);
        
        --if num1 = 5 then exit; end if;
        exit when num1 = 5;
    END LOOP;
END;
/

BEGIN
    FOR i IN REVERSE 1..5
    LOOP
        dbms_output.put_line('Linea: ' || i);
    END LOOP;
END;
/

DECLARE
    num1 number := 0;
BEGIN
    WHILE num1 <= 5 LOOP
        dbms_output.put_line('Linea: ' || num1);
        num1 := num1 + 1;
    END LOOP;
END;
/

DECLARE
    num1 number := 0;
BEGIN
    WHILE num1 < 5 LOOP
        num1 := num1 + 1;
        dbms_output.put_line('Linea: ' || num1);
        EXIT WHEN num1 = 3;
    END LOOP;
END;
/

BEGIN
    FOR i IN 1..10
    LOOP
        CONTINUE WHEN MOD(i,2) = 0;   
        dbms_output.put_line('Numero: ' || i);
    END LOOP;
END;
/


--CURSOR IMPLICITO
--devuelve una fila y una columna. si no da error el cursor
DECLARE
                                        -- tipo de la columna
    variableNombre animales.nombre_pila%type;
    variableId animales.id_animal%type;
BEGIN
    select nombre_pila, id_animal into variableNombre, variableId from animales where id_animal = 3;
    dbms_output.put_line(variableId || ' ' || variableNombre);
END;
/

--CURSOR EXPLICITO
declare
    tupla animales%rowtype;
    cursor cursorAnimales is select * from animales;
begin
    for tupla in cursorAnimales loop
        dbms_output.put_line(tupla.id_animal || ' ' || tupla.nombre_pila);
    end loop;
end;
/

--excepciones
declare 
    valor volumen.isbn%type;
    vest volumen.estado%type;
begin
    select isbn, estado into valor, vest from volumen where cod_vol = 201;

    -- codigo, mensaje, si se almacena en el stack trace
    raise_application_error(299, 'excepcion personalizada', true);    
exception
    when too_many_rows then
        dbms_output.put_line(' muchas filas');
    when others then
        if sqlcode = 299 then
            dbms_output.put_line('asdasd');
        else
            dbms_output.put_line('asdasdadadadasd');
        end if;
end;    
/

--procedimientos
create or replace procedure actualiza_det(pVol volumen.cod_vol%type) as
begin
    update volumen
    set deteriorado = 1
    where cod_vol = pVol;
end;
/

--funcion
create or replace function getTitulo(pIsbn libro.isbn%type) return libro.titulo%type as
    rTitulo libro.titulo%type;
begin
    select titulo into rTitulo from libro where isbn = pIsbn;
    return titulo;
end;
/







