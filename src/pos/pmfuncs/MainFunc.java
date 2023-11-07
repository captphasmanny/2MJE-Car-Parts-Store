/*MainFunc.java is a subclass of POS.java
 *********************************************************************************
 * The Main Functions will be imported and repeated from here.
 * Didn't combine all the function together in Transmission we need to use them separately.
 *********************************************************************************
 * -SpeciPath is a function to read Category Folder Path in DB.
 * -RTF is a function to read File Details.
 * -ListItem is a function to search specific folder and get all the filenames.
 * -ListDetail is a combination of SpeciPath/RTF/ListItem, to get the detail of specific selected item.
 */

package pos.pmfuncs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



/**
 *
 * 
 */
public class MainFunc {
    
    public static String rootsO = new File("").getAbsolutePath();//Original Path of POS
    
    public static String roots;
    


    
    public static String SpeciPath(String folderName){
    
    roots = rootsO+File.separator+"CarDatabase"+File.separator;//Database Path
        
        return roots + "" + folderName;//Full File Path with Folder Names Specify
    
    }
    
    public static String SpeciPathOri(String folderName){
    
    roots = rootsO+File.separator;//Database Path
        
        return roots + "" + folderName;//Full File Path with Folder Names Specify
    
    }
        
    public static String[] RTF(String fileName) {//Read the details from item files
        String input = null; 
        Scanner anainput = null;
        String[] parts = null;
        String partsX[] = new String [8];
                
        File content = new File(fileName);//new file
          try
          {
            anainput = new Scanner(content);
            if (anainput.hasNextLine()){//test if the file has another word
                           
            while(anainput.hasNextLine())
            {
                input = anainput.nextLine();//read the details
            }
            
            //System.out.println(input);

            }
            else{//test if there is nothing in the input file
            System.out.println("xYour input file is empty.\n"+
                               "Please restart the program and enter again.");
             //System.exit(0);//terminate if so
            }
            anainput.close();
          }catch(FileNotFoundException e)
          {//test if there is no file or the file path is wrong.
            System.out.println("xYou enter the wrong directory or file name.\n"+
                               "Please restart the program and enter again.");
            //System.exit(0);//terminate if so
            
          }
          finally
          {
              anainput.close();//close input
          }

          parts = input.split("###");//Split by ### to seperate values store in files
          //System.out.println(parts.length);
              partsX[0] = parts[0];
              partsX[1] = parts[1];
              partsX[2] = parts[2];
              partsX[3] = parts[3];
              partsX[4] = parts[4];
              partsX[5] = parts[5];
          if(parts.length == 6){
            
              partsX[6] = "0";
              partsX[7] = "0";              
              
          }
          else{
              partsX[6] = parts[6];
              partsX[7] = parts[7];   
          }
          //System.out.println(parts[0]);
          return partsX;
    }
    
    public static String RTF2(String fileName) {//Read the details from item files
        String input = null; 
        Scanner anainput = null;
        
                
        File content = new File(fileName);//new file
          try
          {
            anainput = new Scanner(content);
            if (anainput.hasNextLine()){//test if the file has another word
                           
            while(anainput.hasNextLine())
            {
                input = anainput.nextLine();//read the details
            }
            
            //System.out.println(input);

            }
            else{//test if there is nothing in the input file
            System.out.println("yYour input file is empty.\n"+
                               "Please restart the program and enter again.");
             //System.exit(0);//terminate if so
            }
            anainput.close();
          }catch(FileNotFoundException e)
          {//test if there is no file or the file path is wrong.
            System.out.println("yYou enter the wrong directory or file name.\n"+
                               "Please restart the program and enter again.");
            //System.exit(0);//terminate if so
            
          }
          finally
          {
              anainput.close();//close input
          }

          
          return input;
    }
    
    public static String[] RTF3(String fileName) {//Read the details from item files
        String input = null; 
        Scanner anainput = null;
                        
        File content = new File(fileName);//new file
          try
          {
            anainput = new Scanner(content);
            if (anainput.hasNextLine()){//test if the file has another word
                           
            while(anainput.hasNextLine())
            {
                input = anainput.nextLine();//read the details
            }
            
            //System.out.println(input);

            }
            else{//test if there is nothing in the input file
            System.out.println("rYour input file is empty.\n"+
                               "Please restart the program and enter again.");
             //System.exit(0);//terminate if so
            }
            anainput.close();
          }catch(FileNotFoundException e)
          {//test if there is no file or the file path is wrong.
            System.out.println("rYou enter the wrong directory or file name.\n"+
                               "Please restart the program and enter again.");
            //System.exit(0);//terminate if so
            
          }
          finally
          {
              anainput.close();//close input
          }

          return input.split("###");
    }
    
        public static String[] RTFCoupon(String fileName) {//Read the details from item files
        String input = null; 
        Scanner anainput = null;
        
        //String[] partsC = null;
                
        File content = new File(fileName);//new file
          try
          {
            anainput = new Scanner(content);
            if (anainput.hasNextLine()){//test if the file has another word
                           
            while(anainput.hasNextLine())
            {
                input = anainput.nextLine();//read the details
            }
            
            //System.out.println(input);

            }
            else{//test if there is nothing in the input file
            System.out.println("zYour input file is empty.\n"+
                               "Please restart the program and enter again.");
             //System.exit(0);//terminate if so
            
            return "No Coupon###0".split("###");
            }
            anainput.close();
          }catch(FileNotFoundException e)
          {//test if there is no file or the file path is wrong.
            System.out.println("You enter the wrong directory or file name.\n"+
                               "Please restart the program and enter again.");
            //System.exit(0);//terminate if so
            return "No Coupon###0".split("###");
          }
          finally
          {
              anainput.close();//close input
          }
          //partsC = input.split("###");//Split by ### to seperate values store in files
          
          return input.split("###");
    }
        
        
    
    public static String[] ListItem(String cutPath){
    
         File folder = new File(cutPath);
        // gets you the list of files at this folderut
        File[] listOfFiles = folder.listFiles();//read all the files paths/names
        System.out.println(listOfFiles);
        String[] fileArray = new String[listOfFiles.length];//convert File to String
        
        for (int i = 0; i < listOfFiles.length; ++i){
            fileArray[i] = listOfFiles[i].getName();//restore names to String Array
        }
    
        return fileArray;
    }
    
    public static String[] ListDetail(String detPath, int startLen, String choiceCopy){//FolderPath, Start with how many letter, Copy of String "choice"
        //System.out.println(choiceCopy);
        String DName; int num;
        File folder = new File(detPath);
        // gets you the list of files at this folder
        File[] listOfFiles = folder.listFiles();//read all the files paths/names
              num = Integer.parseInt(choiceCopy.substring(startLen));
              //System.out.println(num);
              DName = detPath+File.separator+listOfFiles[num].getName();//Full Path with Folder and Name and Extention.
              //System.out.println(DName);
              return RTF(DName);
    
    
    }
    
    public static void RateIt(String rateNum){
        String RateName = null; int whichone = -1;
        String testR = MainFunc.RTF2(SpeciPathOri("")+"RateItem.txt").toLowerCase().trim();
        //System.out.println(testR);
            
        File folderR = new File(SpeciPath(""));
            // gets you the list of files at this folder
        File[] listOfFilesR = folderR.listFiles();//read all the files paths/names
        String[] folderArrayR = new String[listOfFilesR.length];//convert File to String
        for (int i = 0; i < listOfFilesR.length; ++i){
            folderArrayR[i] = listOfFilesR[i].getName();//restore names to String Array
            //System.out.println(folderArray[i]);
        }
        
        for(int k=0; k<folderArrayR.length-1; k++){
            File folder2R = new File(SpeciPath("")+folderArrayR[k]);
            //System.out.println(MainFunc.SpeciPath("")+folderArray[k]);
            File[] listOfFiles2R = folder2R.listFiles();
            String[] RateList = new String[listOfFiles2R.length];
        
            for (int i = 0; i < listOfFiles2R.length; ++i){
                RateList[i] = listOfFiles2R[i].getName();//restore names to String Array
                //System.out.println(SEAList[i]);
            }
            
            for (int is=0; is<RateList.length; is++){
                
                String[] Rep = RateList[is].split("_");
                String comP = Rep[0].toLowerCase().trim();
                //System.out.println("FN+"+comP);
                if(comP.startsWith(testR)){
                    //System.out.println("Folder+"+folderArrayR[k]);
                    //System.out.println("LN+"+RateList[is]);
                    RateName = folderArrayR[k]+File.separator+RateList[is];
                    //System.out.println(RateName);
                    break;
                }
              
            }
           
            
        }
        //System.out.println(SpeciPath("")+RateName);
        String[] AddRate = RTF(SpeciPath("")+RateName);

                    BufferedWriter writer;
                    
            try
    {
    File fileD = new File(SpeciPath("")+RateName);
    fileD.createNewFile();


    writer = new BufferedWriter(new FileWriter(fileD));

                writer.write(AddRate[0]+"###"+AddRate[1]+"###"+AddRate[2]+"###"+
                        AddRate[3]+"###"+AddRate[4]+"###"+AddRate[5]+"###"+AddRate[6]+"###"+rateNum);
                
                writer.newLine();
                
    writer.close();
    
    }
    catch(FileNotFoundException e)
    {
        System.out.println("File Not Found");
        //System.exit( 1 );
    }
    catch(IOException e)
    {
        System.out.println("something messed up");
        //System.exit( 1 );
    }
      
    }
    
        public static void QuanChg(){
        //String QuanName = null; int whichone = -1; String QuanQuan = null;
        
        String[] testRI = MainFunc.RTF3(SpeciPathOri("")+"FBListCurr.txt");
        String[] testRQ = MainFunc.RTF3(SpeciPathOri("")+"FBQuanCurr.txt");
        String[] QuanName = new String[testRI.length];
        //for(int xxx=0; xxx<testRI.length; xxx++){
            //System.out.println(testRI[xxx]+"sss"+testRQ[xxx]);
        //}
        //System.out.println("here1");
        //System.out.println(testR);
            
        File folderRQ = new File(SpeciPath(""));
            // gets you the list of files at this folder
        File[] listOfFilesRQ = folderRQ.listFiles();//read all the files paths/names
        String[] folderArrayRQ = new String[listOfFilesRQ.length];//convert File to String
        for (int i = 0; i < listOfFilesRQ.length; ++i){
            folderArrayRQ[i] = listOfFilesRQ[i].getName();//restore names to String Array
            //System.out.println(folderArray[i]);
        }
        //System.out.println("here2");
        for(int k=0; k<folderArrayRQ.length-1; k++){
            File folder2RQ = new File(SpeciPath("")+folderArrayRQ[k]);
            //System.out.println(MainFunc.SpeciPath("")+folderArray[k]);
            File[] listOfFiles2RQ = folder2RQ.listFiles();
            String[] QuanList = new String[listOfFiles2RQ.length];
        
            for (int i = 0; i < listOfFiles2RQ.length; ++i){
                QuanList[i] = listOfFiles2RQ[i].getName();//restore names to String Array
                //System.out.println(QuanList[i]);
            }
            
            for (int is=0; is<QuanList.length; is++){
                
                String[] Qua = QuanList[is].split("_");
                
                //System.out.println("FN+"+comP);
                for(int xs=0; xs<testRI.length; xs++){
                    //System.out.println("Testy"+folderArrayRQ[k]+"---"+Qua[0]+"---"+testRI[xs]);
                if(Qua[0].startsWith(testRI[xs])){
                    //System.out.println("hahaha");
                    //System.out.println("LN+"+RateList[is]);
                    QuanName[xs] = folderArrayRQ[k]+File.separator+QuanList[is];
                    //QuanQuan[xs] = testRQ[xs];
                    //System.out.println("We Start Here:::"+QuanName[xs]+"+++"+testRQ[xs]);
                    
                }
                }
              
            }
           
            
        }
        //System.out.println("here3");
        //System.out.println(SpeciPath("")+RateName);
        for(int f=0; f<QuanName.length; f++){
        String[] MinQuan = RTF(SpeciPath("")+QuanName[f]);
        //System.out.println(SpeciPath("")+QuanName[f]);
        int MinFinal = Integer.parseInt(MinQuan[3]) - Integer.parseInt(testRQ[f]);
                    BufferedWriter writer;
                    
            try
    {
    File fileD = new File(SpeciPath("")+QuanName[f]);
    fileD.createNewFile();


    writer = new BufferedWriter(new FileWriter(fileD));

                writer.write(MinQuan[0]+"###"+MinQuan[1]+"###"+MinQuan[2]+"###"+
                       MinFinal+"###"+MinQuan[4]+"###"+MinQuan[5]+"###"+MinQuan[6]+"###"+MinQuan[7]);
                       //writer.write("hahaha");
                
                writer.newLine();
                
    writer.close();
    
    }
    catch(FileNotFoundException e)
    {
        System.out.println("File Not Found");
        //System.exit( 1 );
    }
    catch(IOException e)
    {
        System.out.println("something messed up");
        //System.exit( 1 );
    }
        }
      
    }
    
    public static void DiscountApply(String disFolder, String disPct){
        String[] fileArrayD = ListItem(SpeciPath(disFolder));
        for (int d=0; d<fileArrayD.length; d++){
            String[] detChg = RTF(SpeciPath(disFolder)+File.separator+fileArrayD[d]);
                //System.out.println(SpeciPath(disFolder)+"\\"+fileArrayD[d]);
                detChg[6] = disPct;
                BufferedWriter writer;
            try
    {
    File fileD = new File(SpeciPath(disFolder)+File.separator+fileArrayD[d]);
    fileD.createNewFile();

    writer = new BufferedWriter(new FileWriter(fileD));

                    writer.write(detChg[0]+"###"+detChg[1]+"###"+detChg[2]+"###"+
                        detChg[3]+"###"+detChg[4]+"###"+detChg[5]+"###"+detChg[6]+"###"+detChg[7]);
                //System.out.println(detChg[0]+"###"+detChg[1]+"###"+detChg[2]+"###"+
                        //detChg[3]+"###"+detChg[4]+"###"+detChg[5]+"###"+detChg[6]+"###"+detChg[7]);
                writer.newLine();
                //System.out.println(SEAList[i]);
    
    writer.close();

    }
    catch(FileNotFoundException e)
    {
        System.out.println("File Not Found");
        //System.exit( 1 );
    }
    catch(IOException e)
    {
        System.out.println("something messed up");
        //System.exit( 1 );
    }
        }
        
    
    }
}
