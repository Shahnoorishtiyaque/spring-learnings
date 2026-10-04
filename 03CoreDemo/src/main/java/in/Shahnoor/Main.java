package in.Shahnoor;

//see notification pakage to understand the dependencies injection


import in.Shahnoor.notification.EmailService;
import in.Shahnoor.notification.NotificationService;
import in.Shahnoor.notification.PopUpNotificationService;
import in.Shahnoor.notification.SmsService;

public class Main {

    static void main() {
        NotificationService notification= new EmailService();  // here we can use different class reffrence
//      NotificationService notification= new PopUpNotificationService();
//        NotificationService notification= new SmsService();
        OrderService order = new OrderService(notification);
        order.placedOrder();
    }
}
