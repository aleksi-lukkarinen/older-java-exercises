/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: KahdenJarjestys
 *
 * Creation Date: 2.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;




public final class KahdenJarjestys {
  private KahdenJarjestys() {
    // NOT TO BE CALLED
  }

  /**
   *
   *
   * @param args
   */
  public static void main(final String[] args) {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    boolean validInput = false;
    long number1 = 0;
    long number2 = 0;

    do {
      validInput = false;

      System.out.printf("%nSyötä 1. kokonaisluku: ");

      try {
        number1 = Integer.parseInt(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    } while (!validInput);

    do {
      validInput = false;

      System.out.printf("%nSyötä 2. kokonaisluku: ");

      try {
        number2 = Integer.parseInt(stdin.readLine());
        validInput = true;
      }
      catch (Exception ex) {
        System.out.printf("%nVirheellinen syöte.%n");
      }
    } while (!validInput);

    System.out.print("\n\n" + orderOfMagnitude(number1, number2) + "\n");
  }


  private static String orderOfMagnitude(final long a, final long b) {
    if (a < b) {
      return "Ensimmäinen luku on pienempi.";
    }
    if (a == b) {
      return "Luvut ovat yhtä suuria.";
    }

    return "Ensimmäinen luku on suurempi.";
  }
}
