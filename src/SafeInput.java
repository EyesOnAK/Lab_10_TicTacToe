import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean isValid = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                isValid = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Error: You entered \"" + trash + "\". Please enter a valid integer.");
            }
        } while (!isValid);

        return retVal;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0.0;
        boolean isValid = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                isValid = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Error: You entered \"" + trash + "\". Please enter a valid double.");
            }
        } while (!isValid);

        return retVal;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean isValid = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                {
                    isValid = true;
                }
                else
                {
                    System.out.println("Error: Number must be between " + low + " and " + high + ".");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Error: You entered \"" + trash + "\". Please enter a valid integer.");
            }
        } while (!isValid);

        return retVal;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0.0;
        boolean isValid = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                {
                    isValid = true;
                }
                else
                {
                    System.out.println("Error: Number must be between " + low + " and " + high + ".");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Error: You entered \"" + trash + "\". Please enter a valid double.");
            }
        } while (!isValid);

        return retVal;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = false;
        boolean isValid = false;
        String response = "";

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();

            if (response.equalsIgnoreCase("Y"))
            {
                retVal = true;
                isValid = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                retVal = false;
                isValid = true;
            }
            else
            {
                System.out.println("Error: Please enter 'Y' or 'N'.");
            }
        } while (!isValid);

        return retVal;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean isValid = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(regEx))
            {
                isValid = true;
            }
            else
            {
                System.out.println("Error: Input does not match required format.");
            }
        } while (!isValid);

        return retVal;
    }
    public static void prettyHeader(String msg)
    {
        int totalWidth = 60;
        int starBorder = 3;

        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        int interiorWidth = totalWidth - (starBorder * 2);
        int msgLen = msg.length();
        int totalSpaces = interiorWidth - msgLen;
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        System.out.print("***");
        for (int i = 0; i < leftSpaces; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightSpaces; i++)
        {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}
