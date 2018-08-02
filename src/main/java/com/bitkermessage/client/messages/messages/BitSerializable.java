package com.bitkermessage.client.messages.messages;

import com.bitkermessage.client.messages.bitio.LittleEndianInputStream;
import com.bitkermessage.client.messages.bitio.LittleEndianOutputStream;

import java.io.IOException;
import java.io.Serializable;

/**
 * This is an interface that all the structures that can be serialized as Bitcoin protocol structures need to implements
 *
 * @author Matteo Franceschi
 *
 */
public interface BitSerializable extends Serializable {

    /**
     * read the structure from the {@link LittleEndianInputStream} passed as argument
     * @param leis the InputStream where the structure is serialized
     * @throws IOException in case something went wrong
     */
    void read(LittleEndianInputStream leis) throws IOException;

    /**
     * write the structure to the {@link LittleEndianOutputStream} passed as argument
     * @param leos the OutputStream where the structure is to be serialized
     * @throws IOException in case something went wrong
     */
    void write(LittleEndianOutputStream leos) throws IOException;
}
