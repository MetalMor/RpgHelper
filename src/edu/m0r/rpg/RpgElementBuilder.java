/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg;

import edu.m0r.rpg.builder.IBuilder;

/**
 *
 * @author m0r
 */
public class RpgElementBuilder implements IBuilder<RpgElement> {
    protected String _name;
    
    protected RpgElementBuilder() { }
    
    public RpgElementBuilder setName(String name) {
        _name = name;
        return this;
    }

    @Override
    public RpgElement build() {
        if(_name == null || _name.isEmpty()) return null;
        RpgElement element = new RpgElement();
        return element;
    }
}
