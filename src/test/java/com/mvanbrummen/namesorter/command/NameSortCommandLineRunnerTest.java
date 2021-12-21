package com.mvanbrummen.namesorter.command;

import com.mvanbrummen.namesorter.model.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NameSortCommandLineRunnerTest {

    @Test
    void shouldReturnListOfNamesWhenValidListOfStringsPassed() {
        var result = NameSortCommandLineRunner.parseNames(List.of(
                        "BAKER, THEODORE",
                        "SMITH, ANDREW",
                        "KENT, MADISON",
                        "SMITH, FREDERICK"
                )
        );

        assertThat(result).contains(
                new Name("THEODORE", "BAKER"),
                new Name("ANDREW", "SMITH"),
                new Name("MADISON", "KENT"),
                new Name("FREDERICK", "SMITH")
        );
    }

    @Test
    void shouldReturnStringWhenValidListOfNames() {
        var result = NameSortCommandLineRunner.namesToString(
                List.of(
                        new Name("THEODORE", "BAKER"),
                        new Name("ANDREW", "SMITH"),
                        new Name("MADISON", "KENT"),
                        new Name("FREDERICK", "SMITH")
                )
        );

        assertThat(result).isEqualTo(
                """
                        BAKER, THEODORE
                        SMITH, ANDREW
                        KENT, MADISON
                        SMITH, FREDERICK"""
        );
    }
}