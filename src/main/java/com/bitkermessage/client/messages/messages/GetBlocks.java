package com.bitkermessage.client.messages.messages;

import com.bitkermessage.client.messages.bitio.LittleEndianInputStream;
import com.bitkermessage.client.messages.bitio.LittleEndianOutputStream;
import io.nayuki.bitcoin.crypto.Sha256Hash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matteo on 07/10/2016.
 *
 */
public class GetBlocks extends Message {

    private int version;
    private List<byte []> hashes;
    private byte [] hashstop;

    public GetBlocks(List<byte []> h){
        hashes = h;
    }
    
    public GetBlocks(){
        hashes = new ArrayList<>();
    }

    public List<byte []> getHashes() {
        return hashes;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setHashstop(byte [] arr){
        hashstop = arr;
    }

    @Override
    public String getCommand() {
        return "getblocks";
    }

    @Override
    public long getLength() {
        int varint = 1;
        if(hashes.size() < 0xFD)
            varint = 1;
        else if(hashes.size() <= 0xFFFF)
            varint = 3;
        else if(hashes.size() <= 0xFFFFFFFF)
            varint = 5;
        return 4+varint+(32*hashes.size())+32;
    }

    @Override
    public void read(LittleEndianInputStream leis) throws IOException {
        version = leis.readInt();
        long hash_count = leis.readVariableSize();
        for(long i = 0; i < hash_count; i++)
        {
            byte [] b = new byte [Sha256Hash.HASH_LENGTH];
            leis.read(b);
            hashes.add(b);
        }
        hashstop = new byte [Sha256Hash.HASH_LENGTH];
        leis.read(hashstop);
    }

    @Override
    public void write(LittleEndianOutputStream leos) throws IOException {
        leos.writeInt(version);
        leos.writeVariableSize(hashes.size());
        for(byte [] hash : hashes)
        {
            leos.write(hash);
        }
        leos.write(hashstop);
    }
}
