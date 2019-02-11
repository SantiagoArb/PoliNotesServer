--Procedimiento almacenado, para la validacion de usuario y contraseña--
CREATE OR REPLACE PROCEDURE LoginUsuario
(
    --VARIABLES DE ENTRADA--
    L_nick USUARIO.NICK_USER%TYPE,
    L_pass USUARIO.PASSWORD_USER%TYPE,
    --VARIABLES DE SALIDA--
    L_aux OUT INTEGER,
    L_doc OUT USUARIO.DOC_USER%TYPE,
    L_nombre OUT USUARIO.NOMBRE_USER%TYPE,
    L_apellidos OUT USUARIO.APELLIDOS_USER%TYPE,
    L_correo OUT USUARIO.CORREO_USER%TYPE,
    L_celular OUT USUARIO.CELULAR_USER%TYPE,
    L_PerfilUsuario OUT USUARIO.ID_PERFIL_USER%TYPE,
    L_Estado OUT USUARIO.ESTADO_USER%TYPE,
    nick OUT USUARIO.NICK_USER%TYPE,
    L_id OUT USUARIO.ID_USUARIO%TYPE
) AS
BEGIN
        SELECT count(*) as Contador, 
              DOC_USER,
              NOMBRE_USER, 
              APELLIDOS_USER, 
              CORREO_USER,
              CELULAR_USER, 
              ID_PERFIL_USER, 
              ESTADO_USER,
              NICK_USER,
              ID_USUARIO
        INTO 
        L_aux, 
        L_doc, 
        L_nombre, 
        L_apellidos, 
        L_correo, 
        L_celular, 
        L_PerfilUsuario, 
        L_Estado,
        nick,
        L_id
        FROM USUARIO
        WHERE NICK_USER = L_nick AND PASSWORD_USER = L_pass
        GROUP BY 
              DOC_USER,
              NOMBRE_USER, 
              APELLIDOS_USER,
              CORREO_USER, 
              CELULAR_USER, 
              ID_PERFIL_USER, 
              ESTADO_USER,
              NICK_USER,
              ID_USUARIO
        ORDER BY DOC_USER;
    EXCEPTION WHEN NO_DATA_FOUND THEN
    L_aux := 0;
END;
/
--/

--/Procedimiento para verificar si se encuentra en uso un codigo o nombre en la tabla Facultad--
CREATE OR REPLACE PROCEDURE Validaciones_Facultad (
    V_tipo VARCHAR2,
    V_variable VARCHAR2,
    V_aux OUT INTEGER
) AS
BEGIN
   IF (V_tipo = 'ValidarCodigo') THEN
       SELECT COUNT(*) INTO V_aux FROM FACULTAD WHERE CODIGO_FACULTAD = V_variable;
   END IF;

   IF (V_tipo = 'ValidarNombre') THEN
       SELECT COUNT(*) INTO V_aux FROM FACULTAD WHERE NOMBRE_FACULTAD = V_variable;
   END IF;

   EXCEPTION WHEN NO_DATA_FOUND THEN
   V_aux := 0;
END;
/
--/

--/Procedimiento para verificar si se encuentra en uso (Nick, Email, Documento) en la tabla usuario
CREATE OR REPLACE PROCEDURE Validaciones_Usuario(
    V_tipo VARCHAR2,
    V_variable VARCHAR2,
    V_aux OUT INTEGER
) AS 
BEGIN

  IF (v_tipo = 'ValidarNick') THEN 
      SELECT COUNT(*) INTO V_aux FROM USUARIO WHERE NICK_USER = V_variable;
  END  IF;

  IF (v_tipo = 'ValidarEmail') THEN 
      SELECT COUNT(*) INTO V_aux FROM USUARIO WHERE CORREO_USER = V_variable;
  END  IF;

  IF (v_tipo = 'ValidarDoc') THEN 
      SELECT COUNT(*) INTO V_aux FROM USUARIO WHERE DOC_USER = V_variable;
  END  IF;
  
  EXCEPTION WHEN NO_DATA_FOUND THEN
  V_aux := 0;  
END;
/

CREATE OR REPLACE PROCEDURE LigarUsuarioEstudiante(V_aux OUT INTEGER) IS

CURSOR CUR_US IS
    SELECT * FROM USUARIO WHERE ID_PERFIL_USER = 1;
BEGIN
     FOR i IN CUR_US
     LOOP
        UPDATE ESTUDIANTES_MATERIA SET ID_USUARIO = i.ID_USUARIO WHERE DOC_ESTUDIANTE = i.DOC_USER;
     END LOOP;
   EXCEPTION WHEN NO_DATA_FOUND THEN
  V_aux := 0;
END;
/
--/


CREATE OR REPLACE PROCEDURE setNota(
                                    In_id  NOTA_ESTUDIANTE.ID_NOTA%TYPE,
                                    In_nota  NOTA_ESTUDIANTE.NOTA_ES%TYPE,
                                    In_id_con  NOTA_ESTUDIANTE.ID_CON%TYPE,
                                    In_doc  NOTA_ESTUDIANTE.DOC_EST%TYPE

                                    ) IS
                                    
 RESULTADO NUMBER;
BEGIN

   SELECT count(*) INTO RESULTADO FROM NOTA_ESTUDIANTE WHERE DOC_EST = In_doc AND ID_CON= In_id_con;
IF RESULTADO = 1 THEN
    UPDATE NOTA_ESTUDIANTE SET NOTA_ES = In_nota WHERE DOC_EST = In_doc AND ID_CON= In_id_con;
ELSE
    IF RESULTADO = 0 THEN
        INSERT INTO NOTA_ESTUDIANTE VALUES(In_id,In_nota,In_id_con,In_doc);
    END IF;
END IF;

END;
/



create or replace PROCEDURE setEstudianteToNotas(In_id_materia MATERIA.ID_MATERIA%TYPE) IS


cursor cur_con is
        select * from concertacion where ID_MATERIA=In_id_materia;
begin
for i in cur_con
loop

MERGE INTO nota_estudiante n
    USING (select * from estudiantes_materia where id_materia = In_id_materia) est

    ON (n.DOC_EST = est.doc_estudiante and i.ID_CONCERTACION = n.id_con)

  WHEN NOT MATCHED THEN
    INSERT (n.ID_NOTA,n.NOTA_ES,n.ID_CON,n.DOC_EST)
    VALUES (1,0.0,i.ID_CONCERTACION,est.doc_estudiante);

end loop;

 end;
    /
--/

create or replace PROCEDURE calcularDefinitiva
                                              (
                                               in_doc  IN estudiantes_materia.doc_estudiante%TYPE,
                                               in_id_materia IN estudiantes_materia.id_materia%TYPE,
                                               out_definitiva out number
                                               ) AS
nota number;
CURSOR cur_salida IS SELECT * from nota_estudiante nt inner join concertacion on nt.ID_CON = concertacion.ID_CONCERTACION 
        where doc_est = in_doc and concertacion.ID_MATERIA=in_id_materia;
begin
out_definitiva:=0;
for indx in cur_salida
loop
nota :=  indx.nota_es * (indx.porcentaje_Con / 100);
out_definitiva := out_definitiva + nota;
DBMS_OUTPUT.PUT_LINE(out_definitiva);
end loop;
end calcularDefinitiva;