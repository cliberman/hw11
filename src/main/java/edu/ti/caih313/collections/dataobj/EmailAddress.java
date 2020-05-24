package edu.ti.caih313.collections.dataobj;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmailAddress {
    private EmailAddress email;

    public static enum EmailType {WORK, HOME, SCHOOL};
    HashMap<EmailType, String> personsEmailAddress = new HashMap<EmailType, String>();

    public String getPrimaryEmailAddress(EmailType emailType) {
        if (personsEmailAddress.containsKey(emailType.HOME)) {
            return emailType.HOME.toString();
        } else if (personsEmailAddress.containsKey(emailType.WORK)) {
            return emailType.WORK.toString();
        } else if (personsEmailAddress.containsKey(emailType.SCHOOL)) {
            return emailType.SCHOOL.toString();
        } else {
            return null;
        }
    }
}