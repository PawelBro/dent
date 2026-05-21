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

package pl.sii.framework.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.sii.framework.base.component.Page;

@Slf4j
public class SignUpPage extends Page {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "field-id_gender-1")
    private WebElement mrRadioButton;

    @FindBy(id = "field-id_gender-2")
    private WebElement mrsRadioButton;

    @FindBy(id = "field-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "field-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "field-email")
    private WebElement emailInput;

    @FindBy(id = "field-password")
    private WebElement passwordInput;

    @FindBy(css = "button[data-link-action='save-customer']")
    private WebElement saveButton;

    @FindBy(css = ".alert-danger")
    private WebElement alertMessage;

    @Step("User selects Mr as gender")
    public SignUpPage withMrGender() {
        log.info("Select Mr gender");
        mrRadioButton.click();
        return this;
    }

    @Step("User selects Mrs as gender")
    public SignUpPage withMrsGender() {
        log.info("Select Mrs gender");
        mrsRadioButton.click();
        return this;
    }

    @Step("User sets first name to first name input field")
    public SignUpPage withFirstName(String firstName) {
        log.info("Set first name {}", firstName);
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("User sets last name to last name input field")
    public SignUpPage withLastName(String lastName) {
        log.info("Set last name {}", lastName);
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("User sets email address to email input field")
    public SignUpPage withEmail(String email) {
        log.info("Set email {}", email);
        emailInput.sendKeys(email);
        return this;
    }

    @Step("User sets password to password input field")
    public SignUpPage withPassword(String password) {
        log.info("Set password {}", password);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("User clicks on Save button")
    public MainPage save() {
        log.info("Submit sign up form");
        saveButton.click();
        return pageFactory.create(MainPage.class);
    }

    @Step("User checks if alert message is displayed")
    public boolean isAlertMessageDisplayed() {
        log.info("Check if alert message displayed");
        return webDriverWait.until(webDriver -> alertMessage.isDisplayed());
    }
}
