/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 16, 2009
 * Time: 2:57:51 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;
import java.rmi.RemoteException;


import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

public class Asterisk_testAMI implements Runnable {

    private ManagerConnection managerConnection;

    public Asterisk_testAMI()throws IOException {

        ManagerConnectionFactory factory = new ManagerConnectionFactory(
                "192.168.1.251","mark","mysecret");
        this.managerConnection = factory.createManagerConnection();
        try
        {
            this.managerConnection.login();
        }catch (Exception e){
            e.printStackTrace();
        }

        
    }

    public void run()
    {
        try{


        OriginateAction originateAction;
        ManagerResponse managerResponse;

        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/8000@siprouter");
        originateAction.setContext("siprouter");
        originateAction.setExten("8111");
        originateAction.setPriority(1);
        originateAction.setTimeout(30000);

      //  managerConnection.login();
        managerResponse = managerConnection.sendAction(originateAction,30000);

        System.out.println(managerResponse.getResponse());

        managerConnection.logoff();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("aaa");
        

    }

    public static void main(String args[]) throws IOException , AuthenticationFailedException,
            TimeoutException
    {
        Asterisk_testAMI test;
        test = new Asterisk_testAMI();
        Thread b = new  Thread(test);

           b.start(); 
        


    }


}
