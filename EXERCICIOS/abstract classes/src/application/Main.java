package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers:");
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println("Tax payer #" +i +" data:");
            System.out.print("Individual or company(i/c): ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.next();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if(ch == 'i'){
                System.out.print("Health expenditures: ");
                double health = sc.nextDouble();
                taxPayers.add(new Individual(name, anualIncome, health));
            }
            if (ch == 'c'){
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                taxPayers.add(new Company(name, anualIncome, numberEmployees));
            }
        }

        double sum = 0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayer payer : taxPayers) {
            double tax = payer.tax();
            System.out.println(payer.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
        sc.close();
    }
}
