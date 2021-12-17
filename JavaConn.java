import java.sql.*;  
import java.util.*;

public class JavaConn{  
    
    public static void main(String args[])throws SQLException, ClassNotFoundException {  
        Scanner sc = new Scanner(System.in);
        Connection con = null;

        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/dental_mngmnt_sys?useSSL=false","root","root@123");  
            Statement stmt=con.createStatement();  
            while(con!=null) {
                System.out.println();
                System.out.println("1.Insert operation");
                System.out.println("2.Update operation");
                System.out.println("3.Delete operation");
                System.out.println("4.Select operation");
                System.out.println("5.Exit");
                System.out.println("Your choice?");
                int ch= sc.nextInt();
                sc.nextLine();
                switch(ch) {
                    case 1 :{
                        System.out.println("Enter the table name you want to insert into");
                        String table = sc.nextLine();
                        if(table.equalsIgnoreCase("Appointment")){
                            System.out.println("Enter appointment id, date, patient id, doctor id, transaction id");
                            String rec[]=sc.nextLine().split(" ");
                            String record = "insert into Appointment values('"+rec[0]+"','"+rec[1]+"','"+rec[2]+"','"+rec[3]+"','"+rec[4]+"')";
                            int x = stmt.executeUpdate(record);
                            System.out.println(x>0?"insert successfull!":"insert unsuccessfull!");
                        }
                        else if(table.equalsIgnoreCase("Bills")){
                            System.out.println("Enter bill id, amount, transaction id");
                            String rec[]=sc.nextLine().split(" ");
                            String record = "insert into Bills values('"+rec[0]+"','"+rec[1]+"','"+rec[2]+"')";
                            int x = stmt.executeUpdate(record);
                            System.out.println(x>0?"insert successfull!":"insert unsuccessfull!");
                        }
                        else if(table.equalsIgnoreCase("Doctor")){
                            System.out.println("Enter doctor id, name, number, specialization");
                            String rec[]=sc.nextLine().split(" ");
                            String record = "insert into Doctor values('"+rec[0]+"','"+rec[1]+"','"+rec[2]+"','"+rec[2]+"')";
                            int x = stmt.executeUpdate(record);
                            System.out.println(x>0?"insert successfull!":"insert unsuccessfull!");
                        }
                        else if(table.equalsIgnoreCase("Patient")){
                            System.out.println("Enter patient id, name, phone number, age, address");
                            String rec[]=sc.nextLine().split(" ");
                            String record = "insert into Patient values('"+rec[0]+"','"+rec[1]+"','"+rec[2]+"','"+rec[3]+"','"+rec[4]+"')";
                            int x = stmt.executeUpdate(record);
                            System.out.println(x>0?"insert successfull!":"insert unsuccessfull!");
                        }
                        else if(table.equalsIgnoreCase("Transaction")){
                            System.out.println("Enter Transaction id, bill id, treatment id");
                            String rec[]=sc.nextLine().split(" ");
                            String record = "insert into Transaction values('"+rec[0]+"','"+rec[1]+"','"+rec[2]+"')";
                            int x = stmt.executeUpdate(record);
                            System.out.println(x>0?"insert successfull!":"insert unsuccessfull!");
                        }
                        else if(table.equalsIgnoreCase("Treatment")){
                            System.out.println("Enter Treatment id, treatment name");
                            String rec[]=sc.nextLine().split(" ");
                            String record = "insert into Treatment values('"+rec[0]+"','"+rec[1]+"')";
                            int x = stmt.executeUpdate(record);
                            System.out.println(x>0?"insert successfull!":"insert unsuccessfull!");
                        }
                        break;
                    }
                    case 2 :{
                        System.out.println("Please enter the treatment id and the name that you want to change");
                        String id[]=sc.nextLine().split(" ");
                        //String name = sc.nextLine();
                        String record="UPDATE Treatment set treatement_name='"+id[1]+"' where treatement_id = '"+id[0]+"'";
                        int x = stmt.executeUpdate(record);
                        System.out.println(x>0?"Update successfull!":"Update unsuccessfull!");
                        break;            
                    }
                    case 3 :{
                        System.out.println("Please enter the treatment id that you want to delete");
                        String id=sc.nextLine();
                        String record="delete from Treatment where treatement_id = '"+id+"'";
                        int x = stmt.executeUpdate(record);
                        System.out.println(x>0?"delete successfull!":"delete unsuccessfull!");
                        break;
                    }
                    case 4 :{
                        String query = "select a.Appointment_ID, a.Appointment_Date, p.patient_name, p.phn_number, p.Address from Appointment a, Patient p where p.patient_id=a.patient_patient_id";
                        ResultSet rs=stmt.executeQuery(query);  
                        System.out.println("Appointment_ID  Appointment_Date  Name  phn_number  Address");
                        while(rs.next())  
                            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5));
                        break;
                     }
                    case 5: System.exit(0);
                }
            }
        }
        catch(SQLException e){ 
            System.out.println(e);
        }
        catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        finally{
            con.close();
            sc.close();
        }
    }  
} 