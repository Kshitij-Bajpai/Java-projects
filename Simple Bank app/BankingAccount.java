import java.util.Scanner;

public class BankingAccount{
    
    public static void main(String[] args){

        Banking bank = new Banking("XYZ","ABC");
        bank.show_menu();
    }

}

class Banking{

    int reserve, last_transaction;
    String custname, custID;

    Banking(String cname, String cid ){
        custname = cname;
        custID = cid;
    }

    String deposit(int amount){
        if(amount != 0 ){
            reserve += amount;
            last_transaction = amount;
        }
        return "Deposited "+amount+"\n";
    }

    String withdraw(int amount){
        if(amount != 0 ){
            reserve -= amount;
            last_transaction = -amount;
        }
        return "Withdrawn "+amount+"\n";
    }

    String show_last_transaction(){
        if(last_transaction > 0 ){
            return "Deposited: "+last_transaction+"\n";
        }
        else if(last_transaction < 0 ){
            return "Withdrawn: "+Math.abs(last_transaction)+"\n";
        }
        else{
            return "No Transaction Occured \n";
        }
    }

    void show_menu(){
        
        int amount;
        String result;
        char option = '\0';
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome "+custname);
        System.out.println("Your ID is "+custID+"\n");
        System.out.println("A:Check Balance");
        System.out.println("B:Deposit");
        System.out.println("C:Withdraw");
        System.out.println("D:Show last transaction");
        System.out.println("E:Exit");

        do{
            System.out.println("Enter an option \n");
            option = scan.next().charAt(0);
            
            switch(option){
                case 'A':System.out.println("\n Balance: "+reserve);
                        break;
                case 'B':System.out.println("\n Enter amount to deposit: ");
                        amount = scan.nextInt();
                        result = deposit(amount);
                        System.out.println("\n"+result);
                        break;
                case 'C':System.out.println("\n Enter amount for withdrawl: ");
                        amount = scan.nextInt();
                        result = withdraw(amount);
                        System.out.println("\n"+result);
                        break;
                case 'D':result = show_last_transaction();
                        System.out.println("\n"+result);
                        break;
                case 'E':System.out.println("Thank you for using our services");
                        break;
                default:System.out.println("Option entered is wrong!!!Please enter right option");
                        break;
            }

        }while( option != 'E');

        scan.close();
    }
}
