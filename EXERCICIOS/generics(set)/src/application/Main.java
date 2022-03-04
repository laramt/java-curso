/* Em um portal de cursos online, cada usuário possui um código único, representado por
um número inteiro.
Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se
matricular em quantos cursos quiser. Assim, o número total de alunos de um instrutor não
é simplesmente a soma dos alunos de todos os cursos que ele possui, pois pode haver
alunos repetidos em mais de um curso.
O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.
Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
quantidade total de alunos dele.
 */

package application;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();


        System.out.print("How many students for course A? ");
        int cA = sc.nextInt();

        for (int i=1; i<= cA; i++){
            System.out.print("Student code: ");
            int code = sc.nextInt();
            courseA.add(code);
        }

        System.out.println();
        System.out.print("How many students for course B? ");
        int cB = sc.nextInt();

        for (int i=1; i<= cB; i++){
            System.out.print("Student code: ");
            int code = sc.nextInt();
            courseB.add(code);
        }

        System.out.println();
        System.out.print("How many students for course C? ");
        int cC = sc.nextInt();

        for (int i=1; i<= cC; i++){
            System.out.print("Student code: ");
            int code = sc.nextInt();
            courseC.add(code);
        }

        Set<Integer> total = new HashSet<>();
        total.addAll(courseA);
        total.addAll(courseB);
        total.addAll(courseC);


        System.out.println();
        System.out.println("Total students: " +total.size());

        sc.close();
    }
}
