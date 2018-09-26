package com.bitkermessage.client.messages.messages;

import com.bitkermessage.client.messages.bitio.LittleEndianInputStream;
import com.bitkermessage.client.messages.bitio.LittleEndianOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Implementation of the "block" {@link Message}
 *
 * @author Matteo Franceschi
 * @see Message
 *
 */
public class Block extends Message {

    /**
     * the parameter which keeps all the {@link Transaction} of this Message
     */
    private BlockHeader header;
    private List<Transaction> transactions;

    /**
     * initialize this Message
     */
    public Block(){
        transactions = new ArrayList<>();
    }


    /**
     * return the list of {@link Transaction}, the list returned is modificable, all the changes done to the list
     * are also done to the list of transaction of this {@link Message}
     * @return the list of {@link Transaction}
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * returns the command for this message
     * @return "block"
     */
    @Override
    public String getCommand() {
        return "block";
    }


    @Override
    public void read(LittleEndianInputStream leis) throws IOException {
        header = new BlockHeader();
        header.read(leis);
        for(long i = 0; i < header.getCount(); i++)
        {
            Transaction tran = new Transaction();
            tran.read(leis);
            transactions.add(tran);
        }

    }

    @Override
    public void write(LittleEndianOutputStream leos) throws IOException {
        header.write(leos);
        for(Transaction tran : transactions)
            tran.write(leos);
    }
}
