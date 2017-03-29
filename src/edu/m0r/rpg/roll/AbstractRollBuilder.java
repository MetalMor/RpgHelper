package edu.m0r.rpg.roll;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.m0r.rpg.RpgElementBuilder;
import edu.m0r.rpg.roll.dice.AbstractDice;
import edu.m0r.rpg.roll.dice.DiceBuilder;
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
public abstract class AbstractRollBuilder<D extends AbstractDice<R>, 
        R extends AbstractDiceResult> extends RpgElementBuilder {
    
    protected int _nDices = 1;
    protected int _nSides = 6;
    protected List<AbstractDice> _dices = new ArrayList<>();
    
    private final DiceBuilder<D> _diceBuilder;
    private final Class<R> _resultType;
    
    protected AbstractRollBuilder(Class<D> diceType, Class<R> resultType) {
        super();
        _diceBuilder = new DiceBuilder<>(diceType);
        _resultType = resultType;
    }
    
    @Override
    public Roll<D, R> build() {
        Roll<D, R> roll = new Roll<>(super.build());
        roll.setDices(makeDiceList(_nDices, _nSides));
        return roll;
    }
    
    private List<D> makeDiceList(int nDices, int nSides) {
        List<D> dices = new ArrayList<>();
        while(dices.size() < nDices) {
            D dice = _diceBuilder.setSides(nSides).build();
            dice.setSides(nSides);
            dices.add(dice);
        }
        return dices;
    }
    
    public Class<R> getResultType() {
        return _resultType;
    }
    
    @Override
    public AbstractRollBuilder<D, R> setName(String name) {
        return (AbstractRollBuilder<D, R>) super.setName(name);
    }
    public AbstractRollBuilder<D, R> setDices(int nDices) {
        _nDices = nDices;
        return this;
    }
    public AbstractRollBuilder<D, R> setSides(int nSides) {
        _nSides = nSides;
        return this;
    }
    
    
}
