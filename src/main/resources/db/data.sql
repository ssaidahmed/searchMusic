DELETE FROM persons;
DELETE FROM groups;
DELETE FROM artists;
DELETE FROM albums;
DELETE FROM authors;
DELETE FROM composers;
DELETE FROM compositions;
DELETE FROM albums_compositions;
DELETE FROM groups_artists;
DELETE FROM artists_compositions;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO persons (first_name, last_name) VALUES
  ('Mark', 'Svoysky'),
  ('Den', 'Dade'),
  ('Igor', 'Nikolaev'),
  ('Filip', 'Kirkorov'),
  ('Sergey', 'Lazarev'),
  ('Oleg', 'Gazmanov'),
  ('Marina', 'Vladi'),
  ('Djastin', 'Timderland'),
  ('Vasiy', 'Gaz'),
  ('Vitaliy', 'Mot'),
  ('Egor', 'Krid'),
  ('Timur', 'Timati'),
  ('Jon', 'Lenon'),
  ('Grigory', 'Leps'),
  ('Any', 'Lorak'),
  ('Valery', 'Leontev'),
  ('Anjelica', 'Ogutin'),
  ('Kristina', 'Ogilera'),
  ('Elton', 'Jon'),
  ('Kristi', 'Misti'),
  ('Kendrick', 'Lamar');
-- 20
INSERT INTO groups (name) VALUES
  ('The Beatles'),
  ('Led Zeppelin'),
  ('Boney M'),
  ('ABBA'),
  ('The Rolling Stones');
--25
INSERT INTO artists (person_id) VALUES
  (100000),
  (100001),
  (100002),
  (100003),
  (100004),
  (100005),
  (100006),
  (100007),
  (100008),
  (100009),
  (100010),
  (100011),
  (100012),
  (100013),
  (100014);
--40
INSERT INTO albums (name, artist_id, group_id, date_of_creation) VALUES
  ('fly down', null, 100022, '2017-12-10'),
  ('Damn', 100026, null, '2016-10-10'),
  ('Melodrama', 100027, null, '2016-11-10'),
  ('Rainbow', null, 100023, '2013-10-10'),
  ('American Dream', null, 100025, '2014-10-09'),
  ('American Teen', 100028, null, '2015-10-11'),
  ('Reputation', null, 100024, '2016-12-11'),
  ('Villains', 100037, null, '2017-12-11');

--48

INSERT INTO authors (person_id) VALUES
  (100000),
  (100002),
  (100004),
  (100005),
  (100001),
  (100006),
  (100007),
  (100008),
  (100010),
  (100009);
--58
INSERT INTO composers (person_id) VALUES
  (100004),
  (100007),
  (100009),
  (100002),
  (100005),
  (100010),
  (100011),
  (100015),
  (100017),
  (100018);
--68
INSERT INTO compositions (name, author_id, composer_id, group_id, date_of_creation) VALUES
  ('Speak to Me', 100049, 100064, 100023,'2011-12-10'),
  ('My love',  100049, 100067, 100021, '2012-12-10'),
  ('Breathe',  100049, 100066, 100022, '2013-12-10'),
  ('Home Again', 100049, 100059, 100021, '2014-12-10'),
  ('Time', 100050, 100067, 100024, '2015-10-10'),
  ('Travel', 100050, 100066, 100024, '2016-11-10'),
  ('Religion', 100053, 100066, 100024, '2017-11-10'),
  ('Money', 100053, 100067, 100024, '2017-12-10'),
  ('Us and Them', 100053, 100067, 100023,'2017-12-10'),
  ('Any Colour You Like', 100055, 100064, 100024, '2017-12-10'),
  ('Brain Damage', 100055, 100059, 100023, '2017-12-10'),
  ('All That You', 100056, 100060, 100021, '2017-12-10'),
  ('Love', 100056, 100068, 100023, '2017-12-10'),
  ('Fly love', 100053, 100068, 100021, '2017-12-10'),
  ('kill love', 100057, 100066, 100022, '2017-12-10'),
  ('Eclipse', 100057, 100062, 100023, '2017-12-10'),
  ('Hells Bells', 100055, 100067, 100022, '2017-12-10'),
  ('Givin’ the Dog a Bone', 100057, 100063, 100022, '2017-12-10');

--86



INSERT INTO albums_compositions(album_id, composition_id) VALUES
(100041, 100069),
(100042, 100070),
(100043, 100071),
(100048, 100072),
(100041, 100073),
(100041, 100074),
(100041, 100070),
(100042, 100076),
(100042, 100077),
(100042, 100078),
(100042, 100079),
(100042, 100080),
(100043, 100081),
(100043, 100082),
(100043, 100083),
(100043, 100084);
--102
INSERT INTO groups_artists(group_id, artist_id) VALUES
(100021, 100026),
(100025, 100027),
(100021, 100028),
(100021, 100029),
(100022, 100030),
(100022, 100031),
(100023, 100032),
(100023, 100033),
(100024, 100034),
(100024, 100035),
(100025, 100036),
(100025, 100037);
--114
INSERT INTO artists_compositions(artist_id, composition_id) VALUES
(100026, 100069),
(100027, 100070),
(100032, 100071),
(100033, 100071),
(100034, 100072),
(100035, 100072),
(100036, 100073),
(100037, 100073),
(100036, 100072),
(100036, 100071),
(100036, 100070),
(100038, 100074),
(100038, 100070),
(100038, 100073),
(100039, 100074);
--124

