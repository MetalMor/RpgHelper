/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.m0r.rpg.sheet.lists;

import edu.m0r.rpg.roll.result.StatDiceResult;
import edu.m0r.rpg.sheet.stats.Stat;

/**
 *
 * @author Mor
 * @param <S>
 */
public class StatList<S extends Stat> extends RpgList<S> {
    public StatList(RpgList<S> rpgList) {
        super(rpgList);
    }
    
    public StatDiceResult roll(int i) {
        return get(i).roll();
    }
    
    public StatDiceResult roll(String name) {
        return get(name).roll();
    }
}
