package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(new Car("Model1",1));
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(new Car("Model2",2));
      userService.add(user2);

      System.out.println(userService.getUserByCar("Model1", 1));
      System.out.println(userService.getUserByCar("Model2", 2));

      context.close();
   }
}
