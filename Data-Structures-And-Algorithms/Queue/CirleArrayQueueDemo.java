public class CirleArrayQueueDemo {
    public static void main(String[] args) {
        CirleArrayQueue queue = new CirleArrayQueue(4);
        char key = ' '; // 获取用户的输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数为：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("退出队列：");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序已退出");
    }
}

class CirleArrayQueue {
    private int maxSize;
    private int front;  // 指向队列头部下标;
    private int rear;   // 指向队列尾部下标后面一个位置
    private int[] arr;

    public CirleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr     = new int[maxSize];
        rear    = 0;
        front   = 0;
    }

    public boolean isFull() {
        return (rear + 1)%maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        int temp = arr[front];
        front++;
        return temp;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列已空");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d] = %d\n", i%maxSize, arr[i%maxSize]);
        }

    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}

