CREATE OR REPLACE TRIGGER TG_TIPO_PERFIL
BEFORE INSERT ON TIPO_PERFIL
FOR EACH ROW
BEGIN	
	DECLARE 
		AUX INTEGER:= 0;
		BEGIN
			SELECT SQ_ID_TIPO_PERFIL.NEXTVAL INTO AUX FROM DUAL;
			:new.ID_TIPO_PERFIL := AUX;
		END;
END;
/

CREATE OR REPLACE TRIGGER TG_ESTADO
BEFORE INSERT ON ESTADO
FOR EACH ROW
BEGIN	
	DECLARE 
		AUX INTEGER:= 0;
		BEGIN
			SELECT SQ_ID_ESTADO.NEXTVAL INTO AUX FROM DUAL;
			:new.ID_ESTADO := AUX;
		END;
END;
/

CREATE OR REPLACE TRIGGER TG_LOGS
BEFORE INSERT ON LOGS
FOR EACH ROW
BEGIN	
	DECLARE 
		AUX INTEGER:= 0;
		BEGIN
			SELECT SQ_ID_LOG.NEXTVAL INTO AUX FROM DUAL;
			:new.ID_LOGS := AUX;
		END;
END;
/

CREATE OR REPLACE TRIGGER TG_FACULTAD
BEFORE INSERT ON FACULTAD
FOR EACH ROW
BEGIN	
	DECLARE 
		AUX INTEGER:= 0;
		BEGIN
			SELECT SQ_ID_FACULTAD.NEXTVAL INTO AUX FROM DUAL;
			:new.ID_FACULTAD := AUX;
		END;
END;
/

CREATE OR REPLACE TRIGGER TG_MATERIA
BEFORE INSERT ON MATERIA
FOR EACH ROW
BEGIN	
	DECLARE 
		AUX INTEGER:= 0;
		CODIGO VARCHAR2(50);
		BEGIN
			SELECT SQ_ID_MATERIA.NEXTVAL INTO AUX FROM DUAL;
			:new.ID_MATERIA := AUX;
		END;
END;
/

CREATE OR REPLACE TRIGGER TG_ID_USUARIO
BEFORE INSERT ON USUARIO
FOR EACH ROW
BEGIN	
	DECLARE 
		AUX INTEGER:= 0;
		CODIGO VARCHAR2(50);
		BEGIN
			SELECT SQ_ID_USUARIO.NEXTVAL INTO AUX FROM DUAL;
			:new.ID_USUARIO := AUX;
		END;
END;
/



CREATE OR REPLACE TRIGGER TG_ID_CONCERTACION
BEFORE INSERT ON CONCERTACION
FOR EACH ROW
BEGIN	
	DECLARE 
		AUX INTEGER:= 0;
		CODIGO VARCHAR2(50);
		BEGIN
			SELECT SQ_ID_CONCERTACION.NEXTVAL INTO AUX FROM DUAL;
			:new.ID_CONCERTACION := AUX;
		END;
END;
/