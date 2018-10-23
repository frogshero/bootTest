
drop table if exists organization;
create table organization(
    id bigint not null auto_increment comment '主键id',
	name varchar(200) not null comment '名称',
	code varchar(50) not null comment '客户代码',
	credit_code varchar(18) not null comment '统一信用代码',
	tel varchar(50) comment '电话',
	addr varchar(500) comment '地址',
	email varchar(50) comment '邮箱',
	fax varchar(50) comment '传真',
    enabled int not null default 1 comment '是否生效',
    create_time datetime not null default now() comment '创建时间',
    update_time datetime not null default now() comment '更新时间',
	primary key(id),
	unique (name), 
	unique (code)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  comment '组织表';

drop table if exists user;
create table user(
    id bigint not null auto_increment comment '主键id',
    org_id bigint not null comment '组织id',
    user_name varchar(50) not null comment '用户名称',
	real_name varchar(20) not null comment '真实姓名',
    pwd varchar(200) not null comment '密码',
	tel varchar(50) comment '电话',
	addr varchar(500) comment '地址',
	email varchar(50) comment '邮箱',
    enabled int not null default 1 comment '是否生效',
    create_time datetime not null default now() comment '创建时间',
    update_time datetime not null default now() comment '更新时间',
    	primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  comment '用户表';

drop table if exists role;
create table role(
    id bigint not null auto_increment comment '主键id',
    role_name varchar(50) not null comment '角色名称',
    enabled int not null default 1 comment '是否生效',
    create_time datetime not null default now() comment '创建时间',
    update_time datetime not null default now() comment '更新时间',
    	primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  comment '角色表';
    
drop table if exists user_role;
create table user_role(
    id bigint not null auto_increment comment '主键id',
    user_id bigint not null comment '用户id',
    role_id bigint not null comment '角色id',
    create_time datetime not null default now() comment '创建时间',
    update_time datetime not null default now() comment '更新时间',
    	primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  comment '用户角色表';
  
drop table if exists role_authority;
create table role_authority(
    id bigint not null auto_increment comment '主键id',
	role_id bigint not null comment '角色id',
    auth_id varchar(50) not null comment '权限id',
    create_time datetime not null default now() comment '创建时间',
    update_time datetime not null default now() comment '更新时间',
    	primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  comment '角色权限表';

drop table if exists authority;
create table authority(
    id bigint not null auto_increment comment '主键id',
	auth_key varchar(50) not null comment '权限key',
    auth_desc varchar(50) not null comment '权限描述',
    create_time datetime not null default now() comment '创建时间',
    update_time datetime not null default now() comment '更新时间',
    	primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  comment '权限定义表';
  
 drop table if exists process_log;
 create table process_log(
     id bigint not null auto_increment comment '主键id',
     module varchar(50) not null comment '模块',
     operation varchar(50) not null comment '操作',
     detail varchar(1000) comment '信息',
     create_time datetime not null default now() comment '创建时间',
     update_time datetime not null default now() comment '更新时间',
    	primary key (id)
 ) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  comment '日志表';