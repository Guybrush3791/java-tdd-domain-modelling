package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CohortManagerTest {

    // Red stage

    @Test
    public void testSearchEmptyName() {

        List<String> cohorts = List.of(
                "cohort java 1",
                "cohort java 2",
                "cohort java 3"
        );
        CohortManager cm = new CohortManager();

        Assertions.assertEquals(null, cm.search(cohorts, null));
        Assertions.assertEquals(null, cm.search(cohorts, ""));
        Assertions.assertEquals(null, cm.search(cohorts, "    "));
        Assertions.assertEquals(null, cm.search(cohorts, "\n\n"));
        Assertions.assertEquals(null, cm.search(cohorts, "\t\n"));
    }

    @Test
    public void testSearchEmptyCohortList() {

        List<String> cohorts = new ArrayList<>();
        CohortManager cm = new CohortManager();

        Assertions.assertEquals(null, cm.search(null, "valid name"));
        Assertions.assertEquals(false, cm.search(cohorts, "valid name"));
    }

    @Test
    public void testSearchNameInList() {

        List<String> cohorts = List.of(
                "cohort java 1",
                "cohort java 2",
                "cohort java 3"
        );
        CohortManager cm = new CohortManager();

        Assertions.assertEquals(true, cm.search(cohorts, "cohort java 1"));
        Assertions.assertEquals(true, cm.search(cohorts, "cohort java 3"));
    }

    @Test
    public void testSearchNameNotInList() {

        List<String> cohorts = List.of(
                "cohort java 1",
                "cohort java 2",
                "cohort java 3"
        );
        CohortManager cm = new CohortManager();

        Assertions.assertEquals(false, cm.search(cohorts, "cohort-java 1"));
        Assertions.assertEquals(false, cm.search(cohorts, "cohort java 4"));
    }
}
