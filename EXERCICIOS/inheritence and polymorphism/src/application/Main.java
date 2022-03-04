/*
   Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário). Ao final,
mostrar a etiqueta de preço de cada produto na mesma ordem em que foram digitados.
   Todos produtos possuem nome e preço. Produtos importados possuem uma taxa de alfândega, e
produtos usados possuem data de fabricação. Estes dados específicos devem ser acrescentados
na etiqueta de preço.
   Para produtos importados, a taxa e alfândega deve ser acrescentada ao preço final do produto.
*/


package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        for (int i =1; i <=n; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)?");
            char ch = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();

            // if used product
            if (ch == 'u') {
                System.out.print("Manufactured date (DD/MM/YYYY): ");
                Date date = sdf.parse(scanner.next());

                list.add(new UsedProduct(name, price, date));
            }
            // if imported product
            if (ch == 'i') {
                System.out.print("Custom fee: ");
                double customFee = scanner.nextDouble();

                list.add(new ImportedProduct(name, price, customFee));
            }
            // if common product
            if(ch == 'i') {
                list.add(new Product(name, price));
            }
        }

        // OUTPUT
        System.out.println();
        System.out.println("PRICE TAGS:");
        for(Product prod : list){
            System.out.println(prod.priceTag());
        }

    }
}
