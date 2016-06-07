package com.piotrek.transactions.core;

import com.piotrek.transactions.client.RestClient;
import com.piotrek.transactions.client.RestClientImpl;
import com.piotrek.transactions.util.SystemProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Objective representation for Coordinator.
 * Holds all required data to perform commit (or rollback) action
 *
 * @author Piotrek
 */
public class Coordinator {
    private Participant[] participants; /**< All participants */
    private State globalState; /**< Global state of all machines */
    private RestClient client; /**< Used for communication with cohorts */

    /**
     * Initializes array of participants, their IPs and holds their state in local memory.
     */
    public Coordinator() {
        List<Participant> list = new ArrayList<>();
        String ipAddress;
        int counter = 1;
        while(true) {
            ipAddress = SystemProperties.getProperty(SystemProperties.COHORT_IP + counter++, false);
            if(ipAddress == null) break;
            list.add(new Participant(ipAddress));
        }
        participants = list.toArray(new Participant[list.size()]);
        client = new RestClientImpl();
    }

    public void startVoting() {

    }

    /**
     * Collect votes from cohorts. Required to perform global commit.
     */
    public void getVotes() {
        State state;
        for (Participant participant : participants) {
            state = client.getMachineState(participant.getIpAddress());
            participant.setState(state);
        }
    }

    /**
     * Processing all votes and deciding about global state.
     */
    public void processVoting() {
        for (Participant participant : participants) {
            if(participant.getState() != State.COMMIT)
                globalState =  State.ROLLBACK;
        }
        globalState = State.COMMIT;
    }

    /**
     * Distributes global state to all cohorts.
     * Is is required to perform commit on any machine.
     */
    public void sendGlobalState() {
        for (Participant participant : participants) {
            client.sendGlobalState(participant.getIpAddress(), globalState);
        }
    }

    /**
     * Getter
     * @return global state of system
     */
    public State getGlobalState() {
        return globalState;
    }
}
