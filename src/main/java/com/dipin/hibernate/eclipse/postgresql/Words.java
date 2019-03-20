package com.dipin.hibernate.eclipse.postgresql;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
 
 
@Entity
public class Words implements Serializable {
     
    private static final long serialVersionUID = 1L;
     
    @Id
    private String word;
     
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
}
