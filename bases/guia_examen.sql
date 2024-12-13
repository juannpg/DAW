--- PASO 1: CREAR TABLAS
--- IMPORTANTE añadir un campo para las FK
CREATE TABLE ejemplo(
    codigo NUMBER(2),
    nombre VARCHAR2(20) UNIQUE NOT NULL,
    fecha DATE DEFAULT(sysdate + 1),
    
    codigo_ejemplo2 NUMBER(2),
    
    CONSTRAINT ejemplo_pk PRIMARY KEY (codigo)
);

CREATE TABLE ejemplo2(
    codigo NUMBER(2),
    fecha DATE NOT NULL,
    tfno NUMBER(9) UNIQUE,
    
    CONSTRAINT ejemplo2_pk PRIMARY KEY (codigo)
);

--- PASO 2: CREAR CHECKS
ALTER TABLE ejemplo
ADD CONSTRAINT ejemplo_chk_codigo CHECK(codigo IN (1, 2, 3));

ALTER TABLE ejemplo2
ADD(
    CONSTRAINT ejemplo2_chk_fecha CHECK(fecha < TO_DATE('11/12/2024', 'DD/MM/YYYY')),
    CONSTRAINT ejemplo2_chk_tfno CHECK(REGEXP_LIKE(tfno, '^[[:digit:]]{9}$'))
);

--- PASO 3: CREAR RELACIONES
ALTER TABLE ejemplo
ADD CONSTRAINT ejemplo_fk_ejemplo2 FOREIGN KEY (codigo_ejemplo2) REFERENCES ejemplo2(codigo) ON DELETE CASCADE;

--- PASO 4: INSERTAR DATOS
--- recordar insertarlos en el orden correcto por las claves ajenas
INSERT INTO ejemplo2(codigo, fecha, tfno)
VALUES(2, '10/11/2025', 644924293);

INSERT INTO ejemplo(codigo, nombre, codigo_ejemplo2)
VALUES(1, 'Juan', 1);