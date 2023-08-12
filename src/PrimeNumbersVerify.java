import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumbersVerify {
    
    /*
        * Prompt Glossary
        * 
        *   >>> input;
        *   ### error;
        *   $$$ many data;
        *   <<< returning to execute the next function;
        *   +++ final result;
     *
     * 
     * ---code level 1---
     * 
     * instantiating an object of the Scanner native class
     * to allow user input
    */
    Scanner scan = new Scanner(System.in);


    //creating numerical fields and numerical arrays to store the data
    //(initially, without initializing)
    int maxRange;
    int numberToVerify;

    int[] maxRangeTableNumbers;
    int[] multipleNumbers;
    int[] primeNumbers;
    int[] clearArray;

    //boolean for flow control
    boolean falsePrint = false;
    boolean msgExecute = true;

    //variable that stores the user's response whether the app should be closed or rerun
    String YorN;


    //method to collect requested user data
    public void scanner() {
        
        //calling the header message to run only once during continuous app execution
        if(msgExecute == true) {

            //app input message
            System.out.println("\n***-.Oriented Prime Number Checker in Bash @v0.6.0.-***"); 
            msgExecute = false;
        };

        //initializing all variables created later with input values

        System.out.print("\n--------------------------------------------------\n");
        System.out.print("\n>>> Enter a maximum number to generate a list: ");
        maxRange = scan.nextInt();
        System.out.print("\n>>> Enter a number to check if it is prime or not: ");
        numberToVerify = scan.nextInt();

        //checking excesses of limitations and returning an error or releasing the app flow
        if(numberToVerify > maxRange) {
            System.err.print("\n### The number that will be checked exceeds the maximum limit defined for table generation (" + maxRange + ")\n");
            scanner();

        } else if(numberToVerify < 2) {
            System.err.print("\n### The number that will be checked is less than the allowed limit (2);\n");
            scanner();

        } else if(maxRange < 2) {
            System.err.print("\n### The number that will generate the verification table is less than the allowed limit (2);\n");
            scanner();

        } else {

            maxRangeTableNumbers = new int[maxRange];
            multipleNumbers = new int[maxRange];
            primeNumbers = new int[maxRange];
            
            calculation();
        };
    }

    /*
     * private method for calculation available only within this class 
     * and without return to the user, working as a backend calculation system
    */
    private void calculation() {

        //inserting values up to the maximum limit stipulated by the user in "maxRange"
        for(int i = 1; i < maxRangeTableNumbers.length; i++) {
            maxRangeTableNumbers[i] = i + 1;    //+1 for inserting the last exclusive value
        }

        /*
         * conditional that will analyze whether the user entered a number greater than 11 or less than 10 to choose how to treat the data when calculating based on the Sieve of Eratosthenes 
         * (this conditional is necessary because the program was generating the base table for calculation after identifying the first number prime that was generated from calculus, 
         * and was not used to calculate like 2, 3, 5 and 7)
         */
        if(maxRange > 10) {

            for(int j = 1; j < multipleNumbers.length; j++) {
                if(maxRangeTableNumbers[j] % 2 == 0 || maxRangeTableNumbers[j] % 3 == 0 || maxRangeTableNumbers[j] % 5 == 0 || maxRangeTableNumbers[j] % 7 == 0) {

                    multipleNumbers[j] = maxRangeTableNumbers[j];   //the verified number for each true index is multiple

                } else {

                    multipleNumbers[j] = 0;     //the verified number for each false index is not multiple
                } 
            }

        } else if(maxRange < 11) {

            for(int n = 1; n < multipleNumbers.length; n++) {

                if(maxRange < 11 && maxRangeTableNumbers[n] % 4 == 0 || maxRangeTableNumbers[n] % 6 == 0 || maxRangeTableNumbers[n] % 10 == 0) {

                    multipleNumbers[n] = maxRangeTableNumbers[n];
                
                } else {

                    multipleNumbers[n] = 0;
                }
            }
            
            //if this conditional above is executed, the line below will replace the index element 8 from 0 (false validation) to 9 (not validated) manually, 
            //and in post processing this index will not be validated as prime
            if(multipleNumbers.length >= 8) {
                multipleNumbers[8] = 9;
            };
        };
        
        //assigning the numbers that tested "false" in the conditional test above to the array "primeNumbers"
        for(int k = 1; k < primeNumbers.length; k++) {
            if(multipleNumbers[k] == 0) {
                primeNumbers[k] = maxRangeTableNumbers[k];

                //reassign prime numbers that tested positive in the test and cannot be removed [small post attribution correction]
                if(primeNumbers[1] == 0 && primeNumbers[2] == 0 && primeNumbers[4] == 0 && primeNumbers[6] == 0) {
                    primeNumbers[1] = multipleNumbers[1];
                    primeNumbers[2] = multipleNumbers[2];
                    primeNumbers[4] = multipleNumbers[4];
                    primeNumbers[6] = multipleNumbers[6];
                }
            }
        }
        
        cleaningArrayList(primeNumbers);    //calling array of primes as parameter of next method beforehand
    }

    //creating a method to return an array without zeros for better visualization
    private int[] cleaningArrayList(int[] array) {

        clearArray = IntStream.of(array).filter(num -> num > 0).toArray();

        showResults();

        return clearArray;
    };

    //showing results in a string list
    public void showResults() {

        String arrayCleared = java.util.Arrays.toString(clearArray);

        //checking if the additional results will be too big and if the user wants to visualize this data
        if(clearArray.length >= 125) {

            System.out.println("\n$$$ A total of " + clearArray.length + " prime numbers were generated in an array, making it quite large. Want to see the results? (y / n)");
            YorN = scan.next();

            if(clearArray.length >= 125 && YorN.equals("y") || YorN.equals("Y")) {
                
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.print("\n$$$ The total number of prime numbers found in the given range are: \n\n" + arrayCleared + "\n");
                System.out.println("\n---------------------------------------------------------------------------------------");

            } else if(clearArray.length >= 125 && YorN.equals("n") || YorN.equals("N")) {

                System.out.println("\n<<< Going to the next verification method...");

            } else {

                showResults();
            };

            //if the data is not so big and confusing, show it at the prompt
        } else {
            
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("\n$$$ The total number of prime numbers found in the given range are: \n\n" + arrayCleared + "\n");
            System.out.println("\n---------------------------------------------------------------------------------------");
            
        };

        userPrimeNumCheck();
    }


    /*
        * ---code level 2---
        * 
        * checking if the number that the user entered to test is prime
    */
    private void userPrimeNumCheck() {

        /*
         * if the number is similar to the one passed to variable 'm', it means that it is prime. 
         * To avoid future misdemeanors in the code, I created a control variable that starts at false, 
         * and changes to 'true' when the number is prime
         */
        for(int m : clearArray) {
            if(numberToVerify == m) {
                System.out.println("\n*************************");
                System.out.println("+++ The number " + numberToVerify + " is prime!");
                System.out.println("***************************");
                falsePrint = true;
            }
        }; 

        if(!falsePrint) {

            System.out.println("\n*******************************");
            System.out.println("+++ The number " + numberToVerify + " is not prime!");
            System.out.println("*******************************");
        }

        restartApp();
    };

    //method that will perform a callback to the first execution method if the user wants to perform a new test
    public void restartApp() {
        
        System.out.println("\n---------------------------------------------");
        System.out.print(">>> Do you want to perform another test? (y / n): ");
        System.out.println("\n---------------------------------------------");
        YorN = scan.next();

        if(YorN.equals("y") || YorN.equals("Y")) {

            falsePrint = false;     //if the 'falsePrint' field is not reassigned as 'false' on each new test, if the number is not prime, it will not find it
            System.out.println("\n\n------------------------");
            System.out.println("...Running a new test...");
            System.out.println("------------------------\n\n");
            scanner();

        } else if(YorN.equals("n") || YorN.equals("N")) {

            System.out.println(".............");
            System.out.println("...Exiting...");
            System.out.println(".............");

            scan.close();

        } else {

            restartApp();   //call the last method again while the result is not y or n
        };
    }
};
