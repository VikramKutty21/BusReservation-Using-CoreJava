
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BusDemo 
{
    public static void main(String args[])
    {
        
        ArrayList <Bus> buses=new ArrayList <Bus> ();
        buses.add(new Bus(1,true,2,0,"Vikram","Chennai","Bangalore")); 
        buses.add(new Bus(2,true,3,0,"Thiru","Bangalore","Mumbai"));
        buses.add(new Bus(3,true,4,0,"Nivas","Mumbai","Chennai")); 

        ArrayList <Booking> bookings=new ArrayList<Booking>();

        Scanner sc=new Scanner(System.in);

        System.out.println("<-----Welcome To Vikram's Transport------>");
        System.out.println("Total Bus Count: "+buses.size());
        System.out.println("Total Employee Count: "+buses.size()*2);
        for(Bus b:buses)
        {
            b.displayBusInfo();
        }

        System.out.println("----Welcome Passengrer----");
        int userOption=1;
        while(userOption==1||userOption==2||userOption==3||userOption==4||userOption==5)
        {
            System.out.println("1. Book ticket "+"\n"+"2. To get Bus info"+"\n"+"3.For getting Allpassenger list "+"\n"+"4.To print passenger from particular bus"+"\n"+"5. Ticket Cancellation"+"\n"+"6.To EXIT"+"\n");
            userOption=sc.nextInt();

            if(userOption==1)
            {
                //System.out.print("Booking...\n");
                Booking booking=new Booking(); //it goes to the Booking class and getting the booking details
                //Parse means analyzing and converting a program into internal format. ex: Browser - js engine(inside) The browser parse the html into a Dom tree

                if(booking.isAvailable(bookings,buses)) //etcccc code
                {
                    bookings.add(booking);

                   
                    
                    //System.out.println("Your Booking is Confirmed\n");
                }
                else
                {
                    System.out.println("Bus is Full. So try another Bus/Date\n");
                }
            }
            else if(userOption==2)
            {
                int B_Num=0;
                System.out.print("Enter BusNo to get information:");//getting singgle bus information
                B_Num=sc.nextInt();

                for(Bus b:buses)
                {   
                    if(b.getBusNo()==B_Num)//get businfo
                    {
                    b.displayBusInfo();
                    break;
                    }
                }
            }
            else if(userOption==3)
            {
                System.out.println("<----All Passenger Booking list----->"+"\n");

                if(bookings.isEmpty())
                {
                System.out.println("-------Booking List is Empty-----"+"\n");
                
                }
                else
                {
                    for(Booking book:bookings)
                    {
                        book.showAllPassenger(bookings,buses);//Full passenger list
                        System.out.println("\n");
                        break;
                    }
                    
                }
                
                   
            }
            else if(userOption==4)
            {
                int bno;
                System.out.print("Enter Bus no. to get passenger list--->");
                bno=sc.nextInt();

                System.out.println("<----Booking list for BusNo: "+bno+" ------->\n");
                for(Booking book:bookings)
                {
                    book.showPassenger(bookings,buses,bno);//Particular passenger list
                    break;
                }

            }
            else if(userOption==5)
            {
                System.out.println("You want too cancel ticket?? say Yes/No ??");
                String str=sc.next();
                //String str1="Yes";
                if((str.toLowerCase()).equals("yes"))
                {
                    //System.out.println("okkk");
                    Booking booking=new Booking();
                    if(booking.isAvailableInBooking(bookings,buses))
                    {
                        //bookings.remove(booking);
                        System.out.println("Your Booking is cancelled\n");//
                        
                    }
                    else
                    {
                        System.out.println("Oops!!! Your Ticket Booking/name not in list\n"); 
                    }
                }
                else
                {
                    System.out.println("You want to book another Ticket??"+"\n");
                }
                
            }
        }
       // sc.close();
    } 
}