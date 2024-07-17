
public class Bus{
 
    private int busNo; //instance variables
    private boolean ac;// other classes cannot access it. So u create a related methods like get/set.
    private int capacity; //get : accessor method, set:mutator method
    public int b_tickets;
    private String driver; 
    public String from; 
    public String to; 
    
     //using constructor 
     public Bus(int no,boolean ac,int cap,int b_tic,String dri,String fro,String to)
     {
        this.busNo=no;
        this.ac=ac;
        this.capacity=cap;
        this.b_tickets=b_tic;
        this.driver=dri;
        this.from=fro;
        this.to=to;
     }

     public int getBusNo()
     {
        return busNo;
     }

     public int getCapacity()
     {
        return capacity;
     }

     public void setCapacit1y(int cap)
     {
        capacity=cap;
     }

     public int getb_tickets()
     {
      return b_tickets;
     }

     public void setb_tickets(int val,int bno,int cap) //display ticket details
     {
      b_tickets=b_tickets+val;
      System.out.println("Bus_Number:"+bno+" Bus_Capasity:"+cap+" "+"Booked_Tickets:"+b_tickets+"  Available_Tic_Counts:"+(cap-b_tickets));
     }

     public void setb_tickets_cancel(int val,int bno,int cap)
     {
         b_tickets=b_tickets-val;
         //System.out.println("Bus Capasity: "+cap+" "+"Total Booked Tic_Counts from BusNum: "+bno+"is "+b_tickets+"  Available Tic_Counts: "+(cap-b_tickets));
         System.out.println("Bus_Number:"+bno+" Bus_Capasity:"+cap+" "+"Booked_Tickets:"+b_tickets+"  Available_Tic_Counts:"+(cap-b_tickets));
     }

     public boolean isAc()
     {
        return ac;
     }

     public void setAc(boolean val)
     {
        ac=val;
     }

     public String getDriver()
     {
      //System.out.println(driver);
      return driver;
     }

     public void setDriver(String dri)
     {
      driver=dri;
     }

    public void displayBusInfo() // here we invoking bus object from the main method
    { 
        System.out.print("BusNO:"+busNo+" AC:"+ac+" Total_Capacity:"+capacity+" Booked_Tickets:"+b_tickets+" DriverName:"+driver+" From:"+from+" To:"+to+"\n");
    }

    public void print()
    {
     System.out.println("hi");
    }
} 