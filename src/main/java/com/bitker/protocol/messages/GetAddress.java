package com.bitker.protocol.messages;

import com.bitker.protocol.bitio.LittleEndianInputStream;
import com.bitker.protocol.bitio.LittleEndianOutputStream;

import java.io.IOException;

/**
 * Created by Matteo on 08/10/2016.
 *
 */
public class GetAddress extends Message {


    public GetAddress(){
        setLength(0);
    }

    @Override
    public String getCommand() {
        return "getaddr";
    }

    @Override
    public void read(LittleEndianInputStream leis) throws IOException {

    }

    @Override
    public void write(LittleEndianOutputStream leos) throws IOException {

    }
}
