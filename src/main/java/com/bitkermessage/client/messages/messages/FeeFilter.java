package com.bitkermessage.client.messages.messages;

import com.bitkermessage.client.messages.bitio.LittleEndianInputStream;
import com.bitkermessage.client.messages.bitio.LittleEndianOutputStream;

import java.io.IOException;

/**
 * Created by Matteo on 08/10/2016.
 *
 */
public class FeeFilter extends Message {

    private long feerate;

    @Override
    public String getCommand() {
        return "feefilter";
    }

    public void setFeerate(long feerate) {
        this.feerate = feerate;
    }

    @Override
    public void read(LittleEndianInputStream leis) throws IOException {
        feerate = leis.readLong();
    }

    @Override
    public void write(LittleEndianOutputStream leos) throws IOException {
        leos.writeLong(feerate);
    }
}
