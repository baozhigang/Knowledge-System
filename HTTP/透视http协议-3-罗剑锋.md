# 实体数据
1.数据类型表示实体数据的类型是什么，使用的是MIME type，相关的头字段是Accept和Content-Type
2.数据编码表示实体数据的压缩方式，相关的头字段是Accept-Encoding和Content-Encoding
3.语言类型表示实体数据的自然语言，相关的头字段是Accept-Language和Content-Language
4.字符集表示实体数据的编码方式，相关的头字段是Accept-Charset和Content-Charset
5.客户端需要在请求头里使用Accept等头字段与服务器进行内容协商，要求服务器返回合适的数据
6.Accept 等头字段可以用“,”顺序列出多个可能的选项，还可以用“;q=”参数来精确指定权重 

