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
    
    String[] ListOfClasses = { "[Välj i listan]", "F4C", "F4H", "Klubbskala", "FlyOnly"};
    String[] ListOfRuleType = { "[Välj i listan]", "Klubbtävling", "Sanktionerad"};
    String[] ListOfManouvers = { "Approach and Landing", "Chandelle", "Extend and Retract Landing Gear",
                                "Extend and Retract Flaps", "Dropping of Bombs or Fuel Tanks",
                                "Stall Turn", "Immelmann Turn", "Loop", "Cuban Eight",
                                "Split S", "Spin Three Turns", "Roll", "Parachute",
                                "Touch and Go", "Overshoot", "Side Slip", "Flight in Triangular Circuit",
                                "Flight in Rectangular Circuit", "Flight in a Straight Line at Constant Height",
                                "Flight in a Straight Line With One Engine Throttled", "Lazy Eight", 
                                "Wingover", "Take-Off", "Optional"};
    
    String[] F4C_Manouvers_Sweden = { "" };

    /**
     *
     */
    String[] F4C_Static_Sweden = { "1", "Konfiguration (Kontur)", "R" };
    //                               {"1.1","Test" "7.0"};
    
}
