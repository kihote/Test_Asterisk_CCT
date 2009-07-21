import java.util.*;
import java.util.concurrent.TimeoutException;
import java.io.IOException;

import org.asteriskjava.*;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.ManagerConnection;
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



    public Asterisk(String host, String user, String password) throws IllegalStateException, IOException, AuthenticationException, TimeoutException
    {

        managerConnectionFactory = new  ManagerConnectionFactory(host, user, password);

    }



    public ManagerResponse call(String destination, String queueContext, String queueExtension, String campaign)
            throws NoAnswerException
    {

        OriginateAction originateAction;
        ManagerResponse orManagerResponse = null;
        try {
            originateAction = new OriginateAction();
            originateAction.setChannel("SIP/"+destination+"@siprouter");
            originateAction.setContext("siprouter");
            originateAction.setExten("8111");
            originateAction.setPriority(1);
            originateAction.setTimeout(30000);
            originateAction.setCallerId("cetete");

            orManagerResponse = originateAction.send
                        

            
            
            


            
        }

    }




    


    public void update(Observable observable, Object o) {
        //To change body of implemented methods use File | Settings | File Templates.

        
    }
}
