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

package org.paumard.katas.onetwo;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by José
 */
public class OneTwoTest {

    @Test
    public void should_return_one_one_for_1() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "1";
        String expectedResult = "one one";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_two_for_2() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "2";
        String expectedResult = "one two";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_two_for_3() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "3";
        String expectedResult = "one three";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_one_two_for_4() {

        // Given
        OneTwo oneTwo = new OneTwo();
        String input = "4";
        String expectedResult = "one four";

        // When
        String result = oneTwo.convertToNames(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}