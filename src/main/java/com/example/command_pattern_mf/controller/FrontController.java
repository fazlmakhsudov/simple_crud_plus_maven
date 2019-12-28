package com.example.command_pattern_mf.controller;

import com.example.command_pattern_mf.command.ICommand;
import com.example.command_pattern_mf.invoker.Invoker;
import com.example.command_pattern_mf.util.Client;
import com.example.command_pattern_mf.util.Fields;
import com.example.command_pattern_mf.util.Receiver;
import com.example.command_pattern_mf.util.View;

import java.util.Map;
import java.util.Scanner;

public class FrontController {
    private Map<String, Object> pocket;

    public FrontController(Map<String, Object> pocket) {
        this.pocket = pocket;
    }

    public void start() {
        Receiver receiver = new Receiver(pocket);
        Client client = new Client(receiver);
        View view = new View();
        Invoker invoker = new Invoker(receiver);
        view.show(Fields.HOME, pocket);
        Scanner scanner = new Scanner(System.in);
        String commandType = "";
        while (true) {
            try {
                int commandItem = scanner.nextInt();
                ICommand iCommand = client.initCommand(commandItem);
                commandType = invoker.invokeCommand(iCommand);
                view.show(commandType, pocket);
            } catch (Exception ex) {
                view.show(Fields.PAGE404, pocket);
            } finally {
                if (commandType.equals(Fields.EXIT)) {
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }
}
