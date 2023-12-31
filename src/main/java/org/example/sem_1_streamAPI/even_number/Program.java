package org.example.sem_1_streamAPI.even_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Задание: Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 *
 * Решение: Создаем список чисел используя ArrayList, создаем второй список(в него войдут
 * результаты) - применяем технологию
 * stream и пользуемся методом filter, что бы отобрать те значения(четные), которые нужны. Методом
 * forEach проходимся по новому списку результатов и выводим на экран значения.
 */
public class Program {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add( 0 );
        numbers.add( 1 );
        numbers.add( 2 );
        numbers.add( 3 );
        numbers.add( 4 );
        numbers.add( 5 );
        numbers.add( 6 );

        List<Integer> evenNumbers = numbers
                .stream()
                .filter( n  -> n % 2 == 0 && n != 0 ) // отбор по четности с проверкой на ноль
                .toList(); // собираем результаты в список
        evenNumbers.forEach(System.out::println); // выводим результат на экран
    }
}
