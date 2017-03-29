package edu.m0r.rpg.roll.dice;

import edu.m0r.rpg.roll.result.AbstractDiceResult;
import edu.m0r.rpg.util.Constants;
import edu.m0r.rpg.util.Reflection;
import java.util.Date;
import java.util.Random;

/**
 * Simula una tirada de dados.
 * Se pueden definir en el constructor el minimo y el maximo de la tirada, ambos
 * inclusivos. Por defecto, el minimo es 1 y el maximo es 6.
 * 
 * @author m0r
 * @param <R>
 */
public abstract class AbstractDice<R extends AbstractDiceResult> {
    /**
     * Identificador inequivoco.
     */
    private long _id = new Date().getTime();
    /**
     * Maximo inclusivo de la tirada.
     */
    private int _max = Constants.INT_DEFAULT_DICE_MAX;
    /**
     * Minimo inclusivo de la tirada.
     */
    private int _min = Constants.INT_DEFAULT_DICE_MIN;
    /**
     * Objeto de aleatoriedad.
     */
    private final Random _random;
    /**
     * Resultado de la tirada.
     */
    private R _result;
    
    private final Class<R> _resultType;
    
    /**
     * Constructor con un argumento. Inicializa el objeto de aleatoriedad y el
     * tipo de resultado segun especificado por parametro.
     * @param resultType
     */
    protected AbstractDice(Class<R> resultType) {
        _random = new Random();
        _resultType = resultType;
    }
    
    /**
     * Retorna el resultado de una tirada de dados. El resultado estara entre el
     * minimo y el maximo inclusivos.
     * @return Resultado de la tirada.
     */
    public R roll() {
        if(_result == null) {
            int value = randomValue();
            _result = (R) Reflection.getInstance(_resultType.getConstructors()[1], value);
        }
        return _result;
    }
    
    protected int randomValue() {
        return _random.nextInt(getMax() - getMin() + 1) + getMin();
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
     * Define el numero de caras del dado.
     * @param nSides Numero de caras.
     */
    public void setSides(int nSides) {
        setMax(nSides);
        _min = 0;
    }
    
    /**
     * Retorna el numero de caras del dado.
     * @return Numero de caras.
     */
    public int getSides() {
        return getMax() - _min;
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
    public R getResult() {
        if(_result == null) roll();
        return _result;
    }
    
    protected void setResult(R result) {
        _result = result;
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
        if(!(obj instanceof AbstractDice)) return false;
        AbstractDice other = (AbstractDice) obj;
        return other._id == _id;
    }
    
}
