package com.example.command_pattern_mf.command;

import com.example.command_pattern_mf.util.Receiver;

/**
 * Functional interface
 */
public interface ICommand {
    String execute(Receiver receiver);
}
