/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.fields;

import edu.m0r.rpg.RpgElement;

/**
 *
 * @author m0r
 */
public class Field extends RpgElement {
    
    private String _value;
    
    protected Field(RpgElement element) {
        super();
        init(element.getName());
    }
    
    public String getValue() {
        return _value;
    }
    public void setValue(String value) {
        _value = value;
    }
}
