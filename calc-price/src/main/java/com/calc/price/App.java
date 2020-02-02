package com.calc.price;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {

        Double[] enteredValues = new Double[4];

        Scanner scannerAppealToUser = new Scanner(new File("calc-price/src/main/resources/SystemOut.txt"));
        ArrayList<String> listAppealToUser = new ArrayList<>();
        while (scannerAppealToUser.hasNext()) {
            listAppealToUser.add(scannerAppealToUser.nextLine());
        }

        Scanner scannerUserNumberValue = new Scanner(System.in);
        String inputValue;
        int count = 0;
        do {
           if (count == 0) {
                System.out.print(listAppealToUser.get(count));
            } else if (count == 1) {
                System.out.print(listAppealToUser.get(count));
            } else if (count == 2) {
                System.out.print(listAppealToUser.get(count));
            } else {
                System.out.print(listAppealToUser.get(count));
            }


            inputValue = scannerUserNumberValue.next();

            if (!isExitValue(inputValue)) {
                if (isCorrectDoubleValue(inputValue)) {
                    enteredValues[count] = Double.parseDouble(inputValue);
                    count++;
                }
            }

            List<Double> coefficientDistance = adminInformationFromTxt("calc-price/src/main/resources/coefficienDistance.txt");

            List<Double> coefficientWeight = adminInformationFromTxt("calc-price/src/main/resources/coefficientWeight.txt");

            if (count == 4) {
                Double coefficientCalcDistance = coefficientCalc(enteredValues[0],1000.0,3000.0, coefficientDistance);
                Double coefficientCalcWeight = coefficientCalc(enteredValues[2], 5000.0, 15000.0, coefficientWeight);

                Double caclResult = (enteredValues[0] * enteredValues[1]*coefficientCalcDistance) + (enteredValues[2] * enteredValues[3]*coefficientCalcWeight);
                System.out.println("Price: $" + caclResult);
                count = 0;
            }
        } while (!isExitValue(inputValue));

        System.out.println("Finish!");

    }

    private static  Double coefficientCalc(Double valueUser, Double firstCompareValue, Double secondCompareValue, List<Double> list ) throws FileNotFoundException {
        Double resultCoefficient = 1.0;
        if (valueUser<firstCompareValue){
            resultCoefficient = list.get(0);}
        else if (valueUser >firstCompareValue && valueUser <secondCompareValue ){
            resultCoefficient = list.get(1);}
        else if (valueUser > secondCompareValue ){
            resultCoefficient = list.get(2);}
        return resultCoefficient;
    }

    private static List adminInformationFromTxt (String wayToTxt) throws FileNotFoundException {
        List<Double> newList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(wayToTxt));
        while (scanner.hasNext()) {
            newList.add(scanner.nextDouble());
        }
        scanner.close();
        return newList;
    }

    private static boolean isExitValue(String value) {
        return value.equalsIgnoreCase("Q");
    }

    private static boolean isCorrectDoubleValue(String value) {
        boolean checkResult;
        try {
            double enteredDoubleValue = Double.parseDouble(value);
            checkResult = enteredDoubleValue >= 0;
        } catch (NumberFormatException ex) {
            checkResult = false;
        }
        return checkResult;
    }

    }







































































































































































































































































































































































































