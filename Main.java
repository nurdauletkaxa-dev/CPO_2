import java.util.Scanner;

// Узел списка (контакт)
class Contact {
    String name;
    String phone;
    Contact next;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.next = null;
    }
}

// Связный список (телефонная книга)
class PhoneBook {
    private Contact head;

    // Добавление контакта
    public void add(String name, String phone) {
        Contact newContact = new Contact(name, phone);

        if (head == null) {
            head = newContact;
        } else {
            Contact temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newContact;
        }

        System.out.println("Контакт добавлен!");
    }

    // Поиск контакта
    public void search(String name) {
        Contact temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Найден: " + temp.name + " - " + temp.phone);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Контакт не найден!");
    }

    // Удаление контакта
    public void delete(String name) {
        if (head == null) return;

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("Удалено!");
            return;
        }

        Contact temp = head;

        while (temp.next != null) {
            if (temp.next.name.equalsIgnoreCase(name)) {
                temp.next = temp.next.next;
                System.out.println("Удалено!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Контакт не найден!");
    }

    // Показ всех контактов
    public void showAll() {
        Contact temp = head;

        if (temp == null) {
            System.out.println("Список пуст!");
            return;
        }

        while (temp != null) {
            System.out.println(temp.name + " - " + temp.phone);
            temp = temp.next;
        }
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("\n1. Добавить");
            System.out.println("2. Найти");
            System.out.println("3. Удалить");
            System.out.println("4. Показать все");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка

            switch (choice) {
                case 1:
                    System.out.print("Имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Телефон: ");
                    String phone = scanner.nextLine();
                    phoneBook.add(name, phone);
                    break;

                case 2:
                    System.out.print("Введите имя: ");
                    phoneBook.search(scanner.nextLine());
                    break;

                case 3:
                    System.out.print("Введите имя: ");
                    phoneBook.delete(scanner.nextLine());
                    break;

                case 4:
                    phoneBook.showAll();
                    break;

                case 0:
                    System.out.println("Выход...");
                    scanner.close(); // закрываем
                    return;

                default:
                    System.out.println("Ошибка!");
            }
        }
    }
}