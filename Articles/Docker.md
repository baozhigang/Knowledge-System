# Docker

### 1.参考文档 
    https://yeasy.gitbook.io/docker_practice/

### 2.常用指令
    1）docker run alpine:latest /bin/echo 'Hello world’  新建并启动临时容器
         docker run -dit alpine  新建并启动容器 
    2）docker run -t -i alpine:latest /bin/sh     启动容器终端
    3）docker container ls -a  查看所有的容器  
    4）docker container start/stop  CONTAINER ID   启动或者停止容器
    5）docker exec -it 69d1 sh   进入容器
    6）docker image ls  查看镜像 
    7）docker tag php72 baozhigang2021/php72   推送远程服务器时打标签 
    8）docker-compose up -d 启动镜像组合 
    9）docker-compose down 关闭镜像组合 

### 3.部署项目 
    1.Docker 文件夹复制过去
    2.修改配置文件 docker-compose.yml  volumes数据路径  
    3.php  build-php5.bat windows双击运行  mac复制里面的命令运行 
       同理安装php7
    4.配置本地hosts文件  /etc/hosts
       和 Docker/conf/nginx/conf.d 中的配置文件主机对应上  
    5.运行命令 docker-compose up -d
      没有的镜像会默认远程拉取(自己配置的镜像Dockerfile提前准备了)