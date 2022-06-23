CREATE TABLE Account (
    iban TEXT PRIMARY KEY,
    account_type TEXT,
    interest FLOAT,
    expenses FLOAT
);
INSERT INTO Account
VALUES (
        'FR7614785169320147895463201',
        'courrant',
        0.00,
        10
    );
INSERT INTO Account
VALUES (
        'FR7614523665558784868991274',
        'courrant',
        0.00,
        12
    );