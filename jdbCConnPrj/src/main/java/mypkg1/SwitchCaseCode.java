package mypkg1;

import java.sql.SQLException;
import java.util.Scanner;

public class SwitchCaseCode {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {

        Thread t = new Thread();
        boolean value=true;
        while (value!=false) {
            System.out.println("\npls choose you task: \n" +
                    "1: check connection\n" +
                    "2: show Data\n" +
                    "3: post some predefined data\n" +
                    "4: Exit");

            Scanner s = new Scanner(System.in);

            int order = s.nextInt();

            switch (order)  {
                case 1:
                    DbCon.dbCon();

                    t.sleep(2000);
                    break;
                case 2:
                    AllOpr.checkD();
                    t.sleep(2000);
                    break;
                case 3:
                    AllOpr.postData();
                    t.sleep(2000);
                    break;
                case 4:
                    value=false;
                    break;
                default:
                    System.out.println("\npls check input..");
                    t.sleep(2000);
            }
        }
    }
}
