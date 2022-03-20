package com.fastcampus.ch3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tmp {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a;

    private int b;
}
