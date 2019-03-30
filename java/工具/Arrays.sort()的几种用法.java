Java的Arrays类中有一个sort()方法，该方法是Arrays类的静态方法，在需要对数组进行排序时，非常的好用。

但是sort()的参数有好几种，这几种形式的用法。

======================================================

1、Arrays.sort(int[] a)

这种形式是对一个数组的所有元素进行排序，并且是按从小到大的顺序。

举例如下（点“+”可查看代码）：


 1 import java.util.Arrays;
 2 
 3 public class Main {
 4     public static void main(String[] args) {
 5         
 6         int[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
 7         Arrays.sort(a);
 8         for(int i = 0; i < a.length; i ++) {
 9             System.out.print(a[i] + " ");
10         }
11     }
12 
13 }
View Code
运行结果如下：

0 1 2 3 4 5 6 7 8 9 

---------------------------------------------------------

2、Arrays.sort(int[] a, int fromIndex, int toIndex)

这种形式是对数组部分排序，也就是对数组a的下标从fromIndex到toIndex-1的元素排序，注意：下标为toIndex的元素不参与排序哦！

举例如下（点“+”可查看代码）：


 1 import java.util.Arrays;
 2 
 3 public class Main {
 4     public static void main(String[] args) {
 5         
 6         int[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
 7         Arrays.sort(a, 0, 3);
 8         for(int i = 0; i < a.length; i ++) {
 9             System.out.print(a[i] + " ");
10         }
11     }
12 
13 }
View Code
运行结果如下：

7 8 9 2 3 4 1 0 6 5 

上例只是把 9 8 7排列成了7 8 9

----------------------------------------------------------

3、public static <T> void sort(T[] a,int fromIndex, int toIndex,  Comparator<? super T> c)

上面有一个拘束，就是排列顺序只能是从小到大，如果我们要从大到小，就要使用这种方式

这里牵扯到了Java里面的泛型，如果读者不是很了解，可以暂时不去管它，如果真的很想了解，建议查阅上面我推荐的那本书，上面有详细的介绍。

读者只需要读懂下面的例子就可以了，其实就是多了一个Comparator类型的参数而已。


 1 package test;
 2 
 3 import java.util.Arrays;
 4 import java.util.Comparator;
 5 
 6 public class Main {
 7     public static void main(String[] args) {
 8         //注意，要想改变默认的排列顺序，不能使用基本类型（int,double, char）
 9         //而要使用它们对应的类
10         Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
11         //定义一个自定义类MyComparator的对象
12         Comparator cmp = new MyComparator();
13         Arrays.sort(a, cmp);
14         for(int i = 0; i < a.length; i ++) {
15             System.out.print(a[i] + " ");
16         }
17     }
18 }
19 //Comparator是一个接口，所以这里我们自己定义的类MyComparator要implents该接口
20 //而不是extends Comparator
21 class MyComparator implements Comparator<Integer>{
22     @Override
23     public int compare(Integer o1, Integer o2) {
24         //如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值，
25         //这样颠倒一下，就可以实现反向排序了
26         if(o1 < o2) { 
27             return 1;
28         }else if(o1 > o2) {
29             return -1;
30         }else {
31             return 0;
32         }
33     }
34     
35 }
View Code
运行结果如下：

9 8 7 6 5 4 3 2 1 0 
