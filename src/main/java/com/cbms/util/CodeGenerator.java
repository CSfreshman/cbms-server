package com.cbms.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

/**
 * @Author gys619
 * @Date: 2023/04/10
 * @Description mybatis-plus 代码生成器
 */
@Slf4j
public class CodeGenerator {
    //测试数据库
    private static String TEST = "8.130.96.64:3306";
    private static String TEST_USERNAME = "root";
    private static String TEST_PASSWORD = "W809434255wzw";
    private static String DBName = "ContractManagementSystem";
    //表名
    private static String DATA_BASE = "cbms_user";
    //全局输入路径  位置精确到: main/java就行
    private static String GLOBAL_PATH = "E:\\data\\cbms\\cbms-server\\src\\main\\java";
    //实体类自定义路径 位置精确到:具体包路径
    private static String ENTITY_PATH = "E:\\data\\cbms\\cbms-server\\src\\main\\java\\com\\cbms\\entity";
    //作者
    private static String AUTHOR = "wuziwen";

    public static void main(String[] args) {
        //连接
        FastAutoGenerator.create("jdbc:mysql://"+TEST+"/"+DBName+"?useSSL=false&useUnicode=true&characterEncoding=utf-8" +
                                "&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true" +
                                "&tinyInt1isBit=false&allowMultiQueries=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true",
                        TEST_USERNAME,
                        TEST_PASSWORD)

                // 全局配置
                .globalConfig(builder -> {
                    builder
                            .enableSwagger() // 是否启用swagger注解
                            .author(AUTHOR) // 作者名称
                            .dateType(DateType.ONLY_DATE) // 时间策略
                            .commentDate("yyyy-MM-dd") // 注释日期
                            .outputDir(GLOBAL_PATH) // 输出目录 快捷键: CTRL+SHIFT+C
                            .disableOpenDir(); // 生成后禁止打开所生成的系统目录
                })

                // 包配置
                .packageConfig(builder -> {
                    builder
                            .parent("com.cbms") //父包名 快捷键:CTRL+SHIFT+ALT+C
                            .moduleName("") // 模块包名 空:当前包下
                            .entity("entity") // 实体类包名
                            .service("service") // service包名
                            .serviceImpl("service.impl") // serviceImpl包名
                            .mapper("mapper") // mapper包名
                            .xml("mapper") // mapper包名
//					.pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\work\\blade-service\\blade-electric\\src\\main\\resources")) // xml位置（还可自定义配置entity，service等位置）
                            //实体类自定义位置 :精确到包
                            .pathInfo(Collections.singletonMap(OutputFile.entity,ENTITY_PATH ))
                            .controller("controller"); // controller包名

                })

                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            //.addTablePrefix("blade_") // 增加过滤表前缀
//					.addTableSuffix("_db") // 增加过滤表后缀
//					.addFieldPrefix("t_") // 增加过滤字段前缀
//					.addFieldSuffix("_field") // 增加过滤字段后缀
                            .addInclude(DATA_BASE) // 表匹配

                            // Entity 策略配置
                            .entityBuilder()
                            .enableLombok() // 开启lombok
                            .enableChainModel() // 链式
                            .enableRemoveIsPrefix() // 开启boolean类型字段移除is前缀
                            .enableTableFieldAnnotation() //开启生成实体时生成的字段注解
//					.versionColumnName("version") // 乐观锁数据库字段
//					.versionPropertyName("version") // 乐观锁实体类名称
                            .logicDeleteColumnName("is_deleted") // 逻辑删除数据库中字段名
                            .logicDeletePropertyName("deleted") // 逻辑删除实体类中的字段名
                            .naming(NamingStrategy.underline_to_camel) // 表名 下划线 -》 驼峰命名
                            .columnNaming(NamingStrategy.underline_to_camel) // 字段名 下划线 -》 驼峰命名
                            .idType(IdType.ASSIGN_ID) // 主键生成策略 雪花算法生成id
                            .formatFileName("%s") // Entity 文件名称
//                            .addTableFills(new Column("create_time", FieldFill.INSERT)) // 表字段填充
//                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE)) // 表字段填充
                            .enableColumnConstant()
                            .enableActiveRecord()
                            //.superClass("org.springblade.core.mp.base.BaseEntity")//继承父类

                            // Controller 策略配置
                            .controllerBuilder()
                            .enableRestStyle() // 开启@RestController
                            .formatFileName("%sController") // Controller 文件名称

                            // Service 策略配置
                            .serviceBuilder()
                            .formatServiceFileName("I%sService") // Service 文件名称
                            .formatServiceImplFileName("%sServiceImpl") // ServiceImpl 文件名称
                            .superServiceClass(IService.class)//service接口父类
                            .superServiceImplClass(ServiceImpl.class)//service实现类父类

                            // Mapper 策略配置
                            .mapperBuilder()
//					.enableMapperAnnotation() // 开启@Mapper
                            .enableBaseColumnList() // 启用 columnList (通用查询结果列)
                            .enableBaseResultMap() // 启动resultMap
                            .formatMapperFileName("%sMapper") // Mapper 文件名称
                            .formatXmlFileName("%sMapper")
                            .superClass(BaseMapper.class); // Xml 文件名称

                })
                //模板引擎
                .templateEngine(new FreemarkerTemplateEngine())
                .execute(); // 执行
        log.info("【检查实体类】DATA_BASE={}",DATA_BASE);
    }


}
