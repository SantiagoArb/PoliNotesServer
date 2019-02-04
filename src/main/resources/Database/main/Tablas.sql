CREATE TABLE USUARIO
(
    DOC_USER VARCHAR2(15),
    NICK_USER VARCHAR2(20),
    PASSWORD_USER VARCHAR2(200),
    NOMBRE_USER VARCHAR2(40),
    APELLIDOS_USER VARCHAR2(40),
    CELULAR_USER VARCHAR2(15),
    CORREO_USER VARCHAR2(30),
    ID_PERFIL_USER INTEGER,
    ESTADO_USER INTEGER
)
TABLESPACE POLINOTES;

CREATE TABLE TIPO_PERFIL
(
    ID_TIPO_PERFIL INTEGER,
    NOMBRE_TIPO_PERFIL VARCHAR2(10)
)
TABLESPACE POLINOTES;

CREATE TABLE ESTADO
(
    ID_ESTADO INTEGER,
    NOMBRE_ESTADO VARCHAR2(10)
)
TABLESPACE POLINOTES;

CREATE TABLE LOGS 
(
   ID_LOGS INTEGER,
   ID_USER_LOGS INTEGER,
   ACCION_LOGS VARCHAR2(30),
   DESCRIPCION_LOGS VARCHAR2(255),
   FECHA_LOGS VARCHAR2(50)  
)
TABLESPACE POLINOTES;

CREATE TABLE FACULTAD (
    ID_FACULTAD INTEGER,
    CODIGO_FACULTAD VARCHAR2(20),
    NOMBRE_FACULTAD VARCHAR2(80),
    DECANO_FACULTAD VARCHAR2(15)
) 
TABLESPACE POLINOTES;

CREATE TABLE MATERIA (
    ID_MATERIA INTEGER,
    CODIGO_MATERIA VARCHAR2(20),
    NOMBRE_MATERIA VARCHAR2(80),
    FACULTAD_MATERIA INTEGER,
    ID_MAESTRO INTEGER
)
TABLESPACE POLINOTES;

CREATE TABLE ESTUDIANTE
(
DOC_ESTUDIANTE VARCHAR2(15),
NICK_ES VARCHAR2(20),
PASSWORD_ES VARCHAR2(20),
PREGUNTA_ES VARCHAR2(50),
RESPUESTA_ES VARCHAR2(50),
NOMBRE_ES VARCHAR2(40),
APELLIDO_ES VARCHAR2(40),
APELLIDO_ES2 VARCHAR2(40),
CELULAR_ES VARCHAR2(15),
CORREO_ES VARCHAR2(30),
ID_PERFIL_ES INTEGER,
ESTADO_PE_ES VARCHAR(10)
)
TABLESPACE POLINOTES;

CREATE TABLE ESTUDIANTES_MATERIA
(
DOC_ESTUDIANTE VARCHAR2(15),
ID_MATERIA INTEGER,
NOM_ESTUDIANTE VARCHAR2(40)
)TABLESPACE POLINOTES;