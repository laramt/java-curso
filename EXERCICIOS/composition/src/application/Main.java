
/* Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
sumário do pedido.
*/

package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");

        // CLIENT DATA
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scanner.next());
        Client client = new Client(name, email, birthDate);

        // ORDER DATA
        System.out.println();
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scanner.next());
        Order order = new Order(new Date(), status, client);

        System.out.print("How many items in this order? ");
        int q = scanner.nextInt();
        for (int i =1; i<=q; i++){
            System.out.println();
            System.out.println("Enter item #" +i +" data: ");
            System.out.print("Product name: ");
            scanner.nextLine();
            String productName = scanner.nextLine();
            System.out.print("Product price: ");
            double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();

            OrderItem items = new OrderItem(quantity, productPrice, new Product(productName));
            order.addItem(items);
        }

        // FINAL OUTPUT
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        scanner.close();
    }
}
