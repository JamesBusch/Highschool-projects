/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class Node implements NodeInterface{
    
    private String data;
    private Node next;
    
    
    public Node(){
        this.next = null;
        this.data = null;
    }
    
    public Node(String str, Node node){
        this.data = str;
        this.next = node;
    }
    
    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext(Node newNode) {
        this.next = newNode;
    }

    @Override
    public String getValue() {
        return this.data;
    }
}