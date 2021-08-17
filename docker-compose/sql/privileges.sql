use mysql;
select host, user from user;

-- 账户 nacosopr,密码 nacosopr
create user nacosopr identified by 'nacosopr';
grant all on nacos.* to nacosopr@'%' identified by 'nacosopr' with grant option;


-- 这个中间件没什么用
-- redis manager
-- create user redis_manager_orp identified by 'redis_manager_orp';
-- grant all on redis_manager.* to redis_manager_orp@'%' identified by 'redis_manager_orp' with grant option;




-- 这一条命令一定要有：
flush privileges;