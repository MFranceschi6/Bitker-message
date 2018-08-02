package com.bitkermessage.client.messages.messages;

import com.bitkermessage.client.messages.bitio.LittleEndianInputStream;
import com.bitkermessage.client.messages.bitio.LittleEndianOutputStream;
import io.nayuki.bitcoin.crypto.Sha256;
import io.nayuki.bitcoin.crypto.Sha256Hash;

import java.io.IOException;

/**
 * Created by Matteo on 07/10/2016.
 *
 */
public class InventoryVector implements BitSerializable {

    private int type;
    private byte [] hash;

    public void setHash(Sha256Hash hash) {
        this.hash = hash.toBytes();
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public void generateHash(byte [] msg){
        this.hash = Sha256.getHash(msg).toBytes();
    }

    public void setType(InventoryTypes type) {
        switch (type)
        {
            case ERROR :
                this.type = 0;
                break;
            case MSG_TX :
                this.type = 1;
                break;
            case  MSG_BLOCK:
                this.type = 2;
                break;
            case MSG_FILTERED_BLOCK:
                this.type = 3;
                break;
            case MSG_CMPCT_BLOCK:
                this.type = 4;
                break;
        }
    }

    @Override
    public void read(LittleEndianInputStream leis) throws IOException {
        type = leis.readInt();
        hash = new byte [32];
        leis.read(hash);
    }

    @Override
    public void write(LittleEndianOutputStream leos) throws IOException {
        leos.writeInt(type);
        leos.write(hash);
    }

    public InventoryTypes getType() {
        switch (type)
        {
            case 0 :
                return InventoryTypes.ERROR;
            case 1 :
                return InventoryTypes.MSG_TX;
            case 2 :
                return InventoryTypes.MSG_BLOCK;
            case 3 :
                return InventoryTypes.MSG_FILTERED_BLOCK;
            case 4 :
                return InventoryTypes.MSG_CMPCT_BLOCK;
        }
        return null;
    }
}
