import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
         System.out.println("=== BANK MANAGEMENT SYSTEM ===");
        Scanner std=new Scanner(System.in);
        AccountDao accountDao=new AccountDao();
        int choice;
        do{
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Update Account");
            System.out.println("5. Deposit Amount");
            System.out.println("6. Withdraw Amount");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            System.out.println("Enter Choice: ");
            choice=std.nextInt();

            switch(choice){
                case 1:{
                    //Create Account
                    System.out.println("CREATE ACCOUNT OPERATION\n");
                    System.out.print("Enter Account No : ");
                    int accno=std.nextInt();
                    std.nextLine();

                    if(accountDao.accountExists(accno)){
                        System.out.println("Account already exists\n");
                    }
                    else{
                    System.out.print("Enter Account Holder Name : ");
                    String name=std.nextLine();
                    System.out.print("Enter initial Balance : ");
                    int balance=std.nextInt();
                    std.nextLine();
                    System.out.print("Enter Account Type : ");
                    String acctype=std.nextLine();
                    accountDao.insertAccount(accno, name, balance, acctype);
                    
                    }
                    break;
                }

                case 2:{
                    //View All Accounts
                    System.out.println("SHOW ALL ACCOUNTS\n");
                    accountDao.viewAllAccounts();
                    break;
                }

                case 3:{
                    //Search Account
                    System.out.println("SEARCH ACCOUNT OPERATION\n");
                    System.out.print("Search Account No : ");
                    int accno=std.nextInt();
                    std.nextLine();
                    accountDao.searchAccount(accno);
                    break;
                }

                case 4:{
                    //Update Account
                    System.out.println("UPDATE OPERATION\n");
                    System.out.print("Enter Account No : ");
                    int accno = std.nextInt();
                    std.nextLine();

                    System.out.print("Enter New Account Holder Name : ");
                    String name = std.nextLine();

                    System.out.print("Enter New Account Type : ");
                    String acctype = std.nextLine();

                    accountDao.updateAccount(accno, name, acctype);
                    break;
                }
            

                case 5:{
                    //Deposit Amount
                    System.out.println("DEPOSIT OPERATION\n");
                    System.out.print("Enter Account No : ");
                    int accno=std.nextInt();
                    std.nextLine();
                    System.out.print("Enter Amount to Deposit : ");
                    int amount=std.nextInt();
                    std.nextLine();
                    accountDao.depositAmount(accno,amount);
                    break;
                }   

                case 6:{
                    //Withdraw Amount
                    System.out.println("WITHDRAW OPERATION\n");
                    System.out.print("Enter Account No : ");
                    int accno=std.nextInt();
                    std.nextLine();
                    System.out.print("Enter Amount to Withdraw : ");
                    int amount=std.nextInt();
                    std.nextLine();
                    accountDao.withdrawAmount(accno,amount);
                    break;
                }

                case 7:{
                    //Delete Account
                    System.out.println("DELETE OPERATION\n");
                    System.out.print("Enter Account No : ");
                    int accno=std.nextInt();
                    std.nextLine();
                    accountDao.deleteAccount(accno);
                    break;
                }

                case 8:{
                    System.out.println("THANK YOU !!");
                    break;
                }

                default:
                    System.out.println("Invalid Choice");
            }
        }while(choice!=8);
    }
}
