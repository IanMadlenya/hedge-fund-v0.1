package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class PermissionSetRecordTypeVisibility implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public PermissionSetRecordTypeVisibility() {}

    /**
     * element : recordType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo recordType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","recordType","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean recordType__is_set = false;

    private java.lang.String recordType;

    public java.lang.String getRecordType() {
      return recordType;
    }

    public void setRecordType(java.lang.String recordType) {
      this.recordType = recordType;
      recordType__is_set = true;
    }

    /**
     * element : visible of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo visible__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","visible","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean visible__is_set = false;

    private boolean visible;

    public boolean getVisible() {
      return visible;
    }

    public boolean isVisible() {
      return visible;
    }

    public void setVisible(boolean visible) {
      this.visible = visible;
      visible__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeString(__out, recordType__typeInfo, recordType, recordType__is_set);
       __typeMapper.writeBoolean(__out, visible__typeInfo, visible, visible__is_set);
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
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, recordType__typeInfo)) {
            setRecordType(__typeMapper.readString(__in, recordType__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, visible__typeInfo)) {
            setVisible(__typeMapper.readBoolean(__in, visible__typeInfo, boolean.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[PermissionSetRecordTypeVisibility ");
      sb.append(" recordType='").append(com.sforce.ws.util.Verbose.toString(recordType)).append("'\n");
      sb.append(" visible='").append(com.sforce.ws.util.Verbose.toString(visible)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}