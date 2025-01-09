package com.walking.intensive.chapter1.task4;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        double a = 1;
        double b = 0;
        double c = 0;

        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        if (a == 0 && b == 0) {
            return c == 0 ? "Бесконечное множество решений." : "Количество решений: 0.";
        }

        if (a == 0) {
            return "Количество решений: 1." + calculateLinearEquation(b, c);
        }

        if (b == 0 && c == 0) {
            return "Количество решений: 1. Корень: 0.0";
        }

        double discriminant = calculateDiscriminant(a, b, c);

        return (discriminant > 0) ? "Количество решений: 2." + calculateTwoRoots(a, b, discriminant)
                : discriminant == 0 ? "Количество решений: 1." + calculateOneRoot(a, b)
                : "Количество решений: 0.";
    }

    static String calculateLinearEquation(double b, double c) {
        return " Корень: " + (-c / b);
    }

    static double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    static String calculateOneRoot(double a, double b) {
        return " Корень: " + (-b / (2 * a));
    }

    static String calculateTwoRoots(double a, double b, double discriminant) {
        double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
        double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);

        String twoRoots = "";

        if (firstRoot < secondRoot) {
            twoRoots += firstRoot + ";" + secondRoot;
        } else if (secondRoot < firstRoot) {
            twoRoots += secondRoot + ";" + firstRoot;
        }

        return " Корни: " + twoRoots;
    }
}
