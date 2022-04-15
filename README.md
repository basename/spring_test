# springboot-template

springboot-template是Springboot项目模版。

基本按标准的Maven项目结构扩展
- java
  - com.bifrost.template(该包名仅用于举例)
    - config : 所有的配置，包括 MySQL、Redis、SpringMvc等
    - constant : 常量类
    - controller : just controller，controller 尽量不写业务逻辑
    - dao : 数据访问层，mybatis xml 也在此维护(如果是多实例，通过新建库名的包进行管理)
    - enums : 枚举类
    - interceptor : 拦截器实现
    - models :
        - pojo : 普通对象，一般对应dao
        - dto : 数据传输对象
        - query : controller 查询对象
    - service : just service interface
    - service/Impl : interface 实现
    - utils : 工具包 // 已提取到inno-common-tools公共jar包
    - *Application : main 入口(*用实际包名代替，比如SpringbootTemplateApplication.class)
- resources
  - logback-spring.xml 日志配置文件
  - application.properties 公共配置
  - application-dev.properties dev环境配置
  - application-test.properties test环境配置
  - application-production.properties production环境配置

## DemoCode

springboot-template项目中的DemoCode对应的底层数据库表

xes_user
- id 
- name : user's name
- email : user's email
- age : user's age
- status : user's status

## 服务端研发规范