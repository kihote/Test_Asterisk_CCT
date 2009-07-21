/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 16, 2009
 * Time: 2:57:51 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;
import java.rmi.RemoteException;



import java.util.concurrent.Executors;
import java.util.concurrent.Executor;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

public class Asterisk_testAMI implements Runnable {

    private ManagerConnection managerConnection;
    private static final int NTHREADS = 2;
    private static final Executor exec
            = Executors.newFixedThreadPool(NTHREADS);
    
    

    public Asterisk_testAMI()throws IOException {

        ManagerConnectionFactory factory = new ManagerConnectionFactory(
                "192.168.1.251","admin","1234");
        this.managerConnection = factory.createManagerConnection();
       
        try
        {
            this.managerConnection.login();
        }catch (Exception e){
            e.printStackTrace();
        }

        
    }

    public void callAgent(String phoneNumber)
    {
         try{

        OriginateAction originateAction;
        ManagerResponse managerResponse;

        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/"+phoneNumber+"@siprouter");
        originateAction.setContext("siprouter");
        originateAction.setExten("8111");
        originateAction.setPriority(1);
        originateAction.setTimeout(30000);

//       managerConnection.login();
        managerResponse = managerConnection.sendAction(originateAction,30000);

        System.out.println(managerResponse.getResponse());

        managerConnection.logoff();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void run()
    {



      //  callAgent("8001");
      //   callAgent("8000");
        System.out.println("aaa");


    }

    public static void main(String args[]) throws IOException , AuthenticationFailedException,
            TimeoutException
    {
        Asterisk_testAMI test;
        test = new Asterisk_testAMI();
       Thread b = new  Thread(test);

        //  b.start();
       exec.execute(test);
        
        


    }


}
