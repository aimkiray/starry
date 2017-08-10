package com.sinitial.test;

import org.springframework.stereotype.Component;

@Component
public class OneCd implements CompactDisc {
    private String title = "One cd";
    private String artist = "me";

    public void play() {
        System.out.println();
    }
}
