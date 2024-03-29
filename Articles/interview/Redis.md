### 1.Redis用作消息队列优缺点
- 优点：异步、削峰，提高并发
- 缺点：当处理数据失败，或者服务器宕机，容易造成数据丢失
- 怎么解决？解决：数据处理失败则重新push到新的队列中，定时脚本处理

### 2.redis优缺点
- 优点：
- 1）读写性能优异，读11万次/秒，写8.1万次/秒
- 2）支持数据持久化，AOF和RDB两种方式
- 3）支持事务
- 4）数据结构丰富，value支持string、hash、set、zset、list等数据结构
- 5）支持主从复制
- 缺点
- 1）数据容量有限，只适合较小数据量的高性能操作
- 2）不具备容错和数据恢复功能
- 3）较难支持在线扩容

### 3.redis持久化
- 1）RDB：按照一定时间将内存的数据以快照的形式保存到磁盘当中，是全量备份。RDB持久化，安全性较差，它是正常时期数据备份及 master-slave数据同步的最佳手段，文件尺寸较小，恢复数度较快。
- 2）AOF：将redis执行的每次写命令都记录到日志当中。AOF更安全，可将数据及时同步到文件中，但需要较多的磁盘IO，AOF文件尺寸较大，文件内容恢复相对较慢， 也更完整。

### 4.缓存雪崩、击穿、穿透的问题
[看这里](https://baozhigang.github.io/2021/11/02/redis_%E7%BC%93%E5%AD%98%E9%9B%AA%E5%B4%A9/#more)

### 5.缓存和数据库双写一致性问题
[看这里](https://baozhigang.github.io/2021/11/03/redis_%E7%BC%93%E5%AD%98%E5%92%8C%E6%95%B0%E6%8D%AE%E5%BA%93%E5%8F%8C%E5%86%99%E4%B8%80%E8%87%B4%E6%80%A7%E9%97%AE%E9%A2%98/#more)

### 6.redis和memcache区别
- 存储方式：
    memcache 把数据全部存在内存之中，断电后会挂掉，数据不能超过内存大小
    redis有部份数据存在硬盘上，这样能保证数据的持久性。
- 数据支持类型：
   redis在数据支持上要比memcache多的多。
   redis数据类型：String、Hash、List、Set、SortedSet
   memcache支持简单的数据类型K/V键值对缓存，需要客户端自己处理复杂的对象
- 应用范围
    memcache只能当做缓存，redis的内容是可以落地的，可以作为缓存，同时可以设置master-slave主从复制
- 数据一致性不同
   Memcached提供了cas命令(Check-And-Set)，可以保证多个并发访问操作同一份数据的一致性问题。
   Redis没有提供cas 命令，并不能保证这点，不过Redis提供了事务的功能，可以保证一串命令的原子性。
- 性能对比
    Redis只使用单核，而Memcached可以使用多核，所以平均每一个核上Redis在存储小数据时比Memcached性能更高。而在100k以上的数据中，Memcached性能要高于Redis。
- 内存管理
    Memcached使用预分配的内存池的方式，使用slab和大小不同的chunk来管理内存，内存池的方式可以省去申请/释放内存的开销，并且能减小内存碎片产生，但这种方式也会带来一定程度上的空间浪费。
    Redis使用现场申请内存的方式来存储数据，并且很少使用free-list等方式来优化内存分配，会在一定程度上存在内存碎片。

### 7.跳表
- 1）跳表是可以实现二分查找的有序链表
- 2）每个元素插入时随机生成它的level
- 3）最底层包含所有的元素
- 4）如果一个元素出现在level(x)，那么它肯定出现在x以下的level中
- 5) 每个索引结点包含两个指针，一个向下，一个向右
- 6）跳表查询、插入、删除的时间复杂度都是O(logN),与平衡二叉树接近
- 7）为什么Redis选择使用跳表而不是红黑树来实现有序集合？
    按范围区间查找元素时红黑树的效率没有跳表高。
- 8）参考文章看 [这里](https://www.jianshu.com/p/9d8296562806)

### 8.如何使用Redis实现分布式锁？
> 分布式锁是保存在一个共享系统中的，可以被多个客户端共享访问和获取。
1. 使用 SET $lock_key $unique_val EX $second NX 命令保证加锁原子性，并为锁设置过期时间。
2. 锁的过期时间要提前评估好，要大于操作共享资源的时间
3. 每个线程加锁时设置随机值，释放锁时判断是否和加锁设置的值一致，防止自己的锁被别人修改。
4. 释放锁时使用Lua脚本，保证操作的原子性
5. 基于多个节点的 Redlock，加锁时超过半数节点操作成功，并且获取锁的耗时没有超过锁的有效时间才算加锁成功
6. Redlock释放锁时要对所有节点释放(即使某个节点加锁失败了)，因为加锁时可能发生服务端加锁成功，由于网络问题给客户端回复网络包失败的情况，所以需要把所有节点可能存在的锁都释放掉
7. 如果为了效率，使用基于单个Redis节点的分布式锁即可，此方案缺点是允许锁偶尔失效，优点是简单效率高
8. 如果是为了正确性，业务对结果要求非常严格，建议使用Redlock，但缺点是比较重，部署成本高。
> 参考 https://time.geekbang.org/column/article/301092
>
> http://zhangtielei.com/posts/blog-redlock-reasoning.html

### 9.设置了过期时间，如果业务没有完成，redis锁过期了怎么办？
当客户端加锁成功后，可以启动一个定时任务，每隔10s来检测业务是否处理完成，检测的依据就是判断分布式锁的key是否还存在，如果存在就进行续约。

### 10.Redis内存满了怎么办？
1. 首先为了避免缓存过早被写满，我们需要根据应用数据访问特征和成本开销来综合考虑缓存容量的大小，一般会把缓存容量设置为总数据量的15%-30%。
命令：CONFIG SET maxmemory 4gb(4gb是举个例子)

2. 缓存写满是不可避免的，Redis有自己的缓存淘汰策略，在4.0版本之前有6中淘汰策略：
- a. noeviction(默认策略): 若内存大小达到了maxmemory值，并不会淘汰数据，再有写请求时，Redis直接返回错误。
- b. allkeys-lru: 所有key都是使用LRU算法进行淘汰。
- c. volatile-lru: 所有设置了过期时间的key使用LRU算法进行淘汰。
- d. allkeys-random: 所有key使用随机淘汰的方式进行淘汰。
- e. volatile-random: 所有设置了过期时间的key使用随机淘汰的方式进行淘汰。
- f. volatile-ttl: 所有设置了过期时间的key根据过期时间进行淘汰，越早过期越早被淘汰。

在4.0版本之后又增加了2种
- g. allkeys-lfu: 所有key都是使用LFU算法进行淘汰。
- h. volatile-lfu: 所有设置了过期时间的key使用LFU算法进行淘汰。

3. LRU算法
我们来讲讲LRU算法，全称是 Least Recently Used, 即按照最近最少使用的原则来筛选数据，最不常使用的数据会被筛选出来进行淘汰。
底层原理：LRU用一个链表来维护数据，链表头部是MRU端，代表最最近常使用的数据；尾部是LRO端，代表最近不常用的数据。数据访问时根据移动链表来维护数据的最近常用性。
LRU算法有两个问题：1）用链表管理所有的缓存数据会带来额外的空间开销 2）大量数据访问时，链表的移动操作很耗时，会降低Redis的缓存性能。
在Redis中，对LRU算法做了简化。Redis默认会记录每个数据最近一次访问的时间戳(由对象来维护{lru:时间戳})，淘汰数据时第一次会随机筛选出N个数据，放到一个候选链表当中，把时间戳最小的淘汰。(N用配置参数maxmemory-samples来设置)。
当再次淘汰数据时，Redis会挑选时间戳小于候选链表中最小时间戳的数据放到候选链表中，然后把时间戳最小的淘汰出去。

4. LFU算法
Redis从4.0版本之后增加了LFU策略，是对LRU策略的进一步优化。全称 Least Frequently Used。核心思想是根据key最近被访问的频率进行淘汰。即，优先淘汰最近访问频率小的数据，如果频率相同，则淘汰最近最少使用的数据。
底层原理：把lru策略中的lru字段(24bit)差分成两部分，前16bit为ldt值来表示数据访问的时间戳，后8bit为counter值，表示数据的访问次数。

5. 淘汰策略小结
- 如果一部分是热点数据，一部分是冷门数据这样的缓存分布情况，建议使用allkeys-lru或者allkeys-lfu策略。
- 如果业务应用中数据访问频率相差不大，建议用allkeys-random策略。
- 如果业务中有置顶的需求，可以使用volatile-lru或者volatile-lfu策略，同时不给这些置顶数据设置过期时间。

### 11.Redis为什么这么快？
1. 基于内存的操作
2. 采用了高效的数据结构，如哈希表，跳表
3. 采用了多路复用机制，使其在网络I/O操作中能并发处理大量的客户端请求
4. 单线程可以避免不必要的上下文切换，减少了性能消耗

### 12.Redis的string类型


> 大厂常见面试题：https://jishuin.proginn.com/p/763bfbd57a6d