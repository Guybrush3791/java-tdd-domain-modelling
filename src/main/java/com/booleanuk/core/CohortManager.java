package com.booleanuk.core;

import java.util.List;

//    The work is not done when you can't add anything
//    but is done when you can't remove anything

public class CohortManager {

    // Green stage

    public Boolean search(List<String> cohorts, String name) {

        return cohorts == null || name == null || name.isBlank()
                ? null
                : cohorts.contains(name);
    }
}