package com.mvanbrummen.namesorter.command;

import com.mvanbrummen.namesorter.model.Name;
import com.mvanbrummen.namesorter.service.NameSortService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NameSortCommandLineRunner implements CommandLineRunner {
    private final NameSortService nameSortService;

    static final String OUTPUT_FILE_NAME = "names-sorted.txt";
    static final String USAGE_STRING = """
            usage: name-sorter <path-to-input-txt>
            """;

    @Override
    public void run(final String... args) throws Exception {
        if (args.length == 0) {
            System.out.println(USAGE_STRING);
            System.exit(0);
        }

        var filePath = args[0];
        var inputFile = Paths.get(filePath);

        var contents = Files.readAllLines(inputFile);
        var names = parseNames(contents);

        var sortedNames = nameSortService.sortNames(names);

        var newPath = Paths.get(OUTPUT_FILE_NAME);
        Files.writeString(newPath, namesToString(sortedNames));
    }

    static List<Name> parseNames(final List<String> contents) {
        return contents.stream()
                .map(i -> {
                    var parts = i.split(", ");
                    return new Name(parts[1], parts[0]);
                })
                .toList();
    }

    static String namesToString(final List<Name> names) {
        return String.join("\n", names.stream()
                .map(i -> i.lastName() + ", " + i.firstName())
                .toList());
    }
}
