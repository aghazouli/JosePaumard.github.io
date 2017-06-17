/*
 * Copyright (C) 2017 José Paumard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.paumard.katas.anagrams;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by José
 */
public class AnagramsTest {

    @Test
    public void should_return_an_empty_result_list_for_an_empty_input_dictionary() {

        // Given
        List<String> dictionnary = new ArrayList<>();
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void should_return_an_empty_result_list_for_an_input_dictionary_that_contains_no_anagram() {

        // Given
        List<String> dictionnary = Arrays.asList("one", "two", "three");
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void should_return_the_correct_list_of_two_anagrams_for_an_input_dictionary_that_contains_two_anagrams() {

        // Given
        List<String> dictionnary = Arrays.asList("one", "two", "three", "rots", "sort");
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).containsOnly("rots", "sort");
    }

    @Test
    public void should_return_the_correct_lists_of_anagrams_for_an_input_dictionary_that_contains_two_groups_of_anagrams() {

        // Given
        List<String> dictionnary =
                Arrays.asList(
                        "one", "two", "three",
                        "rots", "sort",
                        "boaster", "boaters", "borates");

        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result.get(0)).containsOnly("boaster", "boaters", "borates");
        Assertions.assertThat(result.get(1)).containsOnly("rots", "sort");
    }

    @Test
    public void should_return_20683_sets_of_anagrams_for_the_provided_dictionnary() throws IOException {

        // Given
        Path dictionnaryPath = Paths.get("files/wordlist.txt");
        List<String> dictionnary = Files.lines(dictionnaryPath).collect(toList());
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> result = anagrams.computeAnagrams(dictionnary);

        // Then
        Assertions.assertThat(result).hasSize(22131);
    }

    @Test
    public void should_find_the_correct_set_of_the_longest_anagrams() throws IOException {

        // Given
        Path dictionnaryPath = Paths.get("files/wordlist.txt");
        List<String> dictionnary = Files.lines(dictionnaryPath).collect(toList());
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> longestAnagrams = anagrams.findTheLongestAnagrams(dictionnary);

        // Then
        Assertions.assertThat(longestAnagrams).hasSize(1);
        Assertions.assertThat(longestAnagrams.get(0)).containsOnly("acoustoelectrically", "electroacoustically");
    }

    @Test
    public void should_find_the_correct_set_of_the_words_with_the_most_anagrams() throws IOException {

        // Given
        Path dictionnaryPath = Paths.get("files/wordlist.txt");
        List<String> dictionnary = Files.lines(dictionnaryPath).collect(toList());
        Anagrams anagrams = new Anagrams();

        // When
        List<List<String>> longestAnagrams = anagrams.findTheBiggestAnagramicWord(dictionnary);

        // Then
        Assertions.assertThat(longestAnagrams).hasSize(3);
        Assertions.assertThat(longestAnagrams.get(0)).hasSize(13);
        Assertions.assertThat(longestAnagrams.get(0)).contains("alerts");
        Assertions.assertThat(longestAnagrams.get(1)).hasSize(13);
        Assertions.assertThat(longestAnagrams.get(1)).contains("tangiers");
        Assertions.assertThat(longestAnagrams.get(2)).hasSize(13);
        Assertions.assertThat(longestAnagrams.get(2)).contains("taser");
    }
}