connect /as sysdba;

drop tablespace POLINOTES including contents and datafiles;

CREATE TABLESPACE POLINOTES LOGGING
DATAFILE 'C:\Users\Home\Documents\DataPolinotes\POLINOTES.dbf' size 3M
extent management local segment space management auto; 

drop user us_admin;

create user us_admin profile default 
identified by 1234 
default tablespace POLINOTES 
temporary tablespace temp 
account unlock; 

--permisos 
grant connect, resource,dba to us_admin; 
connect us_admin/1234;