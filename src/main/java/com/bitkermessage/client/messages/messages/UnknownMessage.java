package com.bitkermessage.client.messages.messages;

import com.bitkermessage.client.messages.bitio.LittleEndianInputStream;
import com.bitkermessage.client.messages.bitio.LittleEndianOutputStream;

import java.io.IOException;

/**
 * Created by Matteo on 26/10/2016.
 */
public class UnknownMessage extends Message {

    private String command;

    @Override
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public void read(LittleEndianInputStream leis) throws IOException {

    }

    @Override
    public void write(LittleEndianOutputStream leos) throws IOException {

    }
}
