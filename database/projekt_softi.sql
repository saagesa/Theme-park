CREATE TABLE Perdoruesi (
    Perdorues_id NUMBER PRIMARY KEY,
    Emri         VARCHAR2(50) NOT NULL,
    Mbiemri      VARCHAR2(50) NOT NULL,
    Emaili       VARCHAR2(100) UNIQUE NOT NULL,
    Fjalekalimi  VARCHAR2(255) NOT NULL,
    Telefoni     VARCHAR2(20)
);
CREATE TABLE Staff (
    Staff_id    NUMBER PRIMARY KEY,
    Emri        VARCHAR2(50) NOT NULL,
    Mbiemri     VARCHAR2(50) NOT NULL,
    Emaili      VARCHAR2(100) UNIQUE NOT NULL,
    Fjalekalimi VARCHAR2(255) NOT NULL
);
CREATE TABLE Atraksion (
    Atraksion_id    NUMBER PRIMARY KEY,
    Emri            VARCHAR2(100) NOT NULL,
    Pershkrimi      VARCHAR2(500),
    Kapaciteti      NUMBER,
    Kohezgjatja     NUMBER, -- ne minuta
    Kufizim_moshe   NUMBER,
    Kufizim_gjatesie NUMBER,
    Status          VARCHAR2(20)
);
CREATE TABLE Evente (
    Event_id    NUMBER PRIMARY KEY,
    Emri        VARCHAR2(100) NOT NULL,
    Data        DATE NOT NULL,
    Ora         VARCHAR2(10),
    Lokacion    VARCHAR2(100),
    Pershkrimi  VARCHAR2(500),
    Kapaciteti  NUMBER
);
CREATE TABLE Park_Pass (
    Pass_id      NUMBER PRIMARY KEY,
    Perdorues_id NUMBER NOT NULL,
    Lloji        VARCHAR2(50),
    Zbritje      NUMBER(5,2),

    CONSTRAINT fk_pass_perdorues
        FOREIGN KEY (Perdorues_id)
        REFERENCES Perdoruesi(Perdorues_id)
);
CREATE TABLE Pagesa (
    Pagesa_id     NUMBER PRIMARY KEY,
    Atraksion_id  NUMBER,
    Perdorues_id  NUMBER,
    Data          DATE NOT NULL,
    Status        VARCHAR2(20),

    CONSTRAINT fk_pagesa_atraksion
        FOREIGN KEY (Atraksion_id)
        REFERENCES Atraksion(Atraksion_id),

    CONSTRAINT fk_pagesa_perdorues
        FOREIGN KEY (Perdorues_id)
        REFERENCES Perdoruesi(Perdorues_id)
);
CREATE TABLE Feedback (
    Feedback_id  NUMBER PRIMARY KEY,
    Perdorues_id NUMBER NOT NULL,
    Atraksion_id NUMBER NOT NULL,
    Vleresim     NUMBER CHECK (Vleresim BETWEEN 1 AND 5),
    Koment       VARCHAR2(500),
    Data         DATE,

    CONSTRAINT fk_feedback_perdorues
        FOREIGN KEY (Perdorues_id)
        REFERENCES Perdoruesi(Perdorues_id),

    CONSTRAINT fk_feedback_atraksion
        FOREIGN KEY (Atraksion_id)
        REFERENCES Atraksion(Atraksion_id)
);
CREATE TABLE Promocione (
    Pass_id       NUMBER PRIMARY KEY,
    Perdorues_id  NUMBER NOT NULL,
    Lloji         VARCHAR2(50),
    Zbritje       NUMBER(5,2),
    Data_fillimi  DATE,
    Data_mbarimi  DATE,

    CONSTRAINT fk_promocion_perdorues
        FOREIGN KEY (Perdorues_id)
        REFERENCES Perdoruesi(Perdorues_id)
);
CREATE TABLE Staff_Rezervim (
    Veprim_id     NUMBER PRIMARY KEY,
    Staff_id      NUMBER NOT NULL,
    Atraksion_id  NUMBER NOT NULL,
    Lloj_incidenti VARCHAR2(50),
    Pershkrimi    VARCHAR2(500),
    Data          DATE,

    CONSTRAINT fk_sr_staff
        FOREIGN KEY (Staff_id)
        REFERENCES Staff(Staff_id),

    CONSTRAINT fk_sr_atraksion
        FOREIGN KEY (Atraksion_id)
        REFERENCES Atraksion(Atraksion_id)
);
CREATE TABLE Raport_Incidenti (
    Raport_id     NUMBER PRIMARY KEY,
    Staff_id      NUMBER NOT NULL,
    Atraksion_id  NUMBER NOT NULL,
    Lloj_incidenti VARCHAR2(50),
    Pershkrimi    VARCHAR2(500),
    Data          DATE,

    CONSTRAINT fk_ri_staff
        FOREIGN KEY (Staff_id)
        REFERENCES Staff(Staff_id),

    CONSTRAINT fk_ri_atraksion
        FOREIGN KEY (Atraksion_id)
        REFERENCES Atraksion(Atraksion_id)
);
CREATE SEQUENCE seq_perdoruesi
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_perdoruesi_id
BEFORE INSERT ON Perdoruesi
FOR EACH ROW
BEGIN
    IF :NEW.Perdorues_id IS NULL THEN
        SELECT seq_perdoruesi.NEXTVAL
        INTO :NEW.Perdorues_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_staff
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_staff_id
BEFORE INSERT ON Staff
FOR EACH ROW
BEGIN
    IF :NEW.Staff_id IS NULL THEN
        SELECT seq_staff.NEXTVAL
        INTO :NEW.Staff_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_atraksion
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_atraksion_id
BEFORE INSERT ON Atraksion
FOR EACH ROW
BEGIN
    IF :NEW.Atraksion_id IS NULL THEN
        SELECT seq_atraksion.NEXTVAL
        INTO :NEW.Atraksion_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_evente
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_evente_id
BEFORE INSERT ON Evente
FOR EACH ROW
BEGIN
    IF :NEW.Event_id IS NULL THEN
        SELECT seq_evente.NEXTVAL
        INTO :NEW.Event_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_park_pass
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_park_pass_id
BEFORE INSERT ON Park_Pass
FOR EACH ROW
BEGIN
    IF :NEW.Pass_id IS NULL THEN
        SELECT seq_park_pass.NEXTVAL
        INTO :NEW.Pass_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_pagesa
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_pagesa_id
BEFORE INSERT ON Pagesa
FOR EACH ROW
BEGIN
    IF :NEW.Pagesa_id IS NULL THEN
        SELECT seq_pagesa.NEXTVAL
        INTO :NEW.Pagesa_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_feedback
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_feedback_id
BEFORE INSERT ON Feedback
FOR EACH ROW
BEGIN
    IF :NEW.Feedback_id IS NULL THEN
        SELECT seq_feedback.NEXTVAL
        INTO :NEW.Feedback_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_promocione
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_promocione_id
BEFORE INSERT ON Promocione
FOR EACH ROW
BEGIN
    IF :NEW.Pass_id IS NULL THEN
        SELECT seq_promocione.NEXTVAL
        INTO :NEW.Pass_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_staff_rezervim
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_staff_rezervim_id
BEFORE INSERT ON Staff_Rezervim
FOR EACH ROW
BEGIN
    IF :NEW.Veprim_id IS NULL THEN
        SELECT seq_staff_rezervim.NEXTVAL
        INTO :NEW.Veprim_id
        FROM dual;
    END IF;
END;
/
CREATE SEQUENCE seq_raport_incidenti
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER trg_raport_incidenti_id
BEFORE INSERT ON Raport_Incidenti
FOR EACH ROW
BEGIN
    IF :NEW.Raport_id IS NULL THEN
        SELECT seq_raport_incidenti.NEXTVAL
        INTO :NEW.Raport_id
        FROM dual;
    END IF;
END;
/
