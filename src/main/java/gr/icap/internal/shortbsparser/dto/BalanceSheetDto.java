package gr.icap.internal.shortbsparser.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BalanceSheetDto {

    private String fileName;

    private String corporateUse; //εταιρική χρήση

    private String from; //date

    private String to; //date

    private String assetsYear; //έτος ενεργητικού

    private String fixed; // πάγια

    private String depreciated; // αποσβεσμενα

    private String inventories; // αποθεματα

    private String requirements;

    private String advances; // προκαταβολές

    private String cashAvailable; // ταμειακά διαθέσιμα

    private String others; // λοιπά

    private String totalAssets; // συνολο ενεργητικου

    private String fundsAndReserves; // Κεφάλαια_και_αποθεματικά

    private String longTermLiabilities; // Μακροπρόθεσμες_υποχρεώσεις

    private String shortTermLiabilities; // Βραχυπρόθεσμες_υποχρεώσεις

    private String totalPaymentsAndLiabilities; // Σύνολο_καθαρής_θέσης_και_υποχρεώσεων

    private String resultsYear; // Έτος_αποτελεσμάτων

    private String operationsCircle; // Κύκλος_εργασιών

    private String otherNormalRevenue; // Λοιπά_συνήθη_έσοδα

    private String incomeFromPropertyUse; // Έσοδα_από_ιδιοχρησιμοποίηση_ακινήτων

    private String inventoryChanges; // Μεταβολές_αποθεμάτων

    private String markets; // Αγορές_εμπορευμάτων_και_αυλών

    private String benefitsOfWorkers; // Παροχές_σε_εργαζόμενους

    private String depreciation; // Αποσβέσεις

    private String otherCostsAndLosses; // Λοιπά_έξοδα_και_ζημιές

    private String otherRevenueAndProfits; // Λοιπά_έσοδα_και_κέρδη

    private String interestAndRelatedFunds; // Τοκοι Και Συναφη Κονδυλια

    private String resultsBeforeTaxes; // Αποτελεσματα Προ Φορων

    private String taxes;

    private String periodAfterResultsFullFrames; // Αποτελέσματα_περιόδου_μετά_από_φόρους



    private String assetsYear1;

    private String fixed1;

    private String depreciated1;

    private String inventories1;

    private String requirements1;

    private String advances1;

    private String cashAvailable1;

    private String others1;

    private String totalAssets1;

    private String fundsAndReserves1;

    private String longTermLiabilities1;

    private String shortTermLiabilities1;

    private String totalPaymentsAndLiabilities1;

    private String resultsYear1;

    private String operationsCircle1;

    private String otherNormalRevenue1;

    private String incomeFromPropertyUse1;

    private String inventoryChanges1;

    private String markets1;

    private String benefitsOfWorkers1;

    private String depreciation1;

    private String otherCostsAndLosses1;

    private String otherRevenueAndProfits1;

    private String interestAndRelatedFunds1;

    private String resultsBeforeTaxes1;

    private String taxes1;

    private String periodAfterResultsFullFrames1;
}