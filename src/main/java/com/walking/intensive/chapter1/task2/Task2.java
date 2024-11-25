package com.walking.intensive.chapter1.task2;

import java.util.Arrays;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getFlatLocation(3, 3, 13));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int[] values = {floorAmount, entranceAmount, flatNumber};

        boolean anyLessOrEqualsZero = Arrays.stream(values).anyMatch(v -> v <= 0);
        if(anyLessOrEqualsZero) {
            return "Некорректные входные данные";
        }

        int flatsAmount = floorAmount * entranceAmount * 4;
        if (flatNumber > flatsAmount) {
            return "Такой квартиры не существует";
        }

        int flatsInOneEntrance = flatsAmount / entranceAmount;

        int entranceNumber = (flatNumber % flatsInOneEntrance == 0) ?
                (flatNumber / flatsInOneEntrance) : (flatNumber / flatsInOneEntrance + 1);
        System.out.println(entranceNumber);

        int floorNumber = 0; //УДАЛИТЬ
        //ДОДЕЛАТЬ НОМЕР ЭТАЖА и потом ЛЕВО-ПРАВО

        String location = flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж";

        return location;
    }
}
