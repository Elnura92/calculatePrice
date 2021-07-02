package headFirst;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] data = new String[][]{
                {"Бишкек","8:170.0;10:500.0;30:800.0;50:3495.0->1.0:-1.0"},
                {"Ош","8.0:350.0;10.0:900.0;30.0:2460.0;50.0:4926.0->1.0:-1.0"},
                {"Алматы", "0.3:650.0;0.5:750.0->1.0:430.0"},
                {"Шымкент", "0.3:700.0;0.5:750.0->1.0:430.0"},
                {"Москва","0.5:1130.14->1.0:160.0"},
                {"Санкт-Петербург", "0.5:856.98->1.0:231.53"},
                {"Лондон", "0.5:2900.0->1.0:500.0"},
                {"Мадрид", "0.5:3000.0->1.0:700.0"}};

        Scanner input = new Scanner(System.in);

        double weight;
        int cityId;
        String[] arr;
        double eachNextPrice;
        String[] temp;


        System.out.println("Введите вес товара в кг:");
        weight = input.nextDouble();
        System.out.println("Введите код из города из ниже перечисленных:");


        for(int i=0; i<data.length; i++) {

            System.out.println(i + " - " + data[i][0]);

        }
        cityId = input.nextInt();
        arr = data[cityId][1].split("->");
        temp = arr[1].split(":");
        eachNextPrice = Double.parseDouble(temp[1]);
        arr = arr[0].split(";");

        for(int i=0; i<arr.length; i++){
            temp = arr[i].split(":");
            double intervalWeight = Double.parseDouble(temp[0]);
            double intervalPrice = Double.parseDouble(temp[1]);
            if (weight <= intervalWeight){
                System.out.println("Цена = " + intervalPrice);
                break;
            }else if(i == arr.length-1 && eachNextPrice == -1)
                System.out.println("Невозможно просчитать цену.");

            else if(i == arr.length-1)
                System.out.println("Цена = " + (intervalPrice + (weight - intervalWeight) * eachNextPrice));

            }

        }





    }

