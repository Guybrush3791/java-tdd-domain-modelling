package com.booleanuk.core;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CohortManagerTest {

    private CohortManager cm;
    private List<String> cohorts;

    public CohortManagerTest() {

        cm = new CohortManager();
        cohorts = List.of("Karen", "Janny", "Paul", "Markus");
    }

    @Test
    public void search_fullListKarenName_true() {

        boolean res = cm.search(cohorts, "Karen");

        Assertions.assertEquals(res, true);
    }

    @Test
    public void search_fullListPhilipName_true() {

        boolean res = cm.search(cohorts, "Philip");

        Assertions.assertEquals(res, false);
    }
}
