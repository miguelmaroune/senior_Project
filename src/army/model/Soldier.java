
package army.model;

import java.io.Serializable;
import javax.swing.JOptionPane;


public class Soldier implements Serializable {
   
    static int count=0;
    private int id;
    private String firstname;
    private String lastname;
    private String rank;
    private String unit;
    private int platoonid;
//    private Sanction[] sanctions;
    
    
    public Soldier(){
    super();
    increase();
    
    }
    public Soldier(int sid,String sfn,String sln,String srank,String sunit,int spid){
        this.id=sid ;
        this.firstname=sfn;
        this.lastname=sln;
        this.rank=srank;
        this.unit=sunit;
        this.platoonid = spid;
        increase();
    }
    public Soldier(int sid,String sfn,String sln,String srank){
        this.id=sid ;
        this.firstname=sfn;
        this.lastname=sln;
        this.rank=srank;
        increase();
       
    }  
    public Soldier(int sid,String sfn,String sln){
        this.id=sid ;
        this.firstname=sfn;
        this.lastname=sln;
        increase();
       
    }
//    public Soldier(int sid,String sfn,String sln,Sanction[] sanctions1){
//        this.id=sid ;
//        this.firstname=sfn;
//        this.lastname=sln;
//        this.sanctions=sanctions1;;
//        increase();}
//    
    
    
    
    
    
    public int getid(){
    return id;}
    public String getfirstname(){
        
        return firstname;
    }
    public String getlastname(){
        return lastname;
    }
    public String getrank(){
    return rank;
}    
    public String getunit(){
       return unit;
   } 
    public int getplatoonid(){
        return platoonid;
    }
//    public Sanction[] getsanction(){
//        return sanctions;
//    }
    
    public static int getcount(){
        return count;
    }
    
    public void setfirstname (String x){
        this.firstname=x;
              
    }
    public void setlastname (String x){
        this.lastname=x;}
    public void setid (int x){
        this.id=x;}
    public void setrank (String x){
        this.rank=x;}
    public void setplatoonid (int x){
        this.platoonid=x;}
    public void setunit (String x){
        this.unit=x;}
       
     public static void increase(){
    count++;
}
     public static void decrease(){
    count--;
}
     


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
