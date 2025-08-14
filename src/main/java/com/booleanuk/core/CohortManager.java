package com.booleanuk.core;

import java.util.List;

public class CohortManager {


    public Boolean search(List<String> cohorts, String name) {

        if (cohorts == null || name == null || cohorts.isEmpty() || name.isBlank())
            return null;

        for (String cohort : cohorts)
            if (cohort.toLowerCase().trim().contains(name.toLowerCase().trim()))
                return true;

        return false;
    }
}
