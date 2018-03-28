# RESTful API 练习

## 练习描述
- 在已有的 `Sping Data JPA` 项目基础上，添加Address实体，其中Address和Employee是**一对一**的关系
- 使用RESTful API 对Employee和Address实体进行**CURD**(增删改查)操作
- 学习使用级联删除，当删除Employee时，其对应的Address也应该被删除
- 使用RESTful API实现对Employee的分页查询
- 使用RESTful API实现对Employee的筛选(eg：查询出所有男性Employee)

## 环境要求
- java8
- spring-boot
- Intellij-IDEA
- MySQL
- postman

## 如何开始
- 使用已有的 `Sping Data JPA`， 项目作为 `code base`（或者使用此任务卡代码模版即可）
- 创建Address实体，实现Address和Employee的一对一关系
- 使用RESTful API实现所有接口
- 使用postman对API进行测试
- 将使用postman测试接口的页面截图，并放在`result`文件中
## 输出规范
- RESTful API的实现
- 包含结果截图的result文件夹
