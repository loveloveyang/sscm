import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println("请输入要计算的斐波那契数");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr=fibonacci(n);
        System.out.println("斐波那契数如下："+arr);

    }
    public static int fibonacci(int n){
        int n1=1;//第一个数
        int n2=1;//第二个数
        int n3;//计算的数

            if(n<=0){
                return 0;
            }
            if (n == 1||n==2) {
                return 1;
            }
            for(int i=3;i<=n;i++){
                n3=n1+n2;
                n1=n2;
                n2=n3;
                //System.out.println(n3+",");
            }
            return n2;
    }

}
