#### Spring Bean Base

- `BeanDefinition`

- bean alias的用处

    - 复用beanDefinition
    - 更具有场景化的命名

- 如何将beanDefinition注册到IOC

    - xml

    - annotation

    - api

        - `BeanDefinitionRegistry` -> 命名方式

          ````java
          @Import(value = AnnotationRegistryBeanDefinitionDemo.Config.class)
          public class AnnotationRegistryBeanDefinitionDemo {
              public static void main(String[] args) {
                  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
                  context.register(Config.class);
                  //命名方式显示注册BeanDefinition
                  BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
                  beanDefinitionBuilder.addPropertyValue("id", 22).addPropertyValue("name", "22");
                  //命名方式
                  registryBeanDefinition(context, "user_1", beanDefinitionBuilder.getBeanDefinition());
                  //非命名方式
                  registryBeanDefinition(context, beanDefinitionBuilder.getBeanDefinition());
                  context.refresh();
          
                  Map<String, Config> configBeans = context.getBeansOfType(Config.class);
                  Map<String, User> userBeans = context.getBeansOfType(User.class);
                  System.err.println("Config Type Beans -> " + configBeans);
                  System.err.println("User Type Beans -> " + userBeans);
                  context.close();
              }
          
              public static void registryBeanDefinition(BeanDefinitionRegistry registry, BeanDefinition beanDefinition){
                  BeanDefinitionReaderUtils.registerWithGeneratedName((AbstractBeanDefinition) beanDefinition, registry);
              }
              private static void registryBeanDefinition(BeanDefinitionRegistry registry, String beanName, BeanDefinition beanDefinition) {
                  if (StringUtils.hasText(beanName)) {
                      registry.registerBeanDefinition(beanName, beanDefinition);
                  }else {
                      BeanDefinitionReaderUtils.registerWithGeneratedName((AbstractBeanDefinition) beanDefinition, registry);
                  }
              }
          
              @Component
              public static  class Config {
                  @Bean
                  public User user(){
                      User user = new User();
                      user.setId(11);
                      user.setName("11");
                      return user;
                  }
              }
          }
          
          ````



    - `BeanDefinitionReaderUtils` -> 非命名方式 

      ````java
      //如上所述
      ````

      