package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PayPalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Date (dd/mm/yyyy): ");
        Date date = sdf.parse(scanner.next());
        System.out.print("Contract value: ");
        double totalValue = scanner.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter number of installments: ");
        int installment = scanner.nextInt();

        ContractService contractService = new ContractService(new PayPalService());

        contractService.processContract(contract, installment);

        System.out.println();
        System.out.println("Installments: ");
        for (Installment i : contract.getInstallments()){
            System.out.println(i);
        }


    }
}
