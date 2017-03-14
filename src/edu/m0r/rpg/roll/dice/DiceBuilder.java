/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll.dice;

import edu.m0r.rpg.builder.IBuilder;
import edu.m0r.rpg.util.Constants;
import edu.m0r.rpg.util.Reflection;

/**
 *
 * @author m0r
 * @param <D>
 */
public class DiceBuilder<D extends AbstractDice> implements IBuilder<D> {
    
    private int _min = Constants.INT_DEFAULT_DICE_MIN;
    private int _max = Constants.INT_DEFAULT_DICE_MAX;
    
    private final Class<D> _diceType;
    
    public DiceBuilder(Class<D> diceType) {
        _diceType = diceType;
    }
    
    public DiceBuilder<D> setMin(int min) {
        _min = min;
        return this;
    }
    public DiceBuilder<D> setMax(int max) {
        _max = max;
        return this;
    }
    public DiceBuilder<D> setSides(int nSides) {
        return setMax(nSides).setMin(1);
    }
    
    @Override
    public D build() {
        return (D) Reflection.getInstance(_diceType.getConstructors()[0]);
    }
    
    public Class<D> getDiceType() {
        return _diceType;
    }
}
