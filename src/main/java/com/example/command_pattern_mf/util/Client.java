package com.example.command_pattern_mf.util;

import com.example.command_pattern_mf.command.ICommand;
import com.example.command_pattern_mf.command.impl.*;

public class Client {
    private Receiver mReceiver;

    public Client(Receiver mReceiver) {
        this.mReceiver = mReceiver;
    }

    public ICommand initCommand(int commandItem) {
        ICommand iCommand = null;
        switch (commandItem) {
            case 0:
                iCommand = new HomeCommandImpl();
                break;
            case 1:
                iCommand = new ListAllUserCommandImpl();
                break;
            case 2:
                iCommand = new ListAllArticlesCommandImpl();
                break;
            case 3:
                iCommand = new ExitCommandImpl();
                break;
            default:
                iCommand = new Page404CommandImpl();
        }
        return iCommand;
    }
}
