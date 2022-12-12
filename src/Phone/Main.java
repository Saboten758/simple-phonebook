package Phone;

import java.util.*;

public class Main
{
    static String name;
    static ArrayList<Conts> listing=new ArrayList<>();
    static ArrayList<mesg> l=new ArrayList<>();
    static ArrayList <String> temp=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    public static void choices()
    {
        int y=0;
        System.out.println("MAIN MENU!");
        System.out.println("1.Manage Contacts");
        System.out.println("2.Messages");
        System.out.println("3.Quit");
        System.out.println("Enter Your Choice:");
        int ch=sc.nextInt();
        while(y==0) {
            switch (ch) {
                case 1:
                    y = 1;
                    con();
                    break;
                case 2:
                    y = 1;
                    mesg();
                    break;
                case 3:
                    y = 1;
                    System.out.println("Exitting..");
                    break;
                default:
                    System.out.println("Try Again!");
            }
        }
    }



    public static void mesg()
    {
        int y=0;
        System.out.println("MESSAGES MENU!");
        System.out.println("1.List all messages");
        System.out.println("2.Send a new Message");
        System.out.println("3.Go Back ");
        System.out.println("Enter Your Choice:");
        int ch=sc.nextInt();
        while(y==0)
        {
            switch(ch)
            {
                case 1:
                    y=1;
                    if(l.isEmpty()){
                        System.out.println("No New messages");
                    }
                    else
                    {
                        System.out.println(name+"'s Message List:");
                        System.out.println("Name     Messages");
                        for (int i = 0; i < l.size(); i++) {
                            l.get(i).list();
                            System.out.println("    "+l.get(i).getMsg());
                        }
                    }
                    cont_end_menu(1);
                    break;
                case 2:
                    y=1;
                    if(listing.isEmpty())
                    {
                        System.out.println("No One in Contact List!");
                    }
                    else{
                        String re;
                        while(true) {
                            System.out.println("Select a Recipient:");
                            for (int i = 0; i < listing.size(); i++) {
                                System.out.println((i + 1) + "." + listing.get(i).getName());
                            }
                            System.out.println("Enter Index:");
                            int k = sc.nextInt();
                            k = k - 1;
                            try {
                                re = listing.get(k).getName();
                                break;
                            } catch (Exception e) {
                                System.out.println("No such index");
                            }
                        }
                        System.out.println("Enter Your message:");
                        String st=sc.next();
                        mesg cur=new mesg(st);
                        cur.setName(re);
                        l.add(cur);
                        System.out.println("Successfully Sent message to "+re+" from contact list!");
                    }
                    cont_end_menu(1);
                    break;
                case 3:
                    y=1;
                    choices();
                    break;
                default:
                    System.out.println("Wrong Choice!");
            }
        }

    }



    public static void cont_end_menu(int i)
    {
        System.out.println("Enter 1 to go back to main menu");
        System.out.println("Enter 2 to return to previous menu");
        int ch=sc.nextInt();
        while(true){
            if(ch==1)
            {
                choices();
                break;
            }
            else if(ch==2){
                if(i==0)
                {con();}
                else{mesg();}
                break;
            }
            else{
                System.out.println("Try Again!");
            }
        }
    }
    public static void con()
    {
        int y=0;
        System.out.println("CONTACTS MENU!");
        System.out.println("1.Show all Contacts");
        System.out.println("2.Add a new Contact");
        System.out.println("3.Search For a Contact");
        System.out.println("4.Delete a Contact");
        System.out.println("5.Go Back to previous menu");
        System.out.println("Enter Your Choice:");
        while(y==0)
        {
            switch(sc.nextInt()) {
                case 1:
                    y=1;
                    if (!listing.isEmpty()) {
                        System.out.println(name+"'s Contact List:");
                        System.out.println("Name     Numbers");
                        for (int i = 0; i < listing.size(); i++) {
                            listing.get(i).list();
                            System.out.println("    "+listing.get(i).getNumbers());
                        }
                    }
                    else System.out.println("No One In contact list!");
                    cont_end_menu(0);
                    break;
                case 2:
                    y=1;
                    System.out.println("Enter The Name:");
                    String n = sc.next();
                    System.out.println("Enter The Number:");
                    long num = sc.nextLong();
                    listing.add(new Conts(n, num));
                    System.out.println("Successfully Saved a new Contact!");
                    cont_end_menu(0);
                    break;
                case 3:
                    y=1;
                    System.out.println("Enter The Name:");
                    String search = sc.next();
                    temp.clear();
                    for (int i = 0; i < listing.size(); i++) {
                        temp.add(listing.get(i).getName());
                    }
                    int s = temp.indexOf(search);
                    if (s != -1) {
                        System.out.println("Contact Found! It is at index: " + s+1);
                    } else {
                        System.out.println("Contact Not Found!");
                    }
                    cont_end_menu(0);
                    break;
                case 4:
                    y=1;
                    System.out.println("Enter The Name:");
                    String seah = sc.next();
                    temp.clear();
                    for (int i = 0; i < listing.size(); i++) {
                        temp.add(listing.get(i).getName());
                    }
                    s = temp.indexOf(seah);
                    if (s != -1) {
                        listing.remove(s);
                        System.out.println("Deleted Successfully!");
                    } else {
                        System.out.println("Contact Does Not Exist");
                    }
                    cont_end_menu(0);
                    break;
                case 5:
                    y=1;
                    choices();
                    break;
                default:
                    System.out.println("try again!");
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter Your Name:");
        name=sc.next();
        System.out.println("Hello "+name+"!");
        choices();


    }
}
