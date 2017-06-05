DROP TABLE IF EXISTS player CASCADE;
DROP TABLE IF EXISTS strokes CASCADE;

CREATE TABLE player (
    player_id     BIGINT    PRIMARY KEY,
    last_name		  varchar(40),
    first_name		varchar(40),
    last_update		DATE
);

CREATE TABLE stroke (
    stroke_id     BIGINT    PRIMARY KEY,
    create_date   DATE,
    is_active     boolean,
    player_reference BIGINT REFERENCES player (player_id)
);