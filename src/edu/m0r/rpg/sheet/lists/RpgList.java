/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.m0r.rpg.sheet.lists;

import edu.m0r.rpg.RpgElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Mor
 * @param <E>
 */
public class RpgList<E extends RpgElement> extends RpgElement implements List<E> {
    
    private final ArrayList<E> _list = new ArrayList<>();
    
    protected RpgList(RpgElement element) {
        init(element.getName());
    }
    
    protected RpgList(RpgList<E> rpgList) {
        addAll(rpgList);
    }

    @Override
    public int size() {
        return _list.size();
    }

    @Override
    public boolean isEmpty() {
        return _list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return _list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return _list.iterator();
    }

    @Override
    public Object[] toArray() {
        return _list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return _list.toArray(ts);
    }

    @Override
    public boolean add(E e) {
        return _list.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return _list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        return _list.containsAll(clctn);
    }

    @Override
    public boolean addAll(Collection<? extends E> clctn) {
        return _list.addAll(clctn);
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> clctn) {
        return _list.addAll(i, clctn);
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        return _list.removeAll(clctn);
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        return _list.retainAll(clctn);
    }

    @Override
    public void clear() {
        _list.clear();
    }
    
    public E get(String name) {
        for(E element : _list) 
            if(element.getName().equals(name))
                return element;
        return null;
    }

    @Override
    public E get(int i) {
        return _list.get(i);
    }

    @Override
    public E set(int i, E e) {
        return _list.set(i, e);
    }

    @Override
    public void add(int i, E e) {
        _list.add(i, e);
    }

    @Override
    public E remove(int i) {
        return _list.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return _list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return _list.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return _list.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return _list.listIterator(i);
    }

    @Override
    public List<E> subList(int i, int i1) {
        return _list.subList(i, i1);
    }
    
    @Override
    public String toString() {
        return super.toString() + "(" + size() + ")";
    }
    
}
