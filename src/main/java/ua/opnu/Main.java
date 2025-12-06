package ua.opnu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("TASK 1");

        Predicate negative = i -> {
            int nmbr = (int)i;
            for(int n=2; n<nmbr; n++){
                if(nmbr%n==0){
                    return false;
                }
            }
           return true;
        };

        System.out.println(negative.test(1));
        System.out.println(negative.test(3));
        System.out.println(negative.test(4));
        System.out.println(negative.test(24));
        System.out.println(negative.test(37));


        System.out.println();

        System.out.println("TASK 2");

        ArrayList<Student> students = new ArrayList<>(
                List.of(new Student("Student Ivanov", "AI-111", new int[]{60,30}),
                        new Student("Ivan Petrov ", "AI-222", new int[]{100,3}),
                        new Student("Petr Petrenko", "AI-333", new int[]{40,59}),
                        new Student("Natallya Ivanenko", "AI-222", new int[]{78,89}),
                        new Student("Ilona Smernova", "AI-333", new int[]{67,70})));

        Predicate marks = i -> {
                    Student st = (Student)i;
                    for(int n=0; n < st.getMarks().length; n++){
                        if(st.getMarks()[n]<60) {
                            return false;
                        }
                    }
                   return true;
                };

                System.out.println("Залишаються студенти:");
                for(int i=0; i<students.size(); i++){
                    if(marks.test(students.get(i))) {
                        System.out.print(students.get(i).getName() + "  " + students.get(i).getGroup() + "  ");
                        for( int j = 0; j< students.get(i).getMarks().length; j++){
                            System.out.print(students.get(i).getMarks()[j] +"; ");
                        }
                        System.out.println();
                    }
                }


        System.out.println();
        System.out.println("TASK 3");


        Predicate ai222 = i -> {
            Student st = (Student)i;
            if(st.getGroup().equals("AI-222")){
                return true;
            }
            return false;
        };
        System.out.println("Залишаються студенти з групи AI-222:");
        for(int i=0; i<students.size(); i++){
            if(marks.test(students.get(i)) && ai222.test(students.get(i))) {
                System.out.print(students.get(i).getName() + "  " + students.get(i).getGroup() + "  ");
                for( int j = 0; j< students.get(i).getMarks().length; j++){
                    System.out.print(students.get(i).getMarks()[j] +"; ");
                }
                System.out.println();
            }
        }



        System.out.println();
        System.out.println("TASK 4");

        Consumer consumer = (st) -> {
            Student stud = (Student)st;
            System.out.println(stud.getName());
        };

        students.forEach(consumer);


        System.out.println();
        System.out.println("TASK 5");

        ArrayList<Integer> intArray = new ArrayList<>();
        for(int i=0; i<50; i+=4){
            intArray.add(i);
        }
        for(int i=0; i<intArray.size(); i++){
            System.out.print(intArray.get(i) + " ");
        }
        Predicate predicate= i -> {
            int nmbr = (int)i;
            for(int n=0; n<nmbr; n++){
                if(nmbr>20){
                    return false;
                }
            }
            return true;
        };

        Consumer consumer1 = n -> {
            int nmbr = (int)n;
            if(predicate.test(nmbr)){
                System.out.println(nmbr);
            }
        };
        numbers(intArray, predicate, consumer1);

        System.out.println();
        System.out.println("TASK 6");

        Function<Integer, Integer> function = o -> (int) Math.pow(2, o);
        int[] startMas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i=0; i<startMas.length; i++){
            System.out.println(function.apply(startMas[i]));
        }

        System.out.println();
        System.out.println("TASK 7");
        System.out.println();

        Function<Integer, String> function1 = o -> {
            List<Integer> startMas1 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            List<String> startMas2 =List.of("нуль","один","два","три","чотири","пʼять","шість","сім","вісім","девʼять");
            return startMas2.get(startMas1.indexOf(o));
        };

        int[] startMas1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


        stringify(startMas1, function1);


    }

    public static void stringify(int[] mas, Function<Integer, String> function2){
        for(int i=0; i< mas.length; i++){
            System.out.println(function2.apply(mas[i]));
        }

    }



    public static void numbers(ArrayList<Integer> intArray , Predicate predicate, Consumer consumer){
        intArray.forEach(consumer);
    }


    // 1. Напишіть `Function`, який приймає на вхід ціле число n та повертає ціле число 2^n.
    // Створіть масив з 10 цілих чисел та перевірте роботу методу.



}
