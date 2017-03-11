package edu.m0r.rpg.main;

import edu.m0r.rpg.builder.RpgFactory;
import edu.m0r.rpg.builder.StatBuilder;
import edu.m0r.rpg.roll.Roll;
import edu.m0r.rpg.roll.dice.Dice;
import edu.m0r.rpg.roll.dice.StatDice;
import edu.m0r.rpg.sheet.stats.Stat;


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
        RpgFactory factory = RpgFactory.getInstance("factory");
        
        Roll<StatDice> roll = new Roll(10, 100);
        
    }
    
    private static void commandLine(String[] args) {
        Dice dice = makeDice(args);
        int rollNumber = args.length > 0 ? Integer.parseInt(args[0]) : 1;
        int index = 0;
        while(index++ < rollNumber)
            System.out.println("Result #" + index + ": " + dice.roll());
    }
    
    /**
     * En funcion del array de parametros de entrada, instancia un objeto de la
     * clase <code>Dice</code> para ejecutar las tiradas.
     * @param args Argumentos entrados por linea de comandos.
     * @return Objeto <code>Dice</code> correspondiente a los argumentos.
     */
    private static Dice makeDice(String[] args) {
        if(args == null) return new Dice();
        if(args.length == 2) return new Dice(Integer.parseInt(args[1]));
        if(args.length > 2) return new Dice(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        return new Dice();
    }
}
