/**************************************************************************************************
 *
 * Course: The *VERY* Basics of Programming, Spring 2007
 *
 * Participant: Aleksi Lukkarinen
 *
 * Title of File: YhtaTirehtoorinSirkusta
 *
 * Creation Date: 16.2.2007
 *
 **************************************************************************************************/

package fi.al.courses.basicsofprogramming;


import java.io.BufferedReader;
import java.io.InputStreamReader;




/**
 * <p>
 * Title: YhtaTirehtoorinSirkusta
 * </p>
 *
 * <p>
 * Description:
 * </p>
 */
public final class YhtaTirehtoorinSirkusta {
  /** Lastenlipun hinta. */
  private static final long TICKET_PRICE_CHILD = 12;

  /** Aikuistenlipun hinta. */
  private static final long TICKET_PRICE_ADULT = 24;

  private YhtaTirehtoorinSirkusta() {
    // NOT TO BE CALLED
  }

  /**
   * main
   *
   * @param args String[]
   */
  public static void main(final String[] args) {
    final int clientTypeMale = 1;
    final int clientTypeFemale = 2;
    final int clientTypeChild = 3;

    long countMales = 0;
    long countFemales = 0;
    long countChildren = 0;
    long income = 0;
    int clientType = 0;
    String output = "";

    clientType = askClientType();
    while (clientType != 0) {
      switch (clientType) {
      case clientTypeMale:
        countMales++;
        break;

      case clientTypeFemale:
        countFemales++;
        break;

      case clientTypeChild:
        countChildren++;
        break;
      }

      clientType = askClientType();
    }

    income = (countMales + countFemales) * TICKET_PRICE_ADULT + countChildren * TICKET_PRICE_CHILD;

    output = "%n%nEsitykseen tulleet:%n" + "  - miehiä: %d%n" + "  - naisia: %d%n"
        + "  - lapsia: %d%n" + "Esityksen tuotto: %d rahaa.%n";

    System.out.printf(output, countMales, countFemales, countChildren, income);
  }



  private static int askClientType() {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    int clientType = 0;

    while (true) {
      System.out.printf("%nSyötä asiakastyyppi (1=M, 2=F, 3=C, 0 lopettaa): ");

      try {
        clientType = Integer.parseInt(stdin.readLine());
        if (clientType < 0 || clientType > 3) {
          throw new Exception();
        }

        return clientType;
      }
      catch (Exception ex) {
        System.out.printf("Virheellinen syöte.%n");
      }
    }
  }
}
