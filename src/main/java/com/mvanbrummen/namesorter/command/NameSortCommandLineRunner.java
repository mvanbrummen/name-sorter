package com.mvanbrummen.namesorter.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NameSortCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(final String... args) throws Exception {
        System.out.println("test!!");

    }
}
