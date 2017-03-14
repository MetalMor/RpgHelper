package edu.m0r.rpg.main;

import edu.m0r.rpg.roll.StatRollBuilder;
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
        // Descomentar siguiente linea para juego de dados por consola
        // commandLine(args);
        
        /* Prueba de la clase Roll
        Roll roll = new Roll(10, 100);
        List<DiceResult> results = roll.doThrow();
        for(DiceResult result : results) 
            System.out.println("Result #" + results.indexOf(result) + ": " + result.getValue());
        */
        // Stat stat = new StatBuilder<>().setName("StatTest").setValue(12).build();
        StatBuilder sb = new StatBuilder().setName("StatTest").setValue(10).setModificator(-3);
        StatRollBuilder rb = new StatRollBuilder(sb.build()).setName("RollTest").setDices(10).setSides(100);
        List<StatDiceResult> results = rb.build().doThrow();
        for(StatDiceResult result : results)
            System.out.println("Result #" + results.indexOf(result) + ": " + result.getValue() + " + " + result.getRolledStat().getTotalValue());
        
    }
}
