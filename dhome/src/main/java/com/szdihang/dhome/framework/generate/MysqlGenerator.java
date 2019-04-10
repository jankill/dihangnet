package com.szdihang.dhome.framework.generate;

import com.baomidou.mybatisplus.generator.AutoGenerator;

/* @Author glory
 * @Description Mysql代码生成器
 * @Date 10:03 2019/4/4
 * @Param
 * @return
 **/
public class MysqlGenerator extends SuperGenerator {

    /**
     * <p>
     * MySQL generator
     * </p>
     */
    public void generator(String tableName) {

        // 代码生成器
        AutoGenerator mpg = getAutoGenerator(tableName);
        mpg.execute();
        if (tableName == null) {
            System.err.println(" Generator Success !");
        } else {
            System.err.println(" TableName【 " + tableName + " 】" + "Generator Success !");

        }
    }


}
