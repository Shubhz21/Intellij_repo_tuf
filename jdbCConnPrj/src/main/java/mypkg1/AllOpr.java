package mypkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllOpr {

  private static  Connection con;

    static {
        try {
            con = DbCon.dbCon();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void checkD(){
        try {

            PreparedStatement ps = con.prepareStatement("select * from company");

            ResultSet returnData = ps.executeQuery();

                        while(returnData.next()){

                System.out.println("|  "+returnData.getInt(1)+" "+returnData.getString(2)+" "+returnData.getInt(3)+" "+returnData.getInt(4)+" |");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void postData(){

        try{

            PreparedStatement ps = con.prepareStatement("insert into company (empid,name,deptid,salary) values ( ? , ? , ? , ? )");
            ps.setInt(1,2);
            ps.setString(2,"Mike");
            ps.setInt(3,65);
            ps.setInt(4,24000);

            int response = ps.executeUpdate();

            if(response>0) {

                System.out.println("Data insertion successfull!  rows affected: "+response);

            }else {
                System.out.println("Task incomplete!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
