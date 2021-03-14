# 实体数据
1.数据类型表示实体数据的类型是什么，使用的是MIME type，相关的头字段是Accept和Content-Type
2.数据编码表示实体数据的压缩方式，相关的头字段是Accept-Encoding和Content-Encoding
3.语言类型表示实体数据的自然语言，相关的头字段是Accept-Language和Content-Language
4.字符集表示实体数据的编码方式，相关的头字段是Accept-Charset和Content-Charset
5.客户端需要在请求头里使用Accept等头字段与服务器进行内容协商，要求服务器返回合适的数据
6.Accept 等头字段可以用“,”顺序列出多个可能的选项，还可以用“;q=”参数来精确指定权重 

# 传输大文件
1.压缩HTML等文本文件是传输大文件最基本的方法
2.分块传输可以流式收发数据，节约内存和宽带，使用响应头字段，使用响应头字段“Transfer-Encoding: chunked”来表示，分块的格式是 16 进制长度头 + 数据块；
3.范围请求可以只获取部分数据，即分块请求，实现视频拖拽或者断点续传，使用请求头字段"Range"和相应头字段”Content-Range“，响应状态码必须是206
4.也可以一次请求多个范围，这时候响应报文的数据类型是“multipart/byteranges”，body里面多个部分会用boundary字符串分隔 
