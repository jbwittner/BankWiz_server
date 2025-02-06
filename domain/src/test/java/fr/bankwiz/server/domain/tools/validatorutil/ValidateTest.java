package fr.bankwiz.server.domain.tools.validatorutil;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.bankwiz.server.domain.exception.ValidationException;
import fr.bankwiz.server.domain.tools.ValidatorUtil;
import jakarta.validation.constraints.*;
import lombok.Setter;

@DisplayName("ValidatorUtil Test Base")
class ValidateTest {

    @Test
    @DisplayName("Should validate a valid record")
    void shouldValidateValidRecord() {
        final ValidateTestData data = new ValidateTestData();
        ValidatorUtil.validate(data);
    }

    @Test
    @DisplayName("Should throw an exception when a NotBlank field is blank")
    void shouldThrowExceptionWhenNotBlankFieldIsBlank() {
        final ValidateTestData data = new ValidateTestData();
        data.setNotBlankStringInput("");

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("must not be blank");
    }

    @Test
    @DisplayName("Should throw an exception when a NotBlank field is null")
    void shouldThrowExceptionWhenNotBlankFieldIsNull() {
        final ValidateTestData data = new ValidateTestData();
        data.setNotBlankStringInput(null);

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("must not be blank");
    }

    @Test
    @DisplayName("Should not throw an exception when a NotNull field is blank")
    void shouldNotThrowExceptionWhenNotnullFieldIsBlank() {
        final ValidateTestData data = new ValidateTestData();
        data.setNotNullStringInput("");
        ValidatorUtil.validate(data);
    }

    @Test
    @DisplayName("Should throw an exception when a NotNull field is null")
    void shouldThrowExceptionWhenNotNullFieldIsNull() {
        final ValidateTestData data = new ValidateTestData();
        data.setNotNullStringInput(null);

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("must not be null");
    }

    @Test
    @DisplayName("Should throw an exception when a Max field is greater than the max value")
    void shouldThrowExceptionWhenMaxFieldIsGreaterThanMaxValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setMaxIntegerInput(11);

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("must be less than or equal to 10");
    }

    @Test
    @DisplayName("Should not throw an exception when a Max field is equal than the max value")
    void shouldNotThrowExceptionWhenMaxFieldIsEqualToMaxValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setMaxIntegerInput(10);
        ValidatorUtil.validate(data);
    }

    @Test
    @DisplayName("Should not throw an exception when a Min field is equal to the min value")
    void shouldNotThrowExceptionWhenMinFieldIsEqualToMinValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setMinIntegerInput(1);
        ValidatorUtil.validate(data);
    }

    @Test
    @DisplayName("Should throw an exception when a Min field is less than the min value")
    void shouldThrowExceptionWhenMinFieldIsLessThanMinValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setMinIntegerInput(0);

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("must be greater than or equal to 1");
    }

    @Test
    @DisplayName("Should throw an exception when a MinMax field is less than the min value")
    void shouldThrowExceptionWhenMinMaxFieldIsLessThanMinValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setMinMaxIntegerInput(0);

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("must be greater than or equal to 1");
    }

    @Test
    @DisplayName("Should throw an exception when a MinMax field is greater than the max value")
    void shouldThrowExceptionWhenMinMaxFieldIsGreaterThanMaxValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setMinMaxIntegerInput(11);

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("must be less than or equal to 10");
    }

    @Test
    @DisplayName("Should throw an exception when a Size field is less than the min value")
    void shouldThrowExceptionWhenSizeFieldIsLessThanMinValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setSizeStringInput("a");

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("size must be between 2 and 10");
    }

    @Test
    @DisplayName("Should throw an exception when a Size field is greater than the max value")
    void shouldThrowExceptionWhenSizeFieldIsGreaterThanMaxValue() {
        final ValidateTestData data = new ValidateTestData();
        data.setSizeStringInput("inputinputinput");

        Assertions.assertThatThrownBy(() -> ValidatorUtil.validate(data))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining("size must be between 2 and 10");
    }

    @Setter
    private class ValidateTestData {

        @NotBlank private String notBlankStringInput = "notBlankStringInput";

        @NotNull private String notNullStringInput = "notNullStringInput";

        @Max(10) private Integer maxIntegerInput = 5;

        @Min(1) private Integer minIntegerInput = 5;

        @Min(1) @Max(10) private Integer minMaxIntegerInput = 5;

        @Size(min = 2, max = 10) private String sizeStringInput = "input";
    }
}
