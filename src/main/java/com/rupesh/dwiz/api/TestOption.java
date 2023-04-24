package com.rupesh.dwiz.api;

import java.util.Optional;

public class TestOption {

        static Optional<Boolean> checkOption = Optional.of( false );

    public static void main(String[] args) {



        if (checkOption.equals( Optional.of( true ) )) {
            System.out.println("Its True");
        }else if (checkOption.isEmpty()){
            System.out.println("Its Empty");
        } else {
            System.out.println("Its False");
        }
    }
}
