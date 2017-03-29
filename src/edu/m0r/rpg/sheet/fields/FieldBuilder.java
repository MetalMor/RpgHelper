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
public class FieldBuilder<C> extends RpgElementBuilder {
    
    private C _content;
    
    private final Class<C> _contentType;
    
    public FieldBuilder(Class<C> contentType) {
        super();
        _contentType = contentType;
    }
    
    @Override
    public Field build() {
        Field field = new Field(_contentType);
        field.setName(_name);
        field.setContent(_content);
        return field;
    }
    
    @Override
    public FieldBuilder setName(String name) {
        super.setName(name);
        return this;
    }
    
    public FieldBuilder setContent(C content) {
        _content = content;
        return this;
    }
}
