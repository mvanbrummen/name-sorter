package com.mvanbrummen.namesorter.command;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(args = "src/test/resources/test-input.txt")
class NameSortCommandLineRunnerIntegrationTest {

    @Test
    void shouldCreateFileWhenCommandlineRunnerRuns() throws IOException {
        var path = Paths.get(NameSortCommandLineRunner.OUTPUT_FILE_NAME);

        var result = Files.readAllLines(path);

        assertThat(result).containsExactly(
                "BAKER, THEODORE",
                "KENT, MADISON",
                "SMITH, ANDREW",
                "SMITH, FREDRICK"
        );
    }

    @AfterEach
    void tearDown() throws IOException {
        var path = Paths.get(NameSortCommandLineRunner.OUTPUT_FILE_NAME);

        Files.delete(path);
    }
}