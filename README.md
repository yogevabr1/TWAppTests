# TWAppTests

The project written in Java + Appium and tests the Trust Wallet app as downloaded locally from the official website.

The build tool used to manage the build and dependencies is Maven.

To execute the tests, run: 

1. Appium Server
2. Execute the command: mvn test.

The test executed is a POC of created wallet proccess:

- Create a new wallet
- Select Code phrase (111111)
- Backup manually.
- Finish the process.

As a POC (Home Assignment), the flow itself being tested and not particular UI and pages behavior.