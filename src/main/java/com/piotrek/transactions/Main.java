package com.piotrek.transactions;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Main class for testing
 * @author Piotrek
 */
public class Main {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
    }
}
