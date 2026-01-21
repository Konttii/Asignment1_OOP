package Asignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Portal portal = new Portal("Freelance Portal");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить фрилансера | 2. Список фрилансеров");
            System.out.println("3. Добавить вакансию    | 4. Список вакансий");
            System.out.println("5. Назначить фрилансера  | 6. Выйти");
            System.out.print("Выбор: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Имя фрилансера: ");
                String name = sc.nextLine();
                System.out.print("Навык: ");
                String skill = sc.nextLine();
                portal.addFreelancer(new Freelancer(name, skill));

            } else if (choice.equals("2")) {
                portal.showFreelancers();

            } else if (choice.equals("3")) {
                System.out.print("Название работы: ");
                String title = sc.nextLine();
                System.out.print("Бюджет: ");
                int budget = Integer.parseInt(sc.nextLine());
                portal.addJob(new JobListing(title, budget));

            } else if (choice.equals("4")) {
                portal.showJobs();

            } else if (choice.equals("5")) {
                System.out.print("Введите имя фрилансера: ");
                String fName = sc.nextLine();
                System.out.print("Введите название вакансии: ");
                String jTitle = sc.nextLine();
                portal.assignByNames(fName, jTitle);

            } else if (choice.equals("6")) {
                break;

            } else {
                System.out.println("Ошибка.");
            }
        }
        sc.close();
    }
}