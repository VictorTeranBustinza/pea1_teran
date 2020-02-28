DELIMITER $$
CREATE PROCEDURE insertar_producto(
IN _p_nombre VARCHAR(30);
IN _p_precio NUMERIC(6,2);
IN _p_tipo VARCHAR (30),
OUT _p_confirm INT
)
BEGIN
    UPDATE dispositivos
        SET nombre = _p_
    DECLARE _v_precio INT;
    SET _p_nombre = UPPER(_p_nombre);
    SET _p_precio = _p_precio * 3.5;
    --
    SELECT FLOOR (1 + RAND() * 60) INTO _v_precio;
    --
    INSERT INTO producto
        (nombre, precio, tipo)
        VALUES  
        (_v_nombre, _p_precio , _p_tipo);
        --
        IF ROW_COUNT() > 0 THEN
            SET _p_confirm = 1;
        ELSE
            SET _p_confirm = 0;
        END IF;    
END$$
DELIMITER ; 

