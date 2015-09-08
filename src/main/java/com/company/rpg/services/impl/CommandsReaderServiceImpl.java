package com.company.rpg.services.impl;

import com.company.rpg.services.CommandsReaderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by karmanov on 9/7/15.
 */
public class CommandsReaderServiceImpl implements CommandsReaderService {

    private BufferedReader inputReader;

    public CommandsReaderServiceImpl() {
        this.inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readInput() throws IOException {
        return inputReader.readLine();
    }
}
