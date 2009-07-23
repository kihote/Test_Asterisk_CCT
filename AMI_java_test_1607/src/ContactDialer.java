import org.asteriskjava.manager.response.ManagerResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 22, 2009
 * Time: 9:54:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class ContactDialer implements Runnable {

    AbstractCampaign campaign;
    Contact contact;





    public ContactDialer(Contact contact, AbstractCampaign campaign) {
        this.contact = contact;
        this.campaign = campaign;
        Thread t = new Thread(this);
        t.start();
    }
             
    private ManagerResponse response;
    

                  

    private void dial() {

        try {

            ManagerResponse callResponse = campaign.getAsterisk().call(contact.getPhone(),"siprouter","8111","efefef");
            

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
        dial();
    }
}
