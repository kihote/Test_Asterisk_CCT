import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 22, 2009
 * Time: 10:08:19 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCampaign extends Observable {


    private Asterisk asterisk;
    
    private Thread dialThread;



    public AbstractCampaign(Asterisk asterisk){
        this.asterisk = asterisk;
    }











    public Asterisk getAsterisk() {
        return asterisk;
    }

    public void setAsterisk(Asterisk asterisk) {
        this.asterisk = asterisk;
    }

    public Thread getDialThread() {
        return dialThread;
    }

    public void setDialThread(Thread dialThread) {
        this.dialThread = dialThread;
    }
}
