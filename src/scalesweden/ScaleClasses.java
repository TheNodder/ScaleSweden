/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scalesweden;

/**
 *
 * @author Niclas Olsson, Cobton AB
 */
public interface ScaleClasses {
    static String[] Static_headers = {"Sektion", "Skalariktighet (5m)", "K"}; 
    static String[] Manouvers_headers = {"Sektion", "Manöver", "K"};
    static String[] Empty_Row_Data = { "", "", "" };
    
    static Object[][] Init_Empty_Table = {{ "", "", "" }}; //When creating a new model, populate with void data.
    
    static String[] ListOfClasses = { "[Välj i listan]", "F4C", "F4H", "Klubbskala", "FlyOnly", "POP-skala"};
    
    static String[] ListOfRuleType = { "[Välj i listan]", "Klubbregel", "Officiell"};
    
    static String[] ListOfManouvers = {"Approach and Landing",
                                "Chandelle",
                                "Extend and Retract Landing Gear",
                                "Extend and Retract Flaps",
                                "Dropping of Bombs or Fuel Tanks",
                                "Stall Turn",
                                "Immelmann Turn",
                                "Loop",
                                "Cuban Eight",
                                "Split S",
                                "Spin Three Turns",
                                "Roll",
                                "Parachute",
                                "Touch and Go",
                                "Overshoot",
                                "Side Slip",
                                "Flight in Triangular Circuit",
                                "Flight in Rectangular Circuit",
                                "Flight in a Straight Line at Constant Height",
                                "Flight in a Straight Line With One Engine Throttled",
                                "Lazy Eight", 
                                "Wingover",
                                "Take-Off",
                                "Optional",
                                "Realism",
                                "Sound(Timbre & rpm)",
                                "Scalespeed",
                                "Harmony in flight - trim"};
    
    /* **************************************************************************************************************
     * Declarations for F4C                                                                                         *
     * **************************************************************************************************************/
    Object[][] F4C_Manouvers_Sweden = {{ "1", "Take-Off", "11" },
                                       { "2", "Lazy Eight", "7"},
                                       { "3", "Descending circle 360", "7"},
                                       
                                       { "4", "Optional", "7"},
                                       { "5", "Optional", "7"},
                                       { "6", "Optional", "7"},
                                       { "7", "Optional", "7"},
                                       { "8", "Optional", "7"},
                                       { "9", "Optional", "7"},
                                       
                                       { "10", "Approach and Landing", "7"},
                                       
                                       { "11", "Realism", ""},
                                       { " a)", "Sound(Timbre & rpm)", "4"},
                                       { " b)", "Scalespeed", "9"},
                                       { " c)", "Harmony in flight - trim", "9"}
                                       
    };

    
    Object[][] F4C_Static_Sweden = {{ "1", "Konfiguration (Kontur)", "" },
                                    { " a)", "Sidovyer", "13" },
                                    { " b)", "Ändvyer", "13" },
                                    { " c)", "Planvyer", "13"}, 
                                    
                                    { "2", "Färgsättning", ""},
                                    { " a)", "Noggrannhet", "3"},
                                    { " b)", "Komplexitet", "2"},
                                    
                                    { "3)", "Markeringar", ""},
                                    { " a)", "Noggrannhet", "8"},
                                    { " b)", "Komplexitet", "3"},
                                    
                                    { "4", "Ytsruktur", ""},
                                    { " a)", "Ytsruktur", "7"},
                                    { " b)", "Realism", "7"},
                                    
                                    { "5", "Hantverksskicklighet", ""},
                                    { " a)", "Noggrannhet", "12"},
                                    { " b)", "Komplexitet", "5"},
                                    
                                    { "6", "Skaladetaljer", ""},
                                    { " a)", "Noggrannhet", "9"},
                                    { " b)", "Komplexitet", "5"}
    };
    
    /* **************************************************************************************************************
     * Declarations for F4H                                                                                         *
     * **************************************************************************************************************/
    
    Object[][] F4H_Manouvers_Sweden = F4C_Manouvers_Sweden;
    
    Object[][] F4H_Static_Sweden = {{ "1", "Konfiguration (Kontur)", "" },
                                    { " a)", "Sidovyer", "6" },
                                    { " b)", "Ändvyer", "6" },
                                    { " c)", "Planvyer", "6"},
                                    
     
                                    { "2", "Färgsättning", ""},
                                    { " a)", "Likhet", "10"},
                                    { " b)", "Komplexitet", "5"},

                                    { "3)", "Originalitet av modellen Design och konstruktion", ""},
                                    { " a)", "Poäng", "5"},
                                      
                                    { "4", "Realism", ""},
                                    { " a)", "Poäng", "7"}
                                    
};

    /* **************************************************************************************************************
     * Declarations for Fly Only                                                                                    *
     * **************************************************************************************************************/
    Object[][] FlyOnly_Manouvers_Sweden = F4C_Manouvers_Sweden;
    
    Object[][] FlyOnly_Static_Sweden = null;
    
    /* **************************************************************************************************************
     * Declarations for POP-Skala                                                                                    *
     * **************************************************************************************************************/
    Object[][] POP_Manouvers_Sweden = F4C_Manouvers_Sweden;
    
    Object[][] POP_Static_Sweden = F4C_Static_Sweden;

}
