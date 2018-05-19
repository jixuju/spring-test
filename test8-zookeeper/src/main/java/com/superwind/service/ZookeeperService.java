package com.superwind.service;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiangxj on 2018/4/2.
 */
public class ZookeeperService {
    // 会话超时时间，设置为与系统默认时间一致
    private static final int SESSION_TIMEOUT = 30 * 1000;

    // 创建 ZooKeeper 实例
    private ZooKeeper zk;

    // 创建 Watcher 实例
    private Watcher wh = new Watcher() {
        /**
         * Watched事件
         */
        public void process(WatchedEvent event) {
            System.out.println("WatchedEvent >>> " + event.toString());
        }
    };

    // 初始化 ZooKeeper 实例
    public void createZKInstance() throws IOException {
        // 连接到ZK服务，多个可以用逗号分割写
        zk = new ZooKeeper("192.168.31.98:2181", ZookeeperService.SESSION_TIMEOUT, this.wh);
        if(!zk.getState().equals(ZooKeeper.States.CONNECTED)){
            while(true){
                if(zk.getState().equals(ZooKeeper.States.CONNECTED)){
                    System.out.println("connect ok...");
                    break;
                }
                try {
                    System.out.println("connect fail...");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ZKOperations() throws IOException, InterruptedException, KeeperException {
        System.out.println("\n1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： data1 ，权限： OPEN_ACL_UNSAFE ，节点类型： Persistent");
        zk.create("/zoo2", "data1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println("\n2. 查看是否创建成功： ");
        System.out.println(new String(zk.getData("/zoo2", this.wh, null)));// 添加Watch

        // 前面一行我们添加了对/zoo2节点的监视，所以这里对/zoo2进行修改的时候，会触发Watch事件。
        System.out.println("\n3. 修改节点数据 ");
        zk.setData("/zoo2", "data2".getBytes(), -1);

        // 这里再次进行修改，则不会触发Watch事件，这就是我们验证ZK的一个特性“一次性触发”，也就是说设置一次监视，只会对下次操作起一次作用。
        System.out.println("\n3-1. 再次修改节点数据 ");
        zk.setData("/zoo2", "data3".getBytes(), -1);

        System.out.println("\n4. 查看是否修改成功： ");
        System.out.println(new String(zk.getData("/zoo2", false, null)));

        System.out.println("\n5. 删除节点 ");
        zk.delete("/zoo2", -1);

        System.out.println("\n6. 查看节点是否被删除： ");
        System.out.println(" 节点状态： [" + zk.exists("/zoo2", false) + "]");
    }

    public void ZKClose() throws InterruptedException {
        zk.close();
    }
}
