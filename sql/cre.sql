
-- 文章
create table tb_art(
    -- id
    a_id INT not null auto_increment primary key,
    -- 标题
    title varchar(255) not null,
    -- 作者
    author varchar(255) not null,
    -- 时间戳
    a_date BIGINT not null,
    -- 内容前面一部分
    content text not null,
    -- 内容 md 文件 url
    url varchar(255) not null
);

-- 用户 表
create table tb_user(
    -- id
    u_id int not null auto_increment primary key,
    -- phone number
    u_number int(11),
    -- email
    u_email varchar(255),
    -- 等级
    u_level int(2),
    -- username
    u_name varchar(20) not null unique,
    -- psd
    u_password varchar(32) not null,
    -- 公司
    u_company varchar(50),
    -- title
    u_title varchar(22),
    -- 头像 url
    u_avatar varchar(255) not null default '',
);