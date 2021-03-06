# Nginx 高性能Web服务器
1.Nginx 是一个高性能的 Web 服务器，它非常的轻量级，消耗的 CPU、内存很少；
2.Nginx 采用“master/workers”进程池架构，不使用多线程，消除了进程、线程切换的成本；
3.Nginx 基于 epoll 实现了“I/O 多路复用”，不会阻塞，所以性能很高；
4.Nginx 使用了“职责链”模式，多个模块分工合作，自由组合，以流水线的方式处理 HTTP 请求。

# OpenResty 更灵活的Web服务器
1.Nginx依赖于磁盘上的静态文件，修改后必须重启才能生效，缺乏灵活性
2.OpenResty基于Nginx，打包了很多有用的模块和库，是一个高性能的Web开发平台
3.OpenResty的工作语言是Lua，它小巧灵活，执行效率高，支持代码热加载
4.OpenResty的核心编程范式是“同步非阻塞”，使用携程，不需要异步回调函数。
5.OpenResty也使用“阶段式处理”的工作模式，但因为在阶段里执行的都是Lua的代码，所以非常灵活，配合Redis等外部数据库能够实现各种灵活配置