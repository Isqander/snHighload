CREATE TABLE IF NOT EXISTS user
(
    id        INTEGER AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    surname   VARCHAR(255) NOT NULL,
    age       INT          NOT NULL,
    sex       VARCHAR(255) NOT NULL,
    interests VARCHAR(255) NOT NULL,
    town      VARCHAR(255) NOT NULL
) ENGINE = INNODB;



CREATE TABLE IF NOT EXISTS interest
(
    id   INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE = INNODB;

CREATE TABLE `user_to_interest`
(
    user_id     INT NOT NULL,
    interest_id INT NOT NULL,
    PRIMARY KEY (user_id, interest_id),
    CONSTRAINT `Constr_user_fk`
        FOREIGN KEY user_fk (user_id) REFERENCES user (id)
            ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `Constr_interest_fk`
        FOREIGN KEY interest_fk (interest_id) REFERENCES interest (id)
            ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB