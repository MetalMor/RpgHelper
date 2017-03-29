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
 */
public class FieldListBuilder extends AbstractListBuilder<FieldList, Field<?>> {

    public FieldListBuilder(Class<Field<?>> fieldType) {
        super(FieldList.class, fieldType);
    }

}
