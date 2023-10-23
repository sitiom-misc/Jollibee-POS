CREATE TABLE student
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    section   VARCHAR(255) NOT NULL,
    exam1     INTEGER      NOT NULL,
    exam2     INTEGER      NOT NULL,
    average   DOUBLE       NOT NULL,
    isDeleted BOOLEAN      NOT NULL
);

INSERT INTO student
VALUES (1, 'Ryan Caezar Itang', 'SEG31', 93, 95, 94, 0),
       (2, 'Francis Esteban', 'SEG31', 88, 77, 82.5, 0),
       (3, 'JC Jumawan', 'SEG22', 80, 98, 89, 1);
