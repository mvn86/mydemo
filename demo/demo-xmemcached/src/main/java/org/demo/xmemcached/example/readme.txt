因为XMemcachedClient的创建有比较多的可选项，因此提供了一个XMemcachedClientBuilder类用于构建MemcachedClient。
MemcachedClient是主要接口，操作memcached的主要方法都在这个接口，XMemcachedClient是它的一个实现。
传入的memcached节点列表要求是类似"host1:port1 host2:port2 …"这样的字符串，通过AddrUtil.getAddresses方法获取实际的IP地址列表。

存储数据是通过set方法，它有三个参数，
				第一个是存储的key名称，
				第二个是expire时间（单位秒），超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月），
				第三个参数就是实际存储的数据，可以是任意的java可序列化类型。
				
获取存储的数据是通过get方法，传入key名称即可。
如果要删除存储的数据，这是通过delete方法，它也是接受key名称作为参数。


XMemcached由于是基于nio，因此通讯过程本身是异步的，client发送一个请求给memcached，你是无法确定memcached什么时候返回这个应答，客户端此时只有等待，因此还有个等待超时的概念在这里。
客户端在发送请求后，开始等待应答，如果超过一定时间就认为操作失败，这个等待时间默认是5秒(1.3.8开始改为5秒，之前是1秒），
上面例子展现的3个方法调用的都是默认的超时时间，这三个方法同样有允许传入超时时间的重载方法，例如

   value=client.get(“hello”,3000);

就是等待3秒超时，如果3秒超时就跑出TimeutException，用户需要自己处理这个异常。

因为等待是通过调用CountDownLatch.await(timeout)方法，因此用户还需要处理中断异常InterruptException。最后的MemcachedException表示Xmemcached内部发生的异常，如解码编码错误、网络断开等等异常情况。 