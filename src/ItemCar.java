

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pos.pmfuncs.*;

/**
 *
 
 */
class ItemCar {

    public static String mainMenuCodes[]    =   {"Tires","Head Lights","Wind Shield","Engines","Side Mirrors","Rear Mirror","Brakes","Hood","Front Door","Back Door","Fuel Tank","Transmission"};
    public static String mainMenuDesc[]     =   {"Tires","Head Lights","Wind Shield","Engines","Side Mirrors","Rear Mirror","Brakes","Hood","Front Door","Back Door","Fuel Tank","Transmission"};
    private static ArrayList list;

    public static ArrayList getSubMenu(String mainMenuCodes){

        String roots = new File("").getAbsolutePath()+File.separator+"CarDatabase"+ File.separator;
        //roots = roots.substring(0, roots.length()-8)+"database\\CarDatabase\\";
        System.out.println(roots);     
        list    =   new ArrayList();
        String[] Sep = new String[2];
        if(mainMenuCodes.equals("Tires")){
            
            String[] TiList = MainFunc.ListItem(roots+"Tires");
            String[] subCode = new String[TiList.length];
            String[] subDesc = new String[TiList.length];
            for (int i=0; i<TiList.length; i++){
                subCode [i] = "Ti"+i;
                Sep = TiList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Side Mirrors")){
            
            String[] SMList = MainFunc.ListItem(roots+"Side Mirrors");
            String[] subCode = new String[SMList.length];
            String[] subDesc = new String[SMList.length];
            for (int i=0; i<SMList.length; i++){
                subCode [i] = "SM"+i;
                Sep = SMList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Head Lights")){
            
            String[] HLList = MainFunc.ListItem(roots+"Head Lights");
            String[] subCode = new String[HLList.length];
            String[] subDesc = new String[HLList.length];
            for (int i=0; i<HLList.length; i++){
                subCode [i] = "HL"+i;
                Sep = HLList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Wind Shield")){
            
            String[] WSList = MainFunc.ListItem(roots+"Wind Shield");
            String[] subCode = new String[WSList.length];
            String[] subDesc = new String[WSList.length];
            for (int i=0; i<WSList.length; i++){
                subCode [i] = "WS"+i;
                Sep = WSList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Engines")){
            
            String[] EnList = MainFunc.ListItem(roots+"Engines");
            String[] subCode = new String[EnList.length];
            String[] subDesc = new String[EnList.length];
            for (int i=0; i<EnList.length; i++){
                subCode [i] = "En"+i;
                Sep = EnList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Rear Mirror")){
            
            String[] RMList = MainFunc.ListItem(roots+"Rear Mirror");
            String[] subCode = new String[RMList.length];
            String[] subDesc = new String[RMList.length];
            for (int i=0; i<RMList.length; i++){
                subCode [i] = "RM"+i;
                Sep = RMList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Brakes")){
            
            String[] BrList = MainFunc.ListItem(roots+"Brakes");
            String[] subCode = new String[BrList.length];
            String[] subDesc = new String[BrList.length];
            for (int i=0; i<BrList.length; i++){
                subCode [i] = "Br"+i;
                Sep = BrList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        
        else if(mainMenuCodes.equals("Hood")){
            
            String[] HoList = MainFunc.ListItem(roots+"Hood");
            String[] subCode = new String[HoList.length];
            String[] subDesc = new String[HoList.length];
            for (int i=0; i<HoList.length; i++){
                subCode [i] = "Ho"+i;
                Sep = HoList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        
        else if(mainMenuCodes.equals("Front Door")){
            
            String[] FDList = MainFunc.ListItem(roots+"Front Door");
            String[] subCode = new String[FDList.length];
            String[] subDesc = new String[FDList.length];
            for (int i=0; i<FDList.length; i++){
                subCode [i] = "FD"+i;
                Sep = FDList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Back Door")){
            
            String[] BDList = MainFunc.ListItem(roots+"Back Door");
            String[] subCode = new String[BDList.length];
            String[] subDesc = new String[BDList.length];
            for (int i=0; i<BDList.length; i++){
                subCode [i] = "BD"+i;
                Sep = BDList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Fuel Tank")){
            
            String[] FTList = MainFunc.ListItem(roots+"Fuel Tank");
            String[] subCode = new String[FTList.length];
            String[] subDesc = new String[FTList.length];
            for (int i=0; i<FTList.length; i++){
                subCode [i] = "FT"+i;
                Sep = FTList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        else if(mainMenuCodes.equals("Transmission")){
            
            String[] TrList = MainFunc.ListItem(roots+"Transmission");
            String[] subCode = new String[TrList.length];
            String[] subDesc = new String[TrList.length];
            for (int i=0; i<TrList.length; i++){
                subCode [i] = "Tr"+i;
                Sep = TrList[i].split("_");
                subDesc [i] = Sep[0];
            }

            list.add(subCode);
            list.add(subDesc);
        }
        return list;
    }
}
