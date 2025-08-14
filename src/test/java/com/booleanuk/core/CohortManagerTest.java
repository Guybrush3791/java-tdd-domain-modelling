package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CohortManagerTest {

    List<String> cohorts = List.of("PHP Cohort", "Java Cohort", "JS Cohort");


    @Test
    public void getTrueIfNameIsInList() {

        String cohortName = "php";

        CohortManager cm = new CohortManager();
        Assertions.assertEquals(true, cm.search(cohorts, cohortName));
    }

    @Test
    public void getFalseIfNameIsNotInList() {

        String cohortName = "Perl";

        CohortManager cm = new CohortManager();
        Assertions.assertEquals(false, cm.search(cohorts, cohortName));
    }

    @Test
    public void getNullIfCohortListOrCohortNameIsBlank() {

        CohortManager cm = new CohortManager();

        String cohortName = " ";
        Assertions.assertNull(cm.search(cohorts, cohortName));

        cohortName = null;
        Assertions.assertNull(cm.search(cohorts, cohortName));

        cohortName = "php";
        Assertions.assertNull(cm.search(null, cohortName));
    }
}
