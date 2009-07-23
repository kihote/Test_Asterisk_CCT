import java.util.*;
import java.util.concurrent.TimeoutException;
import java.io.IOException;

import org.asteriskjava.*;
import org.asteriskjava.manager.*;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionState;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

import javax.naming.AuthenticationException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 21, 2009
 * Time: 12:29:32 PM
 * To change this template use File | Settings | File Templates.
 */


public class Asterisk implements  Observer {

    private ManagerConnectionFactory managerConnectionFactory;

    private List<ManagerConnection> dialerManagerPool = Collections.synchronizedList(new ArrayList());

    
    private String asteriskHost;
    private String username;
    private String password;



    public Asterisk(String host, String user, String password) throws IllegalAccessError, IOException, AuthenticationFailedException,
            org.asteriskjava.manager.TimeoutException

    {
       try{

              managerConnectionFactory = new  ManagerConnectionFactory(host, user, password);
              for(int i =0 ; i < 10 ; i++)
              {
                ManagerConnection     c = managerConnectionFactory.createManagerConnection();
                c.login();
                this.dialerManagerPool.add(c);

                Thread.sleep(150);
              }

       }  catch(InterruptedException ex)
       {
           ex.printStackTrace();
       }


    }

    public  ManagerConnection getOneDialerManagerConnection()
    {
        Random generator = new Random();
        ManagerConnection mgr = null;

        synchronized (dialerManagerPool){
            while(mgr == null ){

                int i = generator.nextInt(10);
                if (dialerManagerPool.get(i).getState() == ManagerConnectionState.CONNECTED) {
                    System.out.println("Selected dialer manager connection number:" + i + "/" + 10);
                    mgr = dialerManagerPool.get(i);
              }
            }  
        }

        return mgr;

    }



    public ManagerResponse call(String destination, String queueContext, String queueExtension, String campaign)
            throws NoAnswerException
    {

        OriginateAction originateAction;
        ManagerResponse orManagerResponse = null;
        ManagerConnection mgr = getOneDialerManagerConnection();
        try {

            originateAction = new OriginateAction();
            originateAction.setChannel("SIP/"+destination+"@siprouter");
            originateAction.setContext(queueContext);
            originateAction.setExten(queueExtension);
            originateAction.setPriority(1);
            originateAction.setTimeout(30000);
            originateAction.setCallerId("cetete");

            orManagerResponse = mgr.sendAction(originateAction,3000);

        }catch(Exception e){
            e.printStackTrace();
        }
        return orManagerResponse;

    }




    


    public void update(Observable observable, Object o) {
        //To change body of implemented methods use File | Settings | File Templates.

        
    }
}
