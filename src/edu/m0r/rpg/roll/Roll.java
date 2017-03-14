/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll;

import edu.m0r.rpg.RpgElement;
import edu.m0r.rpg.roll.dice.AbstractDice;
import edu.m0r.rpg.roll.dice.StatDice;
import edu.m0r.rpg.roll.result.AbstractDiceResult;
import edu.m0r.rpg.sheet.stats.Stat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m0r
 * @param <D>
 * @param <R>
 */
public class Roll<D extends AbstractDice<R>, R extends AbstractDiceResult> extends RpgElement {
    private List<D> _dices = new ArrayList<>();
    private boolean _resolved = false;
    
    protected Roll(RpgElement element) {
        init(element.getName());
    }
    
    public void setRolledStat(Stat stat) {
        for(D dice : _dices) ((StatDice) dice).setRolledStat(stat);
    }
    
    public List<R> doThrow() {
        for(D dice : getDices()) dice.roll();
        _resolved = true;
        return getResults();
    }
    
    public List<R> getResults() {
        List<R> results = new ArrayList<>();
        if(isResolved())
            for(D dice : getDices()) 
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
