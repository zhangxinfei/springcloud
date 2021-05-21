package com.fei.user.study.sjms.factory;

/**
 * @author: zhangxinfei
 * create at:  2021/5/20  2:43 下午
 * @description:
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlDataBaseUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();
    }
}

/**
 * 使用场景：
 * MySQL数据的连接，sql命令的发送
 */
//发动接口
interface ICommand{
    void command();
}

//连接接口
interface IConnection{
    void connect();
}

//基础方法
interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

/**
 * @Des: mysql 数据库的连接
 * @Author: zhangxinfei
 * @Date: 2021/5/20 2:57 下午
 */
class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connected");
    }
}

/**
 * @Des: MySQL数据库的命令发送
 * @Author: zhangxinfei
 * @Date: 2021/5/20 2:58 下午
 */
class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MysqlDataBaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

/**
 * 还可以再实现一个Redis或者其他数据库的连接，命令发送的实现
 * 这样就构成了抽象工厂模式
 * 如果只有一个MySQL的实现类，这样的话就是工厂方法模式的实现
 * 但是如果再实现了一个Redis的实现类、mongdb的实现类，这样多个实现的话就是抽象工厂模式
 */