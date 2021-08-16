## 测试mysql镜像的构建
## from this blog
## https://guanpengchn.gitbooks.io/lazy-blog/content/blog/li-yong-dockerfile-gou-jian-mysql-jing-xiang-bing-shi-xian-shu-ju-de-chu-shi-hua-ji-quan-xian-she-zhi.html
## 构建命令
## docker build -t connor-cloud/mysql:0.1 .
FROM mysql:5.7

#设置免密登录, 会导致root用户无法远程登录,但是没关系,不要纠结
# ENV MYSQL_ALLOW_EMPTY_PASSWORD yes


#将所需文件放到容器中
COPY setup.sh /mysql/setup.sh
COPY nacos-schema.sql /mysql/nacos-schema.sql
COPY privileges.sql /mysql/privileges.sql

#设置容器启动时执行的命令
CMD ["sh", "/mysql/setup.sh"]





