package com.piotrek.transactions.client;

import com.piotrek.transactions.core.State;

/**
 * Implementation of REST client in this application case
 *
 * @author Piotrek
 */
public class RestClientImpl implements RestClient {

    /**
     * Retrieves certain machine state
     * @param ip machine IP address
     * @return machine state
     */
    @Override
    public State getMachineState(String ip) {
        return null;
    }

    /**
     * Distributes global states between machines
     * @param ip machine IP address
     * @param state global state of system
     */
    @Override
    public void sendGlobalState(String ip, State state) {

    }
}
