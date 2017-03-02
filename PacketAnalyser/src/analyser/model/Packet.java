package analyser.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;



public class Packet {
	
	// Declare Properties for Basic Packet Analysis Based on the Labels and Data Types Below.
	//StartTime,Dur,Proto,SrcAddr,Sport,Dir,DstAddr,Dport,State,sTos,dTos,TotPkts,TotBytes,SrcBytes,Label
	//2011/08/10 09:46:59.607825,1.026539,tcp,94.44.127.113,1577,   ->,147.32.84.59,6881,S_RA,0,0,4,276,156,flow=Background-Established-cmpgw-CVUT
	
	private final StringProperty StartTime;		// 2011/08/10 09:46:59.607825
    private final StringProperty Dur;			// 1.026539	
    //private final StringProperty Proto;			// tcp
    //private final StringProperty SrcAddr;		// 94.44.127.113
    //private final StringProperty Sport;			// 1577
    //private final StringProperty Dir;			//    ->
    //private final StringProperty DstAddr;		// 147.32.84.59
    //private final StringProperty Dport;			// 6881
    //private final StringProperty State;			// S_RA
    //private final StringProperty sTos;			// 0
    //private final StringProperty dTos;			// 0
    //private final StringProperty TotPkts;		// 4
    //private final StringProperty TotBytes;		// 276
    //private final StringProperty SrcBytes;		// 156
    //private final StringProperty l abel			// flow=Background-Established-cmpgw-CVUT
    
    
    /**
     * Default constructor.
     */
    public Packet() {
        this(null, null);
    }
    
    /**
     * Constructor with some initial data.
     * 
     * @param StartTime
     * @param Dur
     */
    public Packet(String StartTime, String Dur) {
        this.StartTime = new SimpleStringProperty(StartTime);
        this.Dur = new SimpleStringProperty(Dur);

        // Some initial dummy data, just for convenient testing.
    //    this.Proto = new SimpleStringProperty("tcp");
    //    this.SrcAddr = new SimpleStringProperty("94.44.127.113");
    //    this.Sport = new SimpleStringProperty("1577");
    //    this.Dir = new SimpleStringProperty("   ->");
    //    this.DstAddr = new SimpleStringProperty("tcp");
    //    this.Dport = new SimpleStringProperty("94.44.127.113");
    //    this.State = new SimpleStringProperty("1577");
    //    this.sTos  = new SimpleStringProperty("   ->");
    //    this.dTos  = new SimpleStringProperty("tcp");
    //    this.TotPkts  = new SimpleStringProperty("94.44.127.113");
    //    this.TotBytes  = new SimpleStringProperty("1577");
    //    this.SrcBytes  = new SimpleStringProperty("   ->");
    //    this.Label  = new SimpleStringProperty("   ->");
    }
    
    
    
    
    public String getStartTime() {
        return StartTime.get();
    }

    public void setStartTime(String startTime) {
        this.StartTime.set(startTime);
    }

    public StringProperty StartTimeProperty() {
        return StartTime;
    }

  
    public String getDur() {
        return Dur.get();
    }

    public void setDur(String dur) {
        this.Dur.set(dur);
    }

    public StringProperty durProperty() {
        return Dur;
    }
    
    
   // public String getStreet() {
   //     return street.get();
   // }

   // public void setStreet(String street) {
   //     this.street.set(street);
   // }

   // public StringProperty streetProperty() {
   //     return street;
   // }

   // public int getPostalCode() {
   //     return postalCode.get();
   // }

   // public void setPostalCode(int postalCode) {
   //    this.postalCode.set(postalCode);
   // }

   // public IntegerProperty postalCodeProperty() {
   //     return postalCode;
   // }

   // public String getCity() {
   //     return city.get();
   // }

   // public void setCity(String city) {
   //     this.city.set(city);
   // }

   // public StringProperty cityProperty() {
   //     return city;
   // }

   // public LocalDate getBirthday() {
   //     return birthday.get();
   // }




}
