/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.builder;

import edu.m0r.rpg.RpgElement;

/**
 *
 * @author m0r
 */
public class RpgElementBuilder extends AbstractBuilder {
    private String _name;

    protected RpgElementBuilder(AbstractFactory creator) {
        super(creator);
    }
    public RpgElement build() {
        if(_name == null || _name.isEmpty()) return null;
        RpgElement element = (RpgElement) new Object();
        element.setName(_name);
        return element;
    }
    public RpgElementBuilder setName(String name) {
        _name = name;
        return this;
    }
}
