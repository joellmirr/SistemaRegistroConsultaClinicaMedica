/* Script_ClinicaMedica: */

CREATE TABLE Funcionario (
    idfuncionario INTEGER PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    endereco VARCHAR(200) NOT NULL
);

CREATE TABLE Paciente (
    idpaciente INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(9) NOT NULL,
    endereco VARCHAR(200) NOT NULL
);

CREATE TABLE Medico (
    idmedico INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    crm VARCHAR(50) NOT NULL,
    especialidade VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(9) NOT NULL,
    endereco VARCHAR(200) NOT NULL  
);

CREATE TABLE Consultas (
    idconsulta INTEGER PRIMARY KEY AUTO_INCREMENT,
    paciente INTEGER NOT NULL REFERENCES Paciente(idpaciente),
    dataconsulta DATE NOT NULL,
    valorconsulta FLOAT NOT NULL,
    motivoconsulta VARCHAR(50) NOT NULL,
    exame VARCHAR(100) NOT NULL,
    descricaoexame VARCHAR(100) NOT NULL,
    medico INTEGER NOT NULL REFERENCES Medico(idmedico),
    horaregitroconsulta TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL   
);


