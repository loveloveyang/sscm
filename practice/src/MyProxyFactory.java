import proxyResources.UserService;
import proxyResources.UserServiceInstence;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理设计模式
public class MyProxyFactory {
    public static UserService createProxy(){
        //创建被代理对象
        final UserService userService=new UserServiceInstence();

        //创建代理对象
        return Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        TransactionManager.begin;
                        Object o=null;
                       try {
                           method.invoke(userService,args);
                           TransactionManeger.commit;
                       }catch (Exception e){
                           TransactionManager.rollback;
                       }
                       return o;


                    }
                });
    }













}


