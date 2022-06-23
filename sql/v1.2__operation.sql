CREATE TABLE Operation (
    id INTEGER PRIMARY KEY,
    type TEXT,
    source TEXT REFERENCES account (iban),
    destination TEXT REFERENCES account (iban),
    currency TEXT,
    ammount FLOAT,
    operation_date TIMESTAMP
);
INSERT INTO Operation
VALUES(
        12345,
        'VIREMENT',
        'FR7614785169320147895463201',
        'FR7614523665558784868991274',
        'USD',
        1000.0,
        TO_TIMESTAMP(1656113962662)
    );