package com.classes;

import parse.KnifesSaxBuilder;
import parse.KnifesDomBuilder;
import parse.KnifesStaxBuilder;

public class Main {
    public static void main(String args[])
    {
        KnifesStaxBuilder staxBuilder = new KnifesStaxBuilder();
        staxBuilder.buildSetKnifes("data_xml/Knifes.xml");
        System.out.println(staxBuilder.getKnifes());
    }
}