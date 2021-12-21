package com.mvanbrummen.namesorter.service;


import com.mvanbrummen.namesorter.model.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NameSortServiceTest {
    NameSortService nameSortService = new NameSortService();

    @Test
    void shouldSortNamesWhenNamesPassed() {
        var names = List.of(
                new Name("THEODORE", "BAKER"),
                new Name("ANDREW", "SMITH"),
                new Name("MADISON", "KENT"),
                new Name("FREDERICK", "SMITH")
        );

        var result = nameSortService.sortNames(names);

        assertThat(result).containsExactly(
                new Name("THEODORE", "BAKER"),
                new Name("MADISON", "KENT"),
                new Name("ANDREW", "SMITH"),
                new Name("FREDERICK", "SMITH")
        );
    }

    @Test
    void shouldReturnEmptyListWhenEmptyListIsPassed() {
        assertThat(nameSortService.sortNames(List.of())).isEmpty();
    }
}