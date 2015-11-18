# dubbox_boot


这个项目使用spring-boot开发dubbox

1. 首先对我们应用进行分层：

- web层
  - api层(consumer)
  - controller(consumer)
  - filter
  - view


- 业务接口层
 - 接口定义层
 - provider业务实现

- 持久化层
  - mysql orm
  - mongbd
  - redis

2. 关键点

+ Annotation放在接口类还是实现类

在一般应用中，我们建议将annotation放到服务实现类，这样annotation和java实现代码位置更接近，更便于开发和维护。
另外更重要的是，我们一般倾向于避免对接口的污染，保持接口的纯净性和广泛适用性。

**But**

如果我们要用dubbo直接开发的消费端来访问此服务，则annotation必须放到接口上。

如果接口和实现类都同时添加了annotation，则实现类的annotation配置会生效，接口上的annotation被直接忽略。


## REST服务消费端详解

+ 场景1：非dubbo的消费端调用dubbo的REST服务
+ 场景2：dubbo消费端调用dubbo的REST服务
+ 场景3：dubbo的消费端调用非dubbo的REST服务

## 遇到的问题

1. 我们大多数应用都是内部调用，所以在provider层提供rest接口的必要性这个需要考虑？
2. provider层使用rest协议时，最好使用tomcat做内嵌的servlet容器

```xml
<dubbo:protocol name="rest" port="9090" server="tomcat" />
```

3. 每个接口使用Annotation声明时选择使用什么协议进行传输，同时在dubbo配置里可以声明每个protocol

4. 多读dubbo和dubbox的文档，网上的文档都是入门的还不如自己看文档

## 参考

+ [dubbo用户指南](http://dubbo.io/Developer+Guide-zh.htm)
+ [dubbox用户指南](http://dangdangdotcom.github.io/dubbox/rest.html)





## Contributing

1.   Fork it
2.   Create you feature branch (`git checkout -b my-new-feature`)
3.   Commit your changes (`git commit -am 'Add some feature'`)
4.   Push to the branch (`git push origin my-new-feature`)
5.   Create new Pull Request

## 版本历史
-   v0.1.0   初始化版本

## 欢迎fork和反馈

在issue提问或邮件 isnow1112@gmail.com

## License

this gem is released under the [MIT License](http://www.opensource.org/licenses/MIT).





