package guru.sfgpay.payor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by jt on 2018-12-07.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payor {
    /**
     * The payor id (UUID).
     */
    @NotNull(message="The Payor Id is mandatory")
    private String payorId;

    /**
     * The name of the payor.
     */
    @NotNull(message="The Payor Name is mandatory")
    private String payorName;

    /**
     * The address of the payor.
     */
    @NotNull(message="The Address is mandatory")
    private Address address;

    /**
     * Name of primary contact for the payor.
     */
    @NotNull(message="The Primary Contact Name is mandatory")
    private String primaryContactName;

    /**
     * Primary contact phone number for the payor.
     */
    @NotNull(message="The Primary Contact Phone is mandatory")
    private String primaryContactPhone;

    /**
     * Primary contact email for the payor.
     */
    @NotNull(message="The Primary Contact Email is mandatory")
    private String primaryContactEmail;

    /**
     * The funding account routing number to be used for the payor.
     */
    private String fundingAccountRoutingNumber;

    /**
     * The funding account number to be used for the payor.
     */
    private String fundingAccountAccountNumber;

    /**
     * The funding account name to be used for the payor.
     */
    private String fundingAccountAccountName;

    /**
     * The kyc state of the payor.
     */
    private KycState kycState;

    /**
     * Whether or not the payor has been manually locked by the backoffice.
     */
    private Boolean manualLockout;

    /**
     * Whether grace period processing is enabled.
     */
    private Boolean payeeGracePeriodProcessingEnabled;

    /**
     * The grace period for paying payees in days.
     */
    private Integer payeeGracePeriodDays;

    /**
     * How the payor has chosen to refer to payees
     */
    private String collectiveAlias;

    /**
     * The payor's support contact address
     */
    private String supportContact;

    /**
     * The payor's 'Doing Business As' name
     */
    private String dbaName;

    /**
     * Whether or not the payor allows language choice in the UI
     */
    private Boolean allowsLanguageChoice;

    /**
     * Whether or not the payor has opted-out of reminder emails being sent
     */
    private Boolean reminderEmailsOptOut;

    /**
     * The payor's language preference
     */
    @NotNull(message = "The Preferred Language is mandatory")
    private Language language = Language.EN;

    // flag to indicate whether a payor should see reports
    private Boolean includesReports;
}
