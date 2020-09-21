package com.agility.focis.globalVariables;

import java.util.List;
import java.util.Map;

public class GlobalVariables {
    private static String jobNumber;
    private static String jobStatus;
    private static String product;
    private static String productType;
    private static String jobScope;
    private static String incoterm;
    private static String OriginSTKName;
    private static String DestinationSTKName;
    private static String incoTermLocation;
    private static List<Map<String, String>> packagesInfo;
    private static List<Map<String, String>> unitsInfo;
    private static Map<String, Map<String, String>> parties;
    private static Map<String, String> jobReferences;
    private static Map<String, String> mblInformation;
    private static List<Map<String, String>> locationDetails;
    private static String cbrXMLData;
    private static String OriginOrgComponent;
    private static String DestinationOrgComponent;
    private static String SupplierName;
    private static String invoiceType;
    private static String entityName;
    private static List<Map<String, String>> charges;
    private static String supplierAddress;
    private static String entityCode;
    private static String invoiceSubType;
    private static String SuppierinvoiceNum;
    private static Map<String, String> randomChargeDetails;
    private static String writeOffAmount;

    public static String getWriteOffAmount() {
        return writeOffAmount;
    }

    public static void setWriteOffAmount(String writeOffAmount) {
        GlobalVariables.writeOffAmount = writeOffAmount;
    }

    public static Map<String, String> getRandomChargeDetails() {
        return randomChargeDetails;
    }

    public static void setRandomChargeDetails(Map<String, String> randomChargeDetails) {
        GlobalVariables.randomChargeDetails = randomChargeDetails;
    }

    public static String getOriginSTKName() {
        return OriginSTKName;
    }

    public static void setOriginSTKName(String originSTKName) {
        OriginSTKName = originSTKName;
    }

    public static String getDestinationSTKName() {
        return DestinationSTKName;
    }

    public static void setDestinationSTKName(String destinationSTKName) {
        DestinationSTKName = destinationSTKName;
    }


    public static String getSupplierName() {
        return SupplierName;
    }

    public static void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }


    public static List<Map<String, String>> getCharges() {
        return charges;
    }

    public static void setCharges(List<Map<String, String>> charges) {
        GlobalVariables.charges = charges;
    }

    public static String getSupplierAddress() {
        return supplierAddress;
    }

    public static void setSupplierAddress(String supplierAddress) {
        GlobalVariables.supplierAddress = supplierAddress;
    }


    public static String getEntityCode() {
        return entityCode;
    }

    public static void setEntityCode(String entityCode) {
        GlobalVariables.entityCode = entityCode;
    }


    public static String getInvoiceSubType() {
        return invoiceSubType;
    }

    public static void setInvoiceSubType(String invoiceSubType) {
        GlobalVariables.invoiceSubType = invoiceSubType;
    }


    public static String getSuppierinvoiceNum() {
        return SuppierinvoiceNum;
    }

    public static void setSuppierinvoiceNum(String suppierinvoiceNum) {
        SuppierinvoiceNum = suppierinvoiceNum;
    }


    public static String getDestinationOrgComponent() {
        return DestinationOrgComponent;
    }

    public static void setDestinationOrgComponent(String networkComponent, String department) {
        DestinationOrgComponent = networkComponent + " " + department;
    }

    public static String getOriginOrgComponent() {
        return OriginOrgComponent;
    }

    public static void setOriginOrgComponent(String networkComponent, String department) {
        OriginOrgComponent = networkComponent + " " + department;
    }

    public static String getJobNumber() {
        return jobNumber;
    }

    public static void setJobNumber(String jobNumber) {
        GlobalVariables.jobNumber = jobNumber;
    }

    public static String getJobStatus() {
        return jobStatus;
    }

    public static void setJobStatus(String jobStatus) {
        GlobalVariables.jobStatus = jobStatus;
    }

    public static String getProduct() {
        return product;
    }

    public static void setProduct(String product) {
        GlobalVariables.product = product;
    }

    public static String getProductType() {
        return productType;
    }

    public static void setProductType(String productType) {
        GlobalVariables.productType = productType;
    }

    public static String getIncoterm() {
        return incoterm;
    }

    public static void setIncoterm(String incoterm) {
        GlobalVariables.incoterm = incoterm;
    }

    public static String getIncoTermLocation() {
        return incoTermLocation;
    }

    public static void setIncoTermLocation(String incoTermLocation) {
        GlobalVariables.incoTermLocation = incoTermLocation;
    }

    public static Map<String, String> getJobReferences() {
        return jobReferences;
    }

    public static void setJobReferences(Map<String, String> jobReferences) {
        GlobalVariables.jobReferences = jobReferences;
    }

    public static Map<String, String> getMblInformation() {
        return mblInformation;
    }

    public static void setMblInformation(Map<String, String> mblInformation) {
        GlobalVariables.mblInformation = mblInformation;
    }

    public static List<Map<String, String>> getLocationDetails() {
        return locationDetails;
    }

    public static void setLocationDetails(List<Map<String, String>> locationDetails) {
        GlobalVariables.locationDetails = locationDetails;
    }

    public static String getJobScope() {
        return jobScope;
    }

    public static void setJobScope(String jobScope) {
        GlobalVariables.jobScope = jobScope;
    }

    public static List<Map<String, String>> getPackagesInfo() {
        return packagesInfo;
    }

    public static void setPackagesInfo(List<Map<String, String>> packagesInfo) {
        GlobalVariables.packagesInfo = packagesInfo;
    }

    public static List<Map<String, String>> getUnitsInfo() {
        return unitsInfo;
    }

    public static void setUnitsInfo(List<Map<String, String>> unitsInfo) {
        GlobalVariables.unitsInfo = unitsInfo;
    }

    public static String getCbrXMLData() {
        return cbrXMLData;
    }

    public static void setCbrXMLData(String cbrXMLData) {
        GlobalVariables.cbrXMLData = cbrXMLData;
    }

    public static Map<String, Map<String, String>> getParties() {
        return parties;
    }

    public static void setParties(Map<String, Map<String, String>> parties) {
        GlobalVariables.parties = parties;
    }

    public static void setInvoiceType(String invoiceType) {
        GlobalVariables.invoiceType = invoiceType;
    }

    public static String getInvoiceType() {
        return invoiceType;
    }

    public static String getEntityName() {
        return entityName;
    }

    public static void setEntityName(String entityName) {
        GlobalVariables.entityName = entityName;
    }
}
