package post;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Dushk
 */
public class fileWriteRead {
    public static int numb=0;
    public static ArrayList<Integer> fileNum=new ArrayList<Integer>();
    
    public static void readNum()throws IOException{
    numb=0;
    File folder = new File("../webapps/peraBlog/PostColl");
            if(folder.exists()){
           numb = folder.listFiles().length;
            
            }else
            new File("../webapps/peraBlog/PostColl").mkdirs();
    }
    
    
   public static void writeFile(String topic ,String descrip ) throws IOException{
        numb++;
        String hit="0";
        JsonObject j=new JsonObject().add("topic",topic).add("dis",descrip).add("hit",hit);
        JsonArray com=new JsonArray();//.add("a").add("aaaaaaaaaaa");
        JsonArray pending=new JsonArray();
        //int hits=0;
        //j.add("hit",hits);
        j.add("com",com);
        j.add("pending",pending);
        FileWriter xxx=new FileWriter("../webapps/peraBlog/PostColl/"+numb+".json");
        j.writeTo(xxx);
        xxx.close();
        
        //System.out.print(j.get("topic"));

    }
    public static void hits( int num) throws FileNotFoundException, IOException{
         JsonObject jj=JsonObject.readFrom(new FileReader("../webapps/peraBlog/PostColl/"+num+".json"));
         int hit=Integer.valueOf(jj.get("hit").asString());
         hit++;
         
         jj.set("hit",String.valueOf(hit));
        FileWriter xxx=new FileWriter("../webapps/peraBlog/PostColl/"+num+".json");
        jj.writeTo(xxx);
        xxx.close();
    }
     public static void update(String com , int num) throws FileNotFoundException, IOException{
        JsonObject jj=JsonObject.readFrom(new FileReader("../webapps/peraBlog/PostColl/"+num+".json"));
        JsonArray tem=(JsonArray)jj.get("pending");
        tem.add(com);
        jj.set("pending",tem);
         int flag =0 ;
         for(int c =0 ; c < fileNum.size() ; c++ ){
             if(fileNum.get(c) == num ){
                 flag = 1 ;
                 break;
             }
         }
         if(flag ==0 ){
             fileNum.add(num);
         }
        FileWriter xxx=new FileWriter("../webapps/peraBlog/PostColl/"+num+".json");
        jj.writeTo(xxx);
        xxx.close();
     }
    
    public static void upPost(String topic ,String des, int num) throws FileNotFoundException, IOException{
        JsonObject jj=JsonObject.readFrom(new FileReader("../webapps/peraBlog/PostColl/"+num+".json"));
        jj.set("topic",topic);
        jj.set("dis",des);
        
        FileWriter xxx=new FileWriter("../webapps/peraBlog/PostColl/"+num+".json");
        jj.writeTo(xxx);
        xxx.close();
        
     }
    
    
    public static JsonObject getobject(int num) throws FileNotFoundException, IOException{
        
        JsonObject jj=JsonObject.readFrom(new FileReader("../webapps/peraBlog/PostColl/"+num+".json"));
        return jj;
    }
    
    
    public static void ok(int num,int com) throws FileNotFoundException, IOException{
    JsonObject jj=JsonObject.readFrom(new FileReader("../webapps/peraBlog/PostColl/"+num+".json"));
        JsonArray comm=(JsonArray)jj.get("com");
        JsonArray tem=(JsonArray)jj.get("pending");
        String comment=tem.get(com).asString();
        tem.remove(com);
    
        comm.add(comment);
        jj.set("com",comm);
        jj.set("pending",tem);
        
        FileWriter xxx=new FileWriter("../webapps/peraBlog/PostColl/"+num+".json");
        jj.writeTo(xxx);
        xxx.close();
    }
    public static void delete(int num,int com) throws FileNotFoundException, IOException{
    JsonObject jj=JsonObject.readFrom(new FileReader("../webapps/peraBlog/PostColl/"+num+".json"));
        
        JsonArray tem=(JsonArray)jj.get("pending");

        tem.remove(com);
        
        jj.set("pending",tem);
        
        if(tem.size()==0){
        Integer file=num;
         fileNum.remove(file);
         }
        FileWriter xxx=new FileWriter("../webapps/peraBlog/PostColl/"+num+".json");
        jj.writeTo(xxx);
        xxx.close();
    }
    
}
