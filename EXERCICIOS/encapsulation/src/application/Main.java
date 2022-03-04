/*
Em um banco, para se cadastrar uma conta bancária, é necessário informar o número da conta, o nome do 
titular da conta, e o valor de depósito inicial que o titular depositou ao abrir a conta. Este valor de depósito 
inicial, entretanto, é opcional, ou seja: se o titular não tiver dinheiro a depositar no momento de abrir sua 
conta, o depósito inicial não será feito e o saldo inicial da conta será, naturalmente, zero.
Importante: uma vez que uma conta bancária foi aberta, o número da conta nunca poderá ser alterado. Já 
o nome do titular pode ser alterado (pois uma pessoa pode mudar de nome por ocasião de casamento, por 
exemplo). 
Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver um mecanismo para proteger 
isso. O saldo só aumenta por meio de depósitos, e só diminui por meio de saques. Para cada saque 
realizado, o banco cobra uma taxa de $ 5.00. Nota: a conta pode ficar com saldo negativo se o saldo não for 
suficiente para realizar o saque e/ou pagar a taxa.
Você deve fazer um programa que realize o cadastro de uma conta, dando opção para que seja ou não 
informado o valor de depósito inicial. Em seguida, realizar um depósito e depois um saque, sempre 
mostrando os dados da conta após cada operação. 
*/

package application;

import entities.ClientAccount;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ClientAccount account;

        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account holder: ");
        String holder = sc.nextLine();
        System.out.print("Is there a initial deposit? (y/n): ");
        char response = sc.next().charAt(0);

        if (response == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new ClientAccount(number, holder, initialDeposit);
        }
        else {
            account = new ClientAccount(number, holder);
        }


        // Account data
        System.out.println();
        System.out.println("Account data: \n" +account);

        // deposit
        System.out.println();
        System.out.print("Enter deposit value: ");
        double deposit = sc.nextDouble();
        account.deposit(deposit);

        // updated data account
        System.out.println("Updated account data: \n" +account);

        // withdraw
        System.out.println();
        System.out.print("Enter withdraw value: ");
        double draw = sc.nextDouble();
        account.drawBalance(draw);

        // updated data account
        System.out.print("Updated account data: \n" +account);

        sc.close();
    }
}
