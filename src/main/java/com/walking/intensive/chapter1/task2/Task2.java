package com.walking.intensive.chapter1.task2;

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
        System.out.println(getFlatLocation(2, 5, 15));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        if(floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Некорректные входные данные";
        }

        int flatsInOneFloorAmount = 4;
        int flatsInOneEntrance = floorAmount * flatsInOneFloorAmount;
        int flatsAmount = flatsInOneEntrance * entranceAmount;
        if (flatNumber > flatsAmount) {
            return "Такой квартиры не существует";
        }

        int entranceNumber = (flatNumber % flatsInOneEntrance == 0) ?
                (flatNumber / flatsInOneEntrance) : (flatNumber / flatsInOneEntrance + 1);

        int floorNumberHelper = flatNumber - flatsInOneEntrance * (entranceNumber - 1);
        int floorNumber = (floorNumberHelper % flatsInOneFloorAmount == 0) ?
                (floorNumberHelper / flatsInOneFloorAmount) : (floorNumberHelper / flatsInOneFloorAmount + 1);

        String location = flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж";
        switch (flatNumber % flatsInOneFloorAmount) {
            case 1:
                location += ", слева от лифта, влево";
                break;
            case 2:
                location += ", слева от лифта, вправо";
                break;
            case 3:
                location += ", справа от лифта, влево";
                break;
            case 0:
                location += ", справа от лифта, вправо";
        }

        return location;
    }
}
