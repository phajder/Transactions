package com.piotrek.transactions.core;

import com.piotrek.transactions.util.Vote;

/**
 * Represents Coordinator in system.
 *
 * @author Piotrek
 */
public class Coordinator extends Participant {

    /**
     * Researches for transaction state
     * @return Vote transaction decision
     */
    public Vote verdict() {
        for(Participant participant: participants) {
            if(participant.state != State.READY)
                return Vote.ROLLBACK;
        }
        return Vote.COMMIT;
    }

    /**
     * Sets cohorts state
     * @param state new state of Cohort
     * @param cohortId number of Cohort
     */
    public void setCohortState(State state, int cohortId) {
        participants[cohortId].setState(state);
    }

    /**
     * Allows to retrieve number of Cohorts
     * @return number of Cohorts participating in transaction
     */
    public int getNumOfCohorts() {
        return participants.length;
    }
}
