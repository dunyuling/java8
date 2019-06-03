##lambda
    + 定义
        * lambda:In Programming languages such as Lisp,Python and Ruby Lambda is an operator
            used to denote anonymous functions or closures ,following the usage of lambda 
            calculus.
    + 概要
        * 匿名函数;没有声明的方法,即没有访问修饰符,返回值声明和名字
        * lambda表达式为java增加了缺失的函数式编程的特性,使我们能将函数当做一等公民看待
        * 在将函数作为一等公民的语言中,lambda表达式的类型是函数.但在java中,lambda表达式是对象,
            他们必须依赖于一类特别的对象类型---函数式接口(function interface)           
    + 用法
        * 函数作为参数
        * 函数作为返回值
    + 写法
        * (param1,param2,param3) -> {body}
        * (type1 param1,typ2 param2, type3 param3) -> {body}    
        
    + Note:(@interface FunctionalInterface)
        Note that instances of functional interfaces can be created with
        lambda expressions, 
        method references(System.out::println),
         or constructor references   
    + 作用
        + 传递行为,而不仅仅是值
            * 提升抽象层次
            * API重用性更好
            * 更加灵活    
    + 高阶函数
        * 如果一个函数接收一个函数作为参数,或者以一个参数作为返回值,那么该函数就是高阶函数.  
    + 实质(以Function接口为例)
        + 传递行为(从内存的角度去理解)
            * 在形参处保留一个Function接口的引用
            * 实际使用的时候再实例化Function接口对象(在堆中),定义具体的apply方法内容;
            * 形参调用apply方法,就相当于已经实例化的对象内定义的apply方法的执行
        + 示例              
            * compute(1, a -> a + 1)
            * public int compute(int a, Function<Integer, Integer> function) {
                return function.apply(a);
              }            
            * computer函数就是一个高阶函数    

## optional
    * 由于 Optional 类 没有实现序列化,故只建议作为方法的返回值,而不是作为方法的参数和对象的field.             

## 方法引用(见 MethodReferenceTest)
    + 方法引用(method reference)            
        * lambda表达式语法糖
        + 分类
            * 类名::静态方法名    
            * 引用名(对象名)::实例方法名
            * 类名::实例方法名(借助this指针)
            * 构造方法引用 类名::new
            
## stream
    + 组成
        * source
        * 零个或多个中间操作
        * 终止操作   
    + 类型
        * 惰性求值,对应中间操作
        * 及早求值,对应终止操作  
    + 流与集合
        + 迭代方式
            * 集合:外部
            * 流:内部
        + 作用方式:
            * 集合:命令式
            * 流:描述式(像SQL)    
        + 一句话概况
            * 集合关注数据与数据存储本身
            * 流关注的是对数据的计算 
    * 无法重复使用                      
    
##注意
    + 这份文档写的过于简略.主要在于学习过程中,大部分时间用于了源码的学习,而自己的理解程度和概况能力尚不足以很好的完善文档细节.故应根据具体代码进行学习    