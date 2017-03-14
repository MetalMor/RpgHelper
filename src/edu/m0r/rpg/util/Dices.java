/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.util;

import edu.m0r.rpg.roll.dice.AbstractDice;
import java.util.ArrayList;
import java.util.List;
import edu.m0r.rpg.roll.dice.Dice;

/**
 *
 * @author m0r
 */
public class Dices {
    public static <D extends AbstractDice> List<D> makeList(int nDices, int nSides, Class<D> diceType) {
        List<D> dices = new ArrayList<>();
        while(dices.size() < nDices) {
            D dice = (D) Reflection.getInstance(diceType.getConstructors()[0]);
            dice.setSides(nSides);
            dices.add(dice);
        }
        return dices;
    }
}
