package com.booleanuk.core;

import java.util.List;

public class CohortManager {

    public boolean search(List<String> cohorts, String name) {

        return cohorts.contains(name);
    }
}
