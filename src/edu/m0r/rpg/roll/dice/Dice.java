package edu.m0r.rpg.roll.dice;

import edu.m0r.rpg.roll.result.DiceResult;
import edu.m0r.rpg.util.Constants;
import java.util.Date;
import java.util.Random;

/**
 * Simula una tirada de dados.
 * Se pueden definir en el constructor el minimo y el maximo de la tirada, ambos
 * inclusivos. Por defecto, el minimo es 1 y el maximo es 6.
 * 
 * @author m0r
 */
public class Dice {
    /**
     * Identificador inequivoco.
     */
    private long _id = new Date().getTime();
    /**
     * Maximo inclusivo de la tirada.
     */
    private int _max = Constants.INT_DEFAULT_DICE_SIDES;
    /**
     * Minimo inclusivo de la tirada.
     */
    private int _min = Constants.INT_DEFAULT_DICE_MIN;
    /**
     * Objeto de aleatoriedad.
     */
    private Random _random;
    /**
     * Resultado de la tirada.
     */
    private DiceResult _result;
    
    /**
     * Constructor sin argumentos. Inicializa el objeto de aleatoriedad.
     */
    public Dice() {
        _random = new Random();
    }
    
    /**
     * Constructor con argumento de valor entero. Inicializa el maximo inclusivo.
     * @param max Valor maximo inclusivo para la tirada de dados.
     */
    public Dice(int max) {
        this();
        _max = max;
    }
    
    /**
     * Constructor con dos argumentos de valor entero. Inicializa el maximo y el
     * minimo inclusivos.
     * @param min Valor minimo inclusivo para la tirada de dados.
     * @param max Valor maximo inclusivo para la tirada de dados.
     */
    public Dice(int min, int max) {
        this(max);
        _min = min;
    }
    
    /**
     * Retorna el resultado de una tirada de dados. El resultado estara entre el
     * minimo y el maximo inclusivos.
     * @return Resultado de la tirada.
     */
    public DiceResult roll() {
        int resultValue = _random.nextInt(getMax() - getMin() + 1) + getMin();
        _result = new DiceResult(resultValue);
        return _result;
    }

    /**
     * Retorna el maximo inclusivo.
     * @return Valor entero maximo inclusivo para la tirada.
     */
    public int getMax() {
        return _max;
    }

    /**
     * Define el maximo inclusivo.
     * @param max Valor entero maximo inclusivo para la tirada.
     */
    public void setMax(int max) {
        _max = max;
    }

    /**
     * Retorna el minimo inclusivo.
     * @return Valor entero minimo inclusivo para la tirada.
     */
    public int getMin() {
        return _min;
    }

    /**
     * Define el minimo inclusivo.
     * @param min Valor entero minimo inclusivo para la tirada
     */
    public void setMin(int min) {
        _min = min;
    }
    
    /**
     * Retorna el resultado de la tirada.
     * @return Resultado de la tirada.
     */
    public DiceResult getResult() {
        if(_result == null) roll();
        return _result;
    }
    
    /**
     * Evalua si dos objetos <code>Dice</code> son iguales segun su identificador
     * inequivoco interno.
     * @param obj Objeto contra el que evaluar este.
     * @return Flag <code>true</code> si este y el objeto especificado por parametro
     * son iguales.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Dice)) return false;
        Dice other = (Dice) obj;
        return other._id == _id;
    }
    
}
