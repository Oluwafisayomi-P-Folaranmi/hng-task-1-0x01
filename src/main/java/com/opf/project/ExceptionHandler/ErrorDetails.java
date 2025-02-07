package com.opf.project.ExceptionHandler;

/**
 * This is the custom error class
 */
public class ErrorDetails {

    /*
     * Member fields
     */
    private String number;

    private boolean error;

    /*
     * Member constructors
     */
    public ErrorDetails() {
    }

    public ErrorDetails(String number, boolean error) {
        this.number = number;
        this.error = error;
    }

    /*
     * Getters and setters
     */

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
