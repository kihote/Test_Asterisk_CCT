/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 22, 2009
 * Time: 10:34:12 AM
 * To change this template use File | Settings | File Templates.
 */


import java.util.*;

public class AgentCampaignDialer implements Runnable{

    AgentCampaign agentCampaignDialer;

    public AgentCampaignDialer(AgentCampaign agentCampaignDialer) {

        this.agentCampaignDialer = agentCampaignDialer;
        agentCampaignDialer.setDialThread(new Thread(this));
        Thread t = agentCampaignDialer.getDialThread();

        t.start();

        
           
        
        

        
    }


    public void run() {

        Contact c1  = new Contact("001","4000");
        Contact c2 = new Contact("002","4535");
        Contact c3 = new Contact("002","4585");
        Contact c4 = new Contact("002","4655");
        Contact c5 = new Contact("002","4465");
        Contact c6 = new Contact("002","4575");




        List<Contact> listC = new ArrayList<Contact>();

       listC.add(c1);
        listC.add(c2);
        listC.add(c3);
        listC.add(c4);
        listC.add(c5);
        listC.add(c6);

        Iterator it =  listC.iterator();

        while(it.hasNext()){

            Contact c = (Contact)it.next();
            new ContactDialer(c,agentCampaignDialer);
            System.out.println("Start call 1");
        }


    }
}
