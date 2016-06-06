package com.piotrek.transactions.core;

import java.util.Random;

/**
 * Abstract model of transaction participant.
 *
 * @author Piotrek
 */
public abstract class Participant {
    private String ipAddress; /**< Machine IP address */
    private Random random = new Random(); /**< Random generator provided to show rollback in transactions */
    protected State state; /**< Current state of machine */
    protected static Participant[] participants; /**< All participants */

    /**
     * Any action machine can do
     */
    protected void doAction() {
        //TODO: implement any action, for example adding two digits
    }

    /**
     * Getter
     * @return String machine IP address
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Setter
     * @param state new state
     */
    public void setState(State state) {
        this.state = state;
    }
}
