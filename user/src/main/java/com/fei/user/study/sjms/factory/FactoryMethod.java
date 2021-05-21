package com.fei.user.study.sjms.factory;

/**
 * @author: zhangxinfei
 * create at:  2021/5/17  5:58 下午
 * @description:
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Applicaiton applicaiton = new ConcreteProductA();
        Product product = applicaiton.createProduct();
        product.method1();
    }
}

interface Product{
    public void method1();

}
class ProductA implements Product {
    public void method1(){
        System.out.println("ProductA.method1");
    }
}

class ProductB implements Product {
    public void method1(){
        System.out.println("ProductA.method1");
    }
}

 abstract class Applicaiton{
     abstract Product createProduct();

    Product getObject(String type){
        Product productA = createProduct();

        return productA;
    }
}


class ConcreteProductA extends Applicaiton{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}



/**
 * @Des: 简单工厂模式--这个是一种编程习惯
 * 通过不同的type创建不同的对象
 * @Author: zhangxinfei
 * @Date: 2021/5/17 6:10 下午
 */
class SimpleFactory{
    public static Product createProduct(String type){
        if (type.equals("0")){
            return new ProductA();
        } else if (type.equals("1")){
            return new ProductB();
        } else {
            return null;
        }
    }
}