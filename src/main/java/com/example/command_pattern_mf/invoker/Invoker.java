package com.example.command_pattern_mf.invoker;

import com.example.command_pattern_mf.command.ICommand;
import com.example.command_pattern_mf.util.Receiver;

public class Invoker {
    private Receiver mReceiver;

    public Invoker(Receiver receiver) {
        this.mReceiver = receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.mReceiver = receiver;
    }

    public String invokeCommand(ICommand iCommand) {
        return iCommand.execute(this.mReceiver);
    }
}
