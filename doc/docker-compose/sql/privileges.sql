use mysql;
select host, user from user;

-- 账户 nacosopr,密码 nacosopr
create user nacosopr identified by 'nacosopr';
grant all on nacos.* to nacosopr@'%' identified by 'nacosopr' with grant option;


-- admin库
create user connoropr identified by 'connoropr';
grant all on connor.* to connoropr@'%' identified by 'connoropr' with grant option;


-- 这一条命令一定要有：
flush privileges;