create table book (id bigint not null, description varchar(300), isbn varchar(15), lastUpdated varchar(30), nbOfPage integer not null, title varchar(100) not null, unitCost decimal(19,2), primary key (id))
create table hibernate_sequence (next_val bigint)
insert into hibernate_sequence values ( 1 )
