/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.builder;

import edu.m0r.rpg.builder.AbstractFactory;


/**
 *
 * @author m0r
 */
public class RpgFactory extends AbstractFactory {
    protected RpgFactory(String name) {
        super(name);
    }
    
    public StatBuilder makeStatBuilder() {
        return (StatBuilder) makeBuilder();
    }
}
