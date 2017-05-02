/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.lists;

import edu.m0r.rpg.sheet.fields.Field;

/**
 *
 * @author m0r
 * @param <F>
 * @param <C>
 */
public class FieldListBuilder<F extends Field<C>, C> extends AbstractListBuilder<FieldList<C>, Field<C>> {

    public FieldListBuilder(Class<FieldList<C>> fieldListType) {
        super(fieldListType);
    }

}
