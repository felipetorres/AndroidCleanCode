package br.com.app.androidcleancode.scenes.login;

import java.util.regex.Pattern;

/**
 * This should be an external dependency.
 */

final class Patterns {

    static final Pattern CPF = Pattern.compile("^\\d{2,3}\\.?\\d{3}\\.?\\d{3}-\\d{2}$");
    static final Pattern EMAIL = Pattern.compile("[a-zA-Z0-9+._\\%-+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9-]{0,64}(.[a-zA-Z0-9][a-zA-Z0-9-]{0,25})+");
    static final Pattern PASSWORD = Pattern.compile("^(?=.*[a-zA-Z0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{3,}$");
}
