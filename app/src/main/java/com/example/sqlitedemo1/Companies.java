package com.example.sqlitedemo1;

public class Companies {
    int _CompanyRef;
    String _FormalName;
    String _CompanyTypeCode;
    String _MainAdress;
    String _MainPostcode;
    String _ReceptionNo;
    String _WebsiteURL;
    String _Customer;
    String _Supplier;
    String _Companynotes;

    public Companies(String _FormalName) {
        this._FormalName = _FormalName;
    }

    public Companies() {
    }
    public int get_CompanyRef() {
        return _CompanyRef;
    }

    public void set_CompanyRef(int _CompanyRef) {
        this._CompanyRef = _CompanyRef;
    }

    public String get_FormalName() {
        return _FormalName;
    }

    public void set_FormalName(String _FormalName) {
        this._FormalName = _FormalName;
    }

    public String get_CompanyTypeCode() {
        return _CompanyTypeCode;
    }

    public void set_CompanyTypeCode(String _CompanyTypeCode) {
        this._CompanyTypeCode = _CompanyTypeCode;
    }

    public String get_MainAdress() {
        return _MainAdress;
    }

    public void set_MainAdress(String _MainAdress) {
        this._MainAdress = _MainAdress;
    }

    public String get_MainPostcode() {
        return _MainPostcode;
    }

    public void set_MainPostcode(String _MainPostcode) {
        this._MainPostcode = _MainPostcode;
    }

    public String get_ReceptionNo() {
        return _ReceptionNo;
    }

    public void set_ReceptionNo(String _ReceptionNo) {
        this._ReceptionNo = _ReceptionNo;
    }

    public String get_WebsiteURL() {
        return _WebsiteURL;
    }

    public void set_WebsiteURL(String _WebsiteURL) {
        this._WebsiteURL = _WebsiteURL;
    }

    public String get_Customer() {
        return _Customer;
    }

    public void set_Customer(String _Customer) {
        this._Customer = _Customer;
    }

    public String get_Supplier() {
        return _Supplier;
    }

    public void set_Supplier(String _Supplier) {
        this._Supplier = _Supplier;
    }

    public String get_Companynotes() {
        return _Companynotes;
    }

    public void set_Companynotes(String _Companynotes) {
        this._Companynotes = _Companynotes;
    }



    public Companies(int _CompanyRef, String _FormalName, String _CompanyTypeCode, String _MainAdress, String _MainPostcode, String _ReceptionNo, String _WebsiteURL, String _Customer, String _Supplier, String _Companynotes) {
        this._CompanyRef = _CompanyRef;
        this._FormalName = _FormalName;
        this._CompanyTypeCode = _CompanyTypeCode;
        this._MainAdress = _MainAdress;
        this._MainPostcode = _MainPostcode;
        this._ReceptionNo = _ReceptionNo;
        this._WebsiteURL = _WebsiteURL;
        this._Customer = _Customer;
        this._Supplier = _Supplier;
        this._Companynotes = _Companynotes;
    }
}
