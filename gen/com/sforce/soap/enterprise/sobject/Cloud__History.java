package com.sforce.soap.enterprise.sobject;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class Cloud__History extends com.sforce.soap.enterprise.sobject.SObject {

    /**
     * Constructor
     */
    public Cloud__History() {}

    /**
     * element : CreatedBy of type {urn:sobject.enterprise.soap.sforce.com}sObject
     * java type: com.sforce.soap.enterprise.sobject.SObject
     */
    private static final com.sforce.ws.bind.TypeInfo CreatedBy__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CreatedBy","urn:sobject.enterprise.soap.sforce.com","sObject",0,1,true);

    private boolean CreatedBy__is_set = false;

    private com.sforce.soap.enterprise.sobject.SObject CreatedBy;

    public com.sforce.soap.enterprise.sobject.SObject getCreatedBy() {
      return CreatedBy;
    }

    public void setCreatedBy(com.sforce.soap.enterprise.sobject.SObject CreatedBy) {
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
     * element : Field of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Field__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Field","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Field__is_set = false;

    private java.lang.String Field;

    public java.lang.String getField() {
      return Field;
    }

    public void setField(java.lang.String Field) {
      this.Field = Field;
      Field__is_set = true;
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
     * element : NewValue of type {http://www.w3.org/2001/XMLSchema}anyType
     * java type: java.lang.Object
     */
    private static final com.sforce.ws.bind.TypeInfo NewValue__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","NewValue","http://www.w3.org/2001/XMLSchema","anyType",0,1,true);

    private boolean NewValue__is_set = false;

    private java.lang.Object NewValue;

    public java.lang.Object getNewValue() {
      return NewValue;
    }

    public void setNewValue(java.lang.Object NewValue) {
      this.NewValue = NewValue;
      NewValue__is_set = true;
    }

    /**
     * element : OldValue of type {http://www.w3.org/2001/XMLSchema}anyType
     * java type: java.lang.Object
     */
    private static final com.sforce.ws.bind.TypeInfo OldValue__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","OldValue","http://www.w3.org/2001/XMLSchema","anyType",0,1,true);

    private boolean OldValue__is_set = false;

    private java.lang.Object OldValue;

    public java.lang.Object getOldValue() {
      return OldValue;
    }

    public void setOldValue(java.lang.Object OldValue) {
      this.OldValue = OldValue;
      OldValue__is_set = true;
    }

    /**
     * element : Parent of type {urn:sobject.enterprise.soap.sforce.com}Cloud__c
     * java type: com.sforce.soap.enterprise.sobject.Cloud__c
     */
    private static final com.sforce.ws.bind.TypeInfo Parent__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Parent","urn:sobject.enterprise.soap.sforce.com","Cloud__c",0,1,true);

    private boolean Parent__is_set = false;

    private com.sforce.soap.enterprise.sobject.Cloud__c Parent;

    public com.sforce.soap.enterprise.sobject.Cloud__c getParent() {
      return Parent;
    }

    public void setParent(com.sforce.soap.enterprise.sobject.Cloud__c Parent) {
      this.Parent = Parent;
      Parent__is_set = true;
    }

    /**
     * element : ParentId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ParentId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ParentId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean ParentId__is_set = false;

    private java.lang.String ParentId;

    public java.lang.String getParentId() {
      return ParentId;
    }

    public void setParentId(java.lang.String ParentId) {
      this.ParentId = ParentId;
      ParentId__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:sobject.enterprise.soap.sforce.com", "Cloud__History");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeObject(__out, CreatedBy__typeInfo, CreatedBy, CreatedBy__is_set);
       __typeMapper.writeString(__out, CreatedById__typeInfo, CreatedById, CreatedById__is_set);
       __typeMapper.writeObject(__out, CreatedDate__typeInfo, CreatedDate, CreatedDate__is_set);
       __typeMapper.writeString(__out, Field__typeInfo, Field, Field__is_set);
       __typeMapper.writeObject(__out, IsDeleted__typeInfo, IsDeleted, IsDeleted__is_set);
       __typeMapper.writeObject(__out, NewValue__typeInfo, NewValue, NewValue__is_set);
       __typeMapper.writeObject(__out, OldValue__typeInfo, OldValue, OldValue__is_set);
       __typeMapper.writeObject(__out, Parent__typeInfo, Parent, Parent__is_set);
       __typeMapper.writeString(__out, ParentId__typeInfo, ParentId, ParentId__is_set);
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
        if (__typeMapper.isElement(__in, CreatedBy__typeInfo)) {
            setCreatedBy((com.sforce.soap.enterprise.sobject.SObject)__typeMapper.readObject(__in, CreatedBy__typeInfo, com.sforce.soap.enterprise.sobject.SObject.class));
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
        if (__typeMapper.isElement(__in, Field__typeInfo)) {
            setField(__typeMapper.readString(__in, Field__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, IsDeleted__typeInfo)) {
            setIsDeleted((java.lang.Boolean)__typeMapper.readObject(__in, IsDeleted__typeInfo, java.lang.Boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, NewValue__typeInfo)) {
            setNewValue((java.lang.Object)__typeMapper.readObject(__in, NewValue__typeInfo, java.lang.Object.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, OldValue__typeInfo)) {
            setOldValue((java.lang.Object)__typeMapper.readObject(__in, OldValue__typeInfo, java.lang.Object.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Parent__typeInfo)) {
            setParent((com.sforce.soap.enterprise.sobject.Cloud__c)__typeMapper.readObject(__in, Parent__typeInfo, com.sforce.soap.enterprise.sobject.Cloud__c.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ParentId__typeInfo)) {
            setParentId(__typeMapper.readString(__in, ParentId__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[Cloud__History ");
      sb.append(super.toString());sb.append(" CreatedBy='").append(com.sforce.ws.util.Verbose.toString(CreatedBy)).append("'\n");
      sb.append(" CreatedById='").append(com.sforce.ws.util.Verbose.toString(CreatedById)).append("'\n");
      sb.append(" CreatedDate='").append(com.sforce.ws.util.Verbose.toString(CreatedDate)).append("'\n");
      sb.append(" Field='").append(com.sforce.ws.util.Verbose.toString(Field)).append("'\n");
      sb.append(" IsDeleted='").append(com.sforce.ws.util.Verbose.toString(IsDeleted)).append("'\n");
      sb.append(" NewValue='").append(com.sforce.ws.util.Verbose.toString(NewValue)).append("'\n");
      sb.append(" OldValue='").append(com.sforce.ws.util.Verbose.toString(OldValue)).append("'\n");
      sb.append(" Parent='").append(com.sforce.ws.util.Verbose.toString(Parent)).append("'\n");
      sb.append(" ParentId='").append(com.sforce.ws.util.Verbose.toString(ParentId)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}
