package Asignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Portal portal = new Portal("Freelance Portal");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ГЛАВНОЕ МЕНЮ ---");
            System.out.println("1. Добавить фрилансера");
            System.out.println("2. Список фрилансеров");
            System.out.println("3. Обновить навык фрилансера");
            System.out.println("4. Удалить фрилансера");
            System.out.println("5. Добавить вакансию");
            System.out.println("6. Список вакансий");
            System.out.println("7. Назначить фрилансера");
            System.out.println("8. Выход");
            System.out.print("Выбор: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Имя: ");
                String name = sc.nextLine();
                System.out.print("Навык: ");
                String skill = sc.nextLine();
                portal.addFreelancer(new Freelancer(name, skill));

            } else if (choice.equals("2")) {
                portal.showFreelancers();

            } else if (choice.equals("3")) {
                System.out.print("Имя для обновления: ");
                String name = sc.nextLine();
                System.out.print("Новый навык: ");
                String newSkill = sc.nextLine();
                portal.updateSkill(name, newSkill);

            } else if (choice.equals("4")) {
                System.out.print("Имя для удаления: ");
                String name = sc.nextLine();
                portal.deleteFreelancer(name);

            } else if (choice.equals("5")) {
                System.out.print("Название работы: ");
                String title = sc.nextLine();
                System.out.print("Бюджет: ");
                int budget = Integer.parseInt(sc.nextLine());
                portal.addJob(new JobListing(title, budget));

            } else if (choice.equals("6")) {
                portal.showJobs();

            } else if (choice.equals("7")) {
                System.out.print("Имя фрилансера: ");
                String fName = sc.nextLine();
                System.out.print("Название вакансии: ");
                String jTitle = sc.nextLine();
                portal.assignByNames(fName, jTitle);

            } else if (choice.equals("8")) {
                break;

            } else {
                System.out.println("Ошибка ввода.");
            }
        }
        sc.close();
    }
}