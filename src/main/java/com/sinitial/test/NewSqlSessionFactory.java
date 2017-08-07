package com.sinitial.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class NewSqlSessionFactory {

    private NewSqlSessionFactory() {
    }

//    更改xml文件可切换数据库，可选mariadb和oracle
    private static final String DB = "mariadb";
    private static final String MYBATIS_RESOURCE = "mybatis/" + DB + "/Configuration.xml";

    private static SqlSessionFactory sqlSessionFactory = null;

//    静态内部类，只允许new一次
    private static class SingleSessionHolder {
        private static final SqlSessionFactory INSTANCE() {
//            打开输入输出流，sqlsession的close方法可以关闭输入输出流，故抛出，在调用此方法的方法中关闭
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(MYBATIS_RESOURCE);
            } catch (IOException e) {
                e.printStackTrace();
            }
//        根据配置文件得到sqlSessionFactory
            return new SqlSessionFactoryBuilder().build(inputStream);
        }
    }

    /**
     * 用来获取sqlsession的通用方法
     *
     * @return sqlsession
     */
    public static SqlSessionFactory getSessionFactory() {
        return SingleSessionHolder.INSTANCE();
    }
}
