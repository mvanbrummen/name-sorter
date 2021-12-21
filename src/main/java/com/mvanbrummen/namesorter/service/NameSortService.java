package com.mvanbrummen.namesorter.service;

import com.mvanbrummen.namesorter.model.Name;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class NameSortService {

    public List<Name> sortNames(final List<Name> names) {
        return names.stream()
                .sorted(Comparator.comparing(Name::lastName)
                        .thenComparing(Name::firstName))
                .toList();
    }
}
