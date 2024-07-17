import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
 
public class Booking 
{
    String passengerName;
    int busNo;
    Date date;

    public Booking()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter passengerName: ");
        passengerName=sc.next();
        System.out.println("Enter Bus No: ");
        busNo=sc.nextInt();
        System.out.println("Enter Date dd-mm-yyyy");

        String dateInput=sc.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy"); //It is a class, note: MM means Month, mm means mins
        try {
            date=dateFormat.parse(dateInput);
        } catch (ParseException e) {
            // TODO Auto-generated catch block  ---Handling the wrong date input
            e.printStackTrace();
        }

    }

    public boolean isAvailable(ArrayList <Booking> bookings,ArrayList<Bus>buses) //here we passing only the reference of the booking and buses list
    {
        int capacity=0;

        for(Bus bus:buses)
        {
            if(bus.getBusNo()==busNo) //busNo refers current Booking ogject
            {
                capacity=bus.getCapacity();
                break;
            }
        }

        int booked=0;

        for(Booking b:bookings)
        {
            if(b.busNo==busNo && b.date.equals(date)) //current object date
            {
                booked++;
            }
        }

        if(booked<capacity)
        {
            System.out.println("Your Booking is Confirmed\n"); //ticket booking 
            for(Bus b:buses)
            {
                
                if(b.getBusNo()==busNo)
                {
                    b.setb_tickets(1,busNo,b.getCapacity());
                }
            }
        }

        return booked<capacity? true:false;
    }

    /*public void getBusInfo(ArrayList <Booking> bookings,ArrayList<Bus>buses,int B_Num)
    {
        for(Bus b:buses)
        {
            if(b.getBusNo()==B_Num) 
            {
                //System.out.print("BusNO:"+b.getBusNo()+" AC:"+b.isAc()+" Total_Capacity:"+b.getCapacity()+capacity+" DriverName:"+b.getDriver()+driver+" From:"+b.from+" To:"+b.to+"\n");
                System.out.println("hiivikram");
            }
        }
    }*/

    
    
      public void showAllPassenger(ArrayList <Booking>bookings,ArrayList <Bus>buses)
      { 
        
        int sno=1;
        for(Booking book:bookings)
        {
            System.out.print(sno+". "+book.passengerName+" "+book.busNo+" "+book.date+"\n");
            sno++;
        
        }
        
      }

      public void showPassenger(ArrayList<Booking>bookings,ArrayList<Bus>buses,int bno)
      {
        int sno=1; //serial num
        for(Booking book:bookings)
        {
            
            if(book.busNo==bno)
            {
                System.out.print(sno+". "+book.passengerName+" "+book.busNo+" "+" "+book.date+"\n");
                sno++;
            }
        }
       
      }

      public boolean isAvailableInBooking(ArrayList <Booking> bookings,ArrayList<Bus>buses)
      {
        //boolean bool=true;
        for(Booking book:bookings)
        {
            if(book.busNo==busNo&&book.date.equals(date)&&book.passengerName.equals(passengerName))
            {
                bookings.remove(book);

                for(Bus b:buses)
                {
                    if(b.getBusNo()==busNo)
                    {
                        b.setb_tickets_cancel(1,busNo,b.getCapacity());
                    }
                }
                return true;
            }
        } 
        return false;
      }
    

}
