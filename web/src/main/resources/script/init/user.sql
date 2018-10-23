select * from user;
commit;
delete from user;
insert into user(org_id, user_name, real_name, pwd) 
values(1, 'user', 'USER', '{bcrypt}$2a$10$3uGcmbbcgNnwoBx/8MuLneEoi8Q58nf3hVAtN5aZXEGkxz9ZEdLSW');