/*
 * Copyright (c) 2019.  Sii Poland
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.sii.signup;

import io.qameta.allure.Feature;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pl.sii.base.BaseTest;
import pl.sii.framework.pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Sign up with valid user data.")
@Execution(ExecutionMode.CONCURRENT)
public class SignUpTest extends BaseTest {

    @Test
    @Tag("signup")
    @Feature("Sign up to application with valid user data")
    public void userShouldBeAbleToSignUpWhenFormFilledCorrectly() {
        String uniqueEmail = String.join("@", RandomString.make(), "sii.pl");
        MainPage mainPage = application.open()
                .signIn()
                .signUp()
                .withMrGender()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail(uniqueEmail)
                .withPassword("SecurePassword1!")
                .save();

        assertThat(mainPage)
                .as("User should be redirected to main page after successful sign up")
                .isNotNull();
    }
}
