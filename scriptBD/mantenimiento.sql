#Creación de usuario
CREATE USER mantenimiento IDENTIFIED BY '1234'; #Clave para el usuario

#Para verlo cambiamos la BDD
USE mysql;

#Muestra los usuarios de la BDD
SELECT user FROM user; 

#Creamos la BDD
CREATE DATABASE IF NOT EXISTS BDAlumnos;
USE BDAlumnos;
CREATE TABLE IF NOT EXISTS alumnos(
	numero INT PRIMARY KEY,
    nombre VARCHAR(25),
    sexo VARCHAR(1),
    edad INT
);

#Damos privilegios como administrador a un usuario
GRANT ALL PRIVILEGES ON BDAlumnos.* TO mantenimiento WITH GRANT OPTION;

#Cambiamos la variable de zona horaria para que no nos dé el problema al conectarnos desde eclipse
SET GLOBAL time_zone = '+1:00';