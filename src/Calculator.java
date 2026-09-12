import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;
        boolean isNewCalculation = true;

        System.out.println("Добро пожаловать! Доступные операции калькулятора: +, -, *, /");
        System.out.println("Для сброса результата вычисления введите 'C', для завершения работы введите 'S'");

        while (true) {
            if (isNewCalculation) {
                System.out.print("\nВведите первое число: ");
                if (scanner.hasNextDouble()) {
                    result = scanner.nextDouble();
                } else {
                    System.out.println("Введенный символ не является числом. Попробуйте ввести снова.");
                    scanner.next();
                    continue;
                }
                isNewCalculation = false;
            }

            System.out.print("Введите операцию (+, -, *, /), 'C' для сброса или 'S' для выхода: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("S")) {
                System.out.println("Программа успешно завершена.");
                break;
            }

            if (input.equalsIgnoreCase("C")) {
                System.out.println("Предыдущий результат вычислений сброшен.");
                isNewCalculation = true;
                continue;
            }

            char operation = input.charAt(0);
            double operand2;

            System.out.print("Введите второе число: ");

            if (scanner.hasNextDouble()) {
                operand2 = scanner.nextDouble();
            } else {
                System.out.println("Введенный символ не является числом. Попробуйте ввести снова.");
                scanner.next();
                continue;
            }


            switch (operation) {
                case '+':
                    result = result + operand2;
                    break;
                case '-':
                    result = result - operand2;
                    break;
                case '*':
                    result = result * operand2;
                    break;
                case '/':
                    if (operand2 == 0) {
                        System.out.println("Деление на ноль невозможно!");

                    } else {
                        result = result / operand2;
                    }
                    break;
                default:
                    System.out.println("Неподдерживаемая операция '" + operation + "'");
                    continue;
            }

            System.out.println("Текущий результат: " + result);
        }

        scanner.close();
    }
}