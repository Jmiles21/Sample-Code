/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditcardproject;

import java.util.Scanner;

/**
 *
 * @author jaylonmiles
 */
public class CreditCardProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a credit card number as a long integer: ");

        long input = sc.nextLong();

        if (isValid(input) == true) {
            System.out.println("\n" + input + " is Valid. ");
        } else {
            System.out.println("\n" + input + " is Invalid. ");
        }

    //Checks to see if card is valid
    public static boolean isValid(long card) {

        int total = sumEven(card) + sumOdd(card);

        return (total % 10 == 0) && (firstNumber(card, 1) == true) && (getLength(card) >= 13) && (getLength(card) <= 16);
    }

    
    //Checks to see if card is valid with the first method
    public static boolean firstNumber(long number, int d) {
        if ((getLong(number, d) == 4)
                || (getLong(number, d) == 5)
                || (getLong(number, d) == 3)) {

            if (getLong(number, d) == 3) {
                
            } else if 
                    
              (getLong(number, d) == 5) {
                
            } else if 
                    
              (getLong(number, d) == 3) {
                
            }

            return true;

        } else {

            return false;

        }

      
    }

    //If the number length is not long enough, return number
    public static long getLong(long number, int f) {

        if (getLength(number) > f) {
         String num = number + "";
         return Long.parseLong(num.substring(0, f));
        }
        return number;

    }

    
    //Add all the single digit numbers from step1
    public static int sumEven(long number) {
        
        int sum = 0;
	String num = number + "";
	for (int i = getLength(number) - 2; i >= 0; i -= 2)
        {
            
	sum += getNumbers(Integer.parseInt(num.charAt(i) + "") * 2);
        
	}
        return sum;

        
    }

    //Add all digits in the odd places from right to left in the card number
    public static int sumOdd(long number) {
        int result = 0;

        while (number > 0) {
            result += (int) (number % 10);
            number = number / 100;
        }

        return result;
    }

    //If it is divisible by 10, the card number is valid; otherwise, it is invalid.
    public static int getNumbers(int number) {
        
        return number % 10 + (number / 10 % 10);

    }

    //Shows the number length of the card
    public static int getLength(long l) {

      String num = l + "";
      return num.length();


    }

}
