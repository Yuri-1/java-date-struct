package DataStruct.DataStruct;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
//        ArrayQueue arrayQueue = new ArrayQueue(3);
        ArrayQueue queue = new ArrayQueue(3);
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


    static class ArrayQueue{
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;   //存放数据，模拟队列

        //创建队列的构造器
        public ArrayQueue(int arrMaxSize){
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;     //指向队列头部的前一个位置
            rear = -1;      //指向队列尾部（含队列尾）

        }

        public boolean isFull(){
            return rear == maxSize -1;
        }

        public boolean isEmpty(){
            return rear == front;
        }

        public void addQueue(int n){
            if(isFull())
            {
                System.out.println("队列满，不能加");
                return ;
            }
            rear ++;
            arr[rear] = n;
        }

        public int getQueue(){
            if(isEmpty())
            {
                //异常
                throw new RuntimeException("队列空，不能取数据");
            }
            front++;
            return arr[front];
        }

        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列空，无法遍历");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d\n",i,arr[i]);
            }
        }

        public int headQueue(){
            if(isEmpty())
            {
//                System.out.println("队列空");
                throw new RuntimeException("队列空");
            }
            return arr[front+1];//front指向前一个位置，所以要+1
        }
    }
}
