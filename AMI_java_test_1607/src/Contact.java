/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jul 22, 2009
 * Time: 2:48:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Contact {

    private String customerCode;
    private String phone;



   public Contact(String customerCode, String phone){

       this.customerCode = customerCode;
       this.phone = phone;
   }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    
}
