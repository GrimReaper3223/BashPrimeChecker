This is my first "complex" application (with many lines of code and a lot of logic involved) that I've ever done.

This app is divided into 2 parts: Level 1 of execution and Level 2 of execution;

The code is highly documented, so this file will only be a summary of the features.

	[This project is just a personal demonstration of my progress in the Java language. The main execution file is "execute", and the instruction file is "PrimeNumbersVerify" (inside the
	file "manifest.txt" it is specified that the file containing the main execution class is "execute.class"].
	
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Here begins the first level of code execution. Here the user will insert a maximum value for generating the table and a number for verification, the calculation of data will also be carried out, assignment of
values to arrays, reprocessing the array of prime numbers to a new array filtering all zeros (empty spaces) and, depending on the size of the data, in order not to harm the user experience,
it will be asked whether or not it wants to show all generated prime numbers;

Level 1:

	-In this level, initially there will be a method with an object instantiated from the native class 'Scanner' to receive data from the user;
	-Errors are handled depending on the data provided by the user, such as:

		*The number to be verified must not be greater than the number in the table;
		*The number to be checked must not be less than 2 (minimum table generation limit);
		*The table number must not be less than 2 (minimum table generation limit);

	Apart from these negotiations, the program will perform normally;

	-At this same stage, we have the calculation method (based on the Sieve of Eratosthenes);
	-In this method, initially the table is generated according to the maximum limit imposed by the user;

	-Then, it is checked if the user has entered a maximum value for table generation greater than 10 or less than 11 (This check is necessary to avoid a bug when generating the table. Without this
	verification, any value that is placed above 10 will match a prime number resulting from the calculation, then the table will be generated. On the other hand, inserting numbers below 10 the table will
	not be generated. It is the prime number will not be properly verified, because 2, 3, 5 and 7 were used as the calculation base. Soon, they will be included in the calculation of the method according
	to the formula (any number divided by 2, 3, 5 or 7 which returns 0 will not be prime). So these numbers need to be added manually in the table, without having to change the calculation logic). So with
	this method this is fixed, regardless of the number that the user enters (and of course, that it is in accordance with the other conditionals)).

	-After the calculations and assignments, the field that will receive the prime values will be full of unnecessary zeros. There is a next method that will clear the entire array of primes (remove all
	0s)
	and will return a new clean array with only the prime integers;
	-After reprocessing the original array of prime numbers, we have the last method that will show the user the prime numbers in the new table in the form of an array of Strings;
	-Depending on the size of the results (even after reprocessing the data), a message will be generated for the user showing the number of prime numbers found and if he wants them are shown on the
	screen (this is done to avoid polluting the prompt and to improve the user experience). Prime numbers will be shown if the array of Strings is small or of a size acceptable;
	
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Here ends the first level of code execution. The second will be related to checking the second number that the user entered and if the user wants to restart the test;

Level 2:

	-The second level starts with a verification method for the user's number based on the reprocessed array of numbers to verify whether it is a prime number or not;
	-If the number is prime, there is a previously declared field that is used for program flow control called 'alsePrint'. This field has the boolean value "false", and it will be "true" if the
	number tests positively as a prime. Otherwise, the field will continue with its value "false" and it will activate the second conditional, indicating that the number that was tested was not found
	in the array of prime numbers, and therefore it is not a prime number. Regardless of the cases, a message will be shown on the prompt screen for the user containing the number he entered and whether
	or not it is prime;

	-The last method of this level consists of getting a response from the user (y/n) if he wants to run the test again;
	-If the answer is 'y', the program will print a message at the prompt communicating that a new test will be executed, the "falsePrint" field will have its value reset to "false" (if you have tested
	positive, as this is the only variable that is not overwritten as soon as the test is restarted) and the first method of the class is called (which again will obtain a value offered by the user and
	will perform all other tests mentioned above);
	
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

For each message in the prompt there are some specific signals that it assigns so that the user can identify what is being done. Below I will leave a glossary about it:

	>>> 	user input;
	### 	error;
	$$$ 	many data;
	<<< 	returning to execute the next function;
	+++ 	final result;

There will also be an executable in .jar that I will compile so that you can carry out the necessary tests on your machine. Any machine that contains a JVM will be able to successfully start the compilation from the terminal/cmd;
