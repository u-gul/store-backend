package com.sigma.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//        var orderService = context.getBean(OrderService.class);
//        OrderService orderService = new OrderService(new PayPalPaymentService());
//        orderService.setPaymentService(new PayPalPaymentService());
//        orderService.placeOrder();
//        var notificationManager = context.getBean(NotificationManager.class);
//        notificationManager.sendNotification("Your bill is due, please pay asap");

        UserService userService = context.getBean(UserService.class);
        userService.registerUser(new User(101, "hitman@gmail.com", "abc", "Hitman"));
        userService.registerUser(new User(102, "vk@gmail.com", "xyz", "VK"));
        System.out.println("Printing all users below");
        userService.getAllUsers();
    }
}
