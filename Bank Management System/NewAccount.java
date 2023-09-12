import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    // New account creation for admin to make accounts
    String UserName;
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String Address;
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    double AccountNumber;
    public double getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        AccountNumber = accountNumber;
    }

    int age;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String BranchName;
    double previousBalance;
    public double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    double Balance;
    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getBalance() {
        return Balance;
    }

    double DepositedMoney;

    public double getDepositedMoney() {
        return DepositedMoney;
    }

    public void setDepositedMoney(double depositedMoney) {
        DepositedMoney = depositedMoney;
    }

    public Account(String userName, String password, String address, double accountNumber, int age, String branchName,
                   double previousBalance, double depositedMoney, double balance) {
        UserName = userName;
        this.password = password;
        Address = address;
        AccountNumber = accountNumber;
        this.age = age;
        BranchName = branchName;
        this.previousBalance = previousBalance;
        DepositedMoney = depositedMoney;
        Balance = previousBalance + depositedMoney;
    }

    public HashMap<String, String> storinginfo() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(UserName, password);
        return hashMap;
    }

    @Override
    public String toString() {
        return "Account{" +
                "\nUser Name       " + UserName +
                "\nPassword        " + password +
                "\nAddress         " + Address +
                "\nAccount No      " + AccountNumber +
                "\nAge             " + age +
                "\nBranch          " + BranchName +
                "\nPrevious Bal    " + previousBalance +
                "\nBalance         " + Balance +
                "\nDeposited Money " + DepositedMoney + " }";
    }
}

class MoneyTransfer {
    Scanner sc = new Scanner(System.in);
    private HashMap<String, String> hashMap;
    String name;
    String matchpassword;

    public void enteringdetails() {
        System.out.println("Enter Your name : ");
        name = sc.nextLine();
        System.out.println("Enter Your password : ");
        matchpassword = sc.nextLine();
    }

    public MoneyTransfer(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    // Alternatively, use a method to receive the HashMap
    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

   

    // Access and compare the HashMap in the second class
    public void accessHashMap() {
        // Accessing a value using a key
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String username = entry.getKey();
            String storedPassword = entry.getValue();

            // Comparing the stored password with the provided password
            if (username.equals(name) && storedPassword.equals(matchpassword)) {
                // Performing more operations
                System.out.println("1: Withdraw Money ");
                System.out.println("2: Deposit Money");

                int j = sc.nextInt();
                if (j==1) {
                    withdraw();
                }
                else if(j==2){
                deposit();
                }
              
                return; // Exit the method after successful authentication
            }
        }

        System.out.println("Authentication failed");
    }
//for deposit 
    public void deposit(){
         Account a = new Account("Shahzaib", "Shah", "Rawalpindi", 338001, 18, "Rawalpindi", 500, 5000, 0);
        Account a2 = new Account("Haroon", "ah", "pindi", 38002, 21, "pindi",300, 600, 0);

         double balancerequired = a.getBalance();
          balancerequired = a2.getBalance();

        System.out.println("Enter the amount to deposit: ");
        double dAmount = sc.nextDouble();
        double newBalance = balancerequired + dAmount;
        System.out.println("New Balance is: " + newBalance);
 
    }
//for withdraw
    public void withdraw(){
            Account a = new Account("Shahzaib", "Shah", "Rawalpindi", 338001, 18, "Rawalpindi", 500, 5000, 0);
        Account a2 = new Account("Haroon", "ah", "pindi", 38002, 21, "pindi",300, 600, 0);

         double balancerequired = a.getBalance();
          balancerequired = a2.getBalance();

        System.out.println("Enter the amount to deposit: ");
        double dAmount = sc.nextDouble();
        double newBalance = balancerequired -dAmount;
        System.out.println("New Balance is: " + newBalance);
 
    }

 
}

/**
 * NewAccount
 */
public class NewAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------Bank Reception------------");
        System.out.println("1:Account Details");
        System.out.println("2:Transactions");

int key = sc.nextInt();
  //Option 1   
if (key==1) {

    //for adding account 
        Account a = new Account("Shahzaib", "Shah", "Rawalpindi", 338001, 18, "Rawalpindi", 500, 5000, 0);

        HashMap<String, String> hashMap = a.storinginfo();
        System.out.println(a.toString());
       //2 user 
        Account a2 = new Account("Haroon", "ah", "pindi", 38002, 21, "pindi",300, 600, 0);

        HashMap<String, String> hashMap2 = a2.storinginfo();
        System.out.println(a2.toString());
        
//second class 
       }

//Option 2 
     else if(key==2){
        //for transactions
//1 user
 Account a = new Account("Shahzaib", "Shah", "Rawalpindi", 338001, 18, "Rawalpindi", 500, 5000, 0);

        HashMap<String, String> hashMap = a.storinginfo();
        //for hidding details i commented this 
      //  System.out.println(a.toString());
       //2 user 
        Account a2 = new Account("Haroon", "ah", "pindi", 38002, 21, "pindi",300, 600, 0);

        HashMap<String, String> hashMap2 = a2.storinginfo();
       // System.out.println(a2.toString());
       System.out.println("Enter Your member No : ");
int k  = sc.nextInt();
if (k==1) {
     MoneyTransfer m = new MoneyTransfer(hashMap);
        m.enteringdetails();
        m.accessHashMap();
}
 
else if(k==2){
  MoneyTransfer m2 = new MoneyTransfer(hashMap2);
        m2.enteringdetails();
        m2.accessHashMap();
      }
    }




    }
    }

