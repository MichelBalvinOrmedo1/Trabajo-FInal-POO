USE sistemaMatricula;



CREATE TABLE usuario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(15) NOT NULL,
    role VARCHAR(15) NOT NULL,
    estado VARCHAR(15) NOT NULL,
    
);

CREATE TABLE file(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    type VARCHAR(15) NOT NULL,
    size INT NOT NULL
);

CREATE TABLE profile(
    dni CHAR(8) PRIMARY KEY,
    firstName VARCHAR(15) NOT NULL,
    lastName VARCHAR(15) NOT NULL,
    email VARCHAR(15) NOT NULL,
    fileId INT,
    FOREIGN KEY (fileId) REFERENCES file (id)
);

CREATE TABLE persona(
    dni CHAR(8) PRIMARY KEY,
    firstName VARCHAR(15) NOT NULL,
    lastName VARCHAR(15) NOT NULL,
    email VARCHAR(15) NOT NULL,
    celular CHAR(9) NOT NULL,
    tipoPersona VARCHAR(15) NOT NULL,
    fileId INT,
    FOREIGN KEY (fileId) REFERENCES file (id)
);

CREATE TABLE nivel(
    idNivel INT AUTO_INCREMENT PRIMARY KEY,
    nombreNivel VARCHAR(15) NOT NULL
);

CREATE TABLE grado(
    idGrado INT AUTO_INCREMENT PRIMARY KEY,
    nombreGrado VARCHAR(15) NOT NULL
);

CREATE TABLE matricula(
    idMatricula INT AUTO_INCREMENT PRIMARY KEY,
    dniEstudiante CHAR(8),
    fecha DATE NOT NULL,
    idNivel INT,
    idGrado INT,
    FOREIGN KEY (dniEstudiante) REFERENCES persona (dni),
    FOREIGN KEY (idNivel) REFERENCES nivel (idNivel),
    FOREIGN KEY (idGrado) REFERENCES grado (idGrado)
);

CREATE TABLE categoria(
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL
);

CREATE TABLE aula(
    codAula CHAR(4) PRIMARY KEY,
    cantActual INT NOT NULL,
    cantMax INT NOT NULL,
    estado INT,
    FOREIGN KEY (estado) REFERENCES estado (idEstado)
);

CREATE TABLE horario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    dia VARCHAR(15) NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME NOT NULL,
    codAula CHAR(4),
    FOREIGN KEY (codAula) REFERENCES aula (codAula)
);

CREATE TABLE curso(
    idCurso INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    idProfesor CHAR(8),
    idHorario INT,
    idCategoria INT,
    idNivel INT,
    precio FLOAT NOT NULL,
    FOREIGN KEY (idProfesor) REFERENCES persona (dni),
    FOREIGN KEY (idHorario) REFERENCES horario (id),
    FOREIGN KEY (idCategoria) REFERENCES categoria (idCategoria),
    FOREIGN KEY (idNivel) REFERENCES nivel (idNivel)
);

CREATE TABLE detalleMatricula(
    idMatricula INT,
    idCurso INT,
    FOREIGN KEY (idMatricula) REFERENCES matricula (idMatricula),
    FOREIGN KEY (idCurso) REFERENCES curso (idCurso),
    PRIMARY KEY (idMatricula, idCurso)
);

CREATE TABLE nota(
    idNota INT AUTO_INCREMENT PRIMARY KEY,
    idMatricula INT,
    idCurso INT,
    nota FLOAT CHECK (nota >= 0),
    fechaNota DATE NOT NULL,
    FOREIGN KEY (idMatricula) REFERENCES matricula (idMatricula),
    FOREIGN KEY (idCurso) REFERENCES curso (idCurso)
);