DROP TABLE IF EXISTS persons CASCADE;
DROP TABLE IF EXISTS groups CASCADE;
DROP TABLE IF EXISTS artists CASCADE;
DROP TABLE IF EXISTS albums CASCADE;
DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS composers CASCADE;
DROP TABLE IF EXISTS compositions CASCADE;
DROP TABLE IF EXISTS albums_compositions CASCADE;
DROP TABLE IF EXISTS groups_artists CASCADE;
DROP TABLE IF EXISTS artists_compositions CASCADE;

DROP SEQUENCE IF EXISTS global_seq cascade;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE persons
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  first_name  VARCHAR NOT NULL,
  last_name   VARCHAR NOT NULL
);

CREATE TABLE groups
(
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name            VARCHAR         NOT NULL
);



CREATE TABLE artists
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  person_id   INTEGER NOT NULL,
  FOREIGN KEY (person_id) REFERENCES persons (id)

);

CREATE TABLE albums
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name              VARCHAR         NOT NULL,
  artist_id         INTEGER,
  group_id          INTEGER,
  FOREIGN KEY (artist_id) REFERENCES artists(id),
  FOREIGN KEY (group_id) REFERENCES groups(id),
  date_of_creation  TIMESTAMP NOT NULL
);


CREATE TABLE authors
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  person_id   INTEGER NOT NULL,
  FOREIGN KEY (person_id) REFERENCES persons (id)

);

CREATE TABLE composers
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  person_id   INTEGER NOT NULL,
  FOREIGN KEY (person_id) REFERENCES persons (id)

);
CREATE TABLE compositions
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name              VARCHAR         NOT NULL,
  author_id          INTEGER         NOT NULL,
  composer_id        INTEGER         NOT NULL,
  group_id           INTEGER         NOT NULL,
  date_of_creation  TIMESTAMP NOT NULL,
  FOREIGN KEY (author_id) REFERENCES authors(id),
  FOREIGN KEY (composer_id) REFERENCES composers(id),
  FOREIGN KEY (group_id) REFERENCES groups(id)

);



CREATE TABLE albums_compositions
(
  album_id       INTEGER NOT NULL,
  composition_id INTEGER NOT NUll,
  FOREIGN KEY (composition_id) REFERENCES compositions(id),
  FOREIGN KEY (album_id) REFERENCES albums(id)

);
CREATE TABLE groups_artists
(
  group_id       INTEGER NOT NULL,
  artist_id INTEGER NOT NUll,
  FOREIGN KEY (group_id) REFERENCES groups(id),
  FOREIGN KEY (artist_id) REFERENCES artists(id)

);

CREATE TABLE artists_compositions
(
  artist_id INTEGER NOT NUll,
  composition_id       INTEGER NOT NULL,
  FOREIGN KEY (artist_id) REFERENCES artists(id),
  FOREIGN KEY (composition_id) REFERENCES compositions(id)

);


