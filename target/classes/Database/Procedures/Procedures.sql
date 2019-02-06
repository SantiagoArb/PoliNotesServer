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
--/