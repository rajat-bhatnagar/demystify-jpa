CREATE TABLE
    book
    (
        id bigint NOT NULL,
        description VARCHAR(255),
        isbn VARCHAR(255),
        nbOfPage INT NOT NULL,
        title VARCHAR(255),
        unitCost DECIMAL(19,2),
        PRIMARY KEY (id)
    )

CREATE TABLE
    hibernate_sequence
    (
        next_val bigint
    )
