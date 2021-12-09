package com.yunxi.mall.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @description: TODO 生成自动化代码
 * @refer_link: https://www.modb.pro/db/50566
 * @author: qpf
 * @date: 2021/12/8
 * @version: 1.0
 */
public class GenerateCode {


    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //生成文件的输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //开发人
        gc.setAuthor("齐鹏飞");
        //是否打开输出目录
        gc.setOpen(false);
        //是否覆盖已有文件，默认false
        gc.setFileOverride(true);
        //实体属性 Swagger2 注解
        gc.setSwagger2(true);
        //mapper.xml中生成通用查询结果列
        gc.setBaseColumnList(true);
        //mapper.xml中生成通用查询映射结果
        gc.setBaseResultMap(true);
        //设置Controller、Mapper、mapper.xml等命名方式，使用默认即可。
        /*gc.setServiceName("%sService");
        gc.setControllerName();
        gc.setMapperName();
        gc.setEntityName();
        gc.setXmlName();
        gc.setServiceImplName();*/
        mpg.setGlobalConfig(gc);


        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        //数据库 schema name
        // dsc.setSchemaName("public");
        //数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //数据库连接用户名
        dsc.setUsername("root");
        //数据库连接密码
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);


        //包配置
        PackageConfig pc = new PackageConfig();
        //父包模块名
        pc.setModuleName("tiny");
        //父包名，如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.yunxi.mall");
        //设置Controller、Mapper、mapper.xml等存放的包名
        /*pc.setController();
        pc.setEntity();
        ...*/
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否为lombok模型，默认false
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //需要包含的表名，允许正则表达式
        strategy.setInclude("ums_member");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //表前缀
        // strategy.setTablePrefix("tb_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
