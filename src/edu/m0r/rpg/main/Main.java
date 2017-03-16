package edu.m0r.rpg.main;

import edu.m0r.rpg.roll.Roll;
import edu.m0r.rpg.roll.RollBuilder;
import edu.m0r.rpg.roll.StatRollBuilder;
import edu.m0r.rpg.roll.dice.Dice;
import edu.m0r.rpg.roll.result.DiceResult;
import edu.m0r.rpg.roll.result.StatDiceResult;
import edu.m0r.rpg.sheet.stats.StatBuilder;
import java.util.List;


/**
 * Ejecuta un juego de tiradas de dados a partir de los argumentos pasados por
 * la linea de comandos al ejecutar el programa.
 * @author m0r
 * @version 20170308 #workerwomensday
 */
public class Main {
    /**
     * Metodo principal. A partir de los argumentos de entrada por terminal, 
     * realiza una serie de tiradas de dados. El primer parametro es el numero
     * de tiradas. El segundo, el valor maximo inclusivo para la tirada.
     * En caso de haber 3, se escribe el minimo antes que el maximo.
     * @param args Argumentos de entrada por terminal.
     */
    public static void main(String[] args) {
        commandLine(args);
    }
    
    private static void commandLine(String[] args) {
        RollBuilder rb = new RollBuilder().setName("RollTest");
        Roll roll;
        if(args == null) roll = rb.build();
        else if(args.length == 1) roll = rb.setSides(Integer.parseInt(args[0])).build();
        else if(args.length == 2) roll = rb.setDices(Integer.parseInt(args[0]))
                .setSides(Integer.parseInt(args[1])).build();
        else roll = rb.build();
        List<DiceResult> results = roll.doThrow();
        for(DiceResult result : results)
            System.out.println("Result #" + (results.indexOf(result) + 1) + ": " + result.getValue());
    }
}
