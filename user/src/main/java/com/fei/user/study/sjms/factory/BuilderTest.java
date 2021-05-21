//package com.fei.user.study.sjms.factory;
//
///**
// * @author: zhangxinfei
// * create at:  2021/5/20  4:53 下午
// * @description:建造者模式
// */
//public class BuilderTest {
//
//    public static void main(String[] args) {
//        DefaultConcreProductBuilder defaultConcreProductBuilder = new DefaultConcreProductBuilder();
//
//        Director director = new Director(defaultConcreProductBuilder);
////        director.makeProduct()
//
//
//    }
//}
//
//interface ProductBuilder{
//    void builderProductName(String productName);
//    void builderCompanyName(String productName);
//    void builderPart1(String part1);
//    void builderPart2(String part1);
//    void builderPart3(String part1);
//    void builderPart4(String part1);
//
//    Product build();
//}
//
///**
// * @Des: 默认构造器
// * @Author: zhangxinfei
// * @Date: 2021/5/20 5:12 下午
// */
//class DefaultConcreProductBuilder implements ProductBuilder{
//
//    private String productName;
//    private String companyName;
//    private String part1;
//    private String part2;
//    private String part3;
//    private String part4;
//
//    @Override
//    public void builderProductName(String productName) {
//        this.companyName = productName;
//    }
//
//    @Override
//    public void builderCompanyName(String companyName) {
//        this.productName = companyName;
//    }
//
//    @Override
//    public void builderPart1(String part1) {
//        this.part1 = part1;
//    }
//
//    @Override
//    public void builderPart2(String part2) {
//        this.part2 = part2;
//    }
//
//    @Override
//    public void builderPart3(String part3) {
//        this.part3 = part3;
//    }
//
//    @Override
//    public void builderPart4(String part4) {
//        this.part4 = part4;
//    }
//
//    @Override
//    public Product build() {
////        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
//    }
//}
//
///**
// * @Des: 其他的构造器
// * @Author: zhangxinfei
// * @Date: 2021/5/20 5:09 下午
// */
//class SpecialConcreProductBuilder implements ProductBuilder{
//
//    private String productName;
//    private String companyName;
//    private String part1;
//    private String part2;
//    private String part3;
//    private String part4;
//
//    @Override
//    public void builderProductName(String productName) {
//        this.companyName = productName;
//    }
//
//    @Override
//    public void builderCompanyName(String companyName) {
//        this.productName = companyName;
//    }
//
//    @Override
//    public void builderPart1(String part1) {
//        this.part1 = part1;
//    }
//
//    @Override
//    public void builderPart2(String part2) {
//        this.part2 = part2;
//    }
//
//    @Override
//    public void builderPart3(String part3) {
//        this.part3 = part3;
//    }
//
//    @Override
//    public void builderPart4(String part4) {
//        this.part4 = part4;
//    }
//
//    @Override
//    public Product build() {
////        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
//    }
//}
//
//class Director{
//    private ProductBuilder builder;
//
//    public Director(ProductBuilder builder) {
//        this.builder = builder;
//    }
//
//    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4){
//
//        builder.builderProductName(productName);
//        builder.builderCompanyName(companyName);
//        builder.builderPart1(part1);
//        builder.builderPart2(part2);
//        builder.builderPart3(part3);
//        builder.builderPart4(part4);
//
//        Product product = builder.build();
//        return product;
//    }
//
//}