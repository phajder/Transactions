package com.piotrek.transactions.core;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Abstract model of transaction participant.
 *
 * @author Piotrek
 */
public class Participant {
    private String ipAddress; /**< Machine IP address */
    private State state; /**< Current state of machine */

    public Participant(String ipAddress) {
        if(ipAddress != null) {
            this.ipAddress = ipAddress;
        } else {
            try {
                this.ipAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                System.err.println("Unknown host exception thrown.");
                System.exit(1);

            }
        }
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

    /**
     * Getter
     * @return state of machine
     */
    public State getState() {
        return state;
    }
}
