package passwordutils.datasources;

import java.util.Random;

public enum Dictionary {
    perro(0, "perro"),
    dog(1, "dog"),
    cat(2, "cat"),
    gato(3, "gato"),
    azul(3, "azul"),
    blue(4, "blue"),
    berenjena(5, "berenjena"),
    eggplant(6, "eggplant"),
    java(7, "java");


    private static final Random RAND = new Random();
    private int key;
    private String word;


    private Dictionary(int key, String word){
        this.key = key;
        this.word = word;
    }
}
