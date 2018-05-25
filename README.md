### 这个项目采用的是springboot+tk.mybatis+sqlserver（可以切换至mysql）
1. 其中对service层进行了封装,将Mapper<T> baseMapper封装作为service层的一个对象,而其他映射到Mapper.xml的文件
则是针对特殊需求使用

2. 可以通过修改application.yml,添加mysql的驱动就可以了，另外修改pom文件中的驱动设置为mysql

