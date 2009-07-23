/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 23, 2009
 * Time: 1:54:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test_Asterisk {

    public static void main(String argsp[]){

        try{
            Asterisk as = new Asterisk("192.168.1.251","admin","1234");

            AgentCampaign a = new AgentCampaign(as);
            AgentCampaignDialer agentDial = new AgentCampaignDialer(a) ;
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
