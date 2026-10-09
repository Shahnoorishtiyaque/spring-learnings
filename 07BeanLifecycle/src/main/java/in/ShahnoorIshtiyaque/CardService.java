package in.ShahnoorIshtiyaque;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CardService /*implements InitializingBean , DisposableBean*/ {
    Map<Integer, String> mp;
    public CardService(){
        mp= new HashMap<>();
        System.out.println("CardService constructor Called");
    }
    public void addToCart(){
        System.out.println("Added to cart");
    }


//    public void start(){
//        mp.put(1,"Shaan");
//        mp.put(2,"Shahnoor");
//        //init method
//    }
//       public void stop(){
//           System.out.println("bean is getting destroyed");
//           }

    @PreDestroy
    public void stop2(){
        System.out.println("bean is getting destroyed");
    }

      @PostConstruct
      public void start2(){
            mp.put(1,"Shaan");
            mp.put(2,"Shahnoor");
      }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is ready");
//        mp.put(1,"Shaan");
//        mp.put(2,"Shahnoor");
//        //InitializingBean
//    }
    public void add(){
        System.out.println("Added to cart");
    }
    public String getValue(int key){
        return mp.get(key);
    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Bean is getting destroyed");
// //        DisposableBean
//    }
}
