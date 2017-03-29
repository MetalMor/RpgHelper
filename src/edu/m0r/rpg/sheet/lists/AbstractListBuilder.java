/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.lists;

import edu.m0r.rpg.RpgElement;
import edu.m0r.rpg.RpgElementBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m0r
 * @param <L>
 * @param <E>
 */
public abstract class AbstractListBuilder<L extends RpgList<E>, E extends RpgElement> extends RpgElementBuilder {
    
    private final Class<L> _listType;
    private final Class<E> _elementType;
    
    private RpgList<E> _rpgList;
    
    private List<E> _list = new ArrayList<>();
    
    protected AbstractListBuilder(Class<L> listType, Class<E> elementType) {
        super();
        _listType = listType;
        _elementType = elementType;
    }
    
    @Override
    public RpgList<E> build() {
        RpgList<E> rpgList = new RpgList<>(super.build());
        rpgList.addAll(_list);
        return rpgList;
    }
    
    public AbstractListBuilder<L, E> setList(List<E> list) {
        if(list == null) list = new ArrayList<>();
        _list = list;
        return this;
    }
}
