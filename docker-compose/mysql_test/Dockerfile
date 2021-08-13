## 测试mysql镜像的构建
## from this blog
## https://guanpengchn.gitbooks.io/lazy-blog/content/blog/li-yong-dockerfile-gou-jian-mysql-jing-xiang-bing-shi-xian-shu-ju-de-chu-shi-hua-ji-quan-xian-she-zhi.html
## 构建命令
## docker build -t connor/docker-mysql:snapshot .
FROM mysql:5.7

#设置免密登录
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes

#将所需文件放到容器中
COPY setup.sh /mysql/setup.sh
COPY schema.sql /mysql/schema.sql
COPY privileges.sql /mysql/privileges.sql

#设置容器启动时执行的命令
CMD ["sh", "/mysql/setup.sh"]





