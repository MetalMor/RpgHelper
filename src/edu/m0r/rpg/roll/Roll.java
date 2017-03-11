/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll;

import edu.m0r.rpg.roll.dice.Dice;
import edu.m0r.rpg.roll.dice.StatDice;
import edu.m0r.rpg.roll.result.DiceResult;
import edu.m0r.rpg.sheet.stats.Stat;
import edu.m0r.rpg.util.Constants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m0r
 * @param <D>
 */
public class Roll<D extends Dice> {
    private List<D> _dices = new ArrayList<>();
    private boolean _resolved = false;
    
    public Roll(int nDices) {
        this(nDices, Constants.INT_DEFAULT_DICE_SIDES);
    }
    
    public Roll(int nDices, int nSides) {
        while(_dices.size() < nDices) _dices.add(makeDice(nSides));
    }
    
    public Roll(List<D> dices) {
        _dices = dices;
    }
    
    protected D makeDice(int nSides) {
        return (D) new Dice(nSides);
    }
    protected D makeDice(int nSides, Stat stat) {
        StatDice sd = new StatDice(nSides);
        sd.setRolledStat(stat);
        return (D) sd;
    }
    
    public void setRolledStat(Stat stat) {
        for(D dice : _dices) ((StatDice) dice).setRolledStat(stat);
    }
    
    private ParameterizedType getGenericSuperclass() {
        return (ParameterizedType) this.getClass().getGenericSuperclass();
    }
    
    private Class getParameterizedType() {
        return (Class) getGenericSuperclass().getActualTypeArguments()[0];
    }
    
    public List<DiceResult> doThrow() {
        for(Dice dice : getDices()) dice.roll();
        _resolved = true;
        return getResults();
    }
    
    public List<DiceResult> getResults() {
        List<DiceResult> results = new ArrayList<>();
        if(isResolved())
            for(Dice dice : getDices()) 
                results.add(dice.getResult());
        return results;
    }
    
    public List<D> getDices() {
        if(_dices == null) setDices(new ArrayList<>());
        return _dices;
    }
    public void setDices(List<D> dices) {
        _dices = dices;
    }
    public boolean isResolved() {
        return _resolved;
    }
}
