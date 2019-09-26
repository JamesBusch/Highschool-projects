/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u4;

import java.util.Objects;

/**
 *
 * @author jamers444
 */
public class Student {
    
    private int id;
    private long phone;
    private String firstName;
    private String lastName;
    
    
        
    public Student(){
        this.id = -1;
        this.firstName = null;
        this.lastName = null;
        this.phone = -1;
    }
    
    public Student(int id, long phone, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        if(this.id > -1) hash = 11 * hash + Objects.hashCode(this.id);
        if(this.phone > -1) hash = 11 * hash + Objects.hashCode(this.phone);
        if(this.firstName != null) hash = 11 * hash + Objects.hashCode(this.firstName);
        if(this.lastName != null)  hash = 11 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Objects.equals(this.id, other.id) && this.id > -1) {
            return true;
        }
        if (Objects.equals(this.firstName, other.firstName) && this.firstName != null) {
            if(Objects.equals(this.lastName, other.lastName) && this.lastName != null){
                if(Objects.equals(this.phone, other.phone) && this.phone > 0)return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
}