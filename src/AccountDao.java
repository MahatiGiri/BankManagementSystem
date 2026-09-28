import java.sql.*;
public class AccountDao {

    //create Account
    public void insertAccount(int accno,String name,double balance,String acctype){
        try{
            Connection con=DBConnection.getConnection();
            String sql="insert into accmaster values(?,?,?,?)";
            PreparedStatement psmt=con.prepareStatement(sql);
            psmt.setInt(1,accno);
            psmt.setString(2, name);
            psmt.setDouble(3, balance);
            psmt.setString(4, acctype);
            int n=psmt.executeUpdate();
            System.out.println("Rows affected: " + n);
            if(n==1)
                System.out.println("Account created successfully\n");
            else
                System.out.println("Account not created\n");
            con.close();
        }
        catch(Exception er){
            System.out.println("ERROR : "+er);
        }
    }

    //check whether account exists or not
    public boolean accountExists(int accno){
        boolean exists=false;
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from accmaster where accno=?";
            PreparedStatement psmt=con.prepareStatement(sql);
            psmt.setInt(1, accno);
            ResultSet res=psmt.executeQuery();
            while(res.next()){
                if(res.getInt("accno")==accno){
                    return true;
                }
            }
            con.close();
        }
        catch(Exception er){
            System.out.println("ERROR : "+er);
        }
        return exists;
    }

    //View All Accounts
    public void viewAllAccounts(){
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from accmaster";
            Statement smt=con.createStatement();
            ResultSet res=smt.executeQuery(sql);
            while(res.next()){
                System.out.println("Account No. : "+ res.getInt("accno"));
                System.out.println("Account Holder : "+ res.getString("name"));
                System.out.println("Balance : "+ res.getInt("balance"));
                System.out.println("Account Type : "+ res.getString("acctype"));
                System.out.println("-----------------------------------------\n");
            }
            con.close();
        }
        catch(Exception er){
            System.out.println("ERROR : "+er);
        }
    }

    //Search Account
    public void searchAccount(int accno){
        try{
            Connection con=DBConnection.getConnection();
            String sql="select * from accmaster where accno=?";
            PreparedStatement psmt=con.prepareStatement(sql);
            psmt.setInt(1,accno);
            ResultSet res=psmt.executeQuery();
            if(res.next()){
                System.out.println("Account No. : "+ res.getInt("accno"));
                System.out.println("Account Holder : "+ res.getString("name"));
                System.out.println("Balance : "+ res.getInt("balance"));
                System.out.println("Account Type : "+ res.getString("acctype"));
                System.out.println("--------------------------------------------\n");
            }
            else
                System.out.println("Account No. not found\n");
            con.close();
        }
        catch(Exception er){
            System.out.println("ERROR : "+er);
        }
    }

    // Update Account
    public void updateAccount(int accno, String name, String acctype){
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update accmaster set name=?, acctype=? where accno=?";

            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, name);
            psmt.setString(2, acctype);
            psmt.setInt(3, accno);

            String sql1="select * from accmaster where accno=?";
            PreparedStatement psmt1=con.prepareStatement(sql1);
            psmt1.setInt(1,accno);

            ResultSet res=psmt1.executeQuery();

            if(res.next()){
                int n = psmt.executeUpdate();
                if(n==1)
                    System.out.println("Account updated successfully\n");
                else
                    System.out.println("Update operation failed\n");
            }
            else
                System.out.println("Account No. not found\n");
            con.close();
        }   
        catch(Exception er) {
            System.out.println("ERROR : " + er);
        }
    }

    //deposit Amount
    public void depositAmount(int accno,int amount){
        try{
            Connection con=DBConnection.getConnection();
            String sql="update accmaster set balance=balance+? where accno=?";
            PreparedStatement psmt=con.prepareStatement(sql);
            psmt.setInt(1,amount);
            psmt.setInt(2, accno);
            int n=psmt.executeUpdate();
           if(n==1)
                System.out.println("Amount deposited successfully\n");
            else
                System.out.println("Account No. not found\n");
            con.close();
        }
        catch(Exception er){
            System.out.println("ERROR : "+er);
        }
    }

    //withdraw Amount
    public void withdrawAmount(int accno,int amount){
        try{
            Connection con=DBConnection.getConnection();
            String sql="update accmaster set balance=balance-? where accno=?";

            PreparedStatement psmt=con.prepareStatement(sql);
            psmt.setInt(1,amount);
            psmt.setInt(2, accno);

            String sql1="select * from accmaster where accno=?";
            PreparedStatement psmt1=con.prepareStatement(sql1);
            psmt1.setInt(1,accno);
            ResultSet res=psmt1.executeQuery();

            if(res.next()){
                if(res.getDouble("balance")>=amount && amount>0){
                    int n=psmt.executeUpdate();
                    if(n==1)
                        System.out.println("Amount withdrawn successfully\n");
                    else
                        System.out.println("Account No. not found\n");
                }
                else
                    System.out.println("Insufficient Balance.\nWithdraw operation failed\n");
            }
            else {
                System.out.println("Account No. not found\n");
            }
            con.close();
        }
        catch(Exception er){
            System.out.println("ERROR : "+er);
        }
    }

    //delete Account
    public void deleteAccount(int accno){
        try{
            Connection con=DBConnection.getConnection();
            String sql="delete from accmaster where accno=?";
            PreparedStatement psmt=con.prepareStatement(sql);
            psmt.setInt(1, accno);
            int n=psmt.executeUpdate();
           if(n==1)
                System.out.println("Account deleted successfully\n");
            else
                System.out.println("Account No. not found\n");
            con.close();
        }
        catch(Exception er){
            System.out.println("ERROR : "+er);
        }
    }
}
