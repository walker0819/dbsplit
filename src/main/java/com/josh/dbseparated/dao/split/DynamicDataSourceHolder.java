package com.josh.dbseparated.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceHolder {
    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";

    /**
     * @Description: 获取线程的DbType
     * @Param: args
     * @return: String
     * @Author: Object
     * @Date: 2019年11月30日
     */
    public static String getDbType() {
        String db = contextHolder.get();
        if (db == null) {
            db = "master";
        }
        return db;
    }

    /**
     * @Description: 设置线程的DbType
     * @Param: args
     * @return: void
     * @Author: Object
     * @Date: 2019年11月30日
     */
    public static void setDbType(String str) {
        logger.info("所使用的数据源为:" + str);
        contextHolder.set(str);
    }

    /**
     * @Description: 清理连接类型
     * @Param: args
     * @return: void
     * @Author: Object
     * @Date: 2019年11月30日
     */
    public static void clearDbType() {
        contextHolder.remove();
    }
}
