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