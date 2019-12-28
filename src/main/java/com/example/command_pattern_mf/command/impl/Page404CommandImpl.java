package com.example.command_pattern_mf.command.impl;

import com.example.command_pattern_mf.command.ICommand;
import com.example.command_pattern_mf.util.Receiver;

public class Page404CommandImpl implements ICommand {
    @Override
    public String execute(Receiver receiver) {
        return receiver.action(404);
    }
}
