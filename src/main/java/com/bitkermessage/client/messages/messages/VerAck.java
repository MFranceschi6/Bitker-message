package com.bitkermessage.client.messages.messages;

import com.bitkermessage.client.messages.bitio.LittleEndianInputStream;
import com.bitkermessage.client.messages.bitio.LittleEndianOutputStream;

import java.io.IOException;

/**
 * Created by Matteo on 07/10/2016.
 */
public class VerAck extends Message{


    public VerAck(){
        setLength(0);
    }

    @Override
    public String getCommand() {
        return "verack";
    }

    @Override
    public void read(LittleEndianInputStream leis) throws IOException {

    }

    @Override
    public void write(LittleEndianOutputStream leos) throws IOException {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
