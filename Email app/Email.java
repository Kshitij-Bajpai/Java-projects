import java.util.Scanner;

public class Email {

    private String firstname, lastname, password;
    private String Email, alternateEmail;
    private String  department, companyCode = "abc.com";
    private int mailboxcapacity = 500, defaultLength = 10;

    public Email(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = setDepartment();
        this.password = randomPassword(defaultLength);
        this.Email = firstname.toLowerCase() +"."+ lastname.toLowerCase()+"@"+department+"."+companyCode; 
    }
    
    private String setDepartment(){
        System.out.print("\nEnter Department Code\n1.)Sales\n2.)Devlopment\n3.)Accounting\n");
        Scanner scan = new Scanner(System.in);
        int code = scan.nextInt();
        scan.close();
        switch(code){
            case 1:return "sal";
            case 2:return "dev";
            case 3: return "acc";
            default: return "";
        }    
    }

    private String randomPassword(int length){
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*€";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int rand = (int) (Math.random() * passSet.length());
            password[i] = passSet.charAt(rand);
        }
        return new String(password);
    }
    
    public void setMailCapacity(int capacity) { this.mailboxcapacity = capacity;}
    public int getMailCapacity() {return mailboxcapacity;}

    public void setPassword(String pass) { this.password = pass; }
    public String getPassword() {return password;}
 
    public void setAlterEmail(String mail) { this.alternateEmail = mail; }
    public String getAlterEmail() {return alternateEmail; }

    public String showInfo(){
        return "Name: "+firstname +" "+lastname+"\n"+
                "Email: "+Email+"\n"+
                "Password: "+password+"\n"+
                "Mail Capacity: "+mailboxcapacity+"mb"; 
    }




}



 
       
