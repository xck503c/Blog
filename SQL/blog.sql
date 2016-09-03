create database blog character set utf8;

use blog;

#后台管理的侧边栏名称
create table admin_sidebar(
	id int primary key auto_increment,
	name varchar(20)
) character set utf8;

#文章
create table article(
	article_id int primary key auto_increment,
	article_title varchar(150) not null,
	article_content text not null,
	article_time datetime not null,
	article_click int not null,
	article_comment int not null,
	article_grouping int not null,
	article_up int not null,
	article_type int not null,
	article_iscomment int not null
) character set utf8;

#类别
create table article_group(
	grouping_id int primary key auto_increment,
	grouping_name varchar(50) not null,
	grouping_amount int not null,
	grouping_sort_id int
) character set utf8;