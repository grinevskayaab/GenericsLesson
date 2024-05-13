package com.github.grinevskayaab;

/*
* Задача:
a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можно использовать ArrayList;
d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
апельсинами;
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
объекты, которые были в первой;
g. Не забываем про метод добавления фрукта в коробку.
 */

public class Main {
    public static void main(String[] args) {
        //с 3 яблоками
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 3; i++) {
            appleBox.addFruit(new Apple());
        }

        //с 2 яблоками
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 2; i++) {
            appleBox2.addFruit(new Apple());
        }

        //две одинаковые коробки с 2 апельсинами
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        for (int i = 0; i < 2; i++) {
            orangeBox.addFruit(new Orange());
            orangeBox2.addFruit(new Orange());
        }

        //сравнение
        System.out.println("2 апельсина = 3 яблока " + orangeBox.compare(appleBox));
        System.out.println("2 апельсина = 2 апельсина " + orangeBox.compare(orangeBox2));
        System.out.println("2 апельсина != 2 яблока " + orangeBox.compare(appleBox2));
        System.out.println("2 яблока != 3 яблока " +appleBox.compare(appleBox2));


        //пересыпали яблоки
        System.out.println("Пересыпаем из второй коробки в первую (яблоки)");
        System.out.println("Вес 1 коробки "+appleBox.getWeight() + " Вес 2 коробки "+appleBox2.getWeight());
        appleBox.sprinkleFruit(appleBox2);
        System.out.println("Вес 1 коробки "+appleBox.getWeight() + " Вес 2 коробки "+appleBox2.getWeight());

        //пересыпали апельсины
        System.out.println("Пересыпаем из первой коробки во вторую (апельсины)");
        System.out.println("Вес 1 коробки "+orangeBox.getWeight() + " Вес 2 коробки "+orangeBox2.getWeight());
        orangeBox2.sprinkleFruit(orangeBox);
        System.out.println("Вес 1 коробки "+orangeBox.getWeight() + " Вес 2 коробки "+orangeBox2.getWeight());
    }
}