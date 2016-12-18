-- noinspection SqlNoDataSourceInspectionForFile
create table book(
  bookid int auto_increment,
  author text,
  title text
);

create table user(
  userid int auto_increment,
  username text
);

create table break(
  breakid int auto_increment,
  breakname text
);

create table place(
  placeid int auto_increment,
  placename text
);

create table duty(
  dutyid int auto_increment,
  userid int,
  breakid int,
  placeid int,
  date DATE
);

-- Plural vs Singular: http://stackoverflow.com/questions/338156/table-naming-dilemma-singular-vs-plural-names