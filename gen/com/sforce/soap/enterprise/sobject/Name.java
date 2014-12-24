package com.sforce.soap.enterprise.sobject;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class Name extends com.sforce.soap.enterprise.sobject.SObject {

    /**
     * Constructor
     */
    public Name() {}

    /**
     * element : Alias of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Alias__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Alias","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Alias__is_set = false;

    private java.lang.String Alias;

    public java.lang.String getAlias() {
      return Alias;
    }

    public void setAlias(java.lang.String Alias) {
      this.Alias = Alias;
      Alias__is_set = true;
    }

    /**
     * element : Email of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Email__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Email","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Email__is_set = false;

    private java.lang.String Email;

    public java.lang.String getEmail() {
      return Email;
    }

    public void setEmail(java.lang.String Email) {
      this.Email = Email;
      Email__is_set = true;
    }

    /**
     * element : FirstName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo FirstName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","FirstName","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean FirstName__is_set = false;

    private java.lang.String FirstName;

    public java.lang.String getFirstName() {
      return FirstName;
    }

    public void setFirstName(java.lang.String FirstName) {
      this.FirstName = FirstName;
      FirstName__is_set = true;
    }

    /**
     * element : IsActive of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: java.lang.Boolean
     */
    private static final com.sforce.ws.bind.TypeInfo IsActive__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","IsActive","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean IsActive__is_set = false;

    private java.lang.Boolean IsActive;

    public java.lang.Boolean getIsActive() {
      return IsActive;
    }

    public void setIsActive(java.lang.Boolean IsActive) {
      this.IsActive = IsActive;
      IsActive__is_set = true;
    }

    /**
     * element : LastName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo LastName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastName","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean LastName__is_set = false;

    private java.lang.String LastName;

    public java.lang.String getLastName() {
      return LastName;
    }

    public void setLastName(java.lang.String LastName) {
      this.LastName = LastName;
      LastName__is_set = true;
    }

    /**
     * element : LastReferencedDate of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo LastReferencedDate__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastReferencedDate","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean LastReferencedDate__is_set = false;

    private java.util.Calendar LastReferencedDate;

    public java.util.Calendar getLastReferencedDate() {
      return LastReferencedDate;
    }

    public void setLastReferencedDate(java.util.Calendar LastReferencedDate) {
      this.LastReferencedDate = LastReferencedDate;
      LastReferencedDate__is_set = true;
    }

    /**
     * element : LastViewedDate of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo LastViewedDate__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastViewedDate","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean LastViewedDate__is_set = false;

    private java.util.Calendar LastViewedDate;

    public java.util.Calendar getLastViewedDate() {
      return LastViewedDate;
    }

    public void setLastViewedDate(java.util.Calendar LastViewedDate) {
      this.LastViewedDate = LastViewedDate;
      LastViewedDate__is_set = true;
    }

    /**
     * element : Name of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Name__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Name","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Name__is_set = false;

    private java.lang.String Name;

    public java.lang.String getName() {
      return Name;
    }

    public void setName(java.lang.String Name) {
      this.Name = Name;
      Name__is_set = true;
    }

    /**
     * element : Phone of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Phone__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Phone","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Phone__is_set = false;

    private java.lang.String Phone;

    public java.lang.String getPhone() {
      return Phone;
    }

    public void setPhone(java.lang.String Phone) {
      this.Phone = Phone;
      Phone__is_set = true;
    }

    /**
     * element : Profile of type {urn:sobject.enterprise.soap.sforce.com}Profile
     * java type: com.sforce.soap.enterprise.sobject.Profile
     */
    private static final com.sforce.ws.bind.TypeInfo Profile__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Profile","urn:sobject.enterprise.soap.sforce.com","Profile",0,1,true);

    private boolean Profile__is_set = false;

    private com.sforce.soap.enterprise.sobject.Profile Profile;

    public com.sforce.soap.enterprise.sobject.Profile getProfile() {
      return Profile;
    }

    public void setProfile(com.sforce.soap.enterprise.sobject.Profile Profile) {
      this.Profile = Profile;
      Profile__is_set = true;
    }

    /**
     * element : ProfileId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ProfileId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ProfileId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean ProfileId__is_set = false;

    private java.lang.String ProfileId;

    public java.lang.String getProfileId() {
      return ProfileId;
    }

    public void setProfileId(java.lang.String ProfileId) {
      this.ProfileId = ProfileId;
      ProfileId__is_set = true;
    }

    /**
     * element : RecordType of type {urn:sobject.enterprise.soap.sforce.com}RecordType
     * java type: com.sforce.soap.enterprise.sobject.RecordType
     */
    private static final com.sforce.ws.bind.TypeInfo RecordType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","RecordType","urn:sobject.enterprise.soap.sforce.com","RecordType",0,1,true);

    private boolean RecordType__is_set = false;

    private com.sforce.soap.enterprise.sobject.RecordType RecordType;

    public com.sforce.soap.enterprise.sobject.RecordType getRecordType() {
      return RecordType;
    }

    public void setRecordType(com.sforce.soap.enterprise.sobject.RecordType RecordType) {
      this.RecordType = RecordType;
      RecordType__is_set = true;
    }

    /**
     * element : RecordTypeId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo RecordTypeId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","RecordTypeId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean RecordTypeId__is_set = false;

    private java.lang.String RecordTypeId;

    public java.lang.String getRecordTypeId() {
      return RecordTypeId;
    }

    public void setRecordTypeId(java.lang.String RecordTypeId) {
      this.RecordTypeId = RecordTypeId;
      RecordTypeId__is_set = true;
    }

    /**
     * element : Title of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Title__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Title","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Title__is_set = false;

    private java.lang.String Title;

    public java.lang.String getTitle() {
      return Title;
    }

    public void setTitle(java.lang.String Title) {
      this.Title = Title;
      Title__is_set = true;
    }

    /**
     * element : Type of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Type__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Type","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Type__is_set = false;

    private java.lang.String Type;

    public java.lang.String getType() {
      return Type;
    }

    public void setType(java.lang.String Type) {
      this.Type = Type;
      Type__is_set = true;
    }

    /**
     * element : UserRole of type {urn:sobject.enterprise.soap.sforce.com}UserRole
     * java type: com.sforce.soap.enterprise.sobject.UserRole
     */
    private static final com.sforce.ws.bind.TypeInfo UserRole__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","UserRole","urn:sobject.enterprise.soap.sforce.com","UserRole",0,1,true);

    private boolean UserRole__is_set = false;

    private com.sforce.soap.enterprise.sobject.UserRole UserRole;

    public com.sforce.soap.enterprise.sobject.UserRole getUserRole() {
      return UserRole;
    }

    public void setUserRole(com.sforce.soap.enterprise.sobject.UserRole UserRole) {
      this.UserRole = UserRole;
      UserRole__is_set = true;
    }

    /**
     * element : UserRoleId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo UserRoleId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","UserRoleId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean UserRoleId__is_set = false;

    private java.lang.String UserRoleId;

    public java.lang.String getUserRoleId() {
      return UserRoleId;
    }

    public void setUserRoleId(java.lang.String UserRoleId) {
      this.UserRoleId = UserRoleId;
      UserRoleId__is_set = true;
    }

    /**
     * element : Username of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Username__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Username","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Username__is_set = false;

    private java.lang.String Username;

    public java.lang.String getUsername() {
      return Username;
    }

    public void setUsername(java.lang.String Username) {
      this.Username = Username;
      Username__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:sobject.enterprise.soap.sforce.com", "Name");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeString(__out, Alias__typeInfo, Alias, Alias__is_set);
       __typeMapper.writeString(__out, Email__typeInfo, Email, Email__is_set);
       __typeMapper.writeString(__out, FirstName__typeInfo, FirstName, FirstName__is_set);
       __typeMapper.writeObject(__out, IsActive__typeInfo, IsActive, IsActive__is_set);
       __typeMapper.writeString(__out, LastName__typeInfo, LastName, LastName__is_set);
       __typeMapper.writeObject(__out, LastReferencedDate__typeInfo, LastReferencedDate, LastReferencedDate__is_set);
       __typeMapper.writeObject(__out, LastViewedDate__typeInfo, LastViewedDate, LastViewedDate__is_set);
       __typeMapper.writeString(__out, Name__typeInfo, Name, Name__is_set);
       __typeMapper.writeString(__out, Phone__typeInfo, Phone, Phone__is_set);
       __typeMapper.writeObject(__out, Profile__typeInfo, Profile, Profile__is_set);
       __typeMapper.writeString(__out, ProfileId__typeInfo, ProfileId, ProfileId__is_set);
       __typeMapper.writeObject(__out, RecordType__typeInfo, RecordType, RecordType__is_set);
       __typeMapper.writeString(__out, RecordTypeId__typeInfo, RecordTypeId, RecordTypeId__is_set);
       __typeMapper.writeString(__out, Title__typeInfo, Title, Title__is_set);
       __typeMapper.writeString(__out, Type__typeInfo, Type, Type__is_set);
       __typeMapper.writeObject(__out, UserRole__typeInfo, UserRole, UserRole__is_set);
       __typeMapper.writeString(__out, UserRoleId__typeInfo, UserRoleId, UserRoleId__is_set);
       __typeMapper.writeString(__out, Username__typeInfo, Username, Username__is_set);
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
        if (__typeMapper.isElement(__in, Alias__typeInfo)) {
            setAlias(__typeMapper.readString(__in, Alias__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Email__typeInfo)) {
            setEmail(__typeMapper.readString(__in, Email__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, FirstName__typeInfo)) {
            setFirstName(__typeMapper.readString(__in, FirstName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, IsActive__typeInfo)) {
            setIsActive((java.lang.Boolean)__typeMapper.readObject(__in, IsActive__typeInfo, java.lang.Boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastName__typeInfo)) {
            setLastName(__typeMapper.readString(__in, LastName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastReferencedDate__typeInfo)) {
            setLastReferencedDate((java.util.Calendar)__typeMapper.readObject(__in, LastReferencedDate__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastViewedDate__typeInfo)) {
            setLastViewedDate((java.util.Calendar)__typeMapper.readObject(__in, LastViewedDate__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Name__typeInfo)) {
            setName(__typeMapper.readString(__in, Name__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Phone__typeInfo)) {
            setPhone(__typeMapper.readString(__in, Phone__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Profile__typeInfo)) {
            setProfile((com.sforce.soap.enterprise.sobject.Profile)__typeMapper.readObject(__in, Profile__typeInfo, com.sforce.soap.enterprise.sobject.Profile.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ProfileId__typeInfo)) {
            setProfileId(__typeMapper.readString(__in, ProfileId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, RecordType__typeInfo)) {
            setRecordType((com.sforce.soap.enterprise.sobject.RecordType)__typeMapper.readObject(__in, RecordType__typeInfo, com.sforce.soap.enterprise.sobject.RecordType.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, RecordTypeId__typeInfo)) {
            setRecordTypeId(__typeMapper.readString(__in, RecordTypeId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Title__typeInfo)) {
            setTitle(__typeMapper.readString(__in, Title__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Type__typeInfo)) {
            setType(__typeMapper.readString(__in, Type__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, UserRole__typeInfo)) {
            setUserRole((com.sforce.soap.enterprise.sobject.UserRole)__typeMapper.readObject(__in, UserRole__typeInfo, com.sforce.soap.enterprise.sobject.UserRole.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, UserRoleId__typeInfo)) {
            setUserRoleId(__typeMapper.readString(__in, UserRoleId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Username__typeInfo)) {
            setUsername(__typeMapper.readString(__in, Username__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[Name ");
      sb.append(super.toString());sb.append(" Alias='").append(com.sforce.ws.util.Verbose.toString(Alias)).append("'\n");
      sb.append(" Email='").append(com.sforce.ws.util.Verbose.toString(Email)).append("'\n");
      sb.append(" FirstName='").append(com.sforce.ws.util.Verbose.toString(FirstName)).append("'\n");
      sb.append(" IsActive='").append(com.sforce.ws.util.Verbose.toString(IsActive)).append("'\n");
      sb.append(" LastName='").append(com.sforce.ws.util.Verbose.toString(LastName)).append("'\n");
      sb.append(" LastReferencedDate='").append(com.sforce.ws.util.Verbose.toString(LastReferencedDate)).append("'\n");
      sb.append(" LastViewedDate='").append(com.sforce.ws.util.Verbose.toString(LastViewedDate)).append("'\n");
      sb.append(" Name='").append(com.sforce.ws.util.Verbose.toString(Name)).append("'\n");
      sb.append(" Phone='").append(com.sforce.ws.util.Verbose.toString(Phone)).append("'\n");
      sb.append(" Profile='").append(com.sforce.ws.util.Verbose.toString(Profile)).append("'\n");
      sb.append(" ProfileId='").append(com.sforce.ws.util.Verbose.toString(ProfileId)).append("'\n");
      sb.append(" RecordType='").append(com.sforce.ws.util.Verbose.toString(RecordType)).append("'\n");
      sb.append(" RecordTypeId='").append(com.sforce.ws.util.Verbose.toString(RecordTypeId)).append("'\n");
      sb.append(" Title='").append(com.sforce.ws.util.Verbose.toString(Title)).append("'\n");
      sb.append(" Type='").append(com.sforce.ws.util.Verbose.toString(Type)).append("'\n");
      sb.append(" UserRole='").append(com.sforce.ws.util.Verbose.toString(UserRole)).append("'\n");
      sb.append(" UserRoleId='").append(com.sforce.ws.util.Verbose.toString(UserRoleId)).append("'\n");
      sb.append(" Username='").append(com.sforce.ws.util.Verbose.toString(Username)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}