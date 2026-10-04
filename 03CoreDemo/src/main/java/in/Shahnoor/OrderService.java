package in.Shahnoor;

import in.Shahnoor.notification.NotificationService;

public class OrderService {
//    EmailService notification=new EmailService();
//
//    public void PlacedOrder(){
//
//        //orderService is depended on EmailService
//        System.out.println("order is placed");
//        notification.SendNotification();
//
//    }



//why we create notification object here instead of creating it we can just declair the notification obj

    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification=notification;
    }
    public void placedOrder(){
        System.out.println("Order Placed");
        notification.sendNotification();
    }
}
