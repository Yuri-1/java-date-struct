package DataStruct.DataStruct;

import java.util.Scanner;

public class CirclrArrayDemo {
    public static void main(String[] args)
    {
        //测试
//        ArrayQueue arrayQueue = new ArrayQueue(3);
        ArrayQueueDemo.ArrayQueue queue = new ArrayQueueDemo.ArrayQueue(3);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key=scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':  //取出数据
                    try{
                        int res=queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try{
                        int res=queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满");
            return ;
        }
        //rear本身就指向后一个元素，直接赋值
        arr[rear] = n;
        //将rear后移，必须考虑取模
        rear = (rear + 1)%maxSize;
    }

    public int getQueue(){
        if(isEmpty())
        {
            //异常
            throw new RuntimeException("队列空，不能取数据");
        }
        /**
         * front是第一个元素
         * 1.先将front指向的值保存到另一个临时变量里
         * 2.将front后移，注意考虑取模
         * 3.将临时保存的变量返回（若不保存，返回后方法结束，front不能移动）
         */
        int value = arr[front];
        front = (front +1)%maxSize;
        return value;
    }

    public int size()
    {
        return  (rear + maxSize -front) % maxSize;
    }

    //打印队列，循环需要知道长度
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，无法遍历");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //显示头元素
    public int headQueue(){
        if(isEmpty())
        {
//                System.out.println("队列空");
            throw new RuntimeException("队列空");
        }
        return arr[front];//front指向第一个元素
    }

}
