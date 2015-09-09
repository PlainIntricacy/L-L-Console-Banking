import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Account[] LLBank = new Account[30];
        for(int i=0; i<LLBank.length; i++){
            LLBank[i] = new Account();
        }
        
        Scanner input = new Scanner(System.in);
        int in;
        do{
            Menu();
            in = Integer.parseInt(input.nextLine());
            String inpt;
            double inAmt;
            boolean found;
            int pos = 0, i=0;
            switch (in){
                case 0:
                    System.out.println("Thank you for using the L&L Bank Online Banking System");
                    System.out.println("Have a nice day!");
                    break;
                case 1:
                    int sum=0;
                    for(i=0; i<LLBank.length; i++){
                        if(!LLBank[i].name.equals("")){
                            LLBank[i].giveInfo();
                            sum+=1;
                        }
                    }
                    System.out.println(sum + "/30 accounts on file");
                    break;
                case 2:
                    System.out.println("Please enter the name of the account:");
                    inpt = input.nextLine();
                    found = false;
                    i=0;
                    while(i<LLBank.length||!found){
                        if(LLBank[i].name.toLowerCase().equals(inpt.toLowerCase())){
                            LLBank[i].giveInfo();
                            found = true;
                        }
                        i++;
                    }
                    if(!found){
                        System.out.println("No account with this name was found.");
                    }
                    break;
                case 3:
                    System.out.println("Please enter the name of the account:");
                    inpt = input.nextLine();
                    found = false;
                    i=0;
                    while(i<LLBank.length||!found){
                        if(LLBank[i].name.toLowerCase().equals(inpt.toLowerCase())){
                            found = true;
                            pos = i;
                        }
                        i++;
                    }
                    if (!found) {
                        System.out.println("No account with this name was found.");
                    }else{
                        System.out.println("Account found.");
                        System.out.println("Please enter the amount you wish to deposit:");
                        System.out.print("$");
                        inAmt = Double.parseDouble(input.nextLine());
                        LLBank[pos].deposit(inAmt);
                        System.out.println();
                        System.out.println("New account balance: $" + LLBank[pos].giveBalance());
                    }
                    break;
                case 4:
                    System.out.println("Please enter the name of the account:");
                    inpt = input.nextLine();
                    found = false;
                    i=0;
                    while(i<LLBank.length||!found){
                        if(LLBank[i].name.toLowerCase().equals(inpt.toLowerCase())){
                            found = true;
                            pos = i;
                        }
                        i++;
                    }
                    if (!found) {
                        System.out.println("No account with this name was found.");
                    }else{
                        System.out.println("Account found.");
                        System.out.println("Please enter the amount you wish to withdraw:");
                        System.out.print("$");
                        inAmt = Double.parseDouble(input.nextLine());
                        LLBank[pos].withdraw(inAmt);
                        System.out.println();
                        System.out.println("New account balance: $" + LLBank[pos].giveBalance());
                    }
                    break;
                case 5:
                    System.out.println("Adding 3% interest to all available accounts...");
                    for(i=0; i<LLBank.length; i++){
                        LLBank[i].addInterest();
                    }
                    System.out.println("Interest successfully added to all available accounts.");
                    break;
                case 6:
                    found = false;
                    i=0;
                    while(i<LLBank.length||!found){
                        if(LLBank[i].name.equals("")){
                            pos=i;
                            found = true;
                        }
                        i++;
                    }
                    if(!found){
                        System.out.println("All available accounts are filled.");
                    }else{
                        System.out.println("Empty account slot found.");
                        System.out.println("Please enter new account name:");
                        inpt = input.nextLine();
                        LLBank[pos].setName(inpt);
                        System.out.println("Please enter new account balance:");
                        System.out.print("$");
                        inAmt = Double.parseDouble(input.nextLine());
                        LLBank[pos].setBalance(inAmt);
                        System.out.println();
                        LLBank[pos].giveInfo();
                    }
                    break;
                case 7:
                    System.out.println("Please enter the name of the account:");
                    inpt = input.nextLine();
                    found = false;
                    i=0;
                    while(i<LLBank.length||!found){
                        if(LLBank[i].name.toLowerCase().equals(inpt.toLowerCase())){
                            found = true;
                            pos = i;
                        }
                        i++;
                    }
                    if(!found){
                        System.out.println("No account with this name was found.");
                    }else{
                        System.out.println("Account found.");
                        System.out.println("Removing account named " + LLBank[pos].giveName());
                        LLBank[pos].clearAccount();
                        System.out.println("Account removed.");
                    }
                    break;
                default:
                    break;
            }
        }while(in!=0);
        input.close();
    }

    public static void Menu(){
        System.out.println();
        System.out.println("Welcome to the L&L Bank Online Banking System");
        System.out.println();
        System.out.println("Select one of the following instructions by entering its listed number:");
        System.out.println();
        System.out.println("1: Display all current accounts");
        System.out.println("2: Find an account by name");
        System.out.println("3: Make a deposit");
        System.out.println("4: Make a withdrawal");
        System.out.println("5: Add interest to all accounts");
        System.out.println("6: Add an account");
        System.out.println("7: Remove an account");
        System.out.println("0: Exit");
        System.out.println();
    }

}
