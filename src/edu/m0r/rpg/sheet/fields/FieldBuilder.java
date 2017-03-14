/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.fields;

import edu.m0r.rpg.RpgElementBuilder;

/**
 *
 * @author m0r
 */
public class FieldBuilder extends RpgElementBuilder {
    
    private String _value;
    
    public FieldBuilder() {}
    
    @Override
    public Field build() {
        Field field = new Field(super.build());
        field.setValue(_value);
        return field;
    }
    
    public FieldBuilder setValue(String value) {
        _value = value;
        return this;
    }
}
