package com.finki.AdventureTravel.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryBuilder {

    public String addRegions(List<String> regions) {
        StringBuilder sb = new StringBuilder();
        if (regions != null && regions.size() > 0) {
            sb.append("region in ('");
            for (int i = 0; i < regions.size(); i++) {
                sb.append(regions.get(i));
                if (i != regions.size() - 1) {
                    sb.append("', '");
                }
            }
            sb.append("' )");
        }
        return sb.toString();
    }

    public String addCategories(List<String> categories) {
        StringBuilder sb = new StringBuilder();
        if (categories != null && categories.size() > 0) {
            sb.append("category in ('");
            for (int i=0; i<categories.size(); i++) {
                sb.append(categories.get(i));
                if (i != categories.size()-1) {
                    sb.append("', '");
                }
            }
            sb.append("' )");
        }
        return sb.toString();
    }
}
