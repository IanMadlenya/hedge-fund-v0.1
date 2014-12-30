package com.sforce.soap.enterprise.sobject;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class SamlSsoConfig extends com.sforce.soap.enterprise.sobject.SObject {

    /**
     * Constructor
     */
    public SamlSsoConfig() {}

    /**
     * element : AttributeFormat of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo AttributeFormat__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","AttributeFormat","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean AttributeFormat__is_set = false;

    private java.lang.String AttributeFormat;

    public java.lang.String getAttributeFormat() {
      return AttributeFormat;
    }

    public void setAttributeFormat(java.lang.String AttributeFormat) {
      this.AttributeFormat = AttributeFormat;
      AttributeFormat__is_set = true;
    }

    /**
     * element : AttributeName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo AttributeName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","AttributeName","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean AttributeName__is_set = false;

    private java.lang.String AttributeName;

    public java.lang.String getAttributeName() {
      return AttributeName;
    }

    public void setAttributeName(java.lang.String AttributeName) {
      this.AttributeName = AttributeName;
      AttributeName__is_set = true;
    }

    /**
     * element : Audience of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Audience__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Audience","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Audience__is_set = false;

    private java.lang.String Audience;

    public java.lang.String getAudience() {
      return Audience;
    }

    public void setAudience(java.lang.String Audience) {
      this.Audience = Audience;
      Audience__is_set = true;
    }

    /**
     * element : CreatedBy of type {urn:sobject.enterprise.soap.sforce.com}User
     * java type: com.sforce.soap.enterprise.sobject.User
     */
    private static final com.sforce.ws.bind.TypeInfo CreatedBy__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CreatedBy","urn:sobject.enterprise.soap.sforce.com","User",0,1,true);

    private boolean CreatedBy__is_set = false;

    private com.sforce.soap.enterprise.sobject.User CreatedBy;

    public com.sforce.soap.enterprise.sobject.User getCreatedBy() {
      return CreatedBy;
    }

    public void setCreatedBy(com.sforce.soap.enterprise.sobject.User CreatedBy) {
      this.CreatedBy = CreatedBy;
      CreatedBy__is_set = true;
    }

    /**
     * element : CreatedById of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo CreatedById__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CreatedById","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean CreatedById__is_set = false;

    private java.lang.String CreatedById;

    public java.lang.String getCreatedById() {
      return CreatedById;
    }

    public void setCreatedById(java.lang.String CreatedById) {
      this.CreatedById = CreatedById;
      CreatedById__is_set = true;
    }

    /**
     * element : CreatedDate of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo CreatedDate__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CreatedDate","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean CreatedDate__is_set = false;

    private java.util.Calendar CreatedDate;

    public java.util.Calendar getCreatedDate() {
      return CreatedDate;
    }

    public void setCreatedDate(java.util.Calendar CreatedDate) {
      this.CreatedDate = CreatedDate;
      CreatedDate__is_set = true;
    }

    /**
     * element : DeveloperName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo DeveloperName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","DeveloperName","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean DeveloperName__is_set = false;

    private java.lang.String DeveloperName;

    public java.lang.String getDeveloperName() {
      return DeveloperName;
    }

    public void setDeveloperName(java.lang.String DeveloperName) {
      this.DeveloperName = DeveloperName;
      DeveloperName__is_set = true;
    }

    /**
     * element : ErrorUrl of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ErrorUrl__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ErrorUrl","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean ErrorUrl__is_set = false;

    private java.lang.String ErrorUrl;

    public java.lang.String getErrorUrl() {
      return ErrorUrl;
    }

    public void setErrorUrl(java.lang.String ErrorUrl) {
      this.ErrorUrl = ErrorUrl;
      ErrorUrl__is_set = true;
    }

    /**
     * element : IdentityLocation of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo IdentityLocation__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","IdentityLocation","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean IdentityLocation__is_set = false;

    private java.lang.String IdentityLocation;

    public java.lang.String getIdentityLocation() {
      return IdentityLocation;
    }

    public void setIdentityLocation(java.lang.String IdentityLocation) {
      this.IdentityLocation = IdentityLocation;
      IdentityLocation__is_set = true;
    }

    /**
     * element : IdentityMapping of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo IdentityMapping__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","IdentityMapping","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean IdentityMapping__is_set = false;

    private java.lang.String IdentityMapping;

    public java.lang.String getIdentityMapping() {
      return IdentityMapping;
    }

    public void setIdentityMapping(java.lang.String IdentityMapping) {
      this.IdentityMapping = IdentityMapping;
      IdentityMapping__is_set = true;
    }

    /**
     * element : IsDeleted of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: java.lang.Boolean
     */
    private static final com.sforce.ws.bind.TypeInfo IsDeleted__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","IsDeleted","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean IsDeleted__is_set = false;

    private java.lang.Boolean IsDeleted;

    public java.lang.Boolean getIsDeleted() {
      return IsDeleted;
    }

    public void setIsDeleted(java.lang.Boolean IsDeleted) {
      this.IsDeleted = IsDeleted;
      IsDeleted__is_set = true;
    }

    /**
     * element : Issuer of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Issuer__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Issuer","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Issuer__is_set = false;

    private java.lang.String Issuer;

    public java.lang.String getIssuer() {
      return Issuer;
    }

    public void setIssuer(java.lang.String Issuer) {
      this.Issuer = Issuer;
      Issuer__is_set = true;
    }

    /**
     * element : Language of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Language__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Language","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Language__is_set = false;

    private java.lang.String Language;

    public java.lang.String getLanguage() {
      return Language;
    }

    public void setLanguage(java.lang.String Language) {
      this.Language = Language;
      Language__is_set = true;
    }

    /**
     * element : LastModifiedBy of type {urn:sobject.enterprise.soap.sforce.com}User
     * java type: com.sforce.soap.enterprise.sobject.User
     */
    private static final com.sforce.ws.bind.TypeInfo LastModifiedBy__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastModifiedBy","urn:sobject.enterprise.soap.sforce.com","User",0,1,true);

    private boolean LastModifiedBy__is_set = false;

    private com.sforce.soap.enterprise.sobject.User LastModifiedBy;

    public com.sforce.soap.enterprise.sobject.User getLastModifiedBy() {
      return LastModifiedBy;
    }

    public void setLastModifiedBy(com.sforce.soap.enterprise.sobject.User LastModifiedBy) {
      this.LastModifiedBy = LastModifiedBy;
      LastModifiedBy__is_set = true;
    }

    /**
     * element : LastModifiedById of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo LastModifiedById__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastModifiedById","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean LastModifiedById__is_set = false;

    private java.lang.String LastModifiedById;

    public java.lang.String getLastModifiedById() {
      return LastModifiedById;
    }

    public void setLastModifiedById(java.lang.String LastModifiedById) {
      this.LastModifiedById = LastModifiedById;
      LastModifiedById__is_set = true;
    }

    /**
     * element : LastModifiedDate of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo LastModifiedDate__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastModifiedDate","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean LastModifiedDate__is_set = false;

    private java.util.Calendar LastModifiedDate;

    public java.util.Calendar getLastModifiedDate() {
      return LastModifiedDate;
    }

    public void setLastModifiedDate(java.util.Calendar LastModifiedDate) {
      this.LastModifiedDate = LastModifiedDate;
      LastModifiedDate__is_set = true;
    }

    /**
     * element : LoginUrl of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo LoginUrl__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LoginUrl","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean LoginUrl__is_set = false;

    private java.lang.String LoginUrl;

    public java.lang.String getLoginUrl() {
      return LoginUrl;
    }

    public void setLoginUrl(java.lang.String LoginUrl) {
      this.LoginUrl = LoginUrl;
      LoginUrl__is_set = true;
    }

    /**
     * element : LogoutUrl of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo LogoutUrl__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LogoutUrl","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean LogoutUrl__is_set = false;

    private java.lang.String LogoutUrl;

    public java.lang.String getLogoutUrl() {
      return LogoutUrl;
    }

    public void setLogoutUrl(java.lang.String LogoutUrl) {
      this.LogoutUrl = LogoutUrl;
      LogoutUrl__is_set = true;
    }

    /**
     * element : MasterLabel of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo MasterLabel__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","MasterLabel","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean MasterLabel__is_set = false;

    private java.lang.String MasterLabel;

    public java.lang.String getMasterLabel() {
      return MasterLabel;
    }

    public void setMasterLabel(java.lang.String MasterLabel) {
      this.MasterLabel = MasterLabel;
      MasterLabel__is_set = true;
    }

    /**
     * element : NamespacePrefix of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo NamespacePrefix__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","NamespacePrefix","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean NamespacePrefix__is_set = false;

    private java.lang.String NamespacePrefix;

    public java.lang.String getNamespacePrefix() {
      return NamespacePrefix;
    }

    public void setNamespacePrefix(java.lang.String NamespacePrefix) {
      this.NamespacePrefix = NamespacePrefix;
      NamespacePrefix__is_set = true;
    }

    /**
     * element : OptionsSpInitBinding of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: java.lang.Boolean
     */
    private static final com.sforce.ws.bind.TypeInfo OptionsSpInitBinding__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","OptionsSpInitBinding","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean OptionsSpInitBinding__is_set = false;

    private java.lang.Boolean OptionsSpInitBinding;

    public java.lang.Boolean getOptionsSpInitBinding() {
      return OptionsSpInitBinding;
    }

    public void setOptionsSpInitBinding(java.lang.Boolean OptionsSpInitBinding) {
      this.OptionsSpInitBinding = OptionsSpInitBinding;
      OptionsSpInitBinding__is_set = true;
    }

    /**
     * element : OptionsUserProvisioning of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: java.lang.Boolean
     */
    private static final com.sforce.ws.bind.TypeInfo OptionsUserProvisioning__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","OptionsUserProvisioning","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean OptionsUserProvisioning__is_set = false;

    private java.lang.Boolean OptionsUserProvisioning;

    public java.lang.Boolean getOptionsUserProvisioning() {
      return OptionsUserProvisioning;
    }

    public void setOptionsUserProvisioning(java.lang.Boolean OptionsUserProvisioning) {
      this.OptionsUserProvisioning = OptionsUserProvisioning;
      OptionsUserProvisioning__is_set = true;
    }

    /**
     * element : SystemModstamp of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo SystemModstamp__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","SystemModstamp","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean SystemModstamp__is_set = false;

    private java.util.Calendar SystemModstamp;

    public java.util.Calendar getSystemModstamp() {
      return SystemModstamp;
    }

    public void setSystemModstamp(java.util.Calendar SystemModstamp) {
      this.SystemModstamp = SystemModstamp;
      SystemModstamp__is_set = true;
    }

    /**
     * element : ValidationCert of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ValidationCert__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ValidationCert","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean ValidationCert__is_set = false;

    private java.lang.String ValidationCert;

    public java.lang.String getValidationCert() {
      return ValidationCert;
    }

    public void setValidationCert(java.lang.String ValidationCert) {
      this.ValidationCert = ValidationCert;
      ValidationCert__is_set = true;
    }

    /**
     * element : Version of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Version__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Version","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Version__is_set = false;

    private java.lang.String Version;

    public java.lang.String getVersion() {
      return Version;
    }

    public void setVersion(java.lang.String Version) {
      this.Version = Version;
      Version__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:sobject.enterprise.soap.sforce.com", "SamlSsoConfig");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeString(__out, AttributeFormat__typeInfo, AttributeFormat, AttributeFormat__is_set);
       __typeMapper.writeString(__out, AttributeName__typeInfo, AttributeName, AttributeName__is_set);
       __typeMapper.writeString(__out, Audience__typeInfo, Audience, Audience__is_set);
       __typeMapper.writeObject(__out, CreatedBy__typeInfo, CreatedBy, CreatedBy__is_set);
       __typeMapper.writeString(__out, CreatedById__typeInfo, CreatedById, CreatedById__is_set);
       __typeMapper.writeObject(__out, CreatedDate__typeInfo, CreatedDate, CreatedDate__is_set);
       __typeMapper.writeString(__out, DeveloperName__typeInfo, DeveloperName, DeveloperName__is_set);
       __typeMapper.writeString(__out, ErrorUrl__typeInfo, ErrorUrl, ErrorUrl__is_set);
       __typeMapper.writeString(__out, IdentityLocation__typeInfo, IdentityLocation, IdentityLocation__is_set);
       __typeMapper.writeString(__out, IdentityMapping__typeInfo, IdentityMapping, IdentityMapping__is_set);
       __typeMapper.writeObject(__out, IsDeleted__typeInfo, IsDeleted, IsDeleted__is_set);
       __typeMapper.writeString(__out, Issuer__typeInfo, Issuer, Issuer__is_set);
       __typeMapper.writeString(__out, Language__typeInfo, Language, Language__is_set);
       __typeMapper.writeObject(__out, LastModifiedBy__typeInfo, LastModifiedBy, LastModifiedBy__is_set);
       __typeMapper.writeString(__out, LastModifiedById__typeInfo, LastModifiedById, LastModifiedById__is_set);
       __typeMapper.writeObject(__out, LastModifiedDate__typeInfo, LastModifiedDate, LastModifiedDate__is_set);
       __typeMapper.writeString(__out, LoginUrl__typeInfo, LoginUrl, LoginUrl__is_set);
       __typeMapper.writeString(__out, LogoutUrl__typeInfo, LogoutUrl, LogoutUrl__is_set);
       __typeMapper.writeString(__out, MasterLabel__typeInfo, MasterLabel, MasterLabel__is_set);
       __typeMapper.writeString(__out, NamespacePrefix__typeInfo, NamespacePrefix, NamespacePrefix__is_set);
       __typeMapper.writeObject(__out, OptionsSpInitBinding__typeInfo, OptionsSpInitBinding, OptionsSpInitBinding__is_set);
       __typeMapper.writeObject(__out, OptionsUserProvisioning__typeInfo, OptionsUserProvisioning, OptionsUserProvisioning__is_set);
       __typeMapper.writeObject(__out, SystemModstamp__typeInfo, SystemModstamp, SystemModstamp__is_set);
       __typeMapper.writeString(__out, ValidationCert__typeInfo, ValidationCert, ValidationCert__is_set);
       __typeMapper.writeString(__out, Version__typeInfo, Version, Version__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        super.loadFields(__in, __typeMapper);
        __in.peekTag();
        if (__typeMapper.isElement(__in, AttributeFormat__typeInfo)) {
            setAttributeFormat(__typeMapper.readString(__in, AttributeFormat__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, AttributeName__typeInfo)) {
            setAttributeName(__typeMapper.readString(__in, AttributeName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Audience__typeInfo)) {
            setAudience(__typeMapper.readString(__in, Audience__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CreatedBy__typeInfo)) {
            setCreatedBy((com.sforce.soap.enterprise.sobject.User)__typeMapper.readObject(__in, CreatedBy__typeInfo, com.sforce.soap.enterprise.sobject.User.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CreatedById__typeInfo)) {
            setCreatedById(__typeMapper.readString(__in, CreatedById__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CreatedDate__typeInfo)) {
            setCreatedDate((java.util.Calendar)__typeMapper.readObject(__in, CreatedDate__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, DeveloperName__typeInfo)) {
            setDeveloperName(__typeMapper.readString(__in, DeveloperName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ErrorUrl__typeInfo)) {
            setErrorUrl(__typeMapper.readString(__in, ErrorUrl__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, IdentityLocation__typeInfo)) {
            setIdentityLocation(__typeMapper.readString(__in, IdentityLocation__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, IdentityMapping__typeInfo)) {
            setIdentityMapping(__typeMapper.readString(__in, IdentityMapping__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, IsDeleted__typeInfo)) {
            setIsDeleted((java.lang.Boolean)__typeMapper.readObject(__in, IsDeleted__typeInfo, java.lang.Boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Issuer__typeInfo)) {
            setIssuer(__typeMapper.readString(__in, Issuer__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Language__typeInfo)) {
            setLanguage(__typeMapper.readString(__in, Language__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastModifiedBy__typeInfo)) {
            setLastModifiedBy((com.sforce.soap.enterprise.sobject.User)__typeMapper.readObject(__in, LastModifiedBy__typeInfo, com.sforce.soap.enterprise.sobject.User.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastModifiedById__typeInfo)) {
            setLastModifiedById(__typeMapper.readString(__in, LastModifiedById__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastModifiedDate__typeInfo)) {
            setLastModifiedDate((java.util.Calendar)__typeMapper.readObject(__in, LastModifiedDate__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LoginUrl__typeInfo)) {
            setLoginUrl(__typeMapper.readString(__in, LoginUrl__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LogoutUrl__typeInfo)) {
            setLogoutUrl(__typeMapper.readString(__in, LogoutUrl__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, MasterLabel__typeInfo)) {
            setMasterLabel(__typeMapper.readString(__in, MasterLabel__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, NamespacePrefix__typeInfo)) {
            setNamespacePrefix(__typeMapper.readString(__in, NamespacePrefix__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, OptionsSpInitBinding__typeInfo)) {
            setOptionsSpInitBinding((java.lang.Boolean)__typeMapper.readObject(__in, OptionsSpInitBinding__typeInfo, java.lang.Boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, OptionsUserProvisioning__typeInfo)) {
            setOptionsUserProvisioning((java.lang.Boolean)__typeMapper.readObject(__in, OptionsUserProvisioning__typeInfo, java.lang.Boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, SystemModstamp__typeInfo)) {
            setSystemModstamp((java.util.Calendar)__typeMapper.readObject(__in, SystemModstamp__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ValidationCert__typeInfo)) {
            setValidationCert(__typeMapper.readString(__in, ValidationCert__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Version__typeInfo)) {
            setVersion(__typeMapper.readString(__in, Version__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[SamlSsoConfig ");
      sb.append(super.toString());sb.append(" AttributeFormat='").append(com.sforce.ws.util.Verbose.toString(AttributeFormat)).append("'\n");
      sb.append(" AttributeName='").append(com.sforce.ws.util.Verbose.toString(AttributeName)).append("'\n");
      sb.append(" Audience='").append(com.sforce.ws.util.Verbose.toString(Audience)).append("'\n");
      sb.append(" CreatedBy='").append(com.sforce.ws.util.Verbose.toString(CreatedBy)).append("'\n");
      sb.append(" CreatedById='").append(com.sforce.ws.util.Verbose.toString(CreatedById)).append("'\n");
      sb.append(" CreatedDate='").append(com.sforce.ws.util.Verbose.toString(CreatedDate)).append("'\n");
      sb.append(" DeveloperName='").append(com.sforce.ws.util.Verbose.toString(DeveloperName)).append("'\n");
      sb.append(" ErrorUrl='").append(com.sforce.ws.util.Verbose.toString(ErrorUrl)).append("'\n");
      sb.append(" IdentityLocation='").append(com.sforce.ws.util.Verbose.toString(IdentityLocation)).append("'\n");
      sb.append(" IdentityMapping='").append(com.sforce.ws.util.Verbose.toString(IdentityMapping)).append("'\n");
      sb.append(" IsDeleted='").append(com.sforce.ws.util.Verbose.toString(IsDeleted)).append("'\n");
      sb.append(" Issuer='").append(com.sforce.ws.util.Verbose.toString(Issuer)).append("'\n");
      sb.append(" Language='").append(com.sforce.ws.util.Verbose.toString(Language)).append("'\n");
      sb.append(" LastModifiedBy='").append(com.sforce.ws.util.Verbose.toString(LastModifiedBy)).append("'\n");
      sb.append(" LastModifiedById='").append(com.sforce.ws.util.Verbose.toString(LastModifiedById)).append("'\n");
      sb.append(" LastModifiedDate='").append(com.sforce.ws.util.Verbose.toString(LastModifiedDate)).append("'\n");
      sb.append(" LoginUrl='").append(com.sforce.ws.util.Verbose.toString(LoginUrl)).append("'\n");
      sb.append(" LogoutUrl='").append(com.sforce.ws.util.Verbose.toString(LogoutUrl)).append("'\n");
      sb.append(" MasterLabel='").append(com.sforce.ws.util.Verbose.toString(MasterLabel)).append("'\n");
      sb.append(" NamespacePrefix='").append(com.sforce.ws.util.Verbose.toString(NamespacePrefix)).append("'\n");
      sb.append(" OptionsSpInitBinding='").append(com.sforce.ws.util.Verbose.toString(OptionsSpInitBinding)).append("'\n");
      sb.append(" OptionsUserProvisioning='").append(com.sforce.ws.util.Verbose.toString(OptionsUserProvisioning)).append("'\n");
      sb.append(" SystemModstamp='").append(com.sforce.ws.util.Verbose.toString(SystemModstamp)).append("'\n");
      sb.append(" ValidationCert='").append(com.sforce.ws.util.Verbose.toString(ValidationCert)).append("'\n");
      sb.append(" Version='").append(com.sforce.ws.util.Verbose.toString(Version)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}
